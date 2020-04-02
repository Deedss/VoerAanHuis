package products.decorators

import products.IProduct
import products.ProductDecorator

/**
 * The Cheese Class, used in the decorator and factory to make the cheesePizza and extra ingredients.
 * @param IProduct, the product on which cheese is added.
 */
class Cheese(product: IProduct?) : ProductDecorator(product), IProduct {
    override var price: Float = 0.5f
        get() = product!!.price + field
    override var description: String = "Cheese"
        get() = product!!.description + " " + field
}