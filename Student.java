class Student {
    
    String name;
    int age;
    String university;

    Student() {
        name = "XYZ";
        age = 20;
        university = "CU";
    }

    Student(String n, int a, String u) {
        name = n;
        age = a;
        university = u;
    }

    void display() {
        System.out.println(name + " " + age + " " + university);
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Krissh", 19, "CU");
        s1.display();
        s2.display();
    }
}