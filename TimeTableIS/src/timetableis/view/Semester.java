package timetableis.view;

/**
 *
 * @author upeksha
 */
public class Semester implements Comparable<Semester> {

    private String name;
    private int studentcount = 0;
    private int assignedcount = 0;

    public Semester(String name, int studentcount) {
        this.name = name;
        this.studentcount = studentcount;
    }

    public String getName() {
        return name;
    }

    public int getStudentcount() {
        return studentcount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentcount(int studentcount) {
        this.studentcount = studentcount;
    }

    @Override
    public String toString() {
        return name + ": " + studentcount;
    }

    public int getAsgCount() {
        return assignedcount;
    }

    public void incAsgCount() {
        assignedcount++;
    }

    @Override
    public int compareTo(Semester t) {   // highest first
        return -(assignedcount - t.getAsgCount());
    }
}
