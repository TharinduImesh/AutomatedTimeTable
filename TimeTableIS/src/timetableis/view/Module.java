/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetableis.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Shehan
 */
public class Module {

    private String name;
    private String code;
    private int fixedSlots = 0;
    private Lecturer fixedLecturer;
    private Semester fixedClass;
    private List<Integer> availableColors;
    private HashMap<Integer, Module> removedby;
    private int color = 0;

    public final void init() {
        availableColors = new ArrayList<>();
        removedby = new HashMap<>();
    }

    public Module(String name, String code, Semester toClass, int slots) {
        this.name = name;
        this.code = code;
        this.fixedClass = toClass;
        this.fixedSlots = slots;
        init();
    }

    public Module(String name, String code) {
        this.name = name;
        this.code = code;
        init();
    }

    public void setFixedSlots(int slots) {
        this.fixedSlots = slots;
    }

    public void setFixedClass(Semester toClass) {
        this.fixedClass = toClass;
    }

    public void setFixedTeacher(Lecturer fixedLecturer) {
        this.fixedLecturer = fixedLecturer;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getFixedSlots() {
        return fixedSlots;
    }

    public Semester getFixedClass() {
        return fixedClass;
    }

    public Lecturer getFixedTeacher() {
        return fixedLecturer;
    }

    public void setActivity(Semester toclass, Lecturer teacher, int numslots) {
        fixedClass = toclass;
        fixedLecturer = teacher;
        fixedSlots = numslots;
    }

    @Override
    public String toString() {
        return name + ":" + code;
    }

    public List<Integer> getAvailableColorList(){
        return availableColors;
    }
    
    public void addAllColorsUntil(int limit) {
        for (int i = 1; i <= limit; i++) {
            availableColors.add(i);
        }
    }
    
    public void clearColorList(){
        availableColors.clear();
    }

    public void printAvailableColors() {
        System.out.println("Available colous of " + this);
        for (int i = 0; i < availableColors.size(); i++) {
            System.out.println(availableColors.get(i));
        }
    }

    public void removeColor(Integer color, Module by) {
        if (!hasColored()) {
            if (availableColors.contains(color)) {
                removedby.put(color, by);
                availableColors.remove(color);
            }
        }
    }

    public void addPreRemovedColor(int color, Module by) {
        if (!hasColored()) {
            if (!availableColors.contains(color)) {
                if (removedby.get(color)!=null && removedby.get(color).equals(by)) {
                    availableColors.add(color);
                    removedby.remove(color);
                }
            } else {
                System.out.println("Error - added non removed color in " + getName() +", color="+color);
            }
        }
    }

    public void setColor(int col) {
        color = col;
    }

    public int getColor() {
        return color;
    }

    public boolean hasColored() {
        return color != 0;
    }
}
