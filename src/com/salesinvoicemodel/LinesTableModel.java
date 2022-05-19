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
public class LinesTableModel extends AbstractTableModel{
    
    private ArrayList<Line> lines;
private String [] columns = {"No.","Item Name","Item Price","Count","Item Total"};

    public LinesTableModel(ArrayList<Line> lines) {
        this.lines = lines ;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }
    
    
    
    @Override
    public int getRowCount() {
    return lines.size();  
        }

    @Override
    public int getColumnCount() {
return columns.length;
    }
    
     @Override
    public String getColumnName(int t){
        return columns [t];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    Line line = lines.get(rowIndex); 
    switch (columnIndex){
        case 0:return line.getInvoice().getNum();
        case 1:return line.getItem();
        case 2:return line.getPrice();
         case 3:return line.getCountt();
          case 4:return line.getLineTotall();
          default : return "";
    }
    }
}
