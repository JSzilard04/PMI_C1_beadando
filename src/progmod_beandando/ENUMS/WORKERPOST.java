package progmod_beandando.ENUMS;

public enum WORKERPOST {
    PRINCIPAL(450000),
    SECRETARY(350000),
    TEACHER(250000);

    private int salary;

    WORKERPOST(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public static WORKERPOST parse(String name) {
        for (WORKERPOST post : WORKERPOST.values()) {
            if (post.name().equals(name)) {
                return post;
            }
        }
        return null;
    }
}
