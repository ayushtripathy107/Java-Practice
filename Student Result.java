class Student {

    public static void main(String[] args) {

        int[] marks = {85, 90, 80};

        Student s = new Student(101, "Ayush", marks);

        s.calculateResult();
    }

    int rollNumber;
    String studentName;
    int[] marks;

    Student(int rollNumber, String studentName, int[] marks) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.marks = marks;
    }

    void calculateResult() {

        int total = 0;

        for (int i = 0; i < marks.length; i++) {
            total = total + marks[i];
        }

        double average = total / 3.0;
        String grade;

        if (average >= 90) {
            grade = "A";
        }
        else if (average >= 75) {
            grade = "B";
        }
        else if (average >= 60) {
            grade = "C";
        }
        else if (average >= 50) {
            grade = "D";
        }
        else {
            grade = "Fail";
        }

        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Student Name: " + studentName);

        for (int i = 0; i < marks.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks[i]);
        }

        System.out.println("Total Marks: " + total);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
    }
}
