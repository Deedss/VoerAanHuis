import products.IProduct;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestaurantGUI extends Observer implements FunctionsGUI{
    // GUI ELEMENTS
    private JPanel panel;
    private JTextArea orderList;

    public RestaurantGUI() {
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

    /**
     * Updates the order and UI when called from observer
     */
    @Override
    public void update(Order order) {
        orderList.setText(fillOrderList(order));
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

