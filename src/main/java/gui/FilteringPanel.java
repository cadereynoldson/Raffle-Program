/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import main_structure.SpreadSheet;

/**
 * JPanel for filtering data. 
 * @author Cade Reynoldson
 */
public class FilteringPanel extends javax.swing.JPanel {

    /** Serial ID. 35th 4 LYFE ! */
    private static final long serialVersionUID = -8389123424375214143L;
    
    /** Sub panel for containing the two types of boxes. Used for proper resizing and positioning. */
    private JPanel subPanel;
    
    /** Contians the check boxes to filter by. */
    private FilteringCheckBoxes boxes; 
    
    /** Contains the values to group by. */
    private FilteringGroupBy groupBy;
    
    /**
     * Creates new form FilteringPanel
     */
    public FilteringPanel(PropertyChangeListener listener) {
        initComponents();
        groupBy = new FilteringGroupBy(listener);
        title.setFont(MasterDisplay.titleFont);
        subPanel = new JPanel();
        subPanel.setLayout(new GridLayout(1, 2));
        subPanel.setBackground(Color.WHITE);
        boxes = new FilteringCheckBoxes(listener);
        subPanel.add(boxes);
        subPanel.add(groupBy);
        add(subPanel, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.WHITE);
    }
    
    /**
     * Increments to total number of items removed. 
     * @param numRemoved the new number removed. 
     */
    public void addNumRemoved(int numRemoved) {
        boxes.addTotalRemoved(numRemoved);
    }
    
    /**
     * Updates the raffle entires in the filtering panel. 
     * @param s the new sheet to display as entries. 
     */
    public void updateEntries(SpreadSheet s) {
        boxes.updateCheckBoxes(s);
        groupBy.updateEntries(s);
        this.repaint();
    }
    
    /**
     * Updates the raffle items in the filtering panel.
     * @param s the new sheet to display as items.  
     */
    public void updateItems(SpreadSheet s) {
        groupBy.updateItems(s);
        repaint();
    }
    
    /**
     * Resets both the boxes and group by panel. 
     */
    public void reset() {
        boxes.reset();
        groupBy.reset();
        repaint();
    }
    
    /**
     * Resets the raffle items in the panel. 
     */
    public void resetItems() {
        groupBy.resetItems();
        repaint();
    }
    
    /**
     * Resets the raffle entries in the panel.
     */
    public void resetEntries() {
        boxes.reset();
        groupBy.resetEntries();
        repaint();
    }
    
    /*********************************************************************
     *                  AUTOMATICALLY GENERATED CODE:                    *
     *********************************************************************/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new java.awt.BorderLayout());

        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("FILTERING");
        add(title, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
