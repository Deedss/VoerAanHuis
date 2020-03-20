import userInterface.CustomerUi
import userInterface.RestaurantUi

class OrderManager() {
    private var orders : MutableList<Order> = TODO()
    private var observers : MutableList<Observer> = mutableListOf(CustomerUi(), RestaurantUi())

    fun addOrder(order : Order) : Boolean {
        return orders.add(order)
    }

    fun updateOrders() {
        for (observer in observers) {
            observer.update()
        }
    }
}