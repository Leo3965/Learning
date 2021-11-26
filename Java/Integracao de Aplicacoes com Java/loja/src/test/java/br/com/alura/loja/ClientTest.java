package br.com.alura.loja;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;
import com.thoughtworks.xstream.XStream;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

public class ClientTest {

    HttpServer server;
    Client client;
    WebTarget  target;

    @Before
    public void inicializaServidor() {
        server = Servidor.inicializaServidor();
        ClientConfig config = new ClientConfig();
        config.register(new LoggingFilter());
        this.client = ClientBuilder.newClient(config);
        this.target = client.target("http://localhost:8080");

    }

    @After
    public void derrubaServidor(){
        server.stop();
    }

    @Test
    public void TestaConexao() {

        WebTarget  target = client.target("http://www.mocky.io");
        String content = target.path("/v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);

        Assert.assertTrue(content.contains("<rua>Rua Vergueiro 3185"));
    }

    @Test
    public void BuscaCarrinho() {

        client = ClientBuilder.newClient();
        String content = target.path("/carrinhos/1").request().get(String.class);

        Carrinho carrinho = (Carrinho) new XStream().fromXML(content);

        Assert.assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
    }

    @Test
    public void TesteNovosCarrinhos() {

        Carrinho carrinho= new Carrinho();
        carrinho.adiciona(new Produto(314,"Microfone", 37, 1));
        carrinho.setRua("Rua Vergueiro 3185");
        carrinho.setCidade("São Paulo");
        String xml = carrinho.toXML();
        Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

        Response response = target.path("/carrinhos").request().post(entity);
        Assert.assertEquals(201, response.getStatus());

        String location = response.getHeaderString("Location");
        String conteudo = client.target(location).request().get(String.class);
        Assert.assertTrue(conteudo.contains("Microfone"));

    }

}
