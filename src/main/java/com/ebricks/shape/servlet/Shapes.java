package com.ebricks.shape.servlet;

import org.apache.commons.io.IOUtils;

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
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String fileData = IOUtils.toString(fileReader);

        bufferedReader.close();

        printWriter.print(fileData);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(req.getInputStream());
        String json = IOUtils.toString(inputStreamReader);

        FileWriter fileWriter = new FileWriter(getServletContext().getRealPath("shapes.json"));
        fileWriter.write(json);
        fileWriter.close();

        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("Data received");

    }
}
