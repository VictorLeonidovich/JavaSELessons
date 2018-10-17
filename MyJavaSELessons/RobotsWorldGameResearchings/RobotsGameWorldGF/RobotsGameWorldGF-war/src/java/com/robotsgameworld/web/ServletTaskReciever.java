/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robotsgameworld.web;

import com.robotsgameworld.web.facade.TaskRecieverFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
@WebServlet(name = "ServletTaskReciever", urlPatterns = {"/servlettaskreciever"})
public class ServletTaskReciever extends HttpServlet {
    @EJB
    private TaskRecieverFacadeLocal taskRecieverFacade;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskQuantity = req.getParameter("taskQuantity");
        String taskContent = req.getParameter("taskContent");
        String taskRecipient = req.getParameter("taskRecipient");
        System.out.println("ServletTaskReciever::" + "taskQuantity = " + taskQuantity + ", taskContent = " + taskContent + ", taskRecipient = " + taskRecipient);
        taskRecieverFacade.sendTask(taskQuantity, taskRecipient, taskContent);
        resp.sendRedirect(req.getContextPath() + "/index2.jspx");
    }

   
    

}
