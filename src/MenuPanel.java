import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public MenuPanel(AnaPencere pencere) {
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        JLabel header = new JLabel("Matematik Uygulaması");
        JButton faktoriyelBtn = new JButton("Faktöriyel Hesapla");
        JButton mukemmelBtn = new JButton("Mükemmel Sayı Bul");
        JButton asalBtn = new JButton("Asal Sayıları Listele");

        faktoriyelBtn.addActionListener(e -> pencere.showPanel("faktoriyel"));
        mukemmelBtn.addActionListener(e -> pencere.showPanel("mukemmel"));
        asalBtn.addActionListener(e -> pencere.showPanel("asal"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3;
        add(header, gbc);
        gbc.gridwidth = 1;

        gbc.gridy = 1; gbc.gridx = 0; add(faktoriyelBtn, gbc);
        gbc.gridx = 1; add(mukemmelBtn, gbc);
        gbc.gridx = 2; add(asalBtn, gbc);
    }
}
