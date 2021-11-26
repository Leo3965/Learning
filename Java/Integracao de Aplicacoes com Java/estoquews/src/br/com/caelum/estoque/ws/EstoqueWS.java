package br.com.caelum.estoque.ws;

import br.com.caelum.estoque.modelo.item.*;
import br.com.caelum.estoque.modelo.usuario.AuthorizationException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT,use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class EstoqueWS {

    private ItemDao dao = new ItemDao();

    //@RequestWrapper(localName = "itens")
    @WebMethod(operationName = "TodosOSItens")
    @WebResult(name = "itens")
    public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) {

        List<Filtro> filtrosLista = filtros.getLista();
        ArrayList<Item> items = dao.todosItens(filtrosLista);

        return new ListaItens(items);
    }

    @WebMethod(operationName = "CadastrarItem")
    @WebResult(name = "item")
    public Item cadastrarItem
            (@WebParam(name = "Tokenusuario", header = true) TokenUsuario tokenUsuario,
            @WebParam(name = "item") Item item)
            throws AuthorizationException {

        System.out.println("Cadastrando item: " + item + "Token: " + tokenUsuario);
        boolean valido = new TokenDao().ehValido(tokenUsuario);

        if (!valido) {
            throw new AuthorizationException("Autorização falhou!");
        }

        new ItemValidador(item).validate();

        this.dao.cadastrar(item);
        return item;
    }

}
