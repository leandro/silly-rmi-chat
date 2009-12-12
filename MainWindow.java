import java.awt.Dimension;

public class MainWindow extends javax.swing.JFrame {

  private ChatInfo chatInfo;

  public MainWindow() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setTitle("Bate-papo");

    chatInfo = new ChatInfo();
    chatInfo.setFrame(this);

    add(new EntranceForm(chatInfo));
    pack();

    setVisible(true);
  }

  public void pack() {
    Dimension d, d2;
    Double h, w;

    super.pack();

    // INI.centralizando tela
    d2  = getSize();
    d   = getToolkit().getScreenSize();
    w   = d.getWidth()/2 - d2.getWidth()/2;
    h   = d.getHeight()/2 - d2.getHeight()/2;
    setLocation(w.intValue(), h.intValue());
    // FIM.centralizando tela
  }

}
