const bleno = require('@abandonware/bleno');
const led = require('./sensors/led.js');
const util = require('util');

const SERVICE_UUID = 'ff01';
const CHARACTERISTIC_UUID = 'ff03';

var analog_data = 0;
var nodename = "BLE-014";
var Characteristic = bleno.Characteristic;
var PrimaryService = bleno.PrimaryService;

const ApproachCharacteristic = function() {
    ApproachCharacteristic.super_.call(this, {
        uuid : CHARACTERISTIC_UUID,
        properties : ['read','notify','write'],
        value : null
    });
    this._value = 0;
    this._updateValueCallback = null;
};
util.inherits(ApproachCharacteristic, Characteristic);

ApproachCharacteristic.prototype.onReadRequest = (offset, callback) => {
    // var data1 = Buffer.from(this._value.toString());
    var data1 = "hi";
    console.log("블루투스>데이터 1회 송신 서비스: "+ data1);
    callback(this.RESULT_SUCCESS,data1);
}

ApproachCharacteristic.prototype.onWriteRequest = (data,offset, withoutResponse,callback)=> {
    if (data == "on") {
        console.log("블루투스>데이터 수신(write요청): "+data+' (LED ON)');
        led.turnon();
    }
    else if(data =="off") {
        console.log("블루투스>데이터 수신 (write요청): "+data+' (LED OFF)');
        led.turnoff();
    }
    else console.log("블루투스>데이터 수신: "+data+'on/off 이외의 데이터');
    callback(this.RESULT_SUCCESS);
}

ApproachCharacteristic.prototype.onSubscribe = (maxValueSize, updateValueCallback)=> {
    console.log("----------------------------");
    console.log("블루투스>상대방이 센서 데이터 연속 서비스 가입(Subscribe) 요청합니다");
    console.log("----------------------------");
    this._updateValueCallback = updateValueCallback;
};

ApproachCharacteristic.prototype.onUnsubscribe = (maxValueSize,updateValueCallback) => {
    console.log("----------------------------");
    console.log("블루투스>상대방이 센서 데이터 연속서비스 탈퇴(Unsubscribe) 요청합니다");
    console.log("----------------------------");
    this._updateValueCallback = null;
};

bleno.on('stateChange',(state)=> {
    if (state === 'poweredOn') {
        bleno.startAdvertising(nodename,[SERVICE_UUID]);
        console.log("----------------------------");
        console.log("블루투스>ON ("+ nodename +") 가동");
    } else {
        bleno.stopAdvertising();
        console.log("블루투스 > Advertising을 중단합니다");
    }
});

const approachCharacteristic = new ApproachCharacteristic();

bleno.on('advertisingStart', (error)=> {
    if (!error) {
        console.log("블루투스>Advertising을 시작합니다...");
        console.log("----------------------------");
        bleno.setServices([
            new PrimaryService({
                uuid: SERVICE_UUID,
                characteristics: [ approachCharacteristic ]
            })
        ]);
    }
    else console.log("블루투스>Advertising 도중 오류 발생");
});

bleno.on('accept', (addr) => {
    console.log("블루투스>상대편(%s)이 연결을 수락했습니다",addr);
    setInterval( ( ) => { bleno.updateRssi( (error, rssi) => {
        bleno.setMaxListeners(0);
        console.log("수신감도(5초마다): 2m이내(-20~-50), 3~7m(-60~-80), 8m이상(-90~-120) > " + rssi);
    });}, 5000);
});
bleno.on('disconnect',(addr)=> {
    console.log("블루투스>상대편(%s)이 연결을 끊었습니다",addr);
});
bleno.on('servicesSet',(err)=> {
    if (!err) console.log("블루투스>상대에게 보낼 ServiceProfile을 생성합니다");
});
process.on('SIGINT',()=>{
    console.log("\n블루투스>프로그램을 종료합니다.");
    process.exit();
});

setInterval( ()=>{
    analog_data++;
    approachCharacteristic._value = analog_data;
    if(approachCharacteristic._updateValueCallback) {
        console.log("블루투스> 연속데이터 송신: ${approachCharacteristic._value}");
        const notificationBytes = Buffer.from(String(approachCharacteristic._value));
        approachCharacteristic._updateValueCallback(notificationBytes);
    }
},1000);