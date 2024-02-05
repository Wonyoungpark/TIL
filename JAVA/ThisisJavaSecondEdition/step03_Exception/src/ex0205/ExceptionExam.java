package ex0205;

public class ExceptionExam {

	public static void main(String[] args) {
		System.out.println("----메인 시작하기----");
		System.out.println("args= "+args);
		System.out.println("args.length = "+args.length);
		if(args.length>0) {
			for(String s: args) System.out.println(s);
		}
		
		try {
			String param = args[0];
			System.out.println("param="+param);
			
			int convertNo = Integer.parseInt(param);
			System.out.println("변환한 숫자 = "+convertNo);
			
			int result = 100/convertNo;
			System.out.println("나눈 결과 = "+result);
		} catch(ArrayIndexOutOfBoundsException e) {
			//예외발생 시
			System.out.println("e = "+e); //e.toString()호출
		} catch(NumberFormatException e) {
			System.out.println("숫자만 입력하세요"+e.getMessage());
		} catch(Exception e) {
			e.printStackTrace(); //출력 개발 모드	
		} finally {
			System.out.println("예외 발생 여부 상관없이 무조건 실행");
		}
		System.out.println("-------메인 끝-----");
	}

}
