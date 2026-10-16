package Lab1;

public class Main {

    public static void main(String[] args) {

        cycle:
        while (true) {

            System.out.println("\n========== МЕНЮ ==========");
            System.out.println("1. Заполнить массив");
            System.out.println("2. Распечатать");
            System.out.println("3. Определить суммарную нагрузку учителей");
            System.out.println("4. Найти математиков в 7-х классах");
            System.out.println("5. Отсортировать учителей по алфавиту");
            System.out.println("6. Выход");
            System.out.println("==========================");

            System.out.print("Выберите пункт меню (1..6): ");

            int c = Teacher.sc.nextInt();
            Teacher.sc.nextLine();

            switch (c) {

                case 1:
                    TeacherServes.fillTeacher();
                    break;

                case 2:
                    TeacherServes.printTeachers();
                    break;
                case 3:
                    TeacherServes.totalLoad();
                    break;
                case 4:
                    TeacherServes.mathTeachers7Class();
                    break;
                case 5:
                    TeacherServes.sortByName();
                    break;
                case 6:
                    break cycle;

                default:
                    System.out.println("Неверный пункт меню!");
            }
        }
    }
}