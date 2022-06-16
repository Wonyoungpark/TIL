const express = require('express');
const servo = require('./sensors/servo.js');
const bodyParser = require('body-parser');
const methodOverride = require('method-override');
const network = require('network');
const fs = require('fs');
const app = express();
const PORT = 60001;

var mydata = {
    userip: 'y.y.y.y',
    degree:'90'
};

app.use(bodyParser.urlencoded({extended:false}));
app.use(methodOverride('_method'));

const moveServo = (req,res) => {
    console.log("서보모터(PUT): %s에서 제어명령(%s)을 수신함!", req.body.userip, req.body.degree);
    switch(req.body.degree) {
        case '90': servo.move90(); break;
        case '180': servo.move180(); break;
        case '0': servo.move0(); break;
        default: break;
    }
    res.redirect('/servo');
}

const initServo = (req,res)=>{
    console.log("서보모터(POST): %s에서 제어명령(%s)을 수신함!",req.body.userip, req.body.degree);
    servo.move90();
    res.send("서보머터 초기화제어(POST)를 완료하였습니다.");
}
const finalServo = (req,res) =>{
    console.log("서보모터(DELETE): %s에서 제어명령(%s)을 수신함!",req.body.userip, req.body.degree);
    servo.move0();
    res.send("서보머터 초기화제어(DELETE)를 완료하였습니다.");
}
const getServo = (req,response)=> {
    console.log("GET method 요청 받아서, 단순히 응답을 보냅니다.");
    fs.readFile('views/controlpage.html;charset=utf8','utf8',function(error, data) {
        response.writeHead(200, { 'Content-Type': 'text/html' });
        response.end(data);
        console.log("웹페이지에 접속하였습니다");
    });
}

app.post('/servo',initServo);
app.put('/servo', moveServo);
app.delete('/servo',finalServo);
app.get('/servo',getServo);

app.listen(PORT, ()=>{
    network.get_active_interface((err,ifaces)=> {
        if (ifaces.name=='wlan0') {
            console.log("=====================================================");
            console.log('REST API서버가 가동중입니다 http://' + ifaces.ip_address + ':' + PORT);
            console.log("다른 기기로부터 서보모터 제어명령을 기다립니다"); console.log("=====================================================");
        }
    });
});

process.on('SIGINT',function() {
    console.log("/nAPI 서버를 종료합니다.");
    process.exit();
});