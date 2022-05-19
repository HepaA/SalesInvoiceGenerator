/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salesinvoicemodel;

import java.util.ArrayList;

/**
 *
 * @author Heba
 */
public class Invoice {
    
    private int Num;
    private String Date;
    private String Name;
    private String Customer;
    private ArrayList <Line> lines;
    //private double invoiceTotal;

  
    public Invoice() {
    }

    public Invoice(int Num, String Date, String Name) {
        this.Num = Num;
        this.Date = Date;
        this.Name = Name;
        
    }
    
    public double getInvoiceTotal (){
        double total = 0.0;
        for (Line line : getLines()){
            total +=line.getLineTotall ();
                    }
    return total;
    }

     public ArrayList<Line> getLines() {
        if (lines==null){
            lines = new ArrayList<>();
        }
        return lines;
    }
    
    public String getcustomerName() {
        return Name;
    }

    public void setcustomerName(String Name) {
        this.Name = Name;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int Num) {
        this.Num = Num;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Invoice{" + "Num=" + Num + ", Date=" + Date + ", Customer=" + Customer + '}';
    }

   public String getAsCSV(){
   
   return Num + "," + Date + "," + Customer;
   }
    
    
    
}
