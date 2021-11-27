// Duck typing - https://en.wikipedia.org/wiki/Duck_typing

export class AuthenticationSystem {
    static login(authenticable, password) {
        if(AuthenticationSystem.isAuthenticable(authenticable)){
            return authenticable.authenticate(password)
        }
    }

    static isAuthenticable(authenticable) {
        return "authenticate" in authenticable &&
            authenticable.authenticate instanceof Function
    }
}