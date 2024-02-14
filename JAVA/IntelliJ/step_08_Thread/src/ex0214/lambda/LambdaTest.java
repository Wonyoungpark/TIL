package ex0214.lambda;

public class LambdaTest {
    public static void main(String[] args) {
//        //기존 인터페이스 구현
//        AInterface ai = new Test();
//        ai.aa();

        //@FunctionalInterface의 람다식 활용
        AInterface ai = ()->{
            System.out.println("람다식 aa()");
        };
        ai.aa();


        System.out.println("======인수 매개변수가 있는 경우====");
        BInterface bi = (a)->{
            System.out.println("전달된 인수="+a);
        };
        bi.bb(10);
        bi.bb(5);


        System.out.println("======인수 매개변수,리턴이 있는 경우====");
//        CInterface ci = (a,b)->{
//            System.out.println("cc()");
//            System.out.println(a+" "+b);
//            return a*b;
//        };
        CInterface ci = (a,b)->a*b;
        int result = ci.cc(4,2);
        System.out.println("결과 : "+result);
    }
}

//기존 인터페이스 구현
class Test implements AInterface{
    @Override
    public void aa() {
        System.out.println("Test의 aa()");
    }
}