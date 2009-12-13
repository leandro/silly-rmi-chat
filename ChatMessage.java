// wrapper class for transporting a message
public class ChatMessage {

  public static final int USER_LEAVE = 1;
  public static final int USER_ENTER = 2;
  public static final int USER_MESSAGE = 4;

  private String userName;
  private int messageType; // leave = 1, enter = 2, message = 4
  private String messageText;

  public ChatMessage(String usr, String msg, int type) {
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

  public int getMessageType() {
    return messageType;
  }

  public void setUserName(String usr) {
    userName = usr;
  }

  public void setMessageText(String msg) {
    messageText = msg;
  }

  public void setMessageType(int type) {
    messageType = type;
  }

}
