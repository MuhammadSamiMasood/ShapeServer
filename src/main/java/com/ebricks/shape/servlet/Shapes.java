package com.ebricks.shape.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class Shapes extends HttpServlet {

    //String line;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        PrintWriter printWriter = resp.getWriter();

        FileReader fileReader = new FileReader(getServletContext().getRealPath("shapes.json"));
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String fileData = IOUtils.toString(fileReader);


        //String fileData = "";
        //while ((line = bufferedReader.readLine()) != null) {
        //    fileData += line;
        //}

        bufferedReader.close();

        printWriter.print(fileData);

    }
}
