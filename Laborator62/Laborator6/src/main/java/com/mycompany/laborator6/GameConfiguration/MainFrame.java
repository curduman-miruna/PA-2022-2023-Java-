/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator6.GameConfiguration;

import com.mycompany.laborator6.GameControl.ControlPanel;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
import javax.swing.JFrame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
/**
 *
 * @author Miruna
 */
public class MainFrame extends JFrame implements Serializable {

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
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        
        // invoke the layout manager
        pack();

        // center the frame on the screen
        setLocationRelativeTo(null);
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }

    public void setCanvas(DrawingPanel canvas) {
        this.canvas = canvas;
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public void setConfigPanel(ConfigPanel configPanel) {
        this.configPanel = configPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

}
