import javax.swing.DefaultComboBoxModel
import javax.swing.DefaultListModel

/**
 * Interface of functions to use in the GUI's
 */
interface FunctionsGUI {

    /**
     * Function to fill the orderList in both GUI's
     * @return MutableList<String>
     */
    fun fillOrderList(order: Order): String? { return null}

    /**
     * Function to fill a comboBox Model.
     * @return DefaultComboBoxModel<String>
     */
    fun getComboBoxModel(yourClassList: List<String>): DefaultComboBoxModel<String>? { return null }
}