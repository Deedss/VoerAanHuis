import userInterface.CustomerUi
import userInterface.RestaurantUi

class OrderManager() {
    private lateinit var orders : MutableList<Order>
    private var observers : MutableList<Observer> = mutableListOf(CustomerUi(), RestaurantUi())

    fun addOrder(order : Order) : Boolean {
        return orders.add(order)
    }

    fun updateOrders() {
        for (observer in observers) {
            observer.update(orders.last())
        }
    }
}