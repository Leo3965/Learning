package br.com.caelum.jms.topico;

import br.com.caelum.jms.modelo.Pedido;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TesteConsumidorSelector {

    public static void main(String[] args) throws NamingException, JMSException {

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.setClientID("estoque");
        connection.start();

        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Topic topic = (Topic) context.lookup("loja");
        String messageColector = "ebook = false";
        MessageConsumer consumer = session.createDurableSubscriber(topic, "assinatura-selector", messageColector, false);


        //Message message = consumer.receive(2000);

        consumer.setMessageListener(object -> {
            ObjectMessage objectMessage = (ObjectMessage) object;
            try {
                Pedido pedido = (Pedido) objectMessage.getObject();
                System.out.println(objectMessage.toString());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });

        session.close();
        connection.close();
        context.close();
    }
}
