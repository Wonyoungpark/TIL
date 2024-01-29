package ex0126.hw;

public class Lotto {
	int n = 6;
	int[] lotto = new int[n];
	int cnt;
	
	public void createLotto() {
		while(cnt<6) {
			int lottoNo= (int)(Math.random()*45+1);
			if(this.checkDis(lottoNo)) {
				lotto[cnt] = lottoNo;
				cnt++;
			}
		}
	}
	
	public boolean checkDis(int lottoNo) {
		for(int i=0;i<cnt;i++) {
			if(lotto[i]==lottoNo) return false;
		}
		return true;
	}
	
	public void sortDesc() {
		for(int i=0;i<lotto.length-1;i++) {
			for(int j=0;j<lotto.length-1;j++) {
				if(lotto[j]<lotto[j+1]) Sort.switchTwo(lotto,j+1,j);
			}
		}
	}
	
	public void printL() {
		System.out.println(java.util.Arrays.toString(lotto));
	}

	public static void main(String[] args) {
		Lotto lot = new Lotto();
		lot.createLotto();
		lot.sortDesc();
		lot.printL();
	}

}
