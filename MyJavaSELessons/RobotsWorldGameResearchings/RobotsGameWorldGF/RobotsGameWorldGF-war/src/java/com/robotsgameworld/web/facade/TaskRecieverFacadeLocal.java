/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robotsgameworld.web.facade;

import javax.ejb.Local;

/**
 *
 * @author Victor
 */
@Local
public interface TaskRecieverFacadeLocal {
    public void sendTask(String taskQuantity, String taskRecipient, String taskContent);
}
