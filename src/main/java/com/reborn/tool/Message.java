package com.reborn.tool;

import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class Message {
    public static void returnMessage(String msg, HttpServletResponse response){
        try {
            response.setContentType("text/xml;charset=UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            PrintWriter out = response.getWriter();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("msg", msg);
            out.print(jsonObject.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
