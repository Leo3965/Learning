console.log("Léo!")

const itemsEl = document.querySelectorAll(".item")
const btnsIconEl = document.querySelectorAll(".icon")

btnsIconEl.forEach((e, index) => {
    e.addEventListener('click', function () {
        console.log(index)
        itemsEl[index].classList.toggle('open')
    })
})

