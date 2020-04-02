import kotlin.reflect.TypeOfKt;
import products.IProduct;

import javax.swing.*;
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
    private JTextArea orderList;
    private JButton btn_PlaceOrder;
    private JComboBox<String> ingredients_1;
    private JComboBox<String> ingredients_2;
    private JComboBox<String> ingredients_3;
    private JComboBox<String> basePizza;
    private JLabel label;

    /**
     * Create new UI
     */
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

    /**
     * Setup Swing UI
     */
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

    /**
     * Updates the order and UI when called from observer
     */
    @Override
    public void update(Order order) {
        orderList.setText(fillOrderList(order));
        orderList.updateUI();
        if(order.getState().getDescription().equals("Arrived")){
            //Customer can only order again when last order has arrived
            btn_PlaceOrder.setEnabled(true);
        }
    }

    /**
     * Button Onclick listener in UI
     */
    private void listeners() {
        btn_PlaceOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<String> list = new ArrayList<>();
                list.add(ingredients_1.getSelectedItem().toString());
                list.add(ingredients_2.getSelectedItem().toString());
                list.add(ingredients_3.getSelectedItem().toString());
                orderManager.addOrder(customer, basePizza.getSelectedItem().toString(), list);
                btn_PlaceOrder.setEnabled(false);
            }
        });
    }

    /**
     * Create string to fill textarea with current order information
     */
    @Override
    public String fillOrderList(Order order) {
        StringBuilder list = new StringBuilder();
        list.append("The order contains the following products\n");
        for(IProduct product : order.getProducts()) {
            if (product.getDescription().contains("Free")) {
                list.append("Contains: ").append(product.getDescription()).append("\n");
            } else {
                List<String> descList = new ArrayList<String>(Arrays.asList(product.getDescription().split(" ")));
                for (int i = 0; i < descList.size(); i++ ) {
                    if (i == 0) {
                        list.append("The product is: ").append(descList.get(i)).append("\n");
                    } else {
                        list.append("Ingredients: ").append(descList.get(i)).append("\n");
                    }
                }
                list.append("Prijs: ").append(String.format("%.2f", BigDecimal.valueOf(order.getPrice()))).append("\n");
            }
        }
        list.append("\nOrderstatus:").append(order.getState().getDescription()).append("\n");
        return list.toString();
    }

    /**
     * Fill combobox for Swing UI
     */
    @Override
    public DefaultComboBoxModel<String> getComboBoxModel(List<String> yourClassList) {
        String[] comboBoxModel = yourClassList.toArray(new String[0]);
        return new DefaultComboBoxModel<>(comboBoxModel);
    }
}
