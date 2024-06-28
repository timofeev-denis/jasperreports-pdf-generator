package ru.code4fun.demo.jasperreports;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.HashMap;

public class Application {

    public static void main(String[] args) throws JRException {
        var application = new Application();
        application.generateReport();
    }

    public void generateReport() throws JRException {
        JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(DataGenerator.generate());
        var template = this.getClass().getClassLoader().getResourceAsStream("report_template.jrxml");
        var jasperReport = JasperCompileManager.compileReport(template);
        var parameters = new HashMap<String, Object>();
        parameters.put("REPORT_TITLE", "Список пользователей");
        var jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, data);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "target/report.pdf");
    }
}
