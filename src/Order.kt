import products.IProduct
import products.Pizza

class Order() {
    private lateinit var customer : Customer
    private lateinit var products : MutableList<Pizza>
    private lateinit var pizzeria: Pizzeria
    var price : Float = 0F

    constructor(customer : Customer, products : MutableList<Pizza>, pizzeria: Pizzeria) : this() {
        this.customer = customer
        this.products = products
        this.pizzeria = pizzeria

        for (pizza in products) {
            price += pizza.price
        }
    }


}