/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator3;
import java.util.Collection;
import java.util.Comparator;
/**
 *
 * @author Miruna
 */
public class ListComparator implements Comparator<Node>{
        @Override
    public int compare(Node node1,Node node2) {
        if(node1.getWeight()==node2.getWeight())
            return 0;
        else
            if(node1.getWeight()>node2.getWeight())
                return 1;
        return -1;
    }
}
