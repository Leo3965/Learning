import {Account} from "./Account.js";

export class CheckingAccount extends Account {
    static accountNumber = 0
    //#balance - https://github.com/tc39/proposal-class-fields#private-fields

    constructor(client, agency) {
        super(0, client, agency);
        CheckingAccount.accountNumber++
    }

    withdraw(amount){
        //this._withdraw(1.1, amount);
        return super._withdraw(1.1, amount);
    }

}