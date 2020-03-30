import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.ComboBox
import javafx.stage.Stage
import userInterface.CustomerUi
import userInterface.RestaurantUi

class OrderManager() : Application() {
    private lateinit var orders : MutableList<Order>
    lateinit var customerUi : CustomerUi
    lateinit var restaurantUi : RestaurantUi
    private lateinit var observers : MutableList<Observer>

    fun addOrder(order : Order) : Boolean {
        return orders.add(order)
    }

    fun updateOrders() {
        for (observer in observers) {
            observer.update(orders.last())
        }
    }

    override fun start(stage: Stage?) {
        customerUi = CustomerUi()
        restaurantUi = RestaurantUi()

        customerUi.ingredients1.items = customerUi.items
        customerUi.ingredients2.items = customerUi.items
        customerUi.ingredients3.items = customerUi.items

        stage?.title = "Restaurant"
        stage?.scene = Scene(FXMLLoader.load(javaClass.getResource("userInterface/RestaurantUi.fxml")))
        stage?.show()

        val stage2 = Stage()
        stage2?.title = "Customer"
        stage2?.scene = Scene(FXMLLoader.load(javaClass.getResource("userInterface/CustomerUi.fxml")))
        stage2?.show()

        observers = mutableListOf(customerUi, restaurantUi)
    }
}