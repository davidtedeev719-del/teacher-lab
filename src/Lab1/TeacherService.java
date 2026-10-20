package Lab1;

public class TeacherService {
    private static Teacher[] teachers;

    // Первоначальное заполнение массива
    static {
        teachers = new Teacher[]{
                new Teacher("Антонов Олег Вадимович", "физика", 8, 5),
                new Teacher("Петров Владимир Георгиевич", "математика", 7, 7),
                new Teacher("Кузнецова Елена Борисовна", "русский язык", 6, 4),
                new Teacher("Иванова Ольга Николаевна", "математика", 8, 9),
                new Teacher("Сидоров Борис Маратович", "биология", 7, 4)
        };
    }

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

    // Добавление новых учителей
    public static void fillTeacher() {

        System.out.print("Введите количество новых учителей: ");

        int n = Teacher.readInt(1, 100);

        int oldSize = teachers.length;

        Teacher[] newTeachers = new Teacher[oldSize + n];

        // Копируем старых учителей
        for (int i = 0; i < oldSize; i++) {
            newTeachers[i] = teachers[i];
        }

        // Добавляем новых
        for (int i = oldSize; i < oldSize + n; i++) {

            System.out.println("\nУчитель " + (i - oldSize + 1));

            System.out.print("ФИО: ");
            String fio = Teacher.readString();

            System.out.print("Предмет: ");
            String predmet = Teacher.readString();

            System.out.print("Класс: ");
            int n_class = Teacher.readInt(1, 11);

            System.out.print("Кол-во часов: ");
            int hours = Teacher.readInt(1, 100);

            newTeachers[i] = new Teacher(
                    fio,
                    predmet,
                    n_class,
                    hours
            );
        }

        teachers = newTeachers;

        System.out.println("\nНовые учителя добавлены!");
    }

    public static Teacher findByName(String fio) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i].getFio().equalsIgnoreCase(fio)) {
                return teachers[i];
            }
        }
        return null;
    }
}