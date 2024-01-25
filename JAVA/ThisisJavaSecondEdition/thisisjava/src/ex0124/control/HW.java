package ex0124.control;

public class HW {

	public static void main(String[] args) {
		int n1 = 0;
		int n2=0;
		for(;;) {
			n1 = (int) (Math.random()*6+1);
			n2 = (int)(Math.random()*6+1);
			if ((n1+n2)==5) break;
		}
		
		for(int x=1;x<=10;x++) {
			for(int y=1;y<=10;y++) {
				if(4*x+5*y==60) System.out.printf("%d, %d\n",x,y);
			}
		}
		
		for(int i=1;i<6;i++) System.out.println("*".repeat(i));
		for(int i=5;i>0;i--) System.out.println("*".repeat(i));
		for(int i=1;i<6;i++) System.out.println(" ".repeat(6-i)+"*".repeat(i));
		for(int i=5;i>0;i--) System.out.println(" ".repeat(6-i)+"*".repeat(i));
	}

}

//8253jang@daum.net
