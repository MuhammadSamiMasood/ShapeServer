package com.ebricks.shape.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Shapes extends HttpServlet {

    String line;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        PrintWriter printWriter = resp.getWriter();

        FileReader fileReader = new FileReader("C:\\Users\\Mesmer\\IdeaProjects\\shapeserver\\resources\\shapes.json");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String fileData = "";
        while ((line = bufferedReader.readLine()) != null) {
            fileData += line;
        }

        bufferedReader.close();

        printWriter.print(fileData);

    }
}
