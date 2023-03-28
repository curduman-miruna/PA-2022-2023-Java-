/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework5;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Miruna
 */
public class SaveCommand extends GenericCommand {

    private String path;

    public SaveCommand(Catalog catalog, String path) throws InvalidDataException {
        super(catalog);
        if (catalog == null) {
            throw new InvalidDataException("Invalid data encountered in save");
        }
        if (path == null) {
            throw new InvalidDataException("Invalid data encountered in save");
        }
        this.path = path;
    }

    public void execute()
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(this.path),
                this.catalog);
    }
}
