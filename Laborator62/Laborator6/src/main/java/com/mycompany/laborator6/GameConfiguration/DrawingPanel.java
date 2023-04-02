/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator6.GameConfiguration;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.laborator6.GameConfiguration.Elements.Dot;
import com.mycompany.laborator6.GameConfiguration.Elements.Line2DSerializer;
import com.mycompany.laborator6.GameConfiguration.Elements.Player;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Miruna
 */
public class DrawingPanel extends JPanel implements Serializable {

    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] arrayX, arrayY;
    private Dot lastDot = new Dot();
    private boolean changedLast = false;
    private boolean ended=false;
    private Dot currentDot = new Dot();
    @JsonSerialize(contentUsing = Line2DSerializer.class)
    private List<Line2D> lines = new ArrayList<>();

    private Player player1 = new Player();
    private Player player2 =  new Player();
    boolean whoIsPlaying; // 0 - player one, 1 - player 2;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Dot checkDot = new Dot(e.getX(), e.getY());
                if(checkIfSelectedPressed(checkDot)){
                    changedLast=true;
                }
                else changedLast=false;
                    }

            @Override
            public void mouseReleased(MouseEvent e) {
                Dot checkDot = new Dot(e.getX(), e.getY());
                if(ended==false){
                if(checkIfSelectedReleased(checkDot) && changedLast==true){
                    if(whoIsPlaying)
                    {graphics.setColor(player2.getColor());}
                    else
                    {graphics.setColor(player1.getColor());}
                    graphics.setStroke(new BasicStroke(3));
                    Line2D line = new Line2D.Double(lastDot.getX(), lastDot.getY(), currentDot.getX(), currentDot.getY());
                    Line2D lineReversed = new Line2D.Double(currentDot.getX(), currentDot.getY(), lastDot.getX(), lastDot.getY());
                    for (Line2D existingLine : lines) {
                        if ((existingLine.getP1().equals(line.getP1())&&existingLine.getP2().equals(line.getP2())) || (existingLine.getP1().equals(lineReversed.getP1())&&existingLine.getP2().equals(lineReversed.getP2()))) {
                            if(getPlayer().containsLine(currentDot,lastDot)==-2 || getPlayer().containsLine(currentDot,lastDot)==-1){
                                getPlayer().addLine(currentDot,lastDot);
                            graphics.drawLine(lastDot.getX(), lastDot.getY(), currentDot.getX(), currentDot.getY());
                            if(getPlayer().containsTriangle()==true)
                            {
                                drawVertices();
                                repaint();
                                String hexColor = "#" + Integer.toHexString(getPlayer().getColor().getRGB()).substring(2);
                                String message = "<html><font color='" + hexColor + "'>Player has won</font></html>";
                                JOptionPane.showMessageDialog(null, message);
                            ended=true;}
                            whoIsPlaying=!whoIsPlaying;
                            int id=getPlayer().containsLine(currentDot,lastDot);
                            if(id!=-1 && id!=-2)
                                getPlayer().deleteLines(id);
                            break;
                            }}
                        }
                drawVertices();
                repaint();}
            else
            return;}}
        });}

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    public void createImage()
    {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        paint(image.getGraphics());
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.toString().replace("T", "_").replace(":", "-").substring(0, 19);
        String path="C:/Users/Admin/Documents/GitHub/PA-2022-2023/Laborator62/Laborator6/";
        File file = new File(System.getProperty(path), timestamp+".png");
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        lines = new ArrayList<>();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
        ended=false;
        player1 = new Player();
        player2 =  new Player();

    }

    public void resetGame()
    {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
        redrawLines();
        repaint();
        ended=false;
        player1 = new Player();
        player2=new Player();

    }

    private boolean checkIfSelectedPressed(Dot dot){
        for (int i = 0; i < numVertices; i++) {
            Dot circle = new Dot(arrayX[i], arrayY[i]);
            if (circle.getOval().contains(dot.getX(),dot.getY())) {
                lastDot=circle;
                return true;
            }}
        return false;
    }

    private boolean checkIfSelectedReleased(Dot dot){
        for (int i = 0; i < numVertices; i++) {
            Dot circle = new Dot(arrayX[i], arrayY[i]);
            if (circle.getOval().contains(dot.getX(),dot.getY())) {
                currentDot=circle;
                return true;
            }}
        return false;
    }
    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        arrayX = new int[numVertices];
        arrayY = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            arrayX[i] = x0 + (int) (radius * Math.cos(alpha * i));
            arrayY[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        graphics.setColor(Color.BLACK);
        graphics.setStroke(new BasicStroke(2));
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                double r = Math.random();
                if (r < edgeProbability) {
                    Line2D line = new Line2D.Double(arrayX[i], arrayY[i], arrayX[j], arrayY[j]);
                    graphics.drawLine(arrayX[i], arrayY[i], arrayX[j], arrayY[j]);
                    lines.add(line);
                }
            }
        }
    }
     public void redrawLines(){
         graphics.setColor(Color.BLACK);
         graphics.setStroke(new BasicStroke(2));
         for (Line2D line : lines) {
             graphics.draw(line);}
         drawVertices();
         repaint();
     }

    public void loadGameHistory(){
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
        graphics.setColor(Color.BLACK);
        graphics.setStroke(new BasicStroke(2));
        for (Line2D line : lines) {
            graphics.draw(line);
        }
        graphics.setColor(player1.getColor());
        graphics.setStroke(new BasicStroke(3));
        for (Line2D line : player1.getPlayerLines()) {
            graphics.draw(line);
        }
        graphics.setColor(player2.getColor());
        for (Line2D line : player2.getPlayerLines()) {
            graphics.draw(line);
        }
        drawVertices();
        repaint();
    }
    private void drawVertices() {
        graphics.setColor(Color.RED);
        for (int i = 0; i < numVertices; i++) {
            graphics.fillOval(arrayX[i] - 10, arrayY[i] - 10, 20, 20);
        }
    }
    public Player getPlayer()
    {
        if(whoIsPlaying)
            return player2;
        return player1;
    }
    @Override
    public void update(Graphics g) {
    } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public double getEdgeProbability() {
        return edgeProbability;
    }

    public void setEdgeProbability(double edgeProbability) {
        this.edgeProbability = edgeProbability;
    }

    public int[] getArrayX() {
        return arrayX;
    }

    public void setArrayX(int[] arrayX) {
        this.arrayX = arrayX;
    }

    public int[] getArrayY() {
        return arrayY;
    }

    public void setArrayY(int[] arrayY) {
        this.arrayY = arrayY;
    }

    public List<Line2D> getLines() {
        return lines;
    }

    public void setLines(List<Line2D> lines) {
        this.lines = lines;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public boolean isWhoIsPlaying() {
        return whoIsPlaying;
    }

    public void setWhoIsPlaying(boolean whoIsPlaying) {
        this.whoIsPlaying = whoIsPlaying;
    }
}
