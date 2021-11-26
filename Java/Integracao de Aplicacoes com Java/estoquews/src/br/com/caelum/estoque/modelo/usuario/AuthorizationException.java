package br.com.caelum.estoque.modelo.usuario;

import javax.xml.ws.WebFault;

@WebFault(name = "Auto")
public class AuthorizationException extends Exception {

    private static final long serialVersionUID = 1L;

    public AuthorizationException(String msg) {
        super(msg);
    }

    public String getFaultInfo() {
        return "Token Invalido!";
    }
}
