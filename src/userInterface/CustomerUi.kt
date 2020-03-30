package userInterface

import Observer
import Order
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.ComboBox
import javafx.stage.Stage

class CustomerUi() : Observer() {

    val items : ObservableList<String> = FXCollections.observableArrayList(
        "Nothing",
        "Cheese",
        "Pepperoni",
        "Tuna"
    )

    @FXML
    var ingredients1 : ComboBox<String> = ComboBox<String>()
    @FXML
    var ingredients2 : ComboBox<String> = ComboBox<String>()
    @FXML
    var ingredients3 : ComboBox<String> = ComboBox<String>()

    override fun update(order: Order) {
        TODO("Not yet implemented")
    }
}

