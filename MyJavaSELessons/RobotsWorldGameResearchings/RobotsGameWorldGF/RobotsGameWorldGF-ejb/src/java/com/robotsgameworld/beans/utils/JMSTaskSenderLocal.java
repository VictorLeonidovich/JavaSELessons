/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robotsgameworld.beans.utils;

import javax.ejb.Local;

/**
 *
 * @author Victor
 */
@Local
public interface JMSTaskSenderLocal {
    public void sendTasksToRobots()
    
}
