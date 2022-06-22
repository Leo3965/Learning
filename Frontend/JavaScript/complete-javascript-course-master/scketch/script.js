const oneWord = function(str) {
    // Regular expression / /g that get all empty espaces
    return str.replace(/ /g, '').toLowerCase();
};

const upperFirstWord = function(str) {
    const [first, ...others] = str.split(' ');
    return [first.toUpperCase(), ...others].join(' ');
};

// Higher-order function
const transaformer = function(str, fn) {
    console.log(str);
    console.log(`Transformed string: ${fn(str)}`);

    console.log(`Transformed by: ${fn.name}`)
};

transaformer('JavaScript is the best', upperFirstWord);

transaformer('JavaScript is the best', oneWord);