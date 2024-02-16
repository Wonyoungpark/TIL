package ex0216;

public class DemonThreadExam {
    public static void main(String[] args) {
        System.out.println("***메인 시작***");

        System.out.println("***메인 종료***");

        Runnable r = ()->{
            //run메소드에서 해야할 일 작성
            while(true){
                System.out.println("데몬");
            }
        };

        Thread th = new Thread(r);
        th.setDaemon(true);
        th.start();

        //2초후 메인 종료시, 스레드도 함께 종료
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
