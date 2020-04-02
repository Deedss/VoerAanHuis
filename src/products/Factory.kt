package products

import products.decorators.*

/**
 * Abstract factory class to create Pizza's
 */
abstract class Factory {

    /**
     * Creates a Pizza based on the input from the CustomerGUI.
     * @param base : String, the base pizza.
     * @param MutableList<String> extras, all ingredients to add via decorator
     * @return IProduct ,
     */
    fun createPizza(base: String, extras: MutableList<String>) : IProduct? {
        var product : IProduct? = null

        // Make the base Pizza by utilizing the decorator as well.
        if (base == "Base") {
            product = Pizza()
        }
        if (base == "Cheese") {
            product = Cheese(Pizza())
        }
        if (base == "Pepperoni") {
            product = Pepperoni(Pizza())
        }
        if (base == "Special") {
            product = Tuna(Pepperoni(Cheese(Pizza())))
        }

        // Implement the decorator to add new Items to the pizza list.
        for (string in extras) {
            if (string == "Extra Cheese") {
                product = Cheese(product)
            }
            if (string == "Extra Meat") {
                product = Pepperoni(product)
            }
            if (string == "Extra Tuna") {
                product = Tuna(product)
            }
        }

        return product
    }
}
