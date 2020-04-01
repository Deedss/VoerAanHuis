import products.IProduct;

import javax.swing.*;
import java.math.BigDecimal;
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
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    @Override
    public void update(Order order) {
        orderList.setModel(getListModel(fillOrderList(order)));
        orderList.updateUI();
    }

    @Override
    public List<String> fillOrderList(Order order) {
        ArrayList<String> list = new ArrayList<>();
        list.add("The order contains the following products");
        for(IProduct product : order.getProducts()) {
            if (product.getDescription().contains("Free")) {
                list.add("Contains: " + product.getDescription());
            } else {
                List<String> descList = new ArrayList<String>(Arrays.asList(product.getDescription().split(" ")));
                for (int i = 0; i < descList.size(); i++ ) {
                    if (i == 0) {
                        list.add("The product is: " + descList.get(i));
                    } else {
                        list.add("Ingredients: " + descList.get(i));
                    }
                }
                list.add("Prijs: " + String.format("%.2f", BigDecimal.valueOf(order.getPrice())));
            }
        }
        list.add("");
        list.add("");
        list.add("Orderstatus:" + order.getState().getDescription());
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
        for (String s : yourClassList) {
            listModel.addElement(s);
        }
        return listModel;
    }
}

