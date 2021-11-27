export class Client{

    constructor(name, cpf) {
        this._name = name
        this._cpf = cpf
    }

    get cpf() {
        return this._cpf
    }

    get name() {
        return this._name
    }

    authenticate() {
        return false
    }
}