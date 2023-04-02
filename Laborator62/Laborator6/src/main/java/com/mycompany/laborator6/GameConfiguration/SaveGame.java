package com.mycompany.laborator6.GameConfiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.mycompany.laborator6.GameConfiguration.DrawingPanel;
import com.mycompany.laborator6.GameConfiguration.Elements.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.security.sasl.SaslClient;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class SaveGame implements Serializable {
    private int numVertices;
    private double edgeProbability;
    private int[] arrayX, arrayY;
    private boolean ended;
    @JsonSerialize(contentUsing = Line2DSerializer.class)
    private List<Line2D> lines;
    private Player player1;
    private Player player2;
    boolean whoIsPlaying; // 0 - player one, 1 - player 2;

    public SaveGame(){

    }
    public SaveGame(DrawingPanel canva)
    {
        this.whoIsPlaying=canva.isWhoIsPlaying();
        this.arrayX= canva.getArrayX();
        this.arrayY= canva.getArrayY();
        this.player1=canva.getPlayer1();
        this.player2=canva.getPlayer2();
        this.edgeProbability= canva.getEdgeProbability();
        this.numVertices=canva.getNumVertices();
        this.lines=canva.getLines();
    }

    public void saveToFile() {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.toString().replace("T", "_").replace(":", "-").substring(0, 19);
        String path="C:/Users/Admin/Documents/GitHub/PA-2022-2023/Laborator62/Laborator6/"+timestamp+".json";
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Color.class, new ColorSerializer());
        mapper.registerModule(module);
        try {
            mapper.writeValue(new File(path), this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SaveGame loadFromFile(DrawingPanel canva) {
        SaveGame saveGame = new SaveGame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("C:/Users/Admin/Documents/GitHub/PA-2022-2023/Laborator62/Laborator6/"));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ObjectMapper mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(Line2D.class, new Line2DDeserializer());
            module.addDeserializer(Color.class,new ColorDeserializer());
            module.addSerializer(Color.class, new ColorSerializer());
            mapper.registerModule(module);
            try {
                saveGame = mapper.readValue(selectedFile, SaveGame.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            canva.setWhoIsPlaying(saveGame.whoIsPlaying);
            canva.setArrayX(saveGame.arrayX);
            canva.setArrayY(saveGame.arrayY);
            canva.setPlayer1(saveGame.player1);
            canva.setPlayer2(saveGame.player2);
            canva.setEdgeProbability(saveGame.edgeProbability);
            canva.setNumVertices(saveGame.numVertices);
            canva.setLines(saveGame.lines);
            canva.loadGameHistory();}
        return null;
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

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
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
