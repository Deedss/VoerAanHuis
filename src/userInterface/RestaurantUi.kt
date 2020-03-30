package userInterface

import Observer
import Order
import OrderManager
import Pizzeria
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

open class RestaurantUi(var orderManager: OrderManager, var pizzeria: Pizzeria) : Observer(){
    fun initScene() {
        var stage = Stage()
        stage.title = "Restaurant"
        stage.scene = Scene(FXMLLoader.load(javaClass.getResource("RestaurantUi.fxml")))
        stage.show()
    }

    override fun update(order: Order) {

    }
}