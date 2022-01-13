import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        DatabaseConnection db = new DatabaseConnection();
        String comand = "";
        Scanner scanner = new Scanner(System.in);
        while (!comand.equals("exit")) {
            System.out.println("\r\n\r\nFor manager of school:\r\n" +
                    "Enter \"read all students\" to read all students\r\n" +
                    "Enter \"insert student\" to insert student\r\n" +
                    //"Enter \"delete student\" to delete student\r\n" +
                    "Enter \"update student\" to update student\r\n" +
                    "Enter \"read all teachers\" to read all teachers\r\n" +
                    "Enter \"insert teacher\" to insert teacher\r\n" +
                    //"Enter \"delete teacher\" to delete teacher\r\n" +
                    "Enter \"update teacher\" to update teacher\r\n" +
                    "Enter \"read all courses\" to read all courses\r\n" +
                    "Enter \"insert course\" to insert course\r\n" +
                    //"Enter \"delete course\" to delete course\r\n" +
                    "Enter \"update course\" to update course\r\n" +
                    "Enter \"read all exams\" to read all exams\r\n" +
                    "Enter \"insert exam\" to insert exam\r\n" +
                    //"Enter \"delete exam\" to delete exam\r\n" +
                    "Enter \"update exam\" to update exam\r\n" +
                    "Enter \"exit\" to exit \r\n");
            comand = scanner.nextLine();
            switch (comand) {
                case "read all students": {
                    var students = db.ReadAllSchoolStudents();
                    for (Student student : students) {
                        System.out.println("Id of student: " + student.GetSchoolStudentsId() + " Name of student: " + student.GetName());
                    }
                    break;}
                case "insert student": {
                    System.out.println("Please type the Id of student");
                    int studentId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please type the name of student: ");
                    String studentName = scanner.nextLine();
                    db.InsertSchoolStudent(studentId, studentName);
                    break;}
                case "update student": {
                    System.out.println("Please type the id of student: ");
                   int studentId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please type the name of student: ");
                    String studentName = scanner.nextLine();
                    db.UpdateStudent(studentId, studentName);
                    break; }
                case "read all teachers": {
                    var teachers = db.ReadAllTeachers();
                    for (Teacher teacher : teachers) {
                        System.out.println("Id of teacher: " + teacher.GetTeachersId() + " Name of teacher: " + teacher.GetName());
                    }
                    break; }
                case "insert teacher": {
                    System.out.println("Please type the Id of teacher");
                    int teacherId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please type the name of teacher: ");
                    String teacherName = scanner.nextLine();
                    db.InsertTeacher(teacherId, teacherName);
                    break; }
                case "update teacher": {
                    System.out.println("Please type the id of teacher: ");
                    int teacherId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please type the name of teacher: ");
                    String teacherName = scanner.nextLine();
                    db.UpdateTeacher(teacherId, teacherName);
                    break; }
                case "read all courses": {
                    var courses = db.ReadAllCourses();
                    for (Course course : courses) {
                        System.out.println("Id of course: " + course.GetCourseId() + " Id of teacher: " + course.GetTeachersId());
                    }
                    break;}
                case "insert course": {
                    System.out.println("Please type the Id of course: ");
                    int courseId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please type the Id of teacher: ");
                    int teacherId = Integer.parseInt(scanner.nextLine());
                    db.InsertCourse(courseId, teacherId);
                    break; }
                case "update course": {
                    System.out.println("Please type the Id of course: ");
                    int courseId =Integer.parseInt(scanner.nextLine());
                    System.out.println("Please type the id of teacher: ");
                    int teacherId = Integer.parseInt(scanner.nextLine());
                    db.UpdateCourse(courseId, teacherId);
                    break; }
                case "read all exams": {
                    var exams = db.ReadAllExams();
                    for (Exam exam : exams) {
                        System.out.println("Id of exam: " + exam.GetExamsId() + " Id of student: " + exam.GetSchoolStudentsId() + " Id of course: " + exam.GetCourseId() + " Exam grade: " + exam.GetGrade());
                    }
                    break; }
                case "insert exam": {
                    System.out.println("Please type the Id of exam: ");
                    int examId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please type the Id of student");
                    int studentId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please type the Id of course");
                    int courseId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please type the grade of exam");
                    int grade = Integer.parseInt(scanner.nextLine());
                    db.InsertExam(examId, studentId, courseId, grade);
                    break; }
                case "update exam": {
                    System.out.println("Please type the Id of exam: ");
                    int examId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please type the Id of student: ");
                    int newIdOfStudent = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please type the Id of course: ");
                    int newIdOfCourse = Integer.parseInt(scanner.nextLine());
                    System.out.println("Please type the grade of exam: ");
                    int newGradeOfExam = Integer.parseInt(scanner.nextLine());
                    db.UpdateExam(examId, newIdOfStudent, newIdOfCourse, newGradeOfExam);
                    break; }
            }
        }
    }
}