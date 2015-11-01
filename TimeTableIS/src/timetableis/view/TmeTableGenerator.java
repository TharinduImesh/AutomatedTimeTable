/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timetableis.view;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author GAYAN
 */
public class TmeTableGenerator {

    private List<Semester> classes;
    private List<Module> subjects;
    private boolean[][] conflicts;

    public TmeTableGenerator() {
        subjects = new ArrayList<>();
        classes = new ArrayList<>();
    }

    public void run(int limit) {
        initialize();
        setNSortClassList();
        printClassList();

        setSubList();
        printSubList();

        constructConflictTable();
        printConflictTable();

        //testColor();
        colorSubjects(limit);
        printColors();
    }

    public void initialize() {
    }

    public void constructConflictTable() {

        conflicts = new boolean[subjects.size()][subjects.size()];

        for (int i = 0; i < subjects.size(); i++) {
            for (int j = 0; j < subjects.size(); j++) {
                if (i != j) {

                    Module s1 = subjects.get(i);
                    Module s2 = subjects.get(j);

                    if (isConflicted(s1, s2)) {
                        conflicts[i][j] = true;
                    }
                }
            }
        }
    }

    public void printConflictTable() {

        System.out.println("************* CONFLICTS TABLE *************\n");
        System.out.print("\t\t");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.print(subjects.get(i).getCode()+"\t");
        }
        System.out.println("");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.print(i +"\t"+ subjects.get(i).getCode()+"\t");
            for (int j = 0; j < subjects.size(); j++) {

                System.out.print((conflicts[i][j] ? "1" : "0") + "\t");
            }
            System.out.println("");
        }
        
        System.out.println("");

    }

    public boolean isConflicted(Module s1, Module s2) {

        if (s1.getFixedSlots() > 0 && s2.getFixedSlots() > 0) {

            if (s1.getFixedTeacher().equals(s2.getFixedTeacher())) {
                return true;
            } else if (s1.getFixedClass().equals(s2.getFixedClass())) {
                return true;
            } else {
                return false;
            }

        } else {
            System.out.println("Error in isConflicted");
            return false;
        }

    }

    public void setNSortClassList() {
        List<Semester> clslist = ListCollection.getClasses();
        List<Module> sublist = ListCollection.getSubjects();
        for (int i = 0; i < clslist.size(); i++) {
            Semester s = clslist.get(i);

            for (int j = 0; j < sublist.size(); j++) {
                if (s.equals(sublist.get(j).getFixedClass())) {
                    s.incAsgCount();
                }
            }

            if (s.getAsgCount() > 0) {
                classes.add(s);
            }
        }
        Collections.sort(classes);

    }

    public void printClassList() {
        System.out.println("\n************ SORTED NUMBER OF SUBJECTS FOR EACH SEMISTER *************");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println(classes.get(i).getName() + " " + classes.get(i).getAsgCount());
        }
        System.out.println();
    }

    public void setSubList() {
        subjects.clear();
        for (Semester cls : classes) {
            for (Module s : ListCollection.getSubjects()) {
                if (s.getFixedSlots() > 0) {
                    if (cls.equals(s.getFixedClass())) {
                        subjects.add(s);
                    }
                }
            }
        }
    }

    public void printSubList() {
       System.out.println("*********** SORTED SUBJECTS LIST ACCORDING TO THE NUMBER OF CONFLICTS ************");
        for (Module s : subjects) {
            System.out.println(s.getFixedClass().getName() + " " + s);
        }
        System.out.println();
        
    }

    public void testColor() {
        Module s1 = subjects.get(0);
        Module s2 = subjects.get(1);
        Module s3 = subjects.get(2);

        s1.addAllColorsUntil(4);
        s2.addAllColorsUntil(4);
        s3.addAllColorsUntil(4);


        s2.removeColor(1, s3);
        s2.printAvailableColors();
        s2.addPreRemovedColor(5, s3);
        s2.addPreRemovedColor(2, s3);

        s2.printAvailableColors();

        s2.addPreRemovedColor(1, s1);
        s2.printAvailableColors();

        s2.addPreRemovedColor(1, s3);
        s2.printAvailableColors();

    }

    public void colorSubjects(int limit) {

        System.out.println("*************** COLOURING METHOD *****************");
        System.out.println("<Assigned subject's number> -> <Colour number> ");
        
        //initialize
        for (int i = 0; i < subjects.size(); i++) {
            subjects.get(i).clearColorList();
            subjects.get(i).addAllColorsUntil(limit);
        }

        boolean result=recursiveBacktrackColor(0);
        System.out.print(result?"":"[ERROR] ");
        System.out.print("Colouring ");
        System.out.println(result?"Successful":"Unsuccessful");
    }

    public boolean recursiveBacktrackColor(int index) {
        Module s = subjects.get(index);
        List<Integer> colors = s.getAvailableColorList();
        if (colors.isEmpty()) {
            System.out.println("[ERROR] Colors remaining for Subject "+index +" is 0" );
            return false;
        }
        for (int i = 0; i < colors.size(); i++) {
            int current = colors.get(i);
            s.setColor(current);
            System.out.println(index+ " -> " +current);
            for (int j = 0; j < subjects.size(); j++) {
                if (conflicts[index][j] == true) {
                    subjects.get(j).removeColor(current, s);
                }
            }
            if (index + 1 < subjects.size()) {
                boolean result = recursiveBacktrackColor(index + 1);

                if (result == true) {
                    return true;
                } else {             
                    s.setColor(0);
                    System.out.println("\t So Backtracking to Subject No "+index);
                    //readd prevoiously removed colors
                    for (int j = 0; j < subjects.size(); j++) {
                        if (conflicts[index][j] == true) {
                            subjects.get(j).addPreRemovedColor(current, s);
                        }
                    }                   
                    continue;                  
                }
            } else {
                return true;
            }
        }
        System.out.println("[ERROR] All remaining colors for Subject "+index +" is not possible");
        return false;       
    }
    
    public void printColors(){
        System.out.println("\n************* CURRENTLY ASSIGNED COLOURS *************");
        System.out.println("<Subject name> --> <Color number>");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println(subjects.get(i).getName()+" --> " +subjects.get(i).getColor() );
        }
    }   
    
}

