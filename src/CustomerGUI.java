import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class CustomerGUI extends Observer{
    OrderManager orderManager;
    Customer customer;


    private ArrayList<String> ingredientsList = new ArrayList<>();
    private ArrayList<String> pizzaList = new ArrayList<>();
    private JPanel panel;
    private JList orderList;
    private JButton btn_PlaceOrder;
    private JComboBox ingredients_1;
    private JComboBox ingredients_2;
    private JComboBox ingredients_3;
    private JComboBox basePizza;
    private JLabel Label;
    private JButton btn_Received;

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

    }

    private void listeners() {
        btn_PlaceOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<String> list = new ArrayList<>();
                list.add(ingredients_1.getSelectedItem().toString());
                list.add(ingredients_2.getSelectedItem().toString());
                list.add(ingredients_3.getSelectedItem().toString());
                orderManager.addOrder(customer, basePizza.getSelectedItem().toString(), list);
            }
        });

        btn_Received.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    private DefaultComboBoxModel<String> getComboBoxModel(List<String> yourClassList)
    {
        String[] comboBoxModel = yourClassList.toArray(new String[0]);
        return new DefaultComboBoxModel<>(comboBoxModel);
    }
}
