/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package timetableis.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author THARINDU
 */
public class Lecturer {
    
    private String name;
    private List<Module> modules;
    private Boolean[][] availablility;

    public void setAvailablility(Boolean[][] availablility) {
        this.availablility = availablility;
    }

    public Lecturer(String name) {
        this.name = name;
        modules=new ArrayList<>();
        availablility=new Boolean[ListCollection.getNumofSlots()][ListCollection.getNumofDays()];
        
        for (int i = 0; i < ListCollection.getNumofSlots(); i++) {
            for (int j = 0; j < ListCollection.getNumofDays(); j++) {
                availablility[i][j]=true;
            }
        }

    }

    public String getName() {
        return name;
    }

    public Boolean[][] getAvailablility() {
        return availablility;       
    }

    public List<Module> getSubjects() {
        return modules;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
