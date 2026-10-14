package Lab1;

public class TeacherServes {
    private static Teacher[] teachers;
    // Распечатать всех учителей
    public static void printTeachers() {

        System.out.println("\nУчебная нагрузка учителей:");

        for (int i = 0; i < teachers.length; i++) {
            System.out.println(teachers[i]);
        }
    }

}
