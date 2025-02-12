public class StudentManagement {
    private Student[] students;
    private int size;

    //khởi tạo
    public StudentManagement() {
        students = new Student[100];
        size = 0;
    }

    //so sánh
    public static boolean sameGroup(Student s1, Student s2) {
        return s1.getGroup().equals(s2.getGroup());
    }

    //thêm mới
    public void addStudent(Student newStudent) /*thêm sv*/{
        if (size < 100) {
            students[size] = newStudent;
            size++;
        }
    }

    //danh sách
    public String studentsByGroup(String group) {
        String result = "";
        for (int i = 0; i < size; i++) {
            if (students[i].getGroup().equals(group)) {
                result += students[i].getInfo() + "\n";
            }
        }
        return result;
    }

    //xoá
    public void removeStudent(String id) {
        int index = -1;

        //tìm sv cần xoá
        for (int i = 0; i < size; i++) {
            if (students[i].getId().equals(id)) {
                index = i;
                break;
            }
        }

        //xoá sv
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                students[i] = students[i + 1];
            }
            students[size - 1] = null;
            size--;
        }
    }

    //main
    public static void main(String[] args) /*main*/{
        StudentManagement sm = new StudentManagement();

        Student s1 = new Student("Nguyen Van An", "17020001", "17020001@vnu.edu.vn");
        s1.setGroup("K62CC");
        Student s2 = new Student("Nguyen Van B", "17020002", "17020002@vnu.edu.vn");
        s2.setGroup("K62CC");
        Student s3 = new Student("Nguyen Van C", "17020003", "17020003@vnu.edu.vn");
        Student s4 = new Student("Nguyen Van D", "17020004", "17020004@vnu.edu.vn");

        sm.addStudent(s1);
        sm.addStudent(s2);
        sm.addStudent(s3);
        sm.addStudent(s4);

        System.out.println("K62CC");
        System.out.print(sm.studentsByGroup("K62CC"));
        System.out.println("K62CB");
        System.out.println(sm.studentsByGroup("K62CB"));

        sm.removeStudent("17020002");

        System.out.println("K62CC");
        System.out.print(sm.studentsByGroup("K62CC"));
        System.out.println("K62CB");
        System.out.println(sm.studentsByGroup("K62CB"));
    }
}
