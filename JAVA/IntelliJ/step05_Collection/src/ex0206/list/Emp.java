package ex0206.list;

public class Emp implements Comparable<Emp> { //Collections.sort()를 위해 구현
    private int empno;
    private String ename;
    private int age;
    private String addr;

    public Emp(){}
    public Emp(int empno, String ename, int age, String addr) {
        super();
        this.empno = empno;
        this.ename = ename;
        this.age = age;
        this.addr = addr;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
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

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }

    @Override
    public int compareTo(Emp o) {
        System.out.println("compareTo Call");
//        return empno - o.empno; //음수, 0, 양수
        return o.empno - empno; //음수, 0, 양수
    }
}
