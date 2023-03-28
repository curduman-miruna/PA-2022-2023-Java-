/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator6;

import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.Alignment.CENTER;
import javax.swing.JFrame;
import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SpringLayout.SOUTH;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Miruna
 */
public class MainFrame extends JFrame {
 ConfigPanel configPanel;
 ControlPanel controlPanel;
 DrawingPanel canvas;

 public MainFrame() {
 super("My Drawing Application");
 init();
 }

 private void init() {
 setDefaultCloseOperation(EXIT_ON_CLOSE);

 configPanel = new ConfigPanel(this);
 controlPanel= new ControlPanel(this);
 canvas = new DrawingPanel(this);

 //arrange the components in the container (frame)
 //JFrame uses a BorderLayout by default
 add(canvas, CENTER); //this is BorderLayout.CENTER
 add(configPanel, NORTH);
 add(controlPanel,SOUTH);
 //...TODO
 
 //invoke the layout manager
 pack();
 }
}
