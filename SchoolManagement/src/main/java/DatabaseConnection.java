import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    final String dbURL = "jdbc:mysql://localhost:3306/SchoolManagement";
    final String user = "root";
    final String password = "Kristykatja12";

    public ArrayList<Student> ReadAllSchoolStudents() throws SQLException {
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "SELECT * FROM schoolStudents";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Student> students = new ArrayList<Student>();

            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2));
                students.add(student);
            }
            return students;
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
            return null;
        }
    }

    public void InsertSchoolStudent(int schoolStudentsId, String name) throws SQLException {
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "INSERT INTO schoolStudents ( schoolStudentsId, name) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, schoolStudentsId);
            preparedStatement.setString(2, name);
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Student is successfully inserted");
            } else {
                System.out.println("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(Connection conn, int schoolStudentId) throws SQLException {
        String sql = "DELETE FROM schoolStudents WHERE sid = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, schoolStudentId);

        int rowDeleted = preparedStatement.executeUpdate();
        if(rowDeleted > 0){
            System.out.println("A student was deleted successfully");
        }else {
            System.out.println("Something went wrong");
        }
    }

    public void UpdateStudent(int schoolStudentsId, String name)throws SQLException{
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)){
            //String sql = "Edit schoolStudents ( schoolStudentsID, name) VALUES (?, ?)";
            String sql = "UPDATE schoolStudents SET name = ? WHERE sid =?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, schoolStudentsId);
            int rowEdited = preparedStatement.executeUpdate();
            if (rowEdited > 0) {
                System.out.println("Student is successfully updated");
            } else {
                System.out.println("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Teacher> ReadAllTeachers() throws SQLException {
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "SELECT * FROM teachers";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Teacher> teachers = new ArrayList<Teacher>();

            while (resultSet.next()) {
                Teacher teacher = new Teacher(
                        resultSet.getInt(1),
                        resultSet.getString(2));
                teachers.add(teacher);
            }
            return teachers;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void InsertTeacher(int teachersId, String name) throws SQLException {
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "INSERT INTO teachers ( teachersId, name) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, teachersId);
            preparedStatement.setString(2, name);
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Teacher is successfully inserted");
            } else {
                System.out.println("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteTeacher(Connection conn, int teachersId) throws SQLException {
        String sql = "DELETE FROM teachers WHERE tid = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, teachersId);
        int rowDeleted = preparedStatement.executeUpdate();
        if(rowDeleted > 0){
            System.out.println("The teacher was deleted successfully");
        }else {
            System.out.println("Something went wrong");
        }
    }

    public void UpdateTeacher(int teachersId, String name)throws SQLException{
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)){
            String sql = "UPDATE teachers SET name = ? WHERE tid = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, teachersId);
            preparedStatement.setString(2, name);
            int rowEdited = preparedStatement.executeUpdate();
            if (rowEdited > 0) {
                System.out.println("Teacher is successfully updated");
            } else {
                System.out.println("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Course> ReadAllCourses() throws SQLException {
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "SELECT * from courses";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Course> courses = new ArrayList<Course>();

            while (resultSet.next()) {
                Course course = new Course(
                        resultSet.getInt(1),
                        resultSet.getInt(2));
                courses.add(course);
            }
            return courses;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void InsertCourse(int coursesId, int teachersId) throws SQLException {
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "INSERT INTO courses ( coursesId, teachersId) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, coursesId);
            preparedStatement.setInt(2, teachersId);
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Course is successfully inserted");
            } else {
                System.out.println("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse( int courseIdId) throws SQLException {
        Connection conn = DriverManager.getConnection(dbURL, user, password);
        String sql = "DELETE FROM courses WHERE cid = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, courseIdId);
        int rowDeleted = preparedStatement.executeUpdate();
        if(rowDeleted > 0){
            System.out.println("A course was deleted successfully");
        }else {
            System.out.println("Something went wrong");
        }
    }

    public void UpdateCourse(int coursesId, int teachersId)throws SQLException{
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)){
            String sql = "UPDATE courses SET tid =? WHERE cid = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, coursesId);
            preparedStatement.setInt(2, teachersId);
            int rowEdited = preparedStatement.executeUpdate();
            if (rowEdited > 0) {
                System.out.println("Course is successfully updated");
            } else {
                System.out.println("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Exam> ReadAllExams() throws SQLException {
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "SELECT * from exams";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Exam> exams = new ArrayList<Exam>();

            while (resultSet.next()) {
                Exam exam = new Exam(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4));
                exams.add(exam);
            }
            return exams;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void InsertExam(int examsId, int schoolStudentsId, int coursesId, int grade) throws SQLException {
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {
            String sql = "INSERT INTO exams ( examsId, schoolStudentsId, coursesId, grade) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, examsId);
            preparedStatement.setInt(2, schoolStudentsId);
            preparedStatement.setInt(3, coursesId);
            preparedStatement.setInt(4, grade);

            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Exam is successfully inserted");
            } else {
                System.out.println("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteExam (Connection conn, int exId) throws SQLException {
        String sql = "DELETE FROM exams WHERE exid = ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,exId);

        int rowDeleted = preparedStatement.executeUpdate();
        if(rowDeleted > 0){
            System.out.println("A exam was deleted successfully");
        }else {
            System.out.println("Something went wrong");
        }
    }

    public void UpdateExam(int exId, int schoolStudentsId, int coursesId, int grade)throws SQLException{
        try (Connection conn = DriverManager.getConnection(dbURL, user, password)){
            String sql = "UPDATE  exams SET grade = ? WHERE cid =?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,exId);
            preparedStatement.setInt(2, schoolStudentsId);
            preparedStatement.setInt(3, coursesId);
            preparedStatement.setInt(4, grade);
            int rowUpdated = preparedStatement.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Exam is successfully updated");
            } else {
                System.out.println("Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }


