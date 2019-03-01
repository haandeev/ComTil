/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelab.comtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pohan
 */
public class HtmlPopForm extends HtmlElement{
    private String id;

    public HtmlPopForm(String id) {
        this.id = id;
    }
    
    public int getWidth(){
        return 400;
    }
    
    public int getHeight(){
        return 700;
    }
    
    private String readContentFile(String fileName){
        File f = new File(fileName);
        if (f.exists()){
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                StringBuilder sb = new StringBuilder();
                String line;
                while((line = br.readLine())!= null){
                    sb.append(line);
                }
                return sb.toString();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HtmlPopForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HtmlPopForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }
    
    public String getContentFileName(){
        return null;
    }

    @Override
    public String generate() {
        String content = "";
        if (getContentFileName() != null){
            content = readContentFile(getContentFileName());
        }
        return String.format("<div class='popForm' id='%s' style='width:%dpx;height:%dpx'>%s</div>", id, getWidth(), getHeight(), content);
    }
    
}
