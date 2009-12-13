import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

public class ChatServiceServer extends UnicastRemoteObject implements ChatService {

  private ArrayList<ChatMessage> messages;
  private ArrayList<String> users;

  public ChatServiceServer() throws RemoteException {
    super();
    messages  = new ArrayList<ChatMessage>(0);
    users     = new ArrayList<String>(0);
  }

  public ChatUserResponsePacket pingForData(String user, int lastReadMessage) throws RemoteException {

    System.out.println(String.format("User '%s' request chat data.", user));

    if(lastReadMessage < 0) {
      return new ChatUserResponsePacket(users, messages);
    }

    ArrayList<ChatMessage> newMessages = new ArrayList<ChatMessage>(0);
    newMessages.ensureCapacity(messages.size() - (lastReadMessage + 1));
    for(int i = lastReadMessage + 1; i < messages.size(); i++) {
      newMessages.add(messages.get(i));
    }
    return new ChatUserResponsePacket(users, newMessages);
  }

  public boolean sendMessage(ChatMessage packet) throws RemoteException {
    messages.ensureCapacity(messages.size() + 1);
    messages.add(packet);

    if(packet.getMessageType() == ChatMessage.USER_MESSAGE) {
        System.out.println(String.format("User '%s' sent message: '%s'.", packet.getUserName(), packet.getMessageText()));
    } else if(packet.getMessageType() == ChatMessage.USER_ENTER) {
      int pos = users.indexOf(packet.getUserName());
      if(pos == -1) {
        users.ensureCapacity(users.size() + 1);
        users.add(packet.getUserName());
        System.out.println(String.format("User '%s' entered the room.", packet.getUserName()));
      }
    } else {
      int pos = users.indexOf(packet.getUserName());
      if(pos > -1) {
        users.remove(pos);
        System.out.println(String.format("User '%s' left the room.", packet.getUserName()));
      }
    }

    return true;
  }

  public static void main(String[] args) throws Exception {
    ChatServiceServer svr = new ChatServiceServer();
    Naming.rebind("rmi://localhost/ChatService", svr);
    System.out.println("Servico de chat rodando...");
  }

}
