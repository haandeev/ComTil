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
public class HtmlLink extends HtmlElement{
    private String caption;
    private String link;

    public HtmlLink(String caption, String link) {
        this.caption = caption;
        this.link = link;
    }
    

    public String getCaption() {
        return caption;
    }

    public String getLink() {
        return link;
    }
    

    @Override
    public String generate() {
        return String.format("<a href='%s' %s>%s</a>",link, getClassname() == null ? "" : "class='" + getClassname() + "'", caption);
    }
    
    
}
