const mcpadc = require('mcp-spi-adc'); // MCP3208 제어모듈
const SPI_SPEED = 1000000; // Clock Speed = 1Mhz
const VRX = 0;
const VRY = 1;

const joyStick = {
    joyX: 0,
    joyY: 0,
    webio: 0,
    timerId: 0,
    
    init: (io) => {
        joyStick.joyX = mcpadc.openMcp3208(VRX, // 채널0 지정
        { speedHz: SPI_SPEED }, // Clock속도 지정
        (err) => {
            console.log("SPI 채널0 초기화 완료!");
            console.log("-----------------------------");
            if (err) { console.log('채널0 초기화 실패!(HW 점검!)'); process.exit( ); }
        });
        joyStick.joyY = mcpadc.openMcp3208(VRY, // 채널1 지정
        { speedHz: SPI_SPEED }, // Clock속도 지정
        (err) => {
            console.log("SPI 채널1 초기화 완료!");
            console.log("-----------------------------");
            if (err) { console.log('채널1 초기화 실패!(HW 점검!)'); process.exit( ); }
        });
        joyStick.webio = io;
    },
    
    read: ( ) => {
        let xvalue=-1, yvalue=-1;
        
        joyStick.joyX.read((error, reading)=> {
            xvalue = reading.rawValue;
            joyStick.joyY.read((error, reading)=> {
                console.log("X좌표: %d Y좌표 (%d)", xvalue, reading.rawValue);
                yvalue = reading.rawValue;
                if (xvalue != -1 && yvalue != -1){ // x값, y값 모두 읽었다면
                    joyStick.webio.sockets.emit('watch', xvalue, yvalue);
                    xvalue = yvalue = -1;
                }
            });
        });
    },
    
    start: (timerValue) => {
        if (joyStick.timerId == 0) {
            joyStick.timerId = setInterval(joyStick.read, timerValue);
        }
        else { console.log("이미 가동 중 입니다....."); }
    },
    
    stop: ( ) => {
        if (joyStick.timerId != 0)
        clearInterval(joyStick.timerId);
        joyStick.timerId = 0;
    },

    terminate: ( ) => {
        joyStick.joyX.close( ( ) => { // mcp3208 연결해제
            joyStick.joyY.close( ( ) => {
                console.log('MCP-ADC를 해제하고, 웹서버를 종료합니다');
                process.exit();
            });
        });
    }
}

module.exports.init = function(io) { joyStick.init(io); };
module.exports.read = function() { joyStick.read(); };
module.exports.start = function(timerValue) { joyStick.start(timerValue); };
module.exports.stop = function( ) { joyStick.stop( ); };
module.exports.terminate = function( ) { joyStick.terminate( ); };