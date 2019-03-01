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
public abstract class HtmlToolBox extends HtmlElement{
    
    public abstract HtmlImageButton[] buttons();

    @Override
    public String generate() {
        HtmlImageButton hbut[] = buttons();
        StringBuilder sb = new StringBuilder();
        for (HtmlImageButton b : hbut){
            sb.append(b.generate());
        }
        return sb.toString();
    }
    
}
