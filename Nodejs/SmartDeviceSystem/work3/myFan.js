const gpio = require('pigpio').Gpio;
const RELAY = 26;
const relay = new gpio(RELAY, {mode:gpio.OUTPUT});

const relayFan = (state) => {
    if (state) {
        relay.digitalWrite(1); // 팬 가동
        console.log("fan on");
    }
    else {
        relay.digitalWrite(0); // 팬 중지
        console.log("fan off");
    }
}

module.exports = relayFan;