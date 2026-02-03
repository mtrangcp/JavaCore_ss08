import model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===== QUẢN LÝ ĐIỂM SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo Học lực");
            System.out.println("4. Sắp xếp theo học lực giảm dần");
            System.out.println("5. Thoát");
            System.out.println("==================================");
            System.out.print("Chọn chức năng: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    insertStudent(sc, students);
                    break;
                case 2:
                    displayStudets(students);
                    break;
                case 3:
                    searchStudentByRank(sc, students);
                    break;
                case 4:
                    sortStudentByRank(students);
                    break;
                case 5:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không phù hợp!");
                    break;
            }
        } while (choice != 5);
    }

    static void insertStudent(Scanner sc, ArrayList<Student> students) {
        System.out.print("Nhập số sinh viên bạn muốn nhập : ");
        int count = sc.nextInt();
        String id;
        String name;
        int age;
        sc.nextLine();
        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.print("Nhập mã sinh viên : ");
                id = sc.nextLine();
                if (id.matches("^SV\\d{3}$")) {
                    break;
                } else {
                    System.out.println("Mã sai định dạng! Vui lòng nhập lại");
                }
            }

            while (true) {
                System.out.print("Nhập tên sinh viên : ");
                name = sc.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Tên không được để trống! Vui lòng nhập lại");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print("Nhập điểm sinh viên : ");
                age = sc.nextInt();
                sc.nextLine();
                if (age < 0 || age > 100) {
                    System.out.println("Tuổi không hợp lệ! Vui lòng nhập lại");
                } else {
                    break;
                }
            }
            Student newStudent = new Student(id, name, age);
            students.add(newStudent);
            System.out.println("Thêm sinh viên thành công!");
        }
    }
    static void displayStudets(ArrayList<Student> students) {
        if(students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống");
            return;
        }
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
    static void searchStudentByRank(Scanner sc, ArrayList<Student> students) {
        if(students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống");
            return;
        }
        System.out.print("Nhập học lực bạn muốn tìm : ");
        String rank = sc.nextLine().trim();
        if(rank.isEmpty()) {
            System.out.println("Dữ liệu không được để trống");
        }
        for (Student student : students) {
            if(student.getRank().equalsIgnoreCase(rank)) {
                System.out.println(student.toString());
            }
        }

    }
    static void sortStudentByRank(ArrayList<Student> students) {
        if(students.isEmpty()) {
            System.out.println("Danh sách sinh viên trống");
            return;
        }
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getScore() < students.get(j + 1).getScore()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        System.out.println("Sắp xếp thành công!");
    }
}
