/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salesinvoicemodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Heba
 */
public class InvoicesTableModel extends AbstractTableModel {

    private ArrayList<Invoice> invoices;
private String[] columns = {"No.", "Date","Customer","Total"};
    public InvoicesTableModel(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;

    }
    
    
      @Override
    public String getColumnName(int column){
        return columns[column];
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {  
        Invoice invoice = invoices.get(rowIndex);
        switch (columnIndex){
            case 0:return invoice.getNum();
            case 1:return invoice.getDate();
            case 2:return invoice.getcustomerName();
            case 3:return invoice.getInvoiceTotal();
            default: return"";
        }
        
        
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }
    
}
    

    

