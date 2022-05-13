package progmod_beandando.Managers;

import java.util.ArrayList;
import java.util.List;

import progmod_beandando.Models.*;

public class PersonManager {

    private List<Worker> workers;
    private List<Student> students;

    public PersonManager() {
        workers = new ArrayList<Worker>();
        students = new ArrayList<Student>();

        LoadDatas();
    }

    public boolean AddWorker(Worker worker) {
        if (workers.stream().anyMatch(w -> w.getName().toLowerCase().equals(worker.getName().toLowerCase()))) {
            return false;
        }
        return workers.add(worker);
    }

    public boolean RemoveWorker(Worker worker) {
        return RemoveWorker(worker.getName());
    }

    public boolean RemoveWorker(String name) {
        Worker foundedW = null;
        for (Worker worker : workers) {
            if (worker.getName().toLowerCase().equals(name.toLowerCase())) {
                foundedW = worker;
                break;
            }
        }
        return foundedW == null ? false : workers.remove(foundedW);
    }

    public boolean AddStudent(Student student) {
        if (students.stream().anyMatch(w -> w.getName().toLowerCase().equals(student.getName().toLowerCase()))) {
            return false;
        }
        return students.add(student);
    }

    public boolean RemoveStudent(Student student) {
        return students.remove(student);
    }

    public boolean RemoveStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return students.remove(student);
            }
        }
        return false;
    }

    public boolean RemovePerson(String name) {
        for (Worker worker : workers) {
            if (worker.getName().equals(name)) {
                return workers.remove(worker);
            }
        }
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return students.remove(student);
            }
        }
        return false;
    }

    public List<Worker> GetWorkers() {
        return workers;
    }

    public List<Student> GetStudents() {
        return students;
    }

    public List<Person> SearchPerson(String name){
        List<Person> result = new ArrayList<Person>();
        for (Worker worker : workers) {
            if (worker.getName().contains(name)) {
                result.add(worker);
            }
        }
        for (Student student : students) {
            if (student.getName().contains(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public boolean IsWorker(String name) {
        return GetWorker(name) != null;
    }

    public boolean IsStudent(String name) {
        return GetStudent(name) != null;
    }

    public Worker GetWorker(String name) {
        for (Worker worker : workers) {
            if (worker.getName().equals(name)) {
                return worker;
            }
        }
        return null;
    }

    public Student GetStudent(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }


    public boolean EditWorker(Worker worker, Worker newWorker) {
        if (RemoveWorker(worker)) {
            return AddWorker(newWorker);
        }
        return false;
    }

    public boolean EditStudent(Student student, Student newStudent) {
        if (RemoveStudent(student)) {
            return AddStudent(newStudent);
        }
        return false;
    }

    public boolean Save() {
        return XmlManager.WriteDataToXml("nyilvantarto.xml", workers, students);
    }

    public void LoadDatas(){
        List<Worker> _workers = XmlManager.ReadWorkerDataFromXml("nyilvantarto.xml");
        List<Student> _students = XmlManager.ReadStudentDataFromXml("nyilvantarto.xml");

        _workers.forEach((worker) -> {
            AddWorker(worker);
        });

        _students.forEach((student) -> {
            AddStudent(student);
        });
    }
}