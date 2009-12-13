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

  public ChatUserResponsePacket pingForData(int lastReadMessage) throws RemoteException {

    if(lastReadMessage < 0) {
      return new ChatUserResponsePacket(users, messages);
    }

    ArrayList<ChatMessage> newMessages = new ArrayList<ChatMessage>(0);
    newMessages.ensureCapacity(newMessages.size() - (lastReadMessage + 1));
    for(int i = lastReadMessage + 1; i < messages.size(); i++) {
      newMessages.add(messages.get(i));
    }
    return new ChatUserResponsePacket(users, newMessages);
  }

  public boolean sendMessage(ChatMessage packet) throws RemoteException {
    messages.ensureCapacity(messages.size() + 1);
    messages.add(packet);

    if(packet.getMessageType() == ChatMessage.USER_LEAVE) {
      int pos = users.indexOf(packet.getUserName());
      if(pos > -1) {
        users.remove(pos);
      }
    }

    if(packet.getMessageType() == ChatMessage.USER_ENTER) {
      int pos = users.indexOf(packet.getUserName());
      if(pos == -1) {
        users.ensureCapacity(users.size() + 1);
        users.add(packet.getUserName());
      }
    }

    return true;
  }

  public static void main(String[] args) throws Exception {
    ChatServiceServer svr = new ChatServiceServer();
    Naming.bind("ChatService", svr);
    System.out.println("Servico de chat rodando...");
  }

}
