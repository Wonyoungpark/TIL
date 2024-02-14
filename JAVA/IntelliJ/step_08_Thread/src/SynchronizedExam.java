public class SynchronizedExam {
    public static void main(String[] args) {
        System.out.println("메인 시작");

        //공유 객체 생성
        Bank bank = new Bank();
        CustomerThread th1 = new CustomerThread(bank,"인출자",false);
        CustomerThread th2 = new CustomerThread(bank,"입금자",true);

        th1.start();
        th2.start();

        System.out.println("메인 종료");
    }
}

//여러 스레드가 공유할 객체
class Bank{
    int balance; //잔액 0

    //인출자 또는 입급자가 잔액을 변경한는 메소드
    //@param : state가 true면 입금,false라면 출금
    public synchronized void balanceChange(String name, boolean state){
        if (state){
//            synchronized (this) {//괄호 안에는 공유 객체
//                System.out.print(name + " 현재 잔액 확인 " + balance + ',');
//                balance++;
//                System.out.println(name + " 증가 잔액 확인 " + balance);
//            }
            if(balance==0){
                System.out.print(name + " 현재 잔액 확인 " + balance + ',');
                balance++;
                System.out.println(name + " 증가 잔액 확인 " + balance);
            }else {
                System.out.println(name+" 대기 중 입니다.");
                try{
                    wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }else{
//            synchronized (this) {
//                System.out.print(name + " 현재 잔액 확인 " + balance + ',');
//                balance--;
//                System.out.println(name + " 차감 잔액 확인 " + balance);
//            }
            if(balance>0){
                System.out.print(name + " 현재 잔액 확인 " + balance + ',');
                balance--;
                System.out.println(name + " 차감 잔액 확인 " + balance);
            }else{
                System.out.println(name+"대기 중입니다.");
                try {
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        notifyAll(); //wait()으로 대기 중인 스레드 깨우기
    }
}

class CustomerThread extends Thread{
    Bank bank;
    String name;
    boolean state;
    public CustomerThread(Bank bank, String name, boolean state){
        super(name);
        this.bank=bank;
        this.name=name;
        this.state=state;
    }

    @Override
    public void run(){
        for(int i=1;i<=50;i++){
            //스레드로 동작 가능 작성
            bank.balanceChange(name, state);
        }
        System.out.println(super.getName()+" END");
    }
}