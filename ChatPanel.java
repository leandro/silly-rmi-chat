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

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setOpaque(true);
    setPreferredSize(new Dimension(800,500));
  }

}
//setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
