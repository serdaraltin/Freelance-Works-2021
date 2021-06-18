package Run;

import Controller.ControllerFile;
import Model.Book;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ControllerFile fileOperation = new ControllerFile();
        ArrayList<Book> books = new ArrayList<>();
        fileOperation.FillData(books, fileOperation.ReadData("BooksList.txt"));

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new View.Login(books).setVisible(true);

    }
}
