/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelab.comtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pohan
 */
public class HtmlScript extends HtmlElement{
    private String scriptName;
    private String content;

    public HtmlScript(String scriptName) {
        File fx = new File(scriptName);
        if (!fx.exists()){
            fx = new File("./" + scriptName);
        }
        if (fx.exists()){
            FileInputStream fis = null;
            try {
                int size = (int) fx.length();
                byte buffer[] = new byte[size];
                int r = 0;
                int s = 0;
                fis = new FileInputStream(fx);
                while((r = fis.read(buffer, s, size-s)) > 0){
                    r += s;
                }
                content = new String(buffer);
                fis.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HtmlScript.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HtmlScript.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(HtmlScript.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String generate() {
        return content;
    }
    
}
