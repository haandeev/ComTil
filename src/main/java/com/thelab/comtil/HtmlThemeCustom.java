/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelab.comtil;

import java.util.ArrayList;

/**
 *
 * @author pohan
 */
public abstract class HtmlThemeCustom {
    public String generateSideMenu(ArrayList<HtmlLink> links){
        StringBuilder sbut = new StringBuilder();
        if (links.size() > 0){
            sbut.append("<div id='sideMenu' class='sideMenu'>");
            for (HtmlLink mi : links){
                sbut.append(mi.generate());
            }
            sbut.append("</div>");
        }
        return sbut.toString();
    }
    
}
