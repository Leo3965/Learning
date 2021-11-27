import {Client} from "../Client.js";

export class Account {

    constructor(openingBalance, client, agency) {
        this._balance = openingBalance
        this.client = client
        this._agency = agency

        if (this.constructor == Account) {
            throw  new Error("This class shouldn't be instantiated")
        }
    }

    //Abstract method
    withdraw(amount){
        throw new Error("Abstract method")
    }

    _withdraw(tax, amount) {
        const withdrawnAmount = tax * amount
        if(this._balance < withdrawnAmount) return 0

        this._balance -= withdrawnAmount
        return withdrawnAmount;
    }

    deposit(amount){
        if (amount <= 0) return

        this._balance += amount
    }

    transfer(amount, account){
        const withdrawnAmount = this.withdraw(amount)
        account.deposit(withdrawnAmount)
    }

    get agency() {
        return this._agency
    }

    get balance() {
        return this._balance
    }

    get client() {
        return this._client
    }

    set client(client) {
        if (client instanceof Client) this._client = client
    }

}