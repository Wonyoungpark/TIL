const gpio = require('pigpio').Gpio;
const dbif = require('../db/dbif.js');

const TRIG = 6;
const ECHO = 13;
const trig = new gpio(TRIG,{mode:gpio.OUTPUT});
const echo = new gpio(ECHO,{mode:gpio.INPUT, alert:true});

const sonic = {
    timerid : 0,
    init:(io)=>{
        let startTick,distance,diff,dist;

        console.log("초음파 센서를 초기화합니다.");
        trig.digitalWrite(0);

        echo.on('alert',(level,tick)=>{
            if (level==1){ startTick = tick; }
            else {
                const endTick = tick;
                diff = endTick - startTick;
                distance = diff/58;
                dist = Number(distance.toFixed(1));
                console.log("근접거리: "+dist);
                io.sockets.emit('watch',dist);
                dbif.insert(dist);
            }
        });
    },
    start: (timerValue)=> {
        if (sonic.timerid == 0) sonic.timerid = setInterval( ()=>{trig.trigger(10,1);}, timerValue);
        else console.log("이미 가동 중 입니다....");
    },
    stop: ()=>{
        if (sonic.timerid != 0) {
            clearInterval(sonic.timerid);
            sonic.timerid = 0;
        }
    }
};

module.exports.init = function(io) { sonic.init(io); };
module.exports.start = function(timerValue) { sonic.start(timerValue); };
module.exports.stop = function() { sonic.stop(); };