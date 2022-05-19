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
public class Line {
    
   
    private String Item;
    private double Price;
    private int Count;
    private Invoice invoice;
    private ArrayList <Line> lines;

    public Line() {
    }


    public Line(String Item, double Price, int Count, Invoice invoice) {
      
        this.Item = Item;
        this.Price = Price;
        this.Count = Count;
        this.invoice = invoice;
    }

     public double getLineTotall (){
    return Price * Count;
    }
    public int getCountt() {
        return Count;
    }

    public void setCountt(int Count) {
        this.Count = Count;
    }

  
    public String getItem() {
        return Item;
    }

    public void setItem(String Item) {
        this.Item = Item;
    }

    public double getPrice() {
        return Price;
    }

    public void setPricee(double Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "Line{" + "Num=" + invoice.getNum() + ", Item=" + Item + ", Price=" + Price + ", Count=" + Count + '}';
    }

    public Invoice getInvoice() {
        return invoice;
    }
    
    
    public String getAsCSV(){
   
   return invoice.getNum() + "," + Item + "," + Price + "," + Count;
   }
    
}
