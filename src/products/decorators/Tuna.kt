package products.decorators

import products.IProduct
import products.ProductDecorator

class Tuna(product: IProduct?) : ProductDecorator(product) , IProduct {
    override var price: Float = 0.65f
        get() = product.price + field
}
