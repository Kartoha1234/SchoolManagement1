public class Exam {
    private int examsId;
    private int schoolStudentsId;
    private int courseId;
    private int grade;

    public Exam(int examsId, int schoolStudentsId, int courseId, int grade) {
        this.examsId = examsId;
        this.schoolStudentsId = schoolStudentsId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public int GetExamsId() {
        return examsId;
    }
    public int GetSchoolStudentsId(){
        return schoolStudentsId;
    }
    public int GetCourseId(){
        return courseId;
    }
    public int GetGrade(){
        return grade;
    }

}