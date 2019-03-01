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
public class HtmlHTitle extends HtmlElement{
    private int level;
    private String title;

    public HtmlHTitle(int level, String title) {
        this.level = level;
        this.title = title;
    }

    @Override
    public String generate() {
        return String.format("<h%d>%s</h%d>", level, title, level);
    }
    
    
}
