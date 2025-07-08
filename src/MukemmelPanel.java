import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MukemmelPanel extends JPanel {
    public MukemmelPanel(AnaPencere pencere) {
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());

        JLabel label = new JLabel("Pozitif bir sayı girin:");
        JTextField input = new JTextField(20);
        JTextArea sonuc = new JTextArea(8, 40);
        JButton kontrol = new JButton("Kontrol Et");
        JButton geri = new JButton("Geri");

        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        label.setForeground(Color.DARK_GRAY);
        input.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        sonuc.setFont(new Font("Consolas", Font.PLAIN, 16));
        kontrol.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        geri.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        sonuc.setEditable(false);
        sonuc.setLineWrap(true);
        sonuc.setWrapStyleWord(true);
        sonuc.setBackground(Color.WHITE);
        sonuc.setForeground(Color.DARK_GRAY);

        kontrol.addActionListener(e -> {
            try {
                int sayi = Integer.parseInt(input.getText().trim());
                if (sayi <= 0) {
                    sonuc.setText("Pozitif bir sayı giriniz.");
                    return;
                }
                List<Integer> bolenler = new ArrayList<>();
                int toplam = 0;
                for (int i = 1; i <= sayi / 2; i++) {
                    if (sayi % i == 0) {
                        bolenler.add(i);
                        toplam += i;
                    }
                }

                StringBuilder sb = new StringBuilder();
                sb.append("Pozitif tam bölenleri: ").append(bolenler).append("\n");
                sb.append("Bölenler toplamı: ").append(toplam).append("\n");
                sb.append(toplam == sayi ? sayi + " mükemmel sayıdır." : sayi + " mükemmel sayı değildir.");

                sonuc.setText(sb.toString());
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
        gbc.gridy = 2; add(kontrol, gbc);
        gbc.gridy = 3; add(new JScrollPane(sonuc), gbc);
        gbc.gridy = 4; add(geri, gbc);
    }
}
