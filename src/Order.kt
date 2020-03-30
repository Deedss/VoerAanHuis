import products.*
import states.*

class Order() {
    private lateinit var customer : Customer
    var products : MutableList<IProduct> = mutableListOf()
    private lateinit var pizzeria: Pizzeria
    var price : Float = 0F

    constructor(customer: Customer, product : IProduct?, pizzeria: Pizzeria) : this() {
        this.customer = customer
        products.add(product!!)
        this.pizzeria = pizzeria

        checkForDiscount()
    }

    private fun checkForDiscount() {
        when (customer.state){
            is NoDiscount -> price
            is SmallDiscount -> price * 0.95
            is FreeDrink -> products.add(Soda())
            is FreePizza -> products.add(Pizza())
        }
    }

}
