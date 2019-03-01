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
public class HtmlPageSegment extends HtmlElement{
    private String segmentId;

    public HtmlPageSegment(String segmentId) {
        this.segmentId = segmentId;
    }
    
    public String getCaption(){
        return null;
    }
    

    @Override
    public String generate() {
        StringBuilder sbu = new StringBuilder();
        if (getCaption() != null){
            sbu.append(String.format("<h1>%s</h1>", getCaption()));
        }
        sbu.append(String.format("<div class='pageSegment'><input type=button value='OPEN' onclick='%s_getdata()'></div>", segmentId));
        sbu.append(String.format("<div id='%s'></div>", segmentId));
        return sbu.toString();
    }
    
}
