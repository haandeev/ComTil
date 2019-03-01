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
public class HtmlGoogleFont extends HtmlElement{
    private String fontName;

    public HtmlGoogleFont(String fontName) {
        this.fontName = fontName;
    }

    @Override
    public String generate() {
        return String.format("<link href=\"https://fonts.googleapis.com/css?family=%s\" rel=\"stylesheet\">", fontName);
    }
    
}
