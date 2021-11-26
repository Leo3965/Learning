import {Client} from "./Client.js";
import {CheckingAccount} from "./CheckingAccount.js";


const maria = new Client()
maria.nome = 'Maria'
maria.cpf = 123456

const account = new CheckingAccount();
account.agency = 1001

account.deposit(200)
let draw = account.withdraw(110)

/*const client1Nome = "Ricardo"
const client1CPF = 111222333
const client1Agencia = 1001
const client1Saldo = 0*/

console.log(draw)
console.log(maria, account)