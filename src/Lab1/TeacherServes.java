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
    // А) Суммарная учебная нагрузка каждого учителя
    public static void totalLoad() {

        System.out.println("\nСуммарная учебная нагрузка:");

        for (int i = 0; i < teachers.length; i++) {

            boolean already = false;

            for (int j = 0; j < i; j++) {

                if (teachers[i].getFio()
                        .equals(teachers[j].getFio())) {

                    already = true;
                    break;
                }
            }

            if (!already) {

                int sum = 0;

                for (int j = 0; j < teachers.length; j++) {

                    if (teachers[i].getFio()
                            .equals(teachers[j].getFio())) {

                        sum += teachers[j].getHours();
                    }
                }

                System.out.println(
                        teachers[i].getFio()
                                + " - " + sum + " часов"
                );
            }
        }
    }
}
