package ex0216;

public class InterruptExam {
    public static void main(String[] args) {
        System.out.println("***메인 시작***");

        Thread loopTh = new Thread(()->{
            try{
                while(true){
                    System.out.println("Thread");
                    Thread.sleep(1); //0.001초
                }
            }catch (InterruptedException e){
//                e.printStackTrace();
            }
        });
        loopTh.start();

        //3초 후 스레드 종료
        try{
            Thread.sleep(3000); //3초
        }catch (Exception e) {
            e.printStackTrace();
            //리소스 자원 정리
        }
        loopTh.interrupt(); //스레드 종료
        //반드시 일시정지상태가 될때, 스레드 안전 종료 가능

        System.out.println("***메인 종료***");
    }
}
