import products.*
import states.*

class Order() {
    private lateinit var customer : Customer
    private lateinit var products : MutableList<IProduct>
    private lateinit var pizzeria: Pizzeria
    var price : Float = 0F

    constructor(customer : Customer, products : MutableList<IProduct>, pizzeria: Pizzeria) : this() {
        this.customer = customer
        this.products = products
        this.pizzeria = pizzeria

        for (pizza in products) {
            price += pizza.price
        }
    }

    fun checkForDiscount() {
        when (customer.state){
            is NoDiscount -> price
            is SmallDiscount -> price * 0.95
            is FreeDrink -> products.add(Soda())
            is FreePizza -> products.add(Pizza())
        }
    }

}
