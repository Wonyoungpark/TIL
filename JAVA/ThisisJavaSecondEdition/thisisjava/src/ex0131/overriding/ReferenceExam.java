package ex0131.overriding;

class ObjectExam{
	public ObjectExam(){   }
	public ObjectExam(String str){   }
}

class ReferenceExam{
	public static void main(String[] args){
			char c='a';
			String s01="������"; 
			String s02="Java";
			String s03=new String("������");
			ObjectExam oe1=new ObjectExam();
			ObjectExam oe2=new ObjectExam("�ȳ�");
			System.out.println(c);//
			System.out.println(s01);//
			System.out.println(s02);//
			System.out.println(s03);//
			System.out.println(oe1);//
			System.out.println(oe2);//
			
	}
}
