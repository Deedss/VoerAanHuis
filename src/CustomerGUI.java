import products.IProduct;
import states.Arrived;
import states.OnRoute;
import states.Ordered;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerGUI extends Observer implements FunctionsGUI{
    OrderManager orderManager;
    Customer customer;

    private Order order;

    private ArrayList<String> ingredientsList = new ArrayList<>();
    private ArrayList<String> pizzaList = new ArrayList<>();
    private JPanel panel;
    private JList orderList;
    private JButton btn_PlaceOrder;
    private JComboBox ingredients_1;
    private JComboBox ingredients_2;
    private JComboBox ingredients_3;
    private JComboBox basePizza;
    private JLabel label;

    CustomerGUI(OrderManager orderManager,Customer customer) {
        this.orderManager = orderManager;
        this.customer = customer;

        ingredientsList.add("Nothing");
        ingredientsList.add("Extra Cheese");
        ingredientsList.add("Extra Meat");
        ingredientsList.add("Extra Tuna");

        pizzaList.add("Base");
        pizzaList.add("Cheese");
        pizzaList.add("Pepperoni");
        pizzaList.add("Special");

        initGui();
        listeners();
    }

    public void initGui(){
        JFrame jFrame = new JFrame("Customer");
        jFrame.setContentPane(panel);
        jFrame.setSize(600, 800);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        ingredients_1.setModel(getComboBoxModel(ingredientsList));
        ingredients_2.setModel(getComboBoxModel(ingredientsList));
        ingredients_3.setModel(getComboBoxModel(ingredientsList));
        basePizza.setModel(getComboBoxModel(pizzaList));
    }

    @Override
    public void update(Order order) {
        System.out.println("updated");
        this.order = order;
        orderList.setModel(getListModel(fillOrderList(order)));
        orderList.updateUI();
    }

    private void listeners() {
        btn_PlaceOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                orderList.setModel(new DefaultListModel());
                List<String> list = new ArrayList<>();
                list.add(ingredients_1.getSelectedItem().toString());
                list.add(ingredients_2.getSelectedItem().toString());
                list.add(ingredients_3.getSelectedItem().toString());
                orderManager.addOrder(customer, basePizza.getSelectedItem().toString(), list);
            }
        });
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
