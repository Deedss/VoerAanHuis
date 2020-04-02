import states.*

/**
 * Customer class. for holding data on the customer.
 * @param name, String value of customer.
 * @param address, String value of address of customer.
 */
class Customer(var name: String, var address: String) {
    // Field for determining points for discount.
    var points : Int = 0
        set(value){
            field = value
            when (field) {
                0 -> {
                    state = NoDiscount()
                }
                1 -> {
                    state = SmallDiscount()
                }
                2 -> {
                    state = FreeDrink()
                }
                3 -> {
                    state = FreePizza()
                }
                4 -> {
                    field = 0
                    state = NoDiscount()
                }
            }
        }
    var state : DiscountState = NoDiscount()
}