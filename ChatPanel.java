import javax.swing.*;
import javax.swing.border.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ChatPanel extends javax.swing.JPanel {

  private JPanel bodyPanel, bottomPanel, msgsPanel;
  private ChatInfo chatInfo;
  private JFrame frame;
  private JTextField txtMessage;
  private ArrayList<String> userNames;
  private JScrollPane scroll;

  public ChatPanel(ChatInfo info) {
    chatInfo  = info;
    frame     = info.getFrame();
    userNames = new ArrayList<String>();
    userNames.add(info.getUsrNome());
    frame.setTitle(String.format("Usuario '%s' conectado", info.getUsrNome()));

    buildMainStructure();
  }

  public void buildMainStructure() {
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
    msgsPanel = new JPanel();
    msgsPanel.setLayout(new BoxLayout(msgsPanel, BoxLayout.Y_AXIS));
    scroll = new JScrollPane(msgsPanel);
    scroll.setPreferredSize(new Dimension(600, 460));
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    bodyPanel.add(scroll);
    // FIM.container de mensagens
    // INI.lista de usuarios
    usrList = new JList(userNames.toArray());
    usrList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    scrollPane = new JScrollPane(usrList);
    scrollPane.setPreferredSize(new Dimension(200, 460));
    bodyPanel.add(scrollPane);
    // FIM.lista de usuarios
    add(bodyPanel);
    // FIM.o corpo do chat

    bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    bottomPanel.setPreferredSize(new Dimension(800, 40));
    bottomPanel.setBackground(new Color(0xcccccc));
    bottomPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(0x666666)));
    txtMessage = new JTextField();
    txtMessage.setPreferredSize(new Dimension(660, 27));
    //bottomPanel.add(Box.createRigidArea(new Dimension(20,0)));
    bottomPanel.add(txtMessage);
    btn = new JButton("Enviar");
    bottomPanel.add(btn);
    btn.addMouseListener(new MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
        addMessage();
      }
    });

    // filtra-se o evento de fechar o programa
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.out.println("Desconctando...");
        // fazer a chamada para desconectar do servidor
      }
    });
    add(bottomPanel);
  }

  private JPanel buildMessageItem(String user, String msg) {
    JPanel itemPanel;
    JLabel lbl;

    itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
    itemPanel.setMinimumSize(new Dimension(660, 20));
    lbl = new JLabel(user);
    lbl.setPreferredSize(new Dimension(150, 20));
    lbl.setHorizontalAlignment(JLabel.RIGHT);
    lbl.setVerticalAlignment(JLabel.TOP);
    itemPanel.add(lbl);
    itemPanel.add(Box.createRigidArea(new Dimension(10, 0)));
    lbl = new JLabel(msg);
    lbl.setVerticalAlignment(JLabel.TOP);
    lbl.setPreferredSize(new Dimension(440, 20));
    itemPanel.add(lbl);
    itemPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(0x444444)));
    return itemPanel;
  }

  private boolean addMessage() {
    String message = txtMessage.getText().trim();
    if(message.length() == 0) {
      JOptionPane.showMessageDialog(frame, "Voce nao pode enviar uma mensagem vazia.");
      txtMessage.requestFocus();
      return false;
    }
    msgsPanel.add(buildMessageItem(chatInfo.getUsrNome(), message));
    scroll.setViewportView(msgsPanel);
    txtMessage.setText("");
    txtMessage.requestFocus();
    return true;
  }

  private boolean sendMessage() {
    return true;
  }

}
//setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
