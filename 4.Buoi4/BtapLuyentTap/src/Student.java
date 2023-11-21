public class Student extends Human {
    public Student(String name, String gender, int age) {
        super(name, gender, age);
    }



    public void work() {
        System.out.println("Đang học Hóa.");
    }
    public void workInMorning() {
        System.out.println("Đi học trường cấp 3.");
        work();
    }
}
