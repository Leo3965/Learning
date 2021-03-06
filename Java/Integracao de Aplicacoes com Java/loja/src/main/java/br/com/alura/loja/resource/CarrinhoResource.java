package br.com.alura.loja.resource;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;
import com.thoughtworks.xstream.XStream;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("carrinhos")
public class CarrinhoResource {

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String buscar(@PathParam("id") long id) {
        Carrinho carrinho = new CarrinhoDAO().busca(id);
        return carrinho.toXML();
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response adiciona(String conteudo) {
        Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
        new CarrinhoDAO().adiciona(carrinho);
        URI uri = URI.create("/carrinhos/" + carrinho.getId());
        return Response.created(uri).build();
    }

    @Path("{id}/produtos/{produtosId}")
    @DELETE
    public Response removeProduto(@PathParam("id") long id, @PathParam("produtosId") long produtosId) {
        Carrinho carrinho = new CarrinhoDAO().busca(id);
        carrinho.remove(produtosId);
        return Response.ok().build();
    }

    @Path("{id}/produtos/{produtosId}/quantidade")
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response alterarProduto(String conteudo, @PathParam("id") long id, @PathParam("produtosId") long produtosId) {
        Carrinho carrinho = new CarrinhoDAO().busca(id);
        Produto produto = (Produto) new XStream().fromXML(conteudo);
        carrinho.trocaQuantidade(produto);
        return  Response.ok().build();
    }

}
