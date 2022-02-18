'use strict';

// Data needed for a later exercise
const flights =
  '_Delayed_Departure;fao93766109;txl2133758440;11:25+_Arrival;bru0943384722;fao93766109;11:45+_Delayed_Arrival;hel7439299980;fao93766109;12:05+_Departure;fao93766109;lis2323639855;12:30';

// Data needed for first part of the section
const restaurant = {
  name: 'Classico Italiano',
  location: 'Via Angelo Tavanti 23, Firenze, Italy',
  categories: ['Italian', 'Pizzeria', 'Vegetarian', 'Organic'],
  starterMenu: ['Focaccia', 'Bruschetta', 'Garlic Bread', 'Caprese Salad'],
  mainMenu: ['Pizza', 'Pasta', 'Risotto'],

  order: function (starterIndex, mainIndex) {
    return [this.starterMenu[starterIndex], this.mainMenu[mainIndex]]
  },

  orderDelivery: function ({
    time = 20,
    address,
    mainIden = 1,
    starterIndex = 0
  }) {
    console.log(time, address, mainIden, starterIndex);
  },

  orderPasta: function (ing1, ing2, ing3) {
    console.log(`Here is your delicious pasta with
    ${ing1}, ${ing2} and ${ing3}`)
  },

  orderPizaa: function(mainIngredient, ...otherIngredients) {
    console.log(mainIngredient)
    console.log(otherIngredients)
  },

  openingHours: {
    thu: {
      open: 12,
      close: 22,
    },
    fri: {
      open: 11,
      close: 23,
    },
    sat: {
      open: 0, // Open 24 hours
      close: 24,
    },
  },
};

//restaurant.orderDelivery({
//  time: '22:30',
//  address: 'Via del Sole, 21',
//  mainIden: 2,
//  starterIndex: 2
//})

const arr = [0, 1, 2];
const [a, b, c] = arr;
let [first, , second] = restaurant.categories;
[first, second] = [second, first]
//console.log(first, second);

const [starter, main] = restaurant.order(2, 0);
//console.log(starter, main);

const nest = [2, 4, [5, 6]];
const [i, , [j, k]] = nest;
//console.log(j, k);

const [p = 1, q = 1, r = 1] = [0, 9];
//console.log(p, q, r);

const {
  name,
  openingHours,
  categories
} = restaurant;
const {
  name: nome,
  openingHours: horaDeAbertura,
  categories: categorias
} = restaurant;

const {
  menu = [], starterMenu: starters = []
} = restaurant;
//console.log(name, openingHours, categories);
//console.log(nome, horaDeAbertura, categorias);

let aa = 11;
let bb = 99;

const abc = {
  aa: 23,
  bb: 56,
  cc: 14
};

({
  aa,
  bb
} = abc);
//console.log(aa, bb);

//const {open, close} = restaurant.openingHours.fri;
const {
  fri: {
    open,
    close
  }
} = openingHours
// console.log(open, close);

const arr2 = [0, 1, 2];

// Spread operator
const newArr = [1, 2, ...arr2]
//console.log(newArr) 
//console.log(...newArr);
const newMenu = [...restaurant.mainMenu, 'Onocci']
const smenu = [...restaurant.mainMenu, ...restaurant.starterMenu]
//console.log(smenu)

//const ingredients = [
//  prompt(`Let\'s make pasta! Ingredient 1`), prompt('Ingredient 2'), prompt('Ingredient 3')
//]

//console.table(ingredients)

//restaurant.orderPasta(...ingredients);

const newRestaurant = {
  foundIn: 1998,
  ...restaurant,
  founder: 'Guiseppe'
}
//console.log(newRestaurant);

const restaurantCopy = {
  ...restaurant
};
restaurantCopy.name = 'Ristorante Roma';
//console.log(restaurant.name, restaurantCopy.name);

// SPREAD
const array = [1, 2, ...[3, 4]]

// REST
const [a2, b2, ...others] = [1, 2, 3, 4, 5]
//console.log(a2, b2, others)

// REST Objects
const {
  sat,
  ...weekDays
} = restaurant.openingHours
//console.log(sat, weekDays)

// REST Arguments
const add = function (...numbers) {
  let sum = 0;
  for (let i = 0; i < numbers.length; i++) sum += numbers[i]
  console.log(sum)
}

//add(1, 2)
//add(1, 2, 3, 4)
//add(11, 22, 33, 44)

//const numbers = [1, 3, 2, 78]
//add(...numbers)
//restaurant.orderPizaa('onion', 'olives', 'spinach')
//restaurant.orderPizaa('Calabresa')

// Use any data type, return any data type, short-circuting
//console.log(0 || 'Jonas')

restaurant.numGuests = 0
const guests = restaurant.numGuests || 10

//restaurant.orderPizaa && restaurant.orderPizaa('Peperone', 'Salad', 'Calabresa')

//The Nullish Coalescing Operator {Null and undefined} {NOT 0 or ''}
const guestCorrect = restaurant.numGuests ?? 10
//console.log(guests)
//console.log(guestCorrect)

const rest1 = {
  name: 'Capri',
  //numGuests: 20
  numGuests: 0
}

const rest2 = {
  name: 'La Piazza',
  owner: 'Giovanni Carroseli'
}

//rest1.numGuests = rest1.numGuests || 100
rest1.numGuests ??= 100
//rest2.numGuests = rest2.numGuests || 100
rest2.numGuests ||= 100

rest1.owner &&= '<ANONYMOUS>'
rest2.owner &&= '<ANONYMOUS>'


//console.log(rest1, rest2)

const menuu = [...restaurant.starterMenu, ...restaurant.mainMenu]
//for (const item in menuu) console.log(item)
//for (const item of menuu) console.log(item)

for (const [i, el] of menuu.entries()) {
  console.log(`${i + 1}: ${el}`)
}