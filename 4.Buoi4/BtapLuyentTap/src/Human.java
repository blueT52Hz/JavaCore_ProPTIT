public class Human {
    private String name, gender;
    private int age;

    public Human(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Human() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void workInMorning() {
        System.out.println("Ngủ...");
        return;
    }
}
