import {Account} from "./Account.js";

export class SavingsAccount extends Account{
    constructor(openingBalance, client, agency) {
        super(openingBalance, client, agency);
    }

    withdraw(amount){
        return super._withdraw(1.02, amount);
    }
}