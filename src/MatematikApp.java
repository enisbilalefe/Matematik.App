import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MatematikApp {
    public static void main(String[] args) {
        // Open the HTML file in Chrome in normal mode and exit
        openHTMLInChrome("src/index.html");
        System.exit(0);
    }
    
    private static void openHTMLInChrome(String filePath) {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            String chromePath;
            
            if (os.contains("win")) {
                chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
            } else if (os.contains("mac")) {
                chromePath = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
            } else {
                chromePath = "google-chrome"; // Linux/Unix
            }
            
            ProcessBuilder pb = new ProcessBuilder(chromePath, "--new-window", new File(filePath).getAbsolutePath());
            pb.start();
            
        } catch (IOException e) {
            e.printStackTrace();
            try {
                Desktop.getDesktop().browse(new File(filePath).toURI());
            } catch (IOException ex) {
                System.err.println("Failed to open browser: " + ex.getMessage());
            }
        }
    }
}
