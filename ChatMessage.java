// wrapper class for transporting a message
public class ChatMessage {

  private String userName;
  private String messageType; // leave, enter, message
  private String messageText;

  public ChatMessage(String usr, String msg, String type) {
    userName = usr;
    messageText = msg;
    messageType = type;
  }

  public String getUserName() {
    return userName;
  }

  public String getMessageText() {
    return messageText;
  }

  public String getMessageType() {
    return messageType;
  }

  public void setUserName(String usr) {
    userName = usr;
  }

  public void setMessageText(String msg) {
    messageText = msg;
  }

  public void setMessageType(String type) {
    messageType = type;
  }

}
