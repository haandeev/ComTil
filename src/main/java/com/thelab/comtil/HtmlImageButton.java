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
public class HtmlImageButton extends HtmlElement{
    private String id;
    private String imagePath;
    private String caption;

    public HtmlImageButton(String id, String caption, String imagePath) {
        this.id = id;
        this.imagePath = imagePath;
        this.caption = caption;
    }
    
    public String getOnClickName(){
        return String.format("%s_click()",id);
    }

    @Override
    public String generate() {
        StringBuilder sbuk = new StringBuilder();
        sbuk.append(String.format("<button class='toolbutton' onclick=%s>", getOnClickName()));
        sbuk.append(String.format("<img src='%s'>",imagePath));
        sbuk.append(String.format("<span>%s</span>", caption));
        sbuk.append("</button>");
        return sbuk.toString();
    }
    
}
