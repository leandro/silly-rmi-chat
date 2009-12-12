import javax.swing.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;

public class ChatPanel extends javax.swing.JPanel {

  private JPanel bodyPanel, bottomPanel;
  private ChatInfo chatInfo;
  private JFrame frame;

  public ChatPanel(ChatInfo info) {
    chatInfo = info;
    frame = info.getFrame();
    frame.setTitle(String.format("Usuario '%s' conectado", info.getUsrNome()));

    buildMainStructure();
  }

  public void buildMainStructure() {
    JLabel lbl;
    JTextField txt;
    JButton btn;

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setOpaque(true);
    setPreferredSize(new Dimension(800,500));

    bodyPanel = new JPanel();
    bodyPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    bodyPanel.setPreferredSize(new Dimension(800, 460));
    lbl = new JLabel();
    lbl.setPreferredSize(new Dimension(600, 460));
    lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(0x666666)));
    bodyPanel.add(lbl);
    //bodyPanel.setBackground(new Color(0x113377));
    add(bodyPanel);

    bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    bottomPanel.setPreferredSize(new Dimension(800, 40));
    bottomPanel.setBackground(new Color(0xcccccc));
    bottomPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(0x666666)));
    txt = new JTextField();
    txt.setPreferredSize(new Dimension(660, 27));
    //bottomPanel.add(Box.createRigidArea(new Dimension(20,0)));
    bottomPanel.add(txt);
    btn = new JButton("Enviar");
    bottomPanel.add(btn);
    add(bottomPanel);
  }

}
//setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
