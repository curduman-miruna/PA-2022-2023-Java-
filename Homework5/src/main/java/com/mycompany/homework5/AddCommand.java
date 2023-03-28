/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework5;

/**
 *
 * @author Miruna
 */
public class AddCommand extends GenericCommand {

    private Document doc;

    public AddCommand(Catalog catalog, Document doc) throws InvalidDataException {
        super(catalog);
        if (catalog == null) {
            throw new InvalidDataException("Invalid data encountered in save");
        }
        if (doc == null) {
            throw new InvalidDataException("Invalid data encountered in save");
        }
        this.doc = doc;

    }

    public void execute() {
        catalog.add(this.doc);
    }

}
