package ru.code4fun.demo.jasperreports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
        try {
            final JasperReport jasperReport = JasperCompileManager.compileReport(sourceFileName);
            final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);
            JasperExportManager.exportReportToHtmlFile(jasperPrint, "target/StyledTextReport.html");
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
}
