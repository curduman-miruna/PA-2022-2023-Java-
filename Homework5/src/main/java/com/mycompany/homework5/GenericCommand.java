/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework5;

import java.util.Objects;

/**
 *
 * @author Miruna
 */
public abstract class GenericCommand {

    protected Catalog catalog;

    public GenericCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.catalog);
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
        final GenericCommand other = (GenericCommand) obj;
        return Objects.equals(this.catalog, other.catalog);
    }

    @Override
    public String toString() {
        return "GenericCommand{" + "catalog=" + catalog + '}';
    }

}
