/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laborator5;

/**
 *
 * @author Miruna
 */
public class Laborator5 {

    public static void main(String args[]) {
        Laborator5 app = new Laborator5();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog
                = new Catalog("MyDocuments");
        var book = new Document("article1") {};
        var article = new Document("book1") {};
        catalog.add(book);
        catalog.add(article);

        //CatalogUtil.save(catalog, "d:/research/catalog.json");
    }

    private void testLoadView() {
    //Catalog catalog = CatalogUtil.load("d:/research/catalog.json");
    //CatalogUtil.view(catalog.findById("article1"));
    }

}

