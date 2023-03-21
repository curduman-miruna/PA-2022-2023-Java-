/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laborator5;
import java.io.IOException;

/**
 *
 * @author Miruna
 */
public class Laborator5 {

    public static void main(String args[]) throws IOException {
        Laborator5 app = new Laborator5();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog
                = new Catalog("MyDocuments");
        var book = new Document("article1") {};
        var article = new Document("book1") {};
        catalog.add(book);
        catalog.add(article);

        CatalogUtil.save(catalog, "c:/Users/Admin/Documents/GitHub/PA-2022-2023/Laborator5/catalog.json");
    }

    private void testLoadView() {
    //Catalog catalog = CatalogUtil.load("d:/research/catalog.json");
    //CatalogUtil.view(catalog.findById("article1"));
    }

}

