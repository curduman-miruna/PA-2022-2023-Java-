/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.homework5;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 *
 * @author Miruna
 */
public class Homework5 {

    public static void main(String args[]) throws IOException, InvalidCatalogException, URISyntaxException, InvalidDataException {
        // set up configuration for template - o singura data
        Homework5 app = new Homework5();
        app.testCreateSave();
        app.testLoadView();
        app.testReport();
        app.testList();
        app.testInvalidDataException();
    }

    private void testCreateSave() throws IOException, URISyntaxException, InvalidDataException {

        Catalog catalog = new Catalog();
        var article = new Article("1123", "article1", "https://en.wikipedia.org/wiki/Embedded_system");
        var book = new Book("1112", "book1", "https://www.amazon.com/Sistema-embedded-Real-Time-applicazione-Avionica/dp/6203245119");
        var addCommand1 = new AddCommand(catalog, book);
        var addCommand2 = new AddCommand(catalog, article);
        addCommand1.execute();
        addCommand2.execute();
        var saveCommand = new SaveCommand(catalog, "c:/Users/Admin/Documents/GitHub/PA-2022-2023/Homework5/catalog.json");
        saveCommand.execute();
    }

    private void testLoadView() throws InvalidCatalogException, IOException, URISyntaxException, InvalidDataException {
        var catalog = new Catalog("Catalog");
        var loadCommand = new LoadCommand(catalog, "c:/Users/Admin/Documents/GitHub/PA-2022-2023/Homework5/catalog.json");
        catalog = loadCommand.execute();
        var viewCommand = new ViewCommand(catalog, catalog.findById("1123"));
        viewCommand.execute();
    }

    private void testReport() throws IOException, InvalidDataException {
        Catalog catalog = new Catalog("MyDocuments");
        var article = new Article("1123", "article1", "https://en.wikipedia.org/wiki/Embedded_system");
        var book = new Book("1112", "book1", "https://www.amazon.com/Sistema-embedded-Real-Time-applicazione-Avionica/dp/6203245119");
        catalog.add(book);
        catalog.add(article);
        var reportCommand = new ReportCommand(catalog);
        reportCommand.execute();
    }

    public void testList() throws InvalidDataException {
        Catalog catalog = new Catalog("MyDocuments");
        var article = new Article("1123", "article1", "https://en.wikipedia.org/wiki/Embedded_system");
        var book = new Book("1112", "book1", "https://www.amazon.com/Sistema-embedded-Real-Time-applicazione-Avionica/dp/6203245119");
        var addCommand1 = new AddCommand(catalog, book);
        var addCommand2 = new AddCommand(catalog, article);
        addCommand1.execute();
        addCommand2.execute();
        var listCommand = new ListCommand(catalog);
        listCommand.execute();
    }

    public void testInvalidDataException() throws InvalidDataException, IOException {
        var reportCommand = new ReportCommand(null);
    }

}
