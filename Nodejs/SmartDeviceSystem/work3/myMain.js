const network = require('network');
const humitemp = require('./myHt.js');
const lcd = require('./myLcd.js');
const fan = require('./myFan.js');

const HTPIN = 21; // 온습도센서 <- 21번(BCM)

var pre = 0;
var now = 0;

humitemp.init(HTPIN);
lcd.init(); // LCD 초기화

console.log("==============================================");
console.log("5초후부터 5초간격으로 온도와 습도를 측정합니다");
console.log("==============================================");

const check_humi = ( ) => {
    network.get_active_interface( (err, ifaces) => { // WiFi IP주소(라즈베리파이)획득
        if (ifaces !== undefined) {
            if (ifaces.name == 'wlan0') {
                console.log('라즈베리파이 IP주소: ' + ifaces.ip_address); // 16자리(공백) 1234567890123456 영문자/숫자/특수문자만 출력됨
                humitemp.read( );
                now = humitemp["humi"]; // 측정한 온도를 현재 온도 설정
                var humistr = humitemp["temp"] + 'C, ' + humitemp["humi"] + '% ';

                lcd.printMessage(ifaces.ip_address, humistr); // ip 주소와 현재의 온습도 LCD판에 출력

                if (pre < now) {fan(1);} // 습도가 증가하면 팬 가동
                else if (pre > now) {fan(0);} // 습도가 하락하면 팬 중지
                pre = now;
            }
        }
    });
}

process.on('SIGINT',function(){
    fan(0);
    console.log("프로그램을 종료합니다.");
    process.exit();
});

setInterval( check_humi, 5000); // 측정주기: 5초