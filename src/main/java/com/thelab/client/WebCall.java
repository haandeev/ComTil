/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thelab.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author pohan
 */
public class WebCall {
    
    public interface WebResponse{
        public void webreply(int respcode, String response);
        
    }
    
    /*
    
                URL ure = new URL(String.format("%s:%d/%s", server, port, path));
            HttpURLConnection con = (HttpURLConnection) ure.openConnection();
               	con.setRequestMethod("POST");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                con.setRequestProperty("Content-Type", "application/json");

		String urlParameters = body;
                
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
                return response.toString();

    */
    
    public static void callHttp(String server, int ip, String path, String param, WebResponse resp) throws MalformedURLException, IOException{
        call(String.format("http://%s:%d/%s", server, ip, path), param, resp);
    }
    
    public static void call(String link, String param, WebResponse resp) throws MalformedURLException, IOException{
        URL u = new URL(link);
        HttpURLConnection ura = (HttpURLConnection) u.openConnection();
        ura.setRequestMethod("POST");
        ura.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        ura.setRequestProperty("Content-Type", "application/json");
        ura.setDoOutput(true);
        
        DataOutputStream osu = new DataOutputStream(ura.getOutputStream());
        osu.write(param.getBytes());
        osu.flush();
        osu.close();
        
        
        int code = ura.getResponseCode();
        
        BufferedReader bur = new BufferedReader(new InputStreamReader(ura.getInputStream()));
        String line;
        StringBuilder bsk = new StringBuilder();
        while((line = bur.readLine())!= null){
            bsk.append(line);
        }
        
        if (resp != null){
            resp.webreply(code, bsk.toString());
        }
        
    }
    
    public static void callGET(String server, int port, String path, String query, WebResponse resp) throws MalformedURLException, IOException{
        callGET(String.format("http://%s:%d/%s", server, port, path), query, resp);
    }
    
    public static void callGET(String link, String query, WebResponse resp) throws MalformedURLException, IOException{
        if ((query != null) && (!query.isEmpty())){
            link += "?" + query;
        }
        URL u = new URL(link);
        HttpURLConnection ura = (HttpURLConnection) u.openConnection();
        
        ura.setRequestMethod("GET");
        ura.setRequestProperty("Content-Type", "text/html; charset=utf8");
        ura.setRequestProperty("Accept", "text/html");
        
        int code = ura.getResponseCode();
        
        BufferedReader bur = new BufferedReader(new InputStreamReader(ura.getInputStream()));
        String line;
        StringBuilder bsk = new StringBuilder();
        while((line = bur.readLine())!= null){
            bsk.append(line);
        }
        
        if (resp != null){
            resp.webreply(code, bsk.toString());
        }
        
    }
    
    public static void callFirebase(String link, String authorization, WebResponse resp) throws MalformedURLException, IOException{
        URL u = new URL(link);
        HttpURLConnection ura = (HttpURLConnection) u.openConnection();
        
        ura.setRequestMethod("GET");
        ura.setRequestProperty("Content-Type", "application/json; charset=utf8");
        ura.setRequestProperty("Authorization", String.format("key=%s",authorization));
        ura.setRequestProperty("Accept", "text/html");
        
        int code = ura.getResponseCode();
        
        BufferedReader bur = new BufferedReader(new InputStreamReader(ura.getInputStream()));
        String line;
        StringBuilder bsk = new StringBuilder();
        while((line = bur.readLine())!= null){
            bsk.append(line);
        }
        
        if (resp != null){
            resp.webreply(code, bsk.toString());
        }
        
    }
    
    
    
}
