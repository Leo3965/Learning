import {Client} from './Client.js';
import {CheckingAccount} from './CheckingAccount.js';


const maria = new Client('Maria', 123456)

const maccount = new CheckingAccount();
maccount.agency = 1001
maccount.client = maria

maccount.deposit(200)

const joao = new Client('João', 456321)

const jaccount = new CheckingAccount();
jaccount.agency = 1002
jaccount.client = joao

const account = new CheckingAccount();
account.agency = 1001
account.client = 0

jaccount.deposit(50)

maccount.transfer(60, jaccount)

/*const client1Nome = "Ricardo"
const client1CPF = 111222333
const client1Agencia = 1001
const client1Saldo = 0*/

console.log(CheckingAccount.accountNumber)
console.log(maccount, jaccount, account)