Learning List
=============
- [A MEAN Blog](https://www.a-mean-blog.com/ko/blog/MEAN-Stack)
<br>

Node.js
========
JavaScript를 웹브라우저 밖에서 사용할 수 있게하는 프로그램

HTTP Methods
-------------
데이터가 서버로 전달될 때 데이터를 보내는 목적 표시 및 데이터 처리
- GET : 서버에게 resource 송신 요청
- POST : 서버에게 resource 송신 및 서버/DB 저장 요청
- PUT : 서버에게 resource 업데이트 요청
- DELETE : 서버/DB에 저장된 resource 삭제 요청

NPM
---
Node Package Manager, node.js의 라이브러리
- `npm init` : node 프로젝트 생성 -> package.json 생성
- `npm install --save [package 이름]` : node_modules에 해당 패키지 다운로드

서버 실행 방법
------------
1. `node index.js` (package.json에서 main에 해당하는 파일명)
2. `nodemon` : 서버 코드 변경시 자동으로 서버 재시작
 
Express 서버 생성
---------------
```javascript
var express = require('express');
var app = express();
app.get('/',function(req,res) { // '/'에서 get 요청 받는 경우 실행
  res.send('Hello World!');
});
var port = 3000;
app.listen(port,funciton() { // 3000번 포트와 node.js 서버 연결
  console.log('server on! http://localhost:'+port);
});
```
- `require(모듈명)` : 설치된 모듈 불러오기
- `app.get(), app.listen()` : event listener, 각각 get 요청이 있는 경우/서버가 실행되는 경우 실행
- 콜백 함수
  - req : request 관련 값/함수가 저장된 객체 (HTTP request header, 요청 url, cookies, query, body)
  - res : response 관련 값/함수가 저장된 객체 (HTTP response header, cookies, HTTP 코드)
  - next : 여러 콜백 함수 사용시, 다음번 콜백 함수로 넘어감

Static 폴더 생성
--------------
```javascript
app.use(express.static(__dirname + '/public'));
```
- `app.use()`: `app.get()`과 다르게 서버에 요청이 올때마다 무주건 콜백
- `app.use(express.static(__dirname + '/public'))` : '현재s위치/public' route를 static폴더로 지정

EJS
---
Embedded JavaScript, Express에서 Dynamci website 만들기 위해 템플릿으로 사용되는 파일 (.ejs)
- ejs파일에서는 `res.render()` 사용
```javascript
app.set('view engine','ejs'); // 1
app.use(express.static(__dirname + '/public'));

app.get('/hello', function(req,res){ // 2
  res.render('hello', {name:req.query.nameQuery});
});

app.get('/hello/:nameParam', function(req,res){ // 3
  res.render('hello', {name:req.params.nameParam});
});
```
1. ejs를 사용하기 위한 코드
2. query 통해 name 받음. `req.query`에 저장
3. route parameter 통해 name 받음. `req.params`에 저장

- ejs는 변수 출력시 `<%= 변수명 %>` 사용

mongoDB
--------
```javascript
mongoose.connect(process.env.MONGO_DB); // 1
var db = mongoose.connection; //2
db.once('open', function(){ //3, DB 연결 성공
  console.log('DB connected');
});
db.on('error', function(err){ //4, DB 연결 실패
  console.log('DB ERROR : ', err);
});
```
1. `mongoose.connect()`: DB연결
   `process.env.환경변수명` : process.env는 환경변수 갖는 객체
2. mongoose의 DB 객체를 변수화
3. `db.once('once')`: db는 딱 1번 연결
4. `db.on('error')`: 에러는 다양한 경우에 발생 가능
