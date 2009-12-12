import javax.swing.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;

public class ChatPanel extends javax.swing.JPanel {

  private JPanel bodyPanel, bottomPanel;
  private ChatInfo chatInfo;
  private JFrame frame;
  private String[] teste = {
    "bacana", "coisas", "azul", "verde", "amarelo",
    "puta merda", "irra", "caralho", "que legal", "e assim por diante",
    "bacana", "coisas", "azul", "verde", "amarelo",
    "puta merda", "irra", "caralho", "que legal", "e assim por diante",
    "bacana", "coisas", "azul", "verde", "amarelo",
    "puta merda", "irra", "caralho", "que legal", "e assim por diante"
  };

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
    JScrollPane scrollPane;
    JList usrList;

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setOpaque(true);
    setPreferredSize(new Dimension(800,500));

    // INI.o corpo do chat
    bodyPanel = new JPanel();
    bodyPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    bodyPanel.setPreferredSize(new Dimension(800, 460));
    // INI.container de mensagens
    lbl = new JLabel();
    lbl.setPreferredSize(new Dimension(600, 460));
    lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(0x666666)));
    bodyPanel.add(lbl);
    // FIM.container de mensagens
    // INI.lista de usuarios
    usrList = new JList(teste);
    usrList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    scrollPane = new JScrollPane(usrList);
    scrollPane.setPreferredSize(new Dimension(200, 460));
    bodyPanel.add(scrollPane);
    // FIM.lista de usuarios
    add(bodyPanel);
    // FIM.o corpo do chat

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
