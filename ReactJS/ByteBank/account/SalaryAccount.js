import {Account} from "./Account.js";

export class SalaryAccount extends Account{
    constructor(client) {
        super(0, client, 100);
    }

    withdraw(amount){
        return super._withdraw(1.01, amount);
    }
}