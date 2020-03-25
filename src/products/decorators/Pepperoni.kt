package products.decorators

import products.IProduct
import products.ProductDecorator

class Pepperoni(product: IProduct?) : ProductDecorator(product) ,IProduct {
    override var price: Float = 0.35f
        get() = product.price + field
}