package br.com.caelum.jms.topico;

import br.com.caelum.jms.modelo.Pedido;
import br.com.caelum.jms.modelo.PedidoFactory;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXB;
import java.io.StringWriter;

public class TesteProdutor {

    public static void main(String[] args) throws NamingException, JMSException {

        InitialContext context = new InitialContext();
        ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination topico = (Destination) context.lookup("loja");

        MessageProducer producer = session.createProducer(topico);

        Pedido pedido = new PedidoFactory().geraPedidoComValores();

        /*StringWriter writer = new StringWriter();
        JAXB.marshal(pedido, writer);
        String xml = writer.toString();*/

        for (int i = 0; i < 1; i++) {
            Message message = session.createObjectMessage(pedido);
            message.setBooleanProperty("ebook", false);
            producer.send(message);
        }

        session.close();
        connection.close();
        context.close();
    }
}
