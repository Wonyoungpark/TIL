package ex0214;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectLoadExam {
    public ObjectLoadExam(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("step_07_IOStream/src/ex0214/objSave.txt"))){
//            Student st1 = (Student) ois.readObject();
//            Student st2 = (Student) ois.readObject();
//            System.out.println(st1);
//            System.out.println(st2);

            //저장된 list를 파일에서 조회
            List<Student> student = (List<Student>) ois.readObject();
            for(Student s:student) System.out.println(s);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new ObjectLoadExam();
    }
}
