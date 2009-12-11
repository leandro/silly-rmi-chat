public class MainWindow extends javax.swing.JFrame {

  public MainWindow() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setTitle("Bate-papo");
    setLocationRelativeTo(null);
    add(new EntranceForm());
    pack();
    setVisible(true);
  }

}
