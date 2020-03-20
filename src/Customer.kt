import states.DiscountState
import states.NoDiscount

class Customer(var name: String, var address: String) {
    var points : Int? = 0
    var state : DiscountState = NoDiscount()
}