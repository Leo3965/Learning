export class Client{
    name
    _cpf

    constructor(name, cpf) {
        this.name = name
        this._cpf = cpf
    }

    get cpf() {
        return this._cpf
    }
}