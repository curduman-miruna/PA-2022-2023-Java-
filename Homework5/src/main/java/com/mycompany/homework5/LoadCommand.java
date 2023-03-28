/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework5;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author Miruna
 */
public class LoadCommand extends GenericCommand {

    private String path;

    public LoadCommand(Catalog catalog, String path) throws InvalidDataException {
        super(catalog);
        if (path == null) {
            throw new InvalidDataException("Invalid data encountered in load");
        }
        this.path = path;

    }

    public Catalog execute()
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return catalog;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.path);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoadCommand other = (LoadCommand) obj;
        return Objects.equals(this.path, other.path);
    }

    @Override
    public String toString() {
        return "LoadCommand{" + "path=" + path + '}';
    }

}
