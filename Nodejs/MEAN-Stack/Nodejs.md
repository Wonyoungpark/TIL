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
- `app.use()`: `app.get()`과 다르게 서버에 요청이 올때마다 무조건 콜백
- `app.use('route',콜백_함수)`: 해당 route에 요청이 오는 경우만 콜백_함수 호출
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

데이터 생성 및 전달 (C,R)
---------------
* `body-parser` : 웹브라우저의 form으로 전송된 data를 서버에서 사용하기 위한 패키지

```javascript
var bodyParser = require('body-parser');
app.use(bodyParser.json()); // 1
app.use(bodyParser.urlencoded({extended:true})); // 2
// DB schema // 3
var contactSchema = mongoose.Schema({
  name:{type:String, required:true, unique:true},
  email:{type:String},
  phone:{type:String}
})
var Contact = mongoose.model('contact', contactSchema); // 4
// Home // 5
app.get('/', function(req, res){
  res.redirect('/contacts');
});
// Contacts - Index // 6
app.get('/contacts', function(req, res){
  Contact.find({}, function(err, contacts){
    if(err) return res.json(err);
    res.render('contacts/index', {contacts:contacts});
  });
});
// Contacts - New
app.get('/contacts/new', function(req, res){
  res.render('contacts/new');
});
// Contacts - create // 7
app.post('/contacts', function(req, res){
  Contact.create(req.body, function(err, contact){
    if(err) return res.json(err);
    res.redirect('/contacts');
  });
});
```
1. json 형식의 데이터를 받음. `req.body()`에서 form으로 입력받은 데이터를 사용.
2. urlencoded data를 extended 알고리즘으로 분석.
3. DB에 사용할 schema 설정. contact 형태의 데이터를 저장.
4. 설정한 schema의 model 생성. `'contact'`는 mongodb에서 사용하는 collection명
5. route 설정. "/"에 GET 요청이 올 경우, "/contacts"로 redirect.
6. "/contacts"에 GET 요청이 올 경우, 에러가 있다면 json으로 출력하고 없다면, render(페이지 동적으로 제작)함.
  * `모델.find(검색조건, 콜백_함수)`
    - `모델.find()` : DB에서 검색조건에 맞는 model data 찾고 콜백_함수 호출.
    - `검색조건` : Object 형태로 전달.
    - `콜백_함수` : `function(에러, 검색결과)` 형태. 에러가 있는 경우 결과 전달.
7. "/contacts"에 POST 요청이 올 경우.
  - `모델.create()` : DB에 data 생성. 첫번째 파라미터로부터 data object 생성.

HTML
-----
```html
<!DOCTYPE html>
<html>
  <head>
    <%- include('../partials/head') %> <!-- 1 -->
  </head>
  <body>
    <%- include('../partials/nav') %>

    <div class="contact contact-index">
      <h2>Index</h2>
      <ul>
        <% contacts.forEach(function(contact) { %> <!-- 2 -->
          <li>
            <%= contact.name %>
          </li>
        <% }) %>
      </ul>
    </div>
  </body>
</html>
```
1. `<%- include() %>` : 외부 ejs 적용
2. `forEach()` : 반복 출력

데이터 수정 및 삭제 (U,D)
---------------
* `method-override` : query로 method 값을 받아서 request의 HTTP method로 변환하는 패키지

```javascript
var methodOverride = require('method-override');
app.use(methodOverride('_method')); // 1
// Contacts - show // 2
app.get('/contacts/:id', function(req, res){
  Contact.findOne({_id:req.params.id}, function(err, contact){
    if(err) return res.json(err);
    res.render('contacts/show', {contact:contact});
  });
});
// Contacts - edit
app.get('/contacts/:id/edit', function(req, res){
  Contact.findOne({_id:req.params.id}, function(err, contact){
    if(err) return res.json(err);
    res.render('contacts/edit', {contact:contact});
  });
});
// Contacts - update // 3
app.put('/contacts/:id', function(req, res){
  Contact.findOneAndUpdate({_id:req.params.id}, req.body, function(err, contact){
    if(err) return res.json(err);
    res.redirect('/contacts/'+req.params.id);
  });
});
// Contacts - destroy // 4
app.delete('/contacts/:id', function(req, res){
  Contact.deleteOne({_id:req.params.id}, function(err){
    if(err) return res.json(err);
    res.redirect('/contacts');
  });
});
```
1. `_method`의 query로 들어오는 값으로 HTTP method 변환.
2. '/contacts/:id'에 GET 요청이 올 경우, 해당 값을 `req.params`에 넣음.
  - `모델.findOne()` : 조건에 맞는 결과 한개 찾기.
