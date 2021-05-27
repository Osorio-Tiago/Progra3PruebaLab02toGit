package mainPack;
import javaMVCControllers.*;

public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoginController login= new LoginController();
        // Start the application
        login.startApplication();
    }
} 