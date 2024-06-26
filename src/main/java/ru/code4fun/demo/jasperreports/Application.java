package ru.code4fun.demo.jasperreports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.PdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) throws JRException {
        final Application application = new Application();
        application.test();
    }

    public void test() {
        var sourceFileName = "/home/denis/java/pdf-report/pdfreport/src/main/resources/StyledTextReport.jrxml";

        DataBeanList DataBeanList = new DataBeanList();
        ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
        Map parameters = new HashMap();
        parameters.put("ReportTitle", "Отчёт о выборе победителей");
        parameters.put("FilterClause", "");
        parameters.put("OrderClause", "");
        try {
            final JasperReport jasperReport = JasperCompileManager.compileReport(sourceFileName);
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "target/StyledTextReport.html");
            JasperExportManager.exportReportToPdfFile(jasperPrint, "target/StyledTextReport.pdf");
//            var exporter = new JRPdfExporter();
//            var configuration = new SimplePdfExporterConfiguration();
//            exporter.setConfiguration(configuration);
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
}
