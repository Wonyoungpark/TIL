package ex0214;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaveExam {
    public ObjectSaveExam(){
        Student s1 = new Student("홍1",20,"서울");
        Student s2 = new Student("홍2",18,"오리");

        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);

        list.add(new Student("홍3",25,"대구"));
        list.add(new Student("홍4",22,"대전"));
        list.add(new Student("홍5",23,"대구"));
        list.add(new Student("홍6",20,"제주도"));

        //객체를 파일에 저장하는 클래스 - ObjectOutputStream 이용
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("step_07_IOStream/src/ex0214/objSave.txt"))){
            //저장
//            oos.writeObject(s1);
//            oos.writeObject(s2);

            oos.writeObject(list);
            System.out.println("저장 완료");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ObjectSaveExam();
    }
}
