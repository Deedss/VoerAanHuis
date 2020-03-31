import products.*
import states.*

class Order() {
    private lateinit var customer : Customer
    var products : MutableList<IProduct> = mutableListOf()
    private lateinit var pizzeria: Pizzeria
    var price : Float = 0F
    var state : StatusState = Ordered()

    constructor(customer: Customer, product : IProduct?, pizzeria: Pizzeria) : this() {
        this.customer = customer
        products.add(product!!)
        this.pizzeria = pizzeria

        for (item : IProduct in products) {
            price += item.price
        }
        checkForDiscount()
    }

    /**
     * Ups the customer points and sets the state depending on the number of points. Discount is dependent of State
     */
    private fun checkForDiscount() {
        when (customer.state){
            is NoDiscount -> {

            }
            is SmallDiscount -> {
                price = (price * 0.95).toFloat()
            }
            is FreeDrink -> {
                products.add(Soda())
            }
            is FreePizza -> {
                products.add(Pizza())
            }
        }
        customer.points += 1
        println(price)
    }
}
