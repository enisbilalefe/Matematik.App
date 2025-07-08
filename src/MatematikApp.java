import javax.swing.*;

public class MatematikApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnaPencere pencere = new AnaPencere();
            pencere.setVisible(true);
        });
    }
}
