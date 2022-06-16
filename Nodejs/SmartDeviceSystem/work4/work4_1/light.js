const gpio = require('pigpio').Gpio;
const mcpadc = require('mcp-spi-adc'); // MCP3208 제어모듈
const SPI_SPEED = 1000000;
const LIGHT = 2;
const LED = 26;

const led = new gpio(LED, {mode: gpio.OUTPUT});

const analLight = {
    Light: 0,
    timerId: 0, // 타이머제어용
    webio: 0,
    lightSt:0, // 조도 기준값

    init: (io) => {
        analLight.Light = mcpadc.openMcp3208(LIGHT,
            { speedHz: SPI_SPEED },
            (err) => {
                console.log("SPI 채널2 초기화 완료!");
                console.log("-----------------------------");
                if (err) { console.log('채널2 초기화 실패!(HW 점검!)'); process.exit( ); }
            }
            );
        analLight.webio = io;
    },

    read: (lightSt) => {
        let lightdata = -1; // 조도값 측정데이터 저장용

        analLight.Light.read((err, reading) => {
            if(err) throw err;
            console.log(" 현재 측정된 조도값 (%d)", reading.rawValue);
            lightdata = reading.rawValue;
            if ( lightdata != -1 ){ // 아날로그 조도센서값을 읽었다면
                if (lightdata > lightSt) led.pwmWrite(250); // 기준값 이상이면 LED on
                else led.pwmWrite(0);
                analLight.webio.sockets.emit('watch',0,0, lightdata);
                lightdata = -1;
            }
        });
    },

    start: (lightSt) => {
        var timeout = 200;
        if (analLight.timerId == 0) {
            analLight.timerId = setInterval(( )=>{ analLight.read(lightSt); }, timeout);
        }
        else { console.log("이미 가동 중 입니다....."); }
    },

    stop: ( ) => {
        if (analLight.timerId != 0)
        clearInterval(analLight.timerId);
        analLight.timerId = 0;
    },

    terminate: ( ) => {
        analLight.Light.close( ( ) => { // mcp3208 연결해제
            console.log('MCP-ADC를 해제하고, 웹서버를 종료합니다');
            led.pwmWrite(0); // LED끄기
            process.exit();
        });
    }
}

module.exports.init = function(io) { analLight.init(io); };
module.exports.read = function(lightSt) { analLight.read(lightSt); };
module.exports.start = function(lightSt) { analLight.start(lightSt); };
module.exports.stop = function( ) { analLight.stop( ); };
module.exports.terminate = function( ) { analLight.terminate( ); };