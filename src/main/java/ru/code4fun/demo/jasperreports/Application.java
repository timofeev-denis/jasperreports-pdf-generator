package ru.code4fun.demo.jasperreports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) throws JRException {
        new Application().generateReport();
    }

    /*public static void text() {
        JRTextExporter exporter = new JRTextExporter();
        File sourceFile = new File("target/reports/TextReport.jrprint");
        JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(sourceFile);
        File destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".txt");

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(destFile));
        exporter.exportReport();
    }*/

    public void generateReport() throws JRException {
        InputStream employeeReportStream = Application.class.getResourceAsStream("/StyledTextReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);
        final URL resource = this.getClass().getResource("/StyledTextReport.jrxml");
        JasperCompileManager.compileReportToFile("", "");


//        JRSaver.saveObject(jasperReport, "target/template.jasper");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("WINNER_SELECTION_REPORT_TITLE", "Новый ОВП");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);

//        HtmlExporter exporter = new HtmlExporter();
//        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//        exporter.setExporterOutput(new SimpleHtmlExporterOutput("target/employeeReport.html"));
//        exporter.exportReport();

        JasperExportManager.exportReportToHtmlFile(jasperPrint,"target/template-02.html");
    }
}
