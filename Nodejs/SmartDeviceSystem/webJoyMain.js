const http = require('http'); // 웹서버용
const fs = require('fs'); // HTML파일읽기용
const network = require('network'); // IP주소획득용
const socketio = require('socket.io');
const mcpadc = require('mcp-spi-adc');
const joystick = require('./sensors/joystick.js'); // 조이스틱
const PORT = 65001; // 접속포트주소

const serverbody = (request, response) => {
    fs.readFile('views/chart.html', 'utf8', (err, data) => {
        response.writeHead(200, { 'Content-Type': 'text/html' });
        response.end(data);
        console.log("웹페이지에 접속하였습니다");
    });
};

const server = http.createServer(serverbody);
const io = require('socket.io')(server);

joystick.init(io);

io.on('connection', client => {
    client.on('startmsg', function (data) {
        console.log('가동메시지 수신(측정주기:%d)! ', data);
        timeout = data;
        joystick.start(data); // 조이스틱 가동
    });
    
    client.on('stopmsg', function (data) { 
        console.log('중지메시자 수신!');
        joystick.stop(); // 조이스틱 중지
    });
});

server.listen(PORT, ()=>{
    network.get_active_interface( (err, ifaces) => { // WiFi IP주소(라즈베리파이)획득
        if (ifaces !== undefined) {
            if (ifaces.name == 'wlan0') {
                console.log("===================================================");
                console.log('조이스틱 제어용 웹서버');
                console.log('웹서버가 대기중입니다 http://' + ifaces.ip_address + ':' + PORT);
                console.log("웹브라우져를 열고, 라즈베리파이 웹주소로 접속하세요");
                console.log("===================================================");
            }
        }
    });
});

process.on('SIGINT', () => {
    joystick.terminate();
});