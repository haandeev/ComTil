/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelab.comtil;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pohan
 */

public abstract class SettingGson<T> {
    private static Object lock = new Object();

    public abstract Class getItemClass();
    
    
    public final void readSetting(String fileName) throws FileNotFoundException, IOException{
        synchronized(lock){
            File fi = new File(fileName);
            if (!fi.exists()) {
                fi = new File("./" + fileName);
            }
            if (fi.exists()) {
                FileInputStream fisu = new FileInputStream(fi);
                int fs = (int) fi.length();
                byte buff[] = new byte[fs];
                fisu.read(buff);
                String x = new String(buff, "UTF-8");
                fisu.close();
                Gson gos = new Gson();
                
                Object obin = gos.fromJson(x, getItemClass());
                
                Object oout;
                if ((oout = onRead((T) obin)) != null){
                    FileOutputStream fos = new FileOutputStream(fi);
                    String rtx = gos.toJson(oout);
                    fos.write(rtx.getBytes());
                    fos.flush();
                    fos.close();
                };
            }
        }
    }
    
    public abstract Object onRead(T setting);
    
}
