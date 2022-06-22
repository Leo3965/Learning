const greet = function(greeting) {
    return function(name) {
        console.log(`${greeting} ${name}`)
    }
}

const greetArrow = greeting => name => console.log(`${greeting} ${name}`)
    


const greeterHey = greet('Hey') // this lines return a function that recieve a parameter
greeterHey('Léo')
greet('GoodBye')('JS') // This is super wierd
greetArrow('Hello')('Arrow Function')