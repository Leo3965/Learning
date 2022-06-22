const lufthansa = {
    airline: 'Lufthansa',
    iataCode: 'LH',
    bookings: [],
    // book: function() {}
    book(flightNum, name) {
        console.log(`${name} booked a seat on ${this.airline}
        flight ${this.iataCode}${flightNum}`)
        this.bookings.push({
            flight: `${this.iataCode}${flightNum}`,
            name
        })
    }
}

const eurowings = {
    airline: 'Eurowings',
    iataCode: 'EW',
    bookings: []
}

const book = lufthansa.book

// Bind method
const bookEW = book.bind(eurowings)
// Partial application - (presets parameters) means that a part of the process is already set =D
const bookEW23 = book.bind(eurowings, 23)

bookEW(852, 'Leo Freitas')
bookEW23('Cirilo')

// With Event Listeners
lufthansa.planes = 300
lufthansa.buyPlane = function() {
    console.log(this)
    this.planes++
    console.log(this.planes)
}

// partial applications
const addTax = (rate, value) => value + (value * rate)
console.log(addTax(0.1, 200))

const addVAT = addTax.bind(null, 0.23)

const addVATArrow = value => addTax(0.23, value)