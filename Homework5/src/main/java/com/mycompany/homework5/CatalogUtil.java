/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework5;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Miruna
 */
public class CatalogUtil {

    public static boolean isURL(String str) {
        try {
            URI uri = new URI(str);
            String scheme = uri.getScheme();
            return scheme != null && (scheme.equals("http") || scheme.equals("https"));
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static boolean isPath(String str) {
        try {
            URI uri = new URI(str);
            String scheme = uri.getScheme();
            return scheme == null || scheme.equals("file");
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return catalog;
    }

    public static void view(Document doc) throws IOException, URISyntaxException {

        if (doc == null) {
            throw new IllegalArgumentException("Document cannot be null");
        }

        Desktop desktop = Desktop.getDesktop();
        if (isPath(doc.getLocation())) {
            var viewDocument = new File(doc.getLocation());
            if (viewDocument.exists()) {
                desktop.open(viewDocument);
            }
        }
        if (isURL(doc.getLocation())) {
            var viewDocument = new URI(doc.getLocation());
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(viewDocument);
            }
        }
    }

}
