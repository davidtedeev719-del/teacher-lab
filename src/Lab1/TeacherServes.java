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
    // Б) Математики в 7-х классах
    public static void mathTeachers7Class() {

        System.out.println(
                "\nПреподаватели-математики в 7-х классах:"
        );

        for (int i = 0; i < teachers.length; i++) {

            if (teachers[i].getPredmet()
                    .equalsIgnoreCase("математика")
                    && teachers[i].getN_class() == 7) {

                System.out.println(teachers[i]);
            }
        }
    }
    // В) Сортировка по алфавиту
    public static void sortByName() {

        for (int i = 0; i < teachers.length - 1; i++) {

            for (int j = 0; j < teachers.length - 1 - i; j++) {

                if (teachers[j].getFio()
                        .compareTo(teachers[j + 1].getFio()) > 0) {

                    Teacher temp = teachers[j];

                    teachers[j] = teachers[j + 1];

                    teachers[j + 1] = temp;
                }
            }
        }

        System.out.println("\nУчителя по алфавиту:");

        for (int i = 0; i < teachers.length; i++) {
            System.out.println(teachers[i]);
        }
    }
}
