/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework5;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 *
 * @author Miruna
 */
public class ReportCommand extends GenericCommand {

    public ReportCommand(Catalog catalog) throws InvalidDataException {
        super(catalog);
        if (catalog == null) {
            throw new InvalidDataException("Invalid data encountered in report");
        }
    }

    public void execute() throws IOException, InvalidDataException {
        {

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
            cfg.setDirectoryForTemplateLoading(new File("C:/Users/Admin/Documents/GitHub/PA-2022-2023/Homework5/target/classes/com/mycompany/homework5/templates/"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());

            // load the FreeMarker template
            Template template = cfg.getTemplate("report_template.ftlh");

            // create a data model for the template
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("catalog", catalog);

            // generate the HTML report
            Writer out = new FileWriter("report.html");
            try {
                template.process(dataModel, out);
            } catch (TemplateException e) {
                throw new IOException(e);
            } finally {
                out.close();
            }

            // open the HTML report in the default web browser
            File outputFile = new File("report.html");
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(outputFile.toURI());
            }
        }

    }
}
