package progmod_beandando.Models;

import java.util.Date;

import progmod_beandando.ENUMS.WORKERPOST;

public class Worker extends Person{

    private WORKERPOST post;

    public Worker(String name, int age, Date hiredDate, boolean isFired, WORKERPOST post) {
        super(name, age, hiredDate, isFired);
        this.verboseName = "Dolgozó";
        this.post = post;
    }

    public WORKERPOST getPost() {
        return post;
    }

    public void setPost(WORKERPOST post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return super.toString() + ", Post: " + post;
    }
}