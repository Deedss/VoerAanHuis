import javafx.application.Application
import javafx.stage.Stage

class OrderManager() : Application() {
    private var orders : MutableList<Order> = mutableListOf(Order())
    private var pizzeria : Pizzeria = Pizzeria()
    private var customer : Customer = Customer("Gertjan", "Poelsnip 4")
    private lateinit var customerGUI : CustomerGUI
    private lateinit var restaurantGUI : RestaurantGUI
    private lateinit var observers : MutableList<Observer>

    fun addOrder(customer: Customer, base: String, list: MutableList<String>){
        val product= pizzeria.createPizza(base, list)
        val order = Order(customer, product, pizzeria)
        orders.add(order)
        updateOrders()
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
        customerGUI = CustomerGUI(this, customer)
        restaurantGUI = RestaurantGUI(this, pizzeria)

        // Add UI's to list of observers
        observers = mutableListOf(customerGUI, restaurantGUI)
        observers.add(customerGUI)
        observers.add(restaurantGUI)
    }
}