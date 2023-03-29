/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton newGameBtn = new JButton("New Game");
    JButton undoBtn = new JButton("Undo");
    
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 5));
        add(loadBtn);
        add(saveBtn);
        add(newGameBtn);
        add(undoBtn);
        add(exitBtn);
        
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadData);
        saveBtn.addActionListener(this::saveData);
        newGameBtn.addActionListener(this::startNewGame);
        undoBtn.addActionListener(this::undoLastAction);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
    
    private void loadData(ActionEvent e) {
        // to do
    }
    
    private void saveData(ActionEvent e) {
        // to do
    }
    
    private void startNewGame(ActionEvent e) {
        // to do
    }
    
    private void undoLastAction(ActionEvent e) {
        //to do
    }
}
