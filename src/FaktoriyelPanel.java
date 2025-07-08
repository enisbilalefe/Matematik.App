import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;

public class FaktoriyelPanel extends JPanel {
    public FaktoriyelPanel(AnaPencere pencere) {
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        JLabel label = new JLabel("Pozitif bir sayı girin:");
        JTextField input = new JTextField(20);
        JTextArea sonuc = new JTextArea(6, 40);
        JButton hesapla = new JButton("Hesapla");
        JButton geri = new JButton("Geri");

        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        label.setForeground(Color.DARK_GRAY);
        input.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        sonuc.setFont(new Font("Consolas", Font.PLAIN, 16));
        hesapla.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        geri.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        sonuc.setEditable(false);
        sonuc.setLineWrap(true);
        sonuc.setWrapStyleWord(true);
        sonuc.setBackground(Color.WHITE);
        sonuc.setForeground(Color.DARK_GRAY);

        hesapla.addActionListener(e -> {
            try {
                int sayi = Integer.parseInt(input.getText().trim());
                if (sayi < 0) {
                    sonuc.setText("Pozitif bir sayı giriniz.");
                    return;
                }
                BigInteger f = BigInteger.ONE;
                for (int i = 1; i <= sayi; i++) {
                    f = f.multiply(BigInteger.valueOf(i));
                }
                sonuc.setText(sayi + "! = " + f);
            } catch (NumberFormatException ex) {
                sonuc.setText("Geçerli bir tam sayı giriniz.");
            }
        });

        geri.addActionListener(e -> pencere.showPanel("menu"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridwidth = 2; gbc.gridx = 0;

        gbc.gridy = 0; add(label, gbc);
        gbc.gridy = 1; add(input, gbc);
        gbc.gridy = 2; add(hesapla, gbc);
        gbc.gridy = 3; add(new JScrollPane(sonuc), gbc);
        gbc.gridy = 4; add(geri, gbc);
    }
}
