import states.*

class Customer(var name: String, var address: String) {
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