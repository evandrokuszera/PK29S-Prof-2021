/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.report;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author evand
 */
public class Report {
    public static void createReport(List javabeans, String jrxml_file) throws JRException, FileNotFoundException {
        Report r = new Report();
               
        // Fetching the .jrxml file from the resources folder.
        // Use a InputStream to fetch the file, otherwise the app jar will not find the report files.
        final InputStream stream = r.getClass().getResourceAsStream("/reports/" + jrxml_file);
        
        // Compile the Jasper report from .jrxml to .japser
        final JasperReport report = JasperCompileManager.compileReport(stream);
 
        // Fetching the employees from the data source.
        final JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(javabeans);

        // Adding the additional parameters to the pdf.
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "kuszera");
 
        // Filling the report with the employee data and additional parameters information.
        final JasperPrint print = JasperFillManager.fillReport(report, parameters, source);
        
        // Showing the report by JasperViewer
        JasperViewer v = new JasperViewer(print, false);
        v.requestFocus();
        v.setVisible(true);
    }
}
