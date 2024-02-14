public class ThreadExam {
    public static void main(String[] args) {
        System.out.println("메인 시작");

        NumberThread th1 = new NumberThread("first Thread");
        NumberThread th2 = new NumberThread("second Thread");

        AlphaRunnable alphaRunnable = new AlphaRunnable();
        Thread th3 = new Thread(alphaRunnable,"third Thread");

        //오류는 안나지만, 멀티가 아닌 순차호출이 된다
//        th1.run();
//        th2.run();
//        th3.run();

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

//A~Z 출력하는 Runnable
class AlphaRunnable implements Runnable {
    @Override
    public void run(){
        //현재 스레드를 얻어오는 주체를 제공
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
    }
}