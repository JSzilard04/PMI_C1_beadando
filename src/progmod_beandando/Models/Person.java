package progmod_beandando.Models;

import java.util.Date;

public class Person implements Comparable<Person> {

    protected String verboseName = "Személy";
    protected String name;
    protected int age;
    protected Date hiredDate;
    protected boolean isFired;

    public Person(String name, int age, Date hiredDate, boolean isFired) {
        this.name = name;
        this.age = age;
        this.hiredDate = hiredDate;
        this.isFired = isFired;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean isFired) {
        this.isFired = isFired;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String elbocsajtva;
        if (isFired){elbocsajtva = "Igaz";}
        else{elbocsajtva = "Hamis";}


        return "Kategoria: " + verboseName
                + ", Név: " + name
                + ", Életkor: " + age
                + ", Felvételt nyert (Dátum): " + hiredDate
                + ", Elbocsjátva " + elbocsajtva;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.toLowerCase().compareTo(o.name.toLowerCase());
    }
}
