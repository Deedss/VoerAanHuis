package products.decorators

import products.IProduct
import products.ProductDecorator

/**
 * The Pepperoni Class, used in the decorator and factory to make the PepperoniPizza and extra ingredients.
 * @param IProduct, the product on which pepperoni is added.
 */
class Pepperoni(product: IProduct?) : ProductDecorator(product) ,IProduct {
    override var price: Float = 0.35f
        get() = product!!.price + field
    override var description: String = "Pepperoni"
        get() = product!!.description + " " + field
}