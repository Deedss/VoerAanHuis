import javax.swing.*;

public class RestaurantGUI extends Observer{

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

    }
}
