import java.rmi.*;

public interface MessageService extends Remote {

  public ChatUserResponsePacket pingForData(int lastReadMessage) throws RemoteException;
  public boolean sendMessage(ChatMessage packet) throws RemoteException;

}
