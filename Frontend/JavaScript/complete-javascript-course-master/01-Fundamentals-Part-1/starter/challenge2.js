let mass, height, markBmi, johnBmi

mass = 92
height = 1.95
johnBmi = mass / (height * height)

mass = 78
height = 1.69
markBmi = mass / (height * height)


markOutputMessage = `Mark's BMI is higher than John's!`
johnOutputMessage = `John's BMI is higher than Mark's!`

if (markBmi > johnBmi) console.log(markOutputMessage)
else console.log(johnOutputMessage)

mass = 85
height = 1.76
johnBmi = mass / (height * height)

mass = 95
height = 1.88
markBmi = mass / (height * height)

if (markBmi > johnBmi) console.log(markOutputMessage)
else console.log(johnOutputMessage)