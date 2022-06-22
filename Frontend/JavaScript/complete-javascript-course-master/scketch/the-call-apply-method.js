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

lufthansa.book(239, 'Leo Freitas')
lufthansa.book(656, 'John Smith')

// does not work
// book(123, 'Sarah')
// Call method
book.call(eurowings, 132, 'Sarah') // this set the this key word to the first parameter

const swiss = {
    airline: 'Swiss Air Lines',
    iataCode: 'LX',
    bookings: []
}

// Apply method
const flightData = [456, 'George']
book.apply(swiss, flightData)

book.call(swiss, ...flightData)