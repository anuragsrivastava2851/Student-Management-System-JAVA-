import java.util.ArrayList;

public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    // Add student
    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully!");
    }

    // View all students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        System.out.println("Roll | Name | Age | Course");
        for (Student s : students) {
            s.display();
        }
    }

    // Search student
    public Student searchStudent(int rollNo) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                return s;
            }
        }
        return null;
    }

    // ✅ UPDATE STUDENT (THIS WAS MISSING)
    public boolean updateStudent(int rollNo, String name, int age, String course) {
        Student s = searchStudent(rollNo);
        if (s != null) {
            s.setName(name);
            s.setAge(age);
            s.setCourse(course);
            return true;
        }
        return false;
    }

    // Delete student
    public boolean deleteStudent(int rollNo) {
        Student s = searchStudent(rollNo);
        if (s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }
}
