import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.next();
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    if (age <= 0) {
                        System.out.println("Invalid age!");
                        break;
                    }

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    service.addStudent(new Student(roll, name, age, course));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int searchRoll = sc.nextInt();
                    Student s = service.searchStudent(searchRoll);

                    if (s != null) {
                        System.out.println("--------------------------------------------");
                        s.display();
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll No to update: ");
                    int upRoll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    if (service.updateStudent(upRoll, newName, newAge, newCourse)) {
                        System.out.println("✅ Student updated successfully!");
                    } else {
                        System.out.println("❌ Student not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Roll No to delete: ");
                    int delRoll = sc.nextInt();

                    if (service.deleteStudent(delRoll)) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the system!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