3. '/contacts/:id'에 PUT 요청이 올 경우.
  - `모델.findOneAndUpdate(조건, update할 정보, 콜백_함수)` : DB에서 해당 model의 document 한개 찾아 수정하는 함수. 콜백_함수에는 수정 전의 값이 넘겨짐(수정 후 값을 받고 싶다면, `{new:true}` 사용)
4. '/contacts/:id'에 DELETE 요청이 올 경우.
  - `모델.deleteOne()` : DB에서 해당 model의 document 한개 삭제

HTML
----
```html
<ul>
  <% contacts.forEach(function(contact) { %>
    <li>
      <a href="/contacts/<%= contact._id %>"><%= contact.name %></a>
    </li>
  <% }) %>
</ul>
```
이름에 `<a>` 태그 추가하여 show action과 연결

```html
<div class="contact-menu">
  <a href="/contacts/<%= contact._id %>/edit">Edit</a> <!-- 1 -->
  <form action="/contacts/<%= contact._id %>?_method=delete" method="post"> <!-- 2 -->
    <a href="#" onclick="confirm('Do you want to delete this?')?this.parentElement.submit():null;">Delete</a>
  </form>
</div>
```
1. `<a>` 태그로 edit action과 연결
2. `<a>` 태그로는 GET만 요청 가능 -> `<form>`도 POST만 가능해 `method=`로 DELETE 요청.

Module
------
my-module 파일 : `module.exports = myModule;`
모듈을 다른 파일에서 사용할 수 있도록 담아줌.<br>
다른 파일 : `var my_module = require("./my-module");`

```javascript
var express = require('express');
var router = express.Router(); // 1

router.get('/', function(req, res){
  res.redirect('/contacts');
});

module.exports = router; // 2
```
1. `express.Router()`: router 함수 초기화
2. `module.exports`로 module이 되어 require하면 사용

```javascript
Module.find({})
  .sort('-createdAt')
  .exec(function(err,posts){})
```
- Module Schema를 createdAt 항목 기준으로 내림차순 정렬
- exec()에서 받아온 data로 할 일 정의

데이터 보안
---------
* bcryptjs
설치 : `npm install --save bcryptjs`

```javascript
var mongoose = require('mongoose');
var bcrypt = require('bcryptjs');

...

  // update user
  if(!user.isNew){
    if(!user.currentPassword){
      user.invalidate('currentPassword', 'Current Password is required!');
    }
    else if(!bcrypt.compareSync(user.currentPassword, user.originalPassword)){ // 1
      user.invalidate('currentPassword', 'Current Password is invalid!');
    }

    ...

// hash password // 2
userSchema.pre('save', function (next){
  var user = this;
  if(!user.isModified('password')){
    return next();
  }
  else {
    user.password = bcrypt.hashSync(user.password); // 입력값 hash로 변환
    return next();
  }
});

// model methods // 3
userSchema.methods.authenticate = function (password) {
  var user = this;
  return bcrypt.compareSync(password,user.password);
};
```
1. bcrypt의 compareSync로 저장된 해시값과 paswword의 hash 일치하는지 확인<br>
text값을 hash로 변환해 비교
2. `userSchema.pre` : event 발생 전 callback() 실행
3. 로그인시 사용되는 password hash 비교 method

Flash
------
이름&값을 저장할 수 있음.<br>
한번 생성되면 사용 전까지 서버 메모리상에 저장 -> 사용되면 사라지는 data<br>
`npm install --save express-session connect-flash`

