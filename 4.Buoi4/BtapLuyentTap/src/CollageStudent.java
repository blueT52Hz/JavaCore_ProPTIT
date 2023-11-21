public class CollageStudent extends Human {
    private String id;
    private double gpa;

    public CollageStudent(String name, String gender, int age, String id, double gpa) {
        super(name, gender, age);
        this.id = id;
        this.gpa = gpa;
    }
    public CollageStudent(Human hm, String id, double gpa) {
        setName(hm.getName());
        setGender(hm.getGender());
        setAge(hm.getAge());
        this.id=id;
        this.gpa=gpa;
    }
    public CollageStudent(String id, double gpa) {
        this.id=id;
        this.gpa=gpa;
    }
//    public CollageStudent(String id, double gpa) {
//        this.id = id;
//        this.gpa = gpa;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void work() {
        System.out.println("Đang học XLTHS...");
    }

    @Override
    public void workInMorning() {
        System.out.println("Đi học đại học.");
        work();
    }

}
