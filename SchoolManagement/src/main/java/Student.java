import java.util.*;

public class Student {
    private int schoolStudentsId;
    private String name;

    public Student(int schoolStudentsId, String name) {
        this.schoolStudentsId = schoolStudentsId;
        this.name = name;
    }
    public int GetSchoolStudentsId() {
        return schoolStudentsId;
    }
    public String GetName(){
        return name;
    }
}
