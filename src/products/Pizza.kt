package products

/**
 * Base Pizza class implements IProduct
 */
class Pizza : IProduct {
    override var price : Float = 3.0f
    override var description : String = "Pizza"
}