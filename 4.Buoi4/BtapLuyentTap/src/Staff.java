public class Staff extends Human {
    private String id;
    private int salary, workHour;

    public Staff(String name, String gender, int age, String id, int salary, int workHour) {
        super(name, gender, age);
        this.id = id;
        this.salary = salary;
        this.workHour = workHour;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getWorkHour() {
        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public void work(){
        System.out.println("Đang code.");
    }
    public void workInMorning() {
        System.out.println("Đi làm.");
        work();
    }
}
