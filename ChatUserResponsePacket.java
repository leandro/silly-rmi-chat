import java.io.*;
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

  public void setNewMessages(ArrayList<ChatMessage> chatMessages) {
    newMessages = chatMessages;
  }

  public void setUsersList(ArrayList<String> users) {
    usersList = users;
  }

  private void readObject(ObjectInputStream input) throws ClassNotFoundException, IOException {
    input.defaultReadObject();
  }

  private void writeObject(ObjectOutputStream ouput) throws IOException {
    ouput.defaultWriteObject();
  }

}