- `regrex` : 정규 표현식, 특정한 형식의 값만 저장하도록 제한
  ```javascript
  var userSchema = mongoose.Schema({
    username:{
      type:String,
      required:[true,'Username is required!'],
      match:[/^.{4,12}$/,'Should be 4-12 characters!'],
      trim:true,
      unique:true
    }
  }
  ```
  - `trim`: 문자열 앞뒤 빈칸 제거
  - `match`: `regrex`에 부합하지 않으면 에러 출력<br>
    > `/ /` : regrex는 이 안에 작성<br>
    > `^` : 문자열의 시작 위치<br>
    > `.` : 문자열 아무거나<br>
    > `{숫자1,숫자2}` : 숫자1<= 길이 <=숫자2<br>
    > `$` : 문자열의 끝 위치<br>
    => 전체 길이가 4이상 12이하의 문자열

```javascript
var methodOverride = require('method-override');
var flash = require('connect-flash');
var session = require('express-session');
var app = express();

...

app.use(methodOverride('_method'));
app.use(flash()); //1
app.use(sesiion({secrete:'MySecrete', resave:true, saveUninitalized:true})); //2
```
1. flash 초기화 => `req.flash(문자열,저장값)` 함수 사용 가능
2. `session()` : 서버에서 접속자를 구분시킴<br>
    `secrete` : session을 hash화할 때 사용

<br/>

```javascript
// New
router.get('/new', funciton(req,res){
  var user = req.fresh('user')[0] || {};
  var errors = req.fresh('errors')[0] || {};
  res.render('users/new', {user:user, errors:errors});
});
```
user 생성시 에러가 발생하면 new 페이지에 에러와 기존에 입력한 값(create route에서 생성된 flash)를 출력.<br/>
값이 없다면 빈 오브젝트 출력 : `|| {}`

```javascript
// create
router.post('/',funciton(req,res){
  User.create(req.body, funciton(err,user){
    if(err){
      req.flash('user',req.body);
      req.flash('errors',parseError(err));
      return res.redirect('/users/new');
    }
    res.redirect('/users');
  });
});
```
user 생성시 오류가 있다면 user & error flash 만들고 new 페이지로 redirect.

```javascript
// edit
router.get('/:username/edit', function(req,res){
  var user = req.flash('user')[0];
  var errors = req.flash('errors')[0] || {};
  if(!user){
    User.findOne({username:req.params.username}, function(err,user){
      if(err) return res.json(err);
      res.render('user/edit',{ userame:req.params.username, user:user, errors:errors });
    });
  }
  else {
    res.render('users/edit', {uername:req.params.user, errrors:errors});
  }
});
```
update에서 오류가 발생하는 경우, 기존에 입력한 값으로 form에 값 생성.<br/>
=> `user`에 `|| {}` 사용 안함.<br/>
render할 때 username을 따로 보내줌.

Login
------
`npm install --save passport passport-local`
passport : user authentication(사용자 인증) 위한 package

```javascript
// index.js
var passport = require('./config/passport'); 
...
app.use(passport.initialize()); //passport 초기화
app.use(passport.session()); //passport를 세션과 연결
app.use(function(req,res,next){
  res.locals.isAuthenticated = req.isAuthenticated(); // 현재 로그인 유무
  res.locals.currentUser = req.user;
  next(); // user 정보
});
```
- `app.use()`에 함수를 넣은 것 -> middleware<br>
  request 올 때마다 무조건 실행
- `user.locals`에 담긴 변수 -> ejs에서 바로 사용 가능

```javascript
// config/passport.js
var passport = require('passport');
var LocalStrategy = require('passport-local').Strategy;
var User = require('../models/User');

passport.serializeUser(function(user,done){
  done(null,user.id);
}); // 로그인시 user를 id만 세션에 저장
passport.deserializeUser(function(id,done){
  User.findOne({_id:id},funciton(err,user){
    done(err,user);
  });
}); // request마다 db에서 user 정보 읽어옴.

// localstrategy 설정
passport.use('local-login',
  new LocalStrategy({
    usernameField : 'username',
    passwordField : 'password',
    passReqToCallback : true
  },
  function(req,username,password,done){ //로그인시 호출
    User.findOne({username:username})
      .select({password:1})
      .exec(funciton(err,user){
        if (err) return done(err);

        // password hash 비교
        if(user&&user.authenticate(password)){
          return done(null,user);
        }
        else{
          req.flash('username',username);
          req.flash('errors',{login:'Theusername or password is incorrect.'});
          return done(null,false);
        }
      });
  }));
  
module.exports = passport;
```
