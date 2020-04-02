/**
 * Class OrderManager to handle all information from the GUI's and create orders,
 * acts as the inbetween for the GUI's and uses the Observer class to
 */
class OrderManager(){
    private var orders : MutableList<Order> = mutableListOf(Order())
    private var pizzeria : Pizzeria = Pizzeria()
    private var customer : Customer = Customer("Gertjan", "Poelsnip 4")
    private var customerGUI : CustomerGUI
    private var restaurantGUI : RestaurantGUI
    private var observers : MutableList<Observer>

    /**
     * Initializes the GUI's and adds them to the observers list.
     */
    init {
        // Initialize objects
        customerGUI = CustomerGUI(this, customer)
        restaurantGUI = RestaurantGUI(this, pizzeria)

        // Add UI's to list of observers
        observers = mutableListOf(customerGUI, restaurantGUI)
        observers.add(customerGUI)
        observers.add(restaurantGUI)
    }

    /**
     * Adds a new order to the orderList.
     * @param customer, Customer to add
     * @param base, String base pizza
     * @param list, MutableList<String>
     */
    fun addOrder(customer: Customer, base: String, list: MutableList<String>){
        val product= pizzeria.createPizza(base, list)
        val order = Order(customer, product, pizzeria)
        orders.add(order)
        changeOrderState(order)
    }

    private fun changeOrderState(order : Order) {
        order.state = order.state?.nextState()
        println(order.state?.description)
        updateOrders()
        TODO( "Rerun this function every few seconds and update the state. Or try something else")
    }

    private fun updateOrders() {
        for (observer in observers) {
            observer.update(orders.last())
        }
    }
}
