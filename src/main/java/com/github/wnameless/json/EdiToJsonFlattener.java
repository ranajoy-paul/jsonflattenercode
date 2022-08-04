package com.github.wnameless.json;

import com.github.wnameless.json.flattener.PrintMode;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.common.io.Resources;
import com.google.common.base.Charsets;

public class EdiToJsonFlattener {

    public static void main(String[] args) throws Exception {
    try{

        URL url = Resources.getResource("edi.json");
        String json = Resources.toString(url, Charsets.UTF_8);
        System.out.println("Unformatted Json="+json);
        json = new com.github.wnameless.json.flattener.JsonFlattener(json).withPrintMode(PrintMode.PRETTY).flatten();
        System.out.println("Flatten Json="+json);
      
        Files.write( Paths.get("flattenedi834.json"), json.getBytes());

    }
    catch(Exception e){
        e.printStackTrace();
    }
    }
}
