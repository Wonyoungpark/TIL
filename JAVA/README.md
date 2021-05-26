## JAVA Courses
 생활 코딩 : [Java 입문 수업](https://www.youtube.com/playlist?list=PLuHgQVnccGMCeAy-2-llhw3nWoQKUvQck)

## JAVA Calculator
- 자바로 터미널 계산기 만들기
- 자바로 GUI 계산기 만들기
    - [참고 사이트](https://m.blog.naver.com/dawonchu99/221754223779)


---
### OverLoading(오버로딩)
- 하나의 메소드로 여러 기능 구현
- 같은 이름 메소드, 여러 매개변수 유형/개수

### OverRiding(오버라이딩)
- 상위 클래스 메소드를 하위 클래스가 재정의

<br/>
|         |OverLoading|OverRiding|
|---------|:----------:|:---------:|
|리턴값|상관X|동일|
|메소드명|동일|동일|
|매개변수|다름|동일|
|적용범위|동일 클래스 내|상속관계|

---
### 접근 제어자
|         |같은 클래스|같은 패키지|다른 패키지 서브클래스|관계없음|
|---------|:-------:|:--------:|:-----------------:|:-----:|
|public|O|O|O|O|
|protected|O|O|O|X|
|default|O|O|X|X|
|private|O|X|X|X|
