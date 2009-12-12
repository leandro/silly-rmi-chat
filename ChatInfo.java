import javax.swing.JFrame;

public class ChatInfo {

  private JFrame frame;
  private String usrNome, salaNome;

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

}
