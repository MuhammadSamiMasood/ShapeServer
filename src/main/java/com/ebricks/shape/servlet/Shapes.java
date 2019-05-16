package com.ebricks.shape.servlet;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class Shapes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        PrintWriter printWriter = resp.getWriter();

        FileReader fileReader = new FileReader(getServletContext().getRealPath("shapes.json"));

        String fileData = IOUtils.toString(fileReader);

        fileReader.close();

        printWriter.print(fileData);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        InputStreamReader inputStreamReader = new InputStreamReader(req.getInputStream());
        String json = IOUtils.toString(inputStreamReader);

        FileReader fileReader = new FileReader(getServletContext().getRealPath("shapes.json"));
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(fileReader);
            JSONArray jsonArray = (JSONArray)jsonObject.get("shapes");
            jsonArray.add((JSONObject)new JSONParser().parse(json));

            FileWriter fileWriter = new FileWriter(getServletContext().getRealPath("shapes.json"));
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.close();

        } catch (ParseException e) {
            e.printStackTrace();
        }



        resp.setContentType("application/json");
        PrintWriter printWriter = resp.getWriter();
        String responseJson = "{\"data status\":\"Received and posted successfully\"}";
        printWriter.print(responseJson);

    }
}
