# JavaScript
![objectandprimitives](../../../../../../../home/leo/Pictures/Screenshot from 2022-01-17 21-58-39.png)
 > JavaScript has dynamic typing: **value has type in JavaScript, not variable** 

#### DOM
    DOCUMENT OBJECT MODEL: It is a structured representation of HTML files. It allows JavaScript to access HTML elements and manipulate them. So the DOM is basically a connection point between HTML and JavaScript.

![dom1](../../../../../../../home/leo/Pictures/Screenshot from 2022-02-08 19-21-18.png)

    The DOM is automatically created by the browser in the moment that the HTML file is loaded and it's stored in a work tree structure. In this tree each HTML element is one object. 

![dom2](../../../../../../../home/leo/Pictures/Screenshot from 2022-02-08 19-32-14.png)

    The DOM is part of the WEB APIs
    like timers and fetch.

![dom3](../../../../../../../home/leo/Pictures/Screenshot from 2022-02-08 19-44-30.png)

    DOCUMENT is a special object that is entry point to the DOM.
    Example: 
~~~javascript
    document.querySelector()
~~~

#### The 7 primitive data types
 - number `let age = 23`
 - string `let firstName = 'Leo'`
 - boolean `let flag = true`
 - undefined `let children`
 - null
 - symbol (ES2015)
 - BigInt (ES2020)


#### var, let and const
     let - we use let with variables that can have it value changed during the execution (reassigning or mutate)

     const - we use to assign the variable than won't have the value changed (unmutable)

     var - var is the old way of defining variables, it's similar to let but a let is blocked scope and var is function scope

     ps: if you don't declare a variable with let, const or var it will be created in the global scope

#### Type Conversion vs Type Coercion
 * Type Conversion - Is when we manually convert a type
~~~javascript
let num = '1998'; num = Number(num); 
~~~
 * Type Coercion - Is when JavaScript converts a type behind the scenes
~~~javascript
console.log('I am ' + 30 + ' years old')
~~~

#### 5 Falsy values
 * 0
 * ''
 * undefined
 * null
 * NaN

#### === vs ==
 * === - strict equality operator
 * == - loose equality operator, it does type coercion

 #### Strict  mode
 to activate strict mode you need to put it at the first line before any statement

     'use strict'

strict mode forbids us from doing certain things and it creates visible errors in the developer console wherein other situations javascript would just fail silently

#### Invoking / Calling / Running a function

~~~JavaScript
function fruitProcessor(apples, oranges) { // The parameter is kind of the placeholder 
    return `Juice with ${apples} apples and ${oranges} oranges`
}

console.log(fruitProcessor(5, 6)) // The argument is the actual value that fill in 
~~~

#### Function Declaration vs Function Expression

the big difference between function declaration and expression is that using function declaration you can call the function before it was defined, on the other hand, with function expression this does not happen. However, arrow functions do not get a so-called this keyword.

~~~JavaScript
function calcAge(birthYear){
    return 2022 - birthYear
}

// function expression
const calcAge2 = function (birthYear){
    return 2022 - birthYear
}

// arrow function
const calcAge3 = birthYear => 2022 - birthYear
~~~
