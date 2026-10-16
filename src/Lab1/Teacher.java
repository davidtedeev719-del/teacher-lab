package Lab1;

import java.util.Scanner;

public class Teacher {

    private String Fio;
    private String predmet;
    private int n_class;
    private int hours;

    private static Teacher[] teachers;

    public static Scanner sc = new Scanner(System.in, "UTF-8");

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

    // Конструктор с параметрами
    public Teacher(String Fio, String predmet, int n_class, int hours) {
        this.Fio = Fio;
        this.predmet = predmet;
        this.n_class = n_class;
        this.hours = hours;
    }

    // Конструктор без параметров
    public Teacher() {

        System.out.print("ФИО Учителя: ");
        setFio(readString());

        System.out.print("Предмет: ");
        setPredmet(readString());

        System.out.print("Класс: ");
        setN_class(readInt(1, 11));

        System.out.print("Кол-во часов: ");
        setHours(readInt(1, 100));
    }


    // Ввод строки без цифр
    public static String readString() {

        while (true) {

            String value = sc.nextLine().trim();

            if (value.isEmpty()) {
                System.out.print("Заполните строку! Повторите ввод: ");
            } else if (!value.matches("[а-яА-ЯёЁa-zA-Z]+")) {
                System.out.print("Символы недопустимы! Повторите ввод: ");
            } else {
                return value;
            }
        }
    }

    // Ввод числа с проверкой
    public static int readInt(int min, int max) {

        while (true) {

            String value = sc.nextLine().trim();

            try {

                int number = Integer.parseInt(value);

                if (number < min || number > max) {
                    System.out.print(
                            "Введите число от " + min + " до " + max + ": "
                    );
                } else {
                    return number;
                }

            } catch (NumberFormatException e) {

                System.out.print("Введите число: ");
            }
        }
    }

    public String toString() {

        return String.format(
                "ФИО: %s ==> предмет: %s \t класс: %d \t часы: %d",
                Fio, predmet, n_class, hours
        );
    }

    public String getFio() {
        return Fio;
    }

    public void setFio(String Fio) {

        if (Fio == null || Fio.trim().isEmpty()) {
            System.out.println("Недопустимое значение!");
        } else {
            this.Fio = Fio;
        }
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {

        if (predmet == null || predmet.trim().isEmpty()) {
            System.out.println("Недопустимое значение!");
        } else {
            this.predmet = predmet;
        }
    }

    public int getN_class() {
        return n_class;
    }

    public void setN_class(int n_class) {

        if (n_class < 1 || n_class > 11) {
            System.out.println("Недопустимый номер класса!");
        } else {
            this.n_class = n_class;
        }
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {

        if (hours <= 0) {
            System.out.println("Недопустимое количество часов!");
        } else {
            this.hours = hours;
        }
    }
}






