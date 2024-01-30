package ex0129.array.hw;

class TwoDmArray {
	//String을 저장하는 twoDmArray 배열 선언
	int n = 10;
	String[][] twoDmArray = new String[n][n];
	
	//메소드 make2DmArray
	//twoDmArray 배열에 값을 할당
	public void make2DmArray() {
		//각행의 열을 생성하고 값을 할당한다.(동호레이아웃.xls 화면 참고)
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) twoDmArray[i][j] = "%d동 %d호 ".formatted(i+1,j+1);
		}
	}
	
	//메소드 print2DmArray
	//twoDmArray 배열의 값을 주어진 형식으로 출력
	public void print2DmArray() {
		//동호레이아웃.bmp파일의 모양처럼 화면에 출력한다.
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if (twoDmArray[j][i] != null) System.out.print(twoDmArray[j][i]);
				else System.out.print("       ");
			}
			System.out.println();
		}
	}
}

public class TwoDmArrayExam {
	//main메소드에서
	public static void main(String[] args) {
		//TwoDmArray객체 생성
		TwoDmArray td = new TwoDmArray();
		
		//TwoDmArray객체의 make2DmArray메소드 호출
		td.make2DmArray();
		//TwoDmArray객체의 print2DmArray메소드 호출
		td.print2DmArray();
	}
}
