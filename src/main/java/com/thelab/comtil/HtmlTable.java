/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelab.comtil;

/**
 *
 * @author pohan
 */
public abstract class HtmlTable extends HtmlElement{
    public abstract int getColCount();
    public abstract int getRowCount();
    
    public boolean hasTitle(){
        return false;
    }
    
    public abstract String getValueAt(int r, int c);
    
    public String getTitle(int c){
        return "";
    }

    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table>");
        if (hasTitle()){
            sb.append("<tr>");
            for (int c = 0;c < getColCount();c++){
                sb.append("<th>");
                sb.append(getTitle(c));
                sb.append("</th>");
            }
            sb.append("</tr>");
        }
        for (int r =0;r < getRowCount();r++){
            sb.append("<tr>");
            for (int c = 0;c < getColCount();c++){
                sb.append("<td>");
                sb.append(getValueAt(r, c));
                sb.append("</td>");
            }
            sb.append("</tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }
}
