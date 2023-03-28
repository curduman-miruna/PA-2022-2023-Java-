/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework5;

/**
 *
 * @author Miruna
 */
public class ListCommand extends GenericCommand {

    public ListCommand(Catalog catalog) throws InvalidDataException {
        super(catalog);
        if (catalog == null) {
            throw new InvalidDataException("Invalid data encountered in list");
        }
    }

    public void execute() {
        var documents = this.catalog.getDocuments();
        documents.stream().forEach(System.out::println);
    }

}
