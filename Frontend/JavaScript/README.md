# JavaScript
![objectandprimitives](../../../../../../../home/leo/Pictures/Screenshot from 2022-01-17 21-58-39.png)
 > JavaScript has dynamic typing: **value has type in JavaScript, not variable** 

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