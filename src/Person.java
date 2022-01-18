public class Person {
    private String fullName;
    private int age;
    private int yearOFBirth;

    public Person(String fullName, int age, int yearOFBirth) {
        this.fullName = fullName;
        this.age = age;
        this.yearOFBirth = yearOFBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public int getYearOFBirth() {
        return yearOFBirth;
    }
}
