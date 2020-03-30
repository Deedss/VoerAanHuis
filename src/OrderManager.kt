import javafx.application.Application
import javafx.stage.Stage
import userInterface.CustomerUi
import userInterface.RestaurantUi

class OrderManager() : Application() {
    private lateinit var orders : MutableList<Order>
    var pizzeria : Pizzeria = Pizzeria()
    var customer : Customer = Customer("Gertjan", "Poelsnip 4")
    private lateinit var customerUi : CustomerUi
    private lateinit var restaurantUi : RestaurantUi
    private lateinit var observers : MutableList<Observer>

    fun addOrder(customer: Customer, base: String, list: MutableList<String>) : Boolean {

        val product= pizzeria.createPizza(base, list)
        val order = Order(customer, product, pizzeria)

        updateOrders()
        return orders.add(order)
    }

    fun updateOrders() {
        for (observer in observers) {
            observer.update(orders.last())
        }
    }

    /**
     * Starts the whole application. Creates both UI's and adds them to the list of observers.
     */
    override fun start(stage: Stage?) {
        // Initialize objects
        customerUi = CustomerUi(this, customer)
        restaurantUi = RestaurantUi(this, pizzeria)

        // Build Stages
        customerUi.initScene()
        restaurantUi.initScene()

        // Add UI's to list of observers
        observers = mutableListOf(customerUi, restaurantUi)
    }
}