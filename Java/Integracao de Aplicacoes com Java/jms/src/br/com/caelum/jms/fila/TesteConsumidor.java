package br.com.caelum.jms.fila;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TesteConsumidor {

    public static void main(String[] args) throws NamingException, JMSException {

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false,Session.CLIENT_ACKNOWLEDGE);
        Destination fila = (Destination) context.lookup("financeiro");
        MessageConsumer consumer = session.createConsumer(fila);

        //Message message = consumer.receive(2000);

        consumer.setMessageListener((Message message) -> {
            TextMessage textMessage = (TextMessage) message;
            try {
                //message.acknowledge();
                System.out.println(textMessage.getText());
                session.commit();
                //session.rollback();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });

        session.close();
        connection.close();
        context.close();
    }
}
