package products

import products.decorators.*

abstract class Factory {
    fun createPizza(base : String, extras : List<String>) : IProduct? {
        var product : IProduct? = null

        if (base == "Base") {
            product = Pizza()
        }
        if (base == "Cheese") {
            product = Cheese(Pizza())
        }
        if (base == "Meat") {
            product = Pepperoni(Pizza())
        }
        if (base == "Special") {
            product = Tuna(Pepperoni(Cheese(Pizza())))
        }

        for (string in extras) {
            if (string == "Extra Cheese") {
                product = Cheese(product)
            }
            if (string == "Extra Pepperoni") {
                product = Pepperoni(product)
            }
            if (string == "Extra Tuna") {
                product = Tuna(product)
            }
        }

        return product
    }
}
