export class CheckingAccount{
    agency
    //#balance - https://github.com/tc39/proposal-class-fields#private-fields
    _balance = 0

    withdraw(amount){
        if(this._balance < amount) return 0

        this._balance -= amount
        return amount;
    }

    deposit(amount){
        if (amount <= 0) return

        this._balance += amount
    }
}