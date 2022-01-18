import java.time.LocalDate;
import java.time.Year;
import java.util.*;
import java.util.function.*;

public class Main {
    public static boolean flag = true;
    public static Map<String, Student> studentMap = new HashMap<>();
    public static Map<String, Person> personMap = new HashMap<>();
    public static Predicate<Integer> checkAdult = integer -> {
        int date = LocalDate.now().getYear();
        return ((date - integer) > 17) && ((date - integer) < 40);
    };
    public static Predicate<Integer> checkYearForGroup = integer -> {
        if (integer < 1995)
            return true;
        else return false;
    };

    public static void main(String[] args) {
        mainMenu();
        System.out.println("Увидимся");
    }

    public static void mainMenu() {
        while (flag) {
            System.out.println("""
                    1. Ввести данные человека
                    2. Переписать человека в студента
                    3. Вывести данные по людям
                    4. Вывести данные по студентам
                    0. Выход""");
            byte i = Byte.parseByte(stringScanner());
            if (i == 1) createPerson();
            if (i == 2) convertPerson();
            if (i == 3) printPerson();
            if (i == 4) printStudentMap();
            if (i == 0) flag = false;
        }
    }

    public static void createPerson() {
        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(stringScanner());
        System.out.print("Введите год рождения: ");
        int year = Integer.parseInt(stringScanner());
        System.out.println("Введите ФИО полностью через пробел: ");
        String name = stringScanner();
        Person person = new Person(name, age, year);
        personMap.put(person.getFullName(), person);
    }

    public static Function<Person, Student> convert = person -> {
        if (checkYearForGroup.test(person.getYearOFBirth()))
            return new Student(person.getFullName(), person.getAge(), "УбИН-01-022");
        else return new Student(person.getFullName(), person.getAge(), "УбИН-02-22");
    };

    public static void convertPerson() {
        System.out.println("Введите ФИО полностью человека к переводу в студенты");
        String fullName = stringScanner();
        if (personMap.containsKey(fullName)) {
            if (checkAdult.test(personMap.get(fullName).getYearOFBirth())) {
                studentMap.put(fullName, convert.apply(personMap.get(fullName)));
                System.out.println("Человек успешно переведен в студента");
            } else System.out.println("Человек не подходит по возрасту");
        } else {
            System.out.println("Нет записей о данном человеке");
        }
    }

    public static String stringScanner() {
        Scanner src = new Scanner(System.in);
        return src.nextLine();
    }

    public static void printPerson() {
        for (Person person : personMap.values()) {
            System.out.println(person.getFullName() + " [" + person.getAge() + "," + person.getYearOFBirth() + "]");
        }
    }

    public static void printStudentMap() {
        for (Student student : studentMap.values() ) {
            System.out.println(student.getFullName() + " [" + student.getAge() + "," + student.getGroup() + "]");
        }
    }

}
