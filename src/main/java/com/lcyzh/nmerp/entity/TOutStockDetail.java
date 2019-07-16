package com.lcyzh.nmerp.entity;

import java.io.Serializable;

/**
* Author ljk
* Date  2019-07-16
*/
public class TOutStockDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String outCode;
    private String barCode;


    public TOutStockDetail(){
    }

    public void setId (Long id) {this.id = id;} 
    public Long getId(){ return id;} 
    public void setOutCode (String outCode) {this.outCode = outCode;} 
    public String getOutCode(){ return outCode;} 
    public void setBarCode (String barCode) {this.barCode = barCode;} 
    public String getBarCode(){ return barCode;} 

}