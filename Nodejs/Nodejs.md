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
- `app.use()`: `app.get()`과 다르게 
