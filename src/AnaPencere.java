import javax.swing.*;
import java.awt.*;

public class AnaPencere extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);

    public AnaPencere() {
        setTitle("Matematik Uygulaması");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panelleri oluştur ve ekle
        JPanel menuPanel = new MenuPanel(this);
        JPanel faktoriyelPanel = new FaktoriyelPanel(this);
        JPanel mukemmelPanel = new MukemmelPanel(this);
        JPanel asalPanel = new AsalPanel(this);
        mainPanel.add(asalPanel, "asal");


        mainPanel.add(menuPanel, "menu");
        mainPanel.add(faktoriyelPanel, "faktoriyel");
        mainPanel.add(mukemmelPanel, "mukemmel");

        add(mainPanel);
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }
}
