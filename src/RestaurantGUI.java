import products.IProduct;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantGUI extends Observer implements FunctionsGUI{

    private OrderManager orderManager;
    private Pizzeria pizzeria;

    // GUI ELEMENTS
    private JPanel panel;
    private JList orderList;

    public RestaurantGUI(OrderManager orderManager, Pizzeria pizzeria) {
        this.orderManager = orderManager;
        this.pizzeria = pizzeria;
        initGui();
    }

    public void initGui(){
        JFrame jFrame = new JFrame("Restaurant");
        jFrame.setContentPane(panel);
        jFrame.setSize(600, 800);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    @Override
    public void update(Order order) {
        orderList.removeAll();
        orderList.setModel(getListModel(fillOrderList(order)));
        orderList.updateUI();
    }

    @Override
    public List<String> fillOrderList(Order order) {
        ArrayList<String> list = new ArrayList<>();
        for(IProduct product : order.getProducts()) {
            List<String> descList = new ArrayList<String>(Arrays.asList(product.getDescription().split(" ")));
            for (String string : descList) {
                list.add("Contains: " + string);
            }
            list.add("Prijs: " + product.getPrice());
        }
        return list;
    }

    @Override
    public DefaultComboBoxModel<String> getComboBoxModel(List<String> yourClassList) {
        String[] comboBoxModel = yourClassList.toArray(new String[0]);
        return new DefaultComboBoxModel<>(comboBoxModel);
    }

    @Override
    public DefaultListModel<?> getListModel(List<String> yourClassList) {
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < yourClassList.size(); i++)
        {
            listModel.addElement(yourClassList.get(i));
        }
        return listModel;
    }
}

