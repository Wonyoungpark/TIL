const temp = require("node-dht-sensor");

const humitemp = {
    type : 22, // 기본값: DT22 (정밀 온습도 센서)
    pin : 21, // 기본값: 21, BCM핀 번호
    humi : 0.0, // 초기값
    temp : 0.0,
    str : '',
    
    init: (number) => {
        humitemp.pin = number;
        console.log('초기화 pin: ' + humitemp.pin);
    },
    
    read: ()=>{
        temp.read(humitemp.type, humitemp.pin, (err, temp, humi) => {
            if (!err) {
                humitemp.temp = temp.toFixed(1); // 정밀 표기: 소수점 1자리
                humitemp.humi = humi.toFixed(1); // 소수점 1자리
                humitemp.str = (new Date()).toLocaleString('ko'); // 측정 일시
                console.log('온도/습도 측정값: ' + humitemp.temp + 'C ' + humitemp.humi + '% ' + humitemp.str);
            } else console.log(err);
        });
    },
}

module.exports = humitemp;
