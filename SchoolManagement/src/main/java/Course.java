public class Course {
    private int courseId;
    private int teachersId;

    public Course(int courseIdId, int teachersId) {
        this.courseId = courseIdId;
        this.teachersId = teachersId;
    }
    public int GetCourseId() {
        return courseId;
    }
    public int GetTeachersId(){
        return teachersId;
    }
}
