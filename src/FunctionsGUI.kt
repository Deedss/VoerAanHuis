import javax.swing.DefaultComboBoxModel
import javax.swing.DefaultListModel

interface FunctionsGUI {

    fun fillOrderList(order: Order): MutableList<String>? { return null}

    fun getComboBoxModel(yourClassList: List<String>): DefaultComboBoxModel<String>? { return null }

    fun getListModel(yourClassList: List<String>): DefaultListModel<*>? { return null }
}