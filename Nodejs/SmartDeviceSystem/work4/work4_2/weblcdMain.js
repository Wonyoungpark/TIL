const http = require('http');
const fs = require('fs');
const network = require('network');
const lcd = require('./sensors/lcd.js.js.js');
const PORT = 65051;

const webServer = (requrest,response)=>{
    fs.readFile('views/webLCD.html','utf8',function(err,data) {
        response.writeHead(200,{'Content-Type':'text/html'});
        response.end(data);
        console.log("웹페이지에 접속하였습니다.");
    });
}

const server = http.createServer(webServer);

server.listen(PORT,( )=>{
    network.get_active_interface( (err,ifaces)=>{
        if(ifaces !== undefined) {
            if(ifaces.name == 'wlan0') {
                console.log("=============================");
                console.log("웹 서버가 대기 중 입니다. http://" + ifaces.ip_address + ':'+ PORT);
                console.log("웹브라우저를 열고, 라즈베리파이 웹주소로 접속하세요.");
                console.log("=============================");
            }
        }
    })
});

const io = require('socket.io')(server);

lcd.init(io);

io.on('connection', client => {
    client.on('startmsg',(data)=>{
        console.log("LCD 메시지 수신: %s",data);
        lcd.start(data);
    });
    client.on('stopmsg',(data)=>{
        console.log("메시지 클리어!");
        lcd.stop();
    });
});

process.on('SIGINT',()=>{
    console.log('웹서버를 종료합니다');
    process.exit();
});