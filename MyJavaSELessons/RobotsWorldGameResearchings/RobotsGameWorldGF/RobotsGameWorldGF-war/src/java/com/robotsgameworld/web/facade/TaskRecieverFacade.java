/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robotsgameworld.web.facade;

import javax.ejb.Stateless;

/**
 *
 * @author Victor
 */
@Stateless
public class TaskRecieverFacade implements TaskRecieverFacadeLocal {

    
    @Override
    public void sendTask(String taskQuantity, String taskRecipient, String taskContent) {
        System.out.println("TaskRecieverFacade--" + "taskQuantity = " + taskQuantity + ", taskContent = " + taskContent + ", taskRecipient = " + taskRecipient);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
