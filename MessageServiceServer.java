import java.rmi.*;
import java.rmi.server.*;

public ChatServiceServer extends UnicastRemoteObject implements ChatService {

  private ArrayList<ChatMessage> messages;

  public ChatServiceServer() throws RemoteException {
    super();
    messages = new ArrayList<ChatMessage>(0);
  }

  public ChatUserResponsePacket pingForData(int lastReadMessage) throws RemoteException {
    if(lastReadMessage < 0) {
      return messages;
    }

    ArrayList<ChatMessage> newMessages = new ArrayList<ChatMessage>(0);
    newMessages.ensureCapacity(newMessages.size() - (lastReadMessage + 1));
    for(int i = lastReadMessage + 1; i < messages.size(); i++) {
      newMessages.add(messages.get(i));
    }
    return newMessages.size() > 0 ? newMessages : null;
  }

  public boolean sendMessage(ChatMessage packet) throws RemoteException {
    messages.ensureCapacity(messages.size() + 1);
    messages.add(packet);
    return true;
  }

  public static void main(String[] args) throws RemoteException {
    ChatServiceServer svr = new ChatServiceServer();
    Naming.bind("ChatService", svr);
    System.out.println("Servico de chat rodando...");
  }

}
