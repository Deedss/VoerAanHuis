package userInterface

import Observer
import Order
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.TitledPane
import javafx.stage.Stage

open class RestaurantUi(): Observer(){

    override fun update(order: Order) {
        TODO("Not yet implemented")
    }
}