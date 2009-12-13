import java.util.ArrayList;

public class ChatClientPing extends Thread {

  public ChatPanel GUIClient;

  public static ChatClientPing startPing(ChatPanel guiHandler) {
    ChatClientPing t = new ChatClientPing();
    t.setName("chat client ping");
    t.GUIClient = guiHandler;
    t.start();
    return t; 
  }

  public void run() {

    ChatUserResponsePacket packet;

    while(true) {
      try {
        try {
          packet = GUIClient.chatClientHandle.pingForData(GUIClient.chatInfo.getUsrNome(), GUIClient.lastReadMessage);
          ArrayList<ChatMessage> messages = packet.getNewMessages();

          GUIClient.usrList.setListData(packet.getUsersList().toArray());
          GUIClient.lastReadMessage += messages.size();
          for(int i = 0; i < messages.size(); i++) {
            ChatMessage message = messages.get(i);

            if(message.getMessageType() == ChatMessage.USER_MESSAGE) {
              GUIClient.addMessage(message.getUserName(), message.getMessageText());
            } else if(message.getMessageType() == ChatMessage.USER_ENTER) {
              GUIClient.addUserEnteredRoomMessage(message.getUserName());
            } else {
              GUIClient.addUserLeftRoomMessage(message.getUserName());
            }
          }
        } catch(Exception err) { err.printStackTrace(); }

        Thread.sleep(500L);
      } catch(InterruptedException e) { e.printStackTrace(); }
    }

  }

}
