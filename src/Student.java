public class Student {
   private String fullName;
   private int age;
   private String group;

    public Student(String fullName, int age, String group) {
        this.fullName = fullName;
        this.age = age;
        this.group = group;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }
}
