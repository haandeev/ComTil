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
public class HtmlDiv extends HtmlElement{
    private String id;

    public HtmlDiv(String id) {
        this.id = id;
    }

    @Override
    public String generate() {
        return String.format("<div id='%s'></div>", id);
    }
    
}
