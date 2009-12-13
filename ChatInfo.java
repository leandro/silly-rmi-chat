import javax.swing.JFrame;

public class ChatInfo {

  private JFrame frame;
  private String usrNome, salaNome;
  private int lastReadMessage; // array position

  public String getUsrNome() {
    return usrNome;
  }

  public ChatInfo setUsrNome(String nome) {
    usrNome = nome;
    return this;
  }

  public String getSalaNome() {
    return salaNome;
  }

  public ChatInfo setSalaNome(String sala) {
    salaNome = sala;
    return this;
  }

  public JFrame getFrame() {
    return frame;
  }

  public ChatInfo setFrame(JFrame frame) {
    this.frame = frame;
    return this;
  }

  public int getLastReadMessage() {
    return lastReadMessage;
  }

  public ChatInfo setLastReadMessage(int lastReadMessage) {
    this.lastReadMessage = lastReadMessage;
    return this;
  }

}
