/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework5;

/**
 *
 * @author Miruna
 */
public class ToStringCommand extends GenericCommand {

    public ToStringCommand(Catalog catalog) throws InvalidDataException {
        super(catalog);
        if (catalog == null) {
            throw new InvalidDataException("Invalid data encountered in save");
        }
    }

    public String execute() {
        return "Catalog{" + "name=" + this.catalog.getName() + ", documents=" + this.catalog.getDocuments() + '}';
    }

}
