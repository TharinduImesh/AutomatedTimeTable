
package timetableis.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author THARINDU
 */
public class LecturerManagerWindow extends javax.swing.JPanel {

    private DefaultTableModel teachertable;
    
    private DefaultComboBoxModel<String> listSubjectsCmb=new DefaultComboBoxModel<>();
    private DefaultListModel<String> subjects=new DefaultListModel<>();
    private DefaultTableModel availabletable;
    
    private ListSelectionListener teachertablelistn;
    
    private List<Module> tempsubjects=new ArrayList<Module>();
    
    
    public LecturerManagerWindow() {
        //model = new DefaultTableModel();
        initComponents();
        //jTable1.setModel(model);
        
        teachertable=(DefaultTableModel)jtblteachers.getModel();
//        availabletable=(DefaultTableModel)jtblavailable.getModel();
        
        cmbsubjects.setModel(listSubjectsCmb);
        jlistsubjects.setModel(subjects);
        jtblteachers.setModel(teachertable);
        
        
        teachertablelistn=new ListSelectionListener() {

            
            
            @Override
            public void valueChanged(ListSelectionEvent lse) {              
                int row=jtblteachers.getSelectedRow();
                
                String name=(String)teachertable.getValueAt(row, 0);
                txtname.setText(name);
                
                Lecturer t=ListCollection.getTeachers().get(ListCollection.getTeachers().indexOf(name));
                
                List<Module> list=t.getSubjects();
                subjects.removeAllElements();
               
                for (int i = 0; i < list.size(); i++) {
                    subjects.addElement(list.get(i).getCode()+" "+list.get(i).getName());
                }
                
                Boolean[][] aval =t.getAvailablility();
                
                availabletable.setDataVector(aval, ListCollection.getDayNames());
                               
            }
        };
        
        jtblteachers.getSelectionModel().addListSelectionListener(teachertablelistn);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblteachers = new javax.swing.JTable();
        btnRemTeacher = new javax.swing.JButton();
        cmbsubjects = new javax.swing.JComboBox();
        btnAddSub = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlistsubjects = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        btnRemSub = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setText("Teacher Name");

        jLabel2.setText("Subject");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jtblteachers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Teacher", "Subject(s)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtblteachers);

        btnRemTeacher.setText("Remove");
        btnRemTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemTeacherActionPerformed(evt);
            }
        });

        cmbsubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbsubjectsActionPerformed(evt);
            }
        });

        btnAddSub.setText("Add Subject");
        btnAddSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSubActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jlistsubjects);

        jLabel3.setText("Current Subjects");

        btnRemSub.setText("Remove");
        btnRemSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemSubActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 2, 18)); // NOI18N
        jLabel5.setText("Teacher Manager Panel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbsubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAddSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtname)))
                            .addComponent(btnRemSub, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRemTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(btnAddSub)
                            .addComponent(cmbsubjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemSub)
                        .addGap(191, 211, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemTeacher))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        String name=txtname.getText();
        Lecturer t=new Lecturer(name);
        
        List<Module> subs=t.getSubjects();
        
        for (int i = 0; i < tempsubjects.size(); i++) {
            subs.add(tempsubjects.get(i));
        }
        
        ListCollection.getTeachers().add(t);
        
        refreshTeacherTable();
        
        txtname.setText("");
//        subjects.clear();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemTeacherActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) this.jtblteachers.getModel();
        int[] rows = jtblteachers.getSelectedRows();
        for(int i=0;i<rows.length;i++){
            model.removeRow(rows[i]-i);
        }
    }//GEN-LAST:event_btnRemTeacherActionPerformed

    private void cmbsubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbsubjectsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbsubjectsActionPerformed

    private void btnAddSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSubActionPerformed
        tempsubjects.add(ListCollection.getSubjects().get(cmbsubjects.getSelectedIndex()));
        refreshTempSubjectList();
    }//GEN-LAST:event_btnAddSubActionPerformed

    private void btnRemSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemSubActionPerformed
        tempsubjects.remove(jlistsubjects.getSelectedIndex());
        refreshTempSubjectList();
    }//GEN-LAST:event_btnRemSubActionPerformed

    
    public void update() {
        listSubjectsCmb.removeAllElements();

        List<Module> list = ListCollection.getSubjects();
        for (int i = 0; i < list.size(); i++) {
            listSubjectsCmb.addElement(list.get(i).getName());
        }
        
        refreshTeacherTable();
        
    }
    
    public void refreshTempSubjectList() {

        subjects.clear();

        for (int i = 0; i < tempsubjects.size(); i++) {
            subjects.addElement(tempsubjects.get(i).toString());
        }
    }
    
    
   
    public void refreshSubjectList(Lecturer t) {

        subjects.clear();
        List<Module> list = t.getSubjects();

        for (int i = 0; i < list.size(); i++) {
            subjects.addElement(list.get(i).toString());
        }
    }
    
    public void refreshTeacherTable(){
        
        jtblteachers.getSelectionModel().removeListSelectionListener(teachertablelistn);
        
        int rows= teachertable.getRowCount();
        for (int i = 0; i < rows;i++) {
            teachertable.removeRow(0);
        }
               
        List<Lecturer> teachers=ListCollection.getTeachers();
        
        for (int i = 0; i < teachers.size(); i++) {
            Lecturer t=teachers.get(i);
            List<Module> sublist=t.getSubjects();
            String subs="";
            for (int j = 0; j < sublist.size(); j++) {
                subs+=sublist.get(j).getCode()+" ";
            }
            
            teachertable.addRow(new Object[]{t.getName(),subs});
            
        }
        
        jtblteachers.getSelectionModel().addListSelectionListener(teachertablelistn);
        
    }
    
public void updateSubjects(List<Module> subjects){
    for(int i=0;i<subjects.size();i++){
        cmbsubjects.addItem(subjects.get(i).getCode()+" : "+subjects.get(i).getName());
    }
}    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddSub;
    private javax.swing.JButton btnRemSub;
    private javax.swing.JButton btnRemTeacher;
    private javax.swing.JComboBox cmbsubjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList jlistsubjects;
    private javax.swing.JTable jtblteachers;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
