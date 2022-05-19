/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salesinvoicecontroller;

import com.salesinvoicedisplay.InvoiceDialog;
import com.salesinvoicedisplay.LineDialog;
import com.salesinvoicedisplay.SalesinvoiceScreen;
import com.salesinvoicemodel.Invoice;
import com.salesinvoicemodel.InvoicesTableModel;
import com.salesinvoicemodel.Line;
import com.salesinvoicemodel.LinesTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller implements ActionListener, ListSelectionListener{
    
    private SalesinvoiceScreen screen;
    private InvoiceDialog invoiceDialog;
    private LineDialog lineDialog;
    
    public Controller (SalesinvoiceScreen screen){
        this.screen=screen;
    }
    @Override
    public void actionPerformed (ActionEvent e){
        String actionCommand = e.getActionCommand();
        System.out.println(actionCommand);
        switch (actionCommand){
            case"Load File":
                loadfile();
            break;
            case"Save File":
                savefile();
            break;
            case"Create New Invoice":
                createnewinvoice();
            break;
            case"Delete Invoice":
                deleteinvoice();
            break;
            case"Create New Item":
                createnewitem();
            break;
            case"Delete Item":
                deleteitem();
            break;
             case"createInvoiceCancel":
                createInvoiceCancel();
            break;
            case"createInvoiceOK":
                createInvoiceOK();
            break;
             case"createLineOK":
                createLineOK();
            break;
            case"createLineCancel":
                createLineCancel();
            break;
        }
    }
    
    
     @Override
    public void valueChanged(ListSelectionEvent e) {
    int selectedIndex = screen.getInvoiTable().getSelectedRow();
    if (selectedIndex != -1){
    System.out.println("You have selected row: " + selectedIndex);
    Invoice currentInvoice = screen.getInvoices().get(selectedIndex);
    screen.getinvoiceNumberValueLabel().setText(""+currentInvoice.getNum());
    screen.getinvoiceDateValueLabel().setText(currentInvoice.getDate());
    screen.getcustomerNameValueLabel().setText(currentInvoice.getcustomerName());
    screen.getinvoiceTotalValueLabel().setText(""+currentInvoice.getInvoiceTotal());
    LinesTableModel linesTableModel = new LinesTableModel(currentInvoice.getLines());
      screen.getItemsTable().setModel(linesTableModel);
      linesTableModel.fireTableDataChanged();
    }
    }
    

    private void loadfile() {
        JFileChooser fc = new JFileChooser(); 
        try{
        int res = fc.showOpenDialog(screen);
        if (res == JFileChooser.APPROVE_OPTION){
            File headerFile = fc.getSelectedFile();
            Path headerPath = Paths.get(headerFile.getAbsolutePath());
            List<String> headerLines = Files.readAllLines(headerPath);
            System.out.println("Invoices have been read");
            ArrayList<Invoice>invoicesArray = new ArrayList<>();
            for (String headerLine: headerLines){
            String [] headerParts = headerLine.split(",");
            int invoiceNumber = Integer.parseInt(headerParts[0]);
            String invoiceDate = headerParts[1];
            String customerName = headerParts[2];
            Invoice invoice = new Invoice (invoiceNumber,invoiceDate,customerName); 
            invoicesArray.add(invoice);
            }
            System.out.println("Check point");
            res = fc.showOpenDialog(screen);
            if (res == JFileChooser.APPROVE_OPTION){
            File lineFile = fc.getSelectedFile();
            Path linePath = Paths.get(lineFile.getAbsolutePath());
            List<String>lineLines = Files.readAllLines(linePath);
            System.out.println("Lines have been read");
            for (String lineLine : lineLines){
            String lineParts [] = lineLine.split(",");
            int invoiceNum = Integer.parseInt(lineParts[0]);
            String itemName = lineParts[1];
            double itemPrice = Double.parseDouble(lineParts[2]);
            int count = Integer.parseInt(lineParts[3]);
            Invoice inv = null;
            for (Invoice invoice :invoicesArray){
            if (invoice.getNum()==invoiceNum){
                inv = invoice;
                break;
            }
            }
            Line line = new Line (itemName,itemPrice,count, inv);
            inv.getLines().add(line);
            }
            System.out.println("Check point");
            }
            
            screen.setInvoices(invoicesArray);
            InvoicesTableModel invoicesTableModel = new InvoicesTableModel (invoicesArray);
            screen.setInvoicesTableModel(invoicesTableModel);
            screen.getInvoiTable().setModel(invoicesTableModel);
            screen.getInvoicesTableModel().fireTableDataChanged();
            
        }
        }catch (IOException ex){
            ex.printStackTrace();
    }
    }

    private void savefile() {
        ArrayList<Invoice> invoices = screen.getInvoices();
        String headers = "";
        String lines = "";
        for (Invoice invoice : invoices){
        String invCSV = invoice.getAsCSV();
        headers += invCSV;
        headers += "\n";
        
        for (Line line : invoice.getLines()){
        String lineCSV = line.getAsCSV();
        lines += lineCSV;
        lines += "\n";
        }
        }    
        try{
        JFileChooser fc = new JFileChooser();
        int result = fc.showSaveDialog(screen);
        if (result == JFileChooser.APPROVE_OPTION){
        File headerFile = fc.getSelectedFile();
        FileWriter hfw = new FileWriter(headerFile);
        hfw.write(headers);
        hfw.flush();
        hfw.close();
        result = fc.showSaveDialog(screen);
        if (result == JFileChooser.APPROVE_OPTION){
        File lineFile = fc.getSelectedFile();
        FileWriter lfw = new FileWriter(lineFile);
        lfw.write(lines);
        lfw.flush();
        lfw.close();
        
        }
        }
        }catch (Exception ex){
        
        }
        }

    private void createnewinvoice() {
        
        invoiceDialog = new InvoiceDialog(screen);
        invoiceDialog.setVisible(true);
        }

    private void deleteinvoice() {
        int selectedRow = screen.getInvoiTable().getSelectedRow();
        if (selectedRow != -1){
            screen.getInvoices().remove(selectedRow);
            screen.getInvoicesTableModel().fireTableDataChanged();
        }
        }

    private void createnewitem() {
        lineDialog = new LineDialog(screen);
        lineDialog.setVisible(true);
        }

    private void deleteitem() {
        int selectedRow = screen.getItemsTable().getSelectedRow();
        if (selectedRow != -1){
            LinesTableModel linesTableModel = (LinesTableModel) screen.getItemsTable().getModel();
            linesTableModel.getLines().remove(selectedRow);
            linesTableModel.fireTableDataChanged();
            screen.getInvoicesTableModel().fireTableDataChanged();
        }
        }

    private void createInvoiceCancel() {
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;
        }

    
    private void createInvoiceOK() {
        System.out.println(invoiceDialog);
        String date = invoiceDialog.getInvDateField().getText();
        String customer = invoiceDialog.getCustNameField().getText();
        int num = screen.getNextInvoiceNum();
        
        Invoice invoice = new Invoice (num,date,customer);
        screen.getInvoices().add(invoice);
        screen.getInvoicesTableModel().fireTableDataChanged();
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;
        }

    private void createLineOK() {
        String item = lineDialog.getItemNameField().getText();
        String countStr = lineDialog.getItemNameField().getText();
        String priceStr = lineDialog.getItemNameField().getText();
        int count = Integer.parseInt(countStr);
        double price = Double.parseDouble(priceStr);
        int selectedInvoice = screen.getInvoiTable().getSelectedRow();
        if (selectedInvoice != -1){
            Invoice invoice = screen.getInvoices().get(selectedInvoice);
            Line line = new Line(item, price, count, invoice);
            invoice.getLines().add(line);
            LinesTableModel linesTableModel = (LinesTableModel)screen.getItemsTable().getModel();
            linesTableModel.fireTableDataChanged();
            screen.getInvoicesTableModel().fireTableDataChanged();
        }
        
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;
        }

    private void createLineCancel() {
        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;
        }

   
    
}
