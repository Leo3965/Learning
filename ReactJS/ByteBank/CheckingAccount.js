import {Client} from './Client.js';

export class CheckingAccount{
    static accountNumber = 0
    agency
    //#balance - https://github.com/tc39/proposal-class-fields#private-fields
    _balance = 0
    _client

    constructor(client, agencia) {
        this.agency = agencia
        this.client = client
        CheckingAccount.accountNumber++
    }

    get balance() {
        return this._balance
    }
    set client(object) {
        if (object instanceof Client) this._client = object
    }

    withdraw(amount){
        if(this._balance < amount) return 0

        this._balance -= amount
        return amount;
    }

    deposit(amount){
        if (amount <= 0) return

        this._balance += amount
    }

    transfer(amount, account){
        const withdrawnAmount = this.withdraw(amount)
        account.deposit(withdrawnAmount)
    }
}