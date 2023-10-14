import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String arg[]){
        int option = JOptionPane.showConfirmDialog(null,
                                 "Do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "You have chosen: " + (option == JOptionPane.YES_NO_OPTION?"YES":"NO"));

        System.exit(0);
    }
}
