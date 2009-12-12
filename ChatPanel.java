import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import javax.accessibility.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ChatPanel extends javax.swing.JPanel {

  private JPanel bodyPanel, bottomPanel;
  private ChatInfo chatInfo;
  private JFrame frame;
  private JTextField txtMessage;
  private ArrayList<String> userNames;
  private JScrollPane scroll;
  private JTextPane msgsField;
  private StyledDocument msgsFieldDoc;

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
    msgsField = new JTextPane();
    msgsField.setEditable(false);
    msgsFieldDoc = msgsField.getStyledDocument();
    addStylesToDocument(msgsFieldDoc);
    scroll = new JScrollPane(msgsField);
    scroll.setPreferredSize(new Dimension(600, 460));
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    bodyPanel.add(scroll);
    userEnteredRoomMessage(chatInfo.getUsrNome());
    userLeftRoomMessage(chatInfo.getUsrNome());
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

  private void userEnteredRoomMessage(String username) {
    appendMessage(new String[] {" >>> O usuario ",username," entrou na sala.\n"}, new String[] {"entrou_style", "entrou_style_bold", "entrou_style"});
  }

  private void userLeftRoomMessage(String username) {
    appendMessage(new String[] {" <<< O usuario ",username," saiu na sala.\n"}, new String[] {"saiu_style", "saiu_style_bold", "saiu_style"});
  }

  private void appendMessage(String[] msgs, String[] styles) {
    try {
      for(int i = 0; i < msgs.length; i++) {
        msgsFieldDoc.insertString(msgsFieldDoc.getLength(), msgs[i], msgsFieldDoc.getStyle(styles[i]));
      }
    } catch(BadLocationException ble) {
      System.out.println("Erro adicionar texto inicial");
    }
  }

  private boolean addMessage() {
    String message = txtMessage.getText().trim();
    if(message.length() == 0) {
      JOptionPane.showMessageDialog(frame, "Voce nao pode enviar uma mensagem vazia.");
      txtMessage.requestFocus();
      return false;
    }
    appendMessage(new String[] {chatInfo.getUsrNome(), String.format(":%s\n", message)}, new String[] {"bold","regular"});
    scroll.setViewportView(msgsField);
    txtMessage.setText("");
    txtMessage.requestFocus();
    return true;
  }

  private boolean sendMessage() {
    return true;
  }

  protected void addStylesToDocument(StyledDocument doc) {
    //Initialize some styles.
    Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);

    Style regular = doc.addStyle("regular", def);
    StyleConstants.setFontFamily(def, "SansSerif");

    Style s = doc.addStyle("italic", regular);
    StyleConstants.setItalic(s, true);

    s = doc.addStyle("bold", regular);
    StyleConstants.setBold(s, true);

    s = doc.addStyle("small", regular);
    StyleConstants.setFontSize(s, 10);

    s = doc.addStyle("large", regular);
    StyleConstants.setFontSize(s, 16);

    s = doc.addStyle("entrou_style", regular);
    StyleConstants.setForeground(s, new Color(0x117711));

    s = doc.addStyle("entrou_style_bold", s);
    StyleConstants.setBold(s, true);

    s = doc.addStyle("saiu_style", regular);
    StyleConstants.setForeground(s, new Color(0x771111));

    s = doc.addStyle("saiu_style_bold", s);
    StyleConstants.setBold(s, true);
  }

}
//setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
