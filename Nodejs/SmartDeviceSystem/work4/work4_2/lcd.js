const LCD = require('raspberrypi-liquid-crystal');
const lcd = new LCD(1, 0x27,16,2);

const Lcd = {
    message : '',
    timerId: 0,

    init: ( ) => {
        console.log('LCD 모듈을 초기화합니다');
        lcd.beginSync();
        lcd.clearSync();
    },
    printMessage: (line) => {
        var len = line.length; // 문자열 길이
        
        lcd.setCursorSync(0, 0);
        if (len<=32) {
            lcd.printSync(line.substring(0,16));
            lcd.setCursorSync(0, 1);
            lcd.printSync(line.substring(16,32));
        }
        else { // 문자열이 두 줄로 출력이 어렵다면
            lcd.scrollDisplayLeft(); // 좌측으로 스크롤
            lcd.printSync(line);
        }
    },
    start: (msg) => {
        if (Lcd.timerId == 0) {
            Lcd.timerId = setInterval(( )=>{ Lcd.printMessage(msg); }, 200);
        }
        else { console.log("이미 가동 중 입니다....."); }
    },
    stop: ( ) => {
        if (Lcd.timerId != 0)
        clearInterval(Lcd.timerId);
        lcd.clearSync(); // LCD판 클리어
        Lcd.timerId = 0;
    }
};

module.exports.init = function( ) { Lcd.init( ); };
module.exports.printMessage = function(line) { Lcd.printMessage(line); };
module.exports.start = function(msg) { Lcd.start(msg); };
module.exports.stop = function( ) { Lcd.stop( ); };