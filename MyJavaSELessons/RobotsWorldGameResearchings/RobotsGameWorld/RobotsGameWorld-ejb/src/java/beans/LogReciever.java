package beans;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.bean.ApplicationScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Victor
 */
@ApplicationScoped
@Singleton(mappedName = "LogReciever")

public class LogReciever  {

    private final Queue<String> logQueue;
    private final List<String> logList;

    public LogReciever() {
        this.logQueue = new ConcurrentLinkedQueue<>();
        this.logList = new CopyOnWriteArrayList<>();
    }

    public void addLog(String log) {
        logQueue.add(log);
        //logList.add(log);
    }

    public String getLog() {
        return logQueue.peek();//poll();
//        String temp = "";
//        for (int i = 0; i < logList.size(); i++) {
//            temp = temp + logList.get(i) + "<br />";
//        }
//        return temp;
    }

}
