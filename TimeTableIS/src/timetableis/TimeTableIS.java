/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timetableis;

import timetableis.view.HomeUI;

/**
 *
 * @author THARU
 */
public class TimeTableIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         HomeUI homeui = new HomeUI();
        homeui.setVisible(true);
        homeui.setSize(1050, 650);
        homeui.setResizable(false);
    }
    
}
