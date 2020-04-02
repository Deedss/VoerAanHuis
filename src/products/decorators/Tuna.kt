package products.decorators

import products.IProduct
import products.ProductDecorator

/**
 * The Tuna Class, used in the decorator and factory to make the SpecialPizza and extra ingredients.
 * @param IProduct, the product on which tuna is added.
 */
class Tuna(product: IProduct?) : ProductDecorator(product) , IProduct {
    override var price: Float = 0.65f
        get() = product!!.price + field
    override var description: String = "Tuna"
        get() = product!!.description + " " + field
}
