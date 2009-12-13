import java.util.ArrayList;

public class ChatUserResponsePacket {

  private ArrayList<String> usersList;
  private ArrayList<ChatMessage> newMessages;

  public ChatUserResponsePacket(ArrayList<String> onlineUsers, ArrayList<ChatMessage> newMessages) {
    this.usersList = onlineUsers;
    this.newMessages = newMessages;
  }

  public ArrayList<String> getUsersList() {
    return usersList;
  }

  public ArrayList<ChatMessage> getNewMessages() {
    return newMessages;
  }

}
