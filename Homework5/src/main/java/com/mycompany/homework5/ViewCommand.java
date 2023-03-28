/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework5;

import static com.mycompany.homework5.CatalogUtil.isPath;
import static com.mycompany.homework5.CatalogUtil.isURL;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Miruna
 */
public class ViewCommand extends GenericCommand {

    private Document doc;

    public ViewCommand(Catalog catalog, Document doc) throws InvalidDataException {
        super(catalog);
        if (catalog == null) {
            throw new InvalidDataException("Invalid data encountered in save");
        }
        if (doc == null) {
            throw new InvalidDataException("Invalid data encountered in save");
        }
        this.doc = doc;
    }

    public static boolean isURL(String path) {
        try {
            URI uri = new URI(path);
            String scheme = uri.getScheme();
            return scheme != null && (scheme.equals("http") || scheme.equals("https"));
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static boolean isPath(String path) {
        try {
            URI uri = new URI(path);
            String scheme = uri.getScheme();
            return scheme == null || scheme.equals("file");
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public void execute() throws IOException, URISyntaxException {

        if (this.doc == null) {
            throw new IllegalArgumentException("Document cannot be null");
        }

        Desktop desktop = Desktop.getDesktop();
        if (isPath(this.doc.getLocation())) {
            var viewDocument = new File(this.doc.getLocation());
            if (viewDocument.exists()) {
                desktop.open(viewDocument);
            }
        }
        if (isURL(doc.getLocation())) {
            var viewDocument = new URI(this.doc.getLocation());
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(viewDocument);
            }
        }
    }
}
