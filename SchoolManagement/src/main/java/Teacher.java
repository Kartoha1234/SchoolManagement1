import java.util.*;

public class Teacher {
    private int teachersId;
    private String name;

    public Teacher(int teachersId, String name) {
        this.teachersId = teachersId;
        this.name = name;
    }
    public int GetTeachersId() {
        return teachersId;
    }
    public String GetName(){
        return name;
    }
}
