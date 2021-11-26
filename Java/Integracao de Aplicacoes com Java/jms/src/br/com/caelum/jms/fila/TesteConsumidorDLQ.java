package br.com.caelum.jms.fila;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TesteConsumidorDLQ {

    public static void main(String[] args) throws NamingException, JMSException {

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination fila = (Destination) context.lookup("dlq");
        MessageConsumer consumer = session.createConsumer(fila);

        //Message message = consumer.receive(2000);

        consumer.setMessageListener(
                message -> System.out.println(message));

        session.close();
        connection.close();
        context.close();
    }
}
