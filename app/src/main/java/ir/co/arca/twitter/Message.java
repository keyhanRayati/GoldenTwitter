package ir.co.arca.twitter;

public class Message {
    private int avatar;
    private String name;
    private String lastMessage;

    public Message(int avatar, String name, String lastMessage) {
        this.avatar = avatar;
        this.name = name;
        this.lastMessage = lastMessage;
    }

    public int getAvatar(){
        return avatar;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public void setLastMessage(int avatar) {
        this.lastMessage = lastMessage;
    }
}
