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
        parameters.put("REPORT_TITLE", "ОВП (Отчёт о выборе победителя) №25436 от 21.10.2024");
        parameters.put("ORGANIZER", "ООО МТС МЕДИА");
        parameters.put("PAYMENT", "Постоплата 30 календарных дней");
        parameters.put("WINNER_SELECTION_CRITERIA", "Цена, Качество, Условия оплаты");
        parameters.put("BUDGET", "3000000");
        parameters.put("CURRENCY", "RUB");
        parameters.put("IS_FOREIGN_CURRENCY", "Нет");
        parameters.put("COMMENT", "Не указан");
        parameters.put("CATEGORIES", "ТБ Сеть радиодоступа, Оборудование базовой станции (BTS 2G), Оборудование контроллера 2G, Оборудование базовой станции 3G, Оборудование контроллера 3G, Оборудование базовой станции LTE, Системы управления (Радиосеть), Оборудование Femto Cell, Оборудование Femtocell Core, ПАК для планирования и оптимизации сети, ЗИП радиосети, ПО и лицензии радиосеть, ТП и ремонт оборудования радиосети, Монтаж и ПНР контроллеров радиосети, Услуги BSS, Консалтинг (Радиосеть), Оборудование и ПО полевого тестирования, Услуги полевого тестирования, бенчмаркинг, ПО и лицензии для данных полевого тестирования");
        parameters.put("CREATED_BY", "Подготовлено: Закупченко Вениамин Николаевич");
        parameters.put("OPEN_ACCREDITATION_NAME", "Предварительный квалификационный отбор на предоставление права участия в на предоставление права участия в на предоставление права участия в");
//        parameters.put("OPEN_ACCREDITATION_NAME", "Предварительный квалификационный отбор на предоставление права участия в закупочных процедурах/биддингах на закупку и размещение РИМ Группы МТС на носителях индор и эмбиент рекламы (АЗС, торговые сети, торгово-развлекательные");
        var jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, data);
        JasperExportManager.exportReportToPdfFile(jasperPrint, "target/report.pdf");
    }
}
