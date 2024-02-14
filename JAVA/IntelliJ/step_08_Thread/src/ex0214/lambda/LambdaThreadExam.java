package ex0214.lambda;

public class LambdaThreadExam {
    public static void main(String[] args) {
        System.out.println("메인 시작");

        NumberThread th1 = new NumberThread("first Thread");
        NumberThread th2 = new NumberThread("second Thread");

        Runnable alphaRun = ()->{
            Thread th = Thread.currentThread();

            for(char ch='A';ch<='z';ch++) {
                System.out.println(th.getName()+"->"+ch);
//            Thread.yield(); //양보(현재 스레드를 대기 상태로)
                try{
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Thread th3 = new Thread(alphaRun,"third Thread");

        //스레드 대기영역
        th1.start();
        th2.start();
        th3.start();

//        try{
//            th1.join(); //th1스레드가 일을 마칠 때까지 현재 스레드(메인)는 대기
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        System.out.println("총 합 = " +th1.sum);

        System.out.println("메인 종료");
    }
}
//1~100 출력하는 스레드
class NumberThread extends Thread {
    int sum;
    public NumberThread(String name){
        super(name); //스레드의 이름
    }
    @Override
    public void run() {
        for(int i=1;i<=100;i++) {
            System.out.println(super.getName()+"->"+i);
//            Thread.yield(); //양보(현재 스레드를 대기 상태로)
            sum+=i;
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
        System.out.println(super.getName()+" 종료");
    }
}