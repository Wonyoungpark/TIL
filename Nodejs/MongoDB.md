Learning List
=============
- [A MEAN Blog](https://www.a-mean-blog.com/ko/blog/MEAN-Stack)
- https://calvinjmkim.tistory.com/33
<br>

Mongo DB
=========
대표적인 NoSQL(Non Relational Database)
table, 행, 열의 개념이 없음.
- document :  하나의 데이터
- collection : document의 모음
document들은 JSON 형식으로 저장.
데이터의 추가/삭제가 자유로움.
DB의 조작은 JavaScript로 함.

mongodb 설치
-----------
1. `brew tap mongodb/brew` : homebrew 통해 공식 tap 연결
2. `brew install mongodb-community` : mongodb community 버전 설치
3. `sudo mkdir -p /Users/[username]/data/db` : mongodb 실행 후 사용할 데이터 폴더 생성
4. `sudo chown -Rv [username] /Users/[username]/data/db`: 데이터 폴더의 권한 설정
5. `sudo mkdir -p /Users/[username]/data/log/db` : 로그 폴더 생성
6. `mongod --dbpath=/Users/[username]/data/db`: mongod 추가한 데이터 폴더 path 인자 전달
7. `brew services start mongodb-community` : mongodb 실행
8. `brew services stop mongodb-community` : mongodb 실행 중지
9. `mongo` / `mongod` : mongodb 쉘 실행