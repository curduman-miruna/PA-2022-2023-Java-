/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laborator7;

import java.util.Collections;
import java.util.*;

public class SharedMemory {
    private final List<Token> tokens;
    
    public SharedMemory(int n) {
        tokens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
    }
    
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.remove(0));
        }
        return extracted;
    }
}
