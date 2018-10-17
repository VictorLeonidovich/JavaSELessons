/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 *
 * @author Victor
 */
@Stateless(mappedName = "Logger")
@LocalBean
public class Logger {
    private Queue<String> logQueue;

    public Logger() {
        this.logQueue = new ConcurrentLinkedQueue<>();
    }

    public void addLog(String log) {
        logQueue.add(log);
    }

    public String getLog() {
        return logQueue.poll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
