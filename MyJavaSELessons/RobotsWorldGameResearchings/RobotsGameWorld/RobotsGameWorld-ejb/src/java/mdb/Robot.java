/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;

import beans.LogReciever;
import beans.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.interceptor.Interceptors;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import utils.LogInterceptor;

/**
 *
 * @author Victor
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Tasks/Topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})

public class Robot implements MessageListener {

    protected volatile long ID = 0;

    //@EJB
    //private LogReciever logReciever;
    @EJB
    private Logger logger;

    public Robot() {
        this.ID = this.ID + 1;
    }

    @PostConstruct
    public void init() {
        logger.addLog(getClass().getName() + ", ID " + ID + " was created!!!");
        System.out.println(getClass().getName() + ", ID " + ID + " was created!!!");
    }

    @PreDestroy
    public void destroy() {
        logger.addLog(getClass().getName() + ", ID " + ID + " will be destroyed now!!!");
        System.out.println(getClass().getName() + ", ID " + ID + " will be destroyed now!!!");
    }

    @Override
    @Interceptors(LogInterceptor.class)
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            logger.addLog("getClass().getName() + \" - \" + message: " + getClass().getName() + ", ID " + ID + " - " + textMessage.getText());
            System.out.println("getClass().getName() + \" - \" + message: " + getClass().getName() + ", ID " + ID + " - " + textMessage.getText());
            //putToStorage(textMessage.getText());

        } catch (JMSException ex) {
            putToStorage(ex.toString());
        }
    }

    protected void putToStorage(String message) {
        System.out.println("getClass().getName() + \" - \" + message:" + getClass().getName() + " - " + message);
        InMemoryStorage.add(getClass().getName() + " - " + message);

    }

}
