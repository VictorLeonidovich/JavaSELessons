/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import mdb.Robot;

/**
 *
 * @author Victor
 */
@Interceptor
public class LogInterceptor {

    @PostConstruct
    public void construct(InvocationContext ctx) {
        System.out.println("LogInterceptor: " + ctx.getTarget() + " was created!");
        try {

            ctx.proceed();
        } catch (Exception ex) {
            Logger.getLogger(LogInterceptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AroundInvoke
    public Object setLog(InvocationContext ctx) throws Exception {
        System.out.println("LogInterceptor: " + ((Robot)ctx.getTarget()).getClass().getSimpleName()+ " perform task!");
        return ctx.proceed();
    }

    @PreDestroy
    public void destroy(InvocationContext ctx) throws Exception {
        System.out.println("LogInterceptor: " + ctx.getTarget() + " will be destroyed!");
        ctx.proceed();
    }
}
