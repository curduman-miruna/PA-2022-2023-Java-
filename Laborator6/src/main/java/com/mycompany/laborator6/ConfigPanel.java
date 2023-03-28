/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator6;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Miruna
 */
public class ConfigPanel extends JPanel {
final MainFrame frame;
JLabel dotsLabel, linesLabel;
JSpinner dotsSpinner;
JComboBox linesCombo;
JButton createButton;

 public ConfigPanel(MainFrame frame) {
 this.frame = frame;
 init();
 }
 private void init() {
 //create the label and the spinner
 dotsLabel = new JLabel("Number of dots:");
 dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

 //create the rest of the components
 //...TODO
 add(dotsLabel); //JPanel uses FlowLayout by default
 add(dotsSpinner);
 //...TODO
 }
}
