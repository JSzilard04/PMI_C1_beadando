package progmod_beandando.Models;

import java.util.Date;

public class Student extends Person{

    private String className;

    public Student(String name, int age, Date hiredDate, boolean isFired, String className) {
        super(name, age, hiredDate, isFired);
        this.verboseName = "Tanuló";
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return super.toString() + ", Osztály: " + className;
    }
}
