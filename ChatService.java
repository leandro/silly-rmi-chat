import java.rmi.*;

public interface ChatService extends Remote {

  public ChatUserResponsePacket pingForData(int lastReadMessage) throws RemoteException;
  public boolean sendMessage(ChatMessage packet) throws RemoteException;

}
