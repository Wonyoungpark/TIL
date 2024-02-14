package ex0214;

import java.io.Serializable;

//객체를 파일에 저장하기 위한 클래스 : 직렬화 필수
//단, 필드만 직렬화 대상(파일에 저장됨) : 생성자/메소드는 불가
//static, transient 키워드는 직렬화 제외
public class Student implements Serializable {
    private String name;
    private int age;
    private String addr;

    public Student(){}

    public Student(String name, int age, String addr) {
        super();
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
