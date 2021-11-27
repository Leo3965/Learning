import {Client} from './Client.js';
import {CheckingAccount} from './account/CheckingAccount.js';
import {SavingsAccount} from "./account/SavingsAccount.js";
import {Manager} from "./employee/Manager.js";
import {Director} from "./employee/Director.js";
import {AuthenticationSystem} from "./AuthenticationSystem.js";

const maria = new Client('Maria', 123456)

const checkingAccount = new CheckingAccount(maria, 1001)
checkingAccount.deposit(200)
checkingAccount.withdraw(20)
const savingsAccount = new SavingsAccount(110, maria, 1001)
savingsAccount.withdraw(10)
// console.log(checkingAccount, savingsAccount)

const manager = new Manager("Rodrigo", 5000, 123456)
manager.registerPassword("123")
const director = new Director("Ricardo", 10000, 987654)
director.registerPassword("123")

const isLogged = AuthenticationSystem.login(director, "123")

console.log(isLogged)