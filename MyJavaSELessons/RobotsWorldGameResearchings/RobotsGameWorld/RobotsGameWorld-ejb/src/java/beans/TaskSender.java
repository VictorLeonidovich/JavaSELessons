package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;

/**
 *
 * @author Victor
 */
@Stateless(mappedName = "TaskSender")
@LocalBean
public class TaskSender {

    @Resource(name = "jms/TasksConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name = "jms/Tasks/Queue")
    private Destination queue;

    @Resource(name = "jms/Tasks/Topic")
    private Destination topic;

    //@EJB(mappedName = "LogReciever")
    //private LogReciever logReciever;
    @EJB
    private Logger logger;

    public void send(String type, String text) throws JMSException {
        Connection connection = connectionFactory.createConnection();
        try {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer;
            System.out.println("-------------------------TaskServletDispatcher ----- send(String type, String text) throws JMSException");
            switch (type) {
                case "Topic":
                    producer = session.createProducer(topic);
                    break;
                case "Queue":
                    producer = session.createProducer(queue);
                    break;
                default:
                    throw new UnsupportedOperationException("Unknown destination " + type);
            }
            producer.send(session.createTextMessage(text));
            logger.addLog("The task '" + text + "' was successfully sended.");
        } finally {
            connection.close();
        }
    }

}
