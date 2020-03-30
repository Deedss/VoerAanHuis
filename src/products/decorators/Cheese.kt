package products.decorators

import products.IProduct
import products.ProductDecorator

class Cheese(product: IProduct?) : ProductDecorator(product), IProduct {
    override var price: Float = 0.5f
        get() = product!!.price + field
}