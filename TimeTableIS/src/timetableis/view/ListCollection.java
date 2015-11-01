
package timetableis.view;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shehan
 */
public class ListCollection {

    private static ListCollection app;
    
    private List<Semester> classes;
    private List<Module> subjects;
    private List<Lecturer> teachers;   
    private int days=5,slots=8;
    private String[] daynames={"Monday","Tuesday","Wednesday","Thursday","Friday"};
    
    public ListCollection() {

        classes = new ArrayList<Semester>() {
            @Override
            public boolean contains(Object o) {
                int i = indexOf(o);
                if (i >= 0) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public int indexOf(Object o) {
                String name = ((String) o).split(":")[0];
                for (int i = 0; i < size(); i++) {
                    if (get(i).toString().split(":")[0].equals(name)) {
                        return i;
                    }
                }
                return -1;
            }
        };
      
        subjects = new ArrayList<Module>() {
            @Override
            public boolean contains(Object o) {
                int i = indexOf(o);
                if (i >= 0) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public int indexOf(Object o) {
                String code = ((String) o).split(":")[0];
                for (int i = 0; i < size(); i++) {
                    if (get(i).toString().split(":")[0].equals(code)) {
                        return i;
                    }
                }
                return -1;
            }
        };
        
        teachers = new ArrayList<Lecturer>() {
            @Override
            public boolean contains(Object o) {
                int i = indexOf(o);
                if (i >= 0) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public int indexOf(Object o) {
                String name = ((String) o).split(":")[0];
                for (int i = 0; i < size(); i++) {
                    if (get(i).toString().split(":")[0].equals(name)) {
                        return i;
                    }
                }
                return -1;
            }
        };
        
        classes.add(new Semester("Semester 1", 100));
        classes.add(new Semester("Semester 2", 100));
        classes.add(new Semester("Semester 3", 100));
        classes.add(new Semester("Semester 4", 100));
        classes.add(new Semester("Semester 5", 100));
        classes.add(new Semester("Semester 7", 100));
        classes.add(new Semester("Semester 8", 100));
        
    }

    private static ListCollection _getinstance() {
        if (app == null) {
            app = new ListCollection();
        }
        return app;
    }

    public static List<Semester> getClasses() {
        return _getinstance().classes;
    }

    public static List<Module> getSubjects(){
        return _getinstance().subjects;
    }

    public static List<Lecturer> getTeachers() {
        return _getinstance().teachers;
    }
      
    
    public static int getNumofDays(){
        return _getinstance().days;
    }
    
    public static int getNumofSlots(){
       return _getinstance().slots;          
    }
    
    public static String[] getDayNames(){
        return _getinstance().daynames;
    }
    
    
}
