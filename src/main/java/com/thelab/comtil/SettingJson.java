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
import org.json.JSONObject;

/**
 *
 * @author pohan
 */
public abstract class SettingJson {

    
    public void readSetting(String fileName) throws FileNotFoundException, IOException{
        File fi = new File(fileName);
        if (!fi.exists()){
            fi = new File("./" + fileName);
        }
        if (fi.exists()){
            FileInputStream fisu = new FileInputStream(fi);
            int fs =  (int) fi.length();
            byte buff[] = new byte[fs];
            fisu.read(buff);
            JSONObject jog = new JSONObject(new String(buff));
            onRead(jog);
        }
    }
    
    public abstract void onRead(JSONObject job);
    
}
