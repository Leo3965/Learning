export class Employee{

    constructor(name, salary, cpf) {
        this._name = name
        this._salary = salary
        this._cpf = cpf
        this._bonificacao = 1
        this._password
    }

    registerPassword(password) {
        this._password = password
    }

    authenticate(password) {
        return this._password == password
    }
}