package userInterface

import Customer
import Observer
import Order
import OrderManager
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.control.ComboBox
import javafx.scene.control.ListView
import javafx.scene.input.MouseEvent
import javafx.stage.Stage
import javafx.collections.ObservableList as ObservableList1

class CustomerUi(var orderManager: OrderManager, var customer : Customer) : Observer() {
    private val ingredients : ObservableList1<String> = FXCollections.observableArrayList(
        "Nothing",
        "Cheese",
        "Pepperoni",
        "Tuna"
    )

    private val basePizza : ObservableList1<String> = FXCollections.observableArrayList(
        "Base",
        "Cheese",
        "Meat",
        "Special"
    )

    @FXML
    lateinit var listView : ListView<String>
    @FXML
    lateinit var ingredients1 : ComboBox<String>
    @FXML
    lateinit var ingredients2 : ComboBox<String>
    @FXML
    lateinit var ingredients3 : ComboBox<String>
    @FXML
    lateinit var base : ComboBox<String>

    /**
     * Initializes the GUI of the Customer
     */
    fun initScene() {
        var stage = Stage()
        stage.title = "Customer"
        stage.scene = Scene(FXMLLoader.load(javaClass.getResource("CustomerUi.fxml")))

        // Bind the JavaFX elements
        listView = stage.scene.lookup("#listView") as ListView<String>
        ingredients1 = stage.scene.lookup("#ingredients1") as ComboBox<String>
        ingredients2 = stage.scene.lookup("#ingredients2") as ComboBox<String>
        ingredients3 = stage.scene.lookup("#ingredients3") as ComboBox<String>
        base = stage.scene.lookup("#base") as ComboBox<String>

        // Fill the dropdown items
        ingredients1.value = "Nothing"
        ingredients2.value = "Nothing"
        ingredients3.value = "Nothing"
        base.value = "Base"
        ingredients1.items.addAll(ingredients)
        ingredients2.items.addAll(ingredients)
        ingredients3.items.addAll(ingredients)
        base.items.addAll(basePizza)

        // Show Stage
        stage.show()
    }

    /**
     * Update the frontend on changes to the order
     */
    override fun update(order: Order) {

    }

    /**
     * Eventhandler for clicking the place order button.
     */
    fun buttonClicked(event: MouseEvent) {
        val baseString = base.value
        val ingredientsList : MutableList<String> = mutableListOf()

        ingredientsList.add(ingredients1.value)
        ingredientsList.add(ingredients2.value)
        ingredientsList.add(ingredients3.value)

        listView.isEditable = false
        listView.items.add(baseString)
        listView.items.addAll(ingredientsList)

        orderManager.addOrder(customer, baseString, ingredientsList)
    }
}

