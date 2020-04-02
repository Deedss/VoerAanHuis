package products

/**
 * Base class for Soda, implements IProduct.
 */
class Soda : IProduct {
    override var price : Float = 1.5f
    override var description: String = "Soda"
}