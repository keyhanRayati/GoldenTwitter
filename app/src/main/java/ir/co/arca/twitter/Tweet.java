package ir.co.arca.twitter;

import java.io.Serializable;
import java.util.List;

public class Tweet implements Serializable {

    private int avatarPic = 0;
    private String username = "";
    private String userId = "";
    private String time = "";
    private String textOfTwitte = "";
    private int mention = 0;
    private int retwitte = 0;
    private int favorite = 0;
    private String mentionNumber = "0";
    private String retwitteNumber = "0";
    private String favoriteNumber = "0";
    private List<Tweet> comments;


    public int getAvatarPic() {
        return avatarPic;
    }

    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }

    public String getTime() {
        return time;
    }

    public String getTextOfTwitte() {
        return textOfTwitte;
    }

    public int getMention() {
        return mention;
    }

    public int getRetwitte() {
        return retwitte;
    }

    public int getFavorite() {
        return favorite;
    }

    public String getMentionNumber() {
        return mentionNumber;
    }

    public String getRetwitteNumber() {
        return retwitteNumber;
    }

    public String getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setTextOfTwitte(String textOfTwitte) {
        this.textOfTwitte = textOfTwitte;
    }


    public Tweet(int avatarPic, String username, String userId,
                 String time, String textOfTwitte, int mention, int retwitte,
                 int favorite, String mentionNumber, String retwitteNumber,
                 String favoriteNumber) {

        this.avatarPic = avatarPic;
        this.username = username;
        this.userId = userId;
        this.time = time;
        this.textOfTwitte = textOfTwitte;
        this.mention = mention;
        this.retwitte = retwitte;
        this.favorite = favorite;
        this.mentionNumber = mentionNumber;
        this.retwitteNumber = retwitteNumber;
        this.favoriteNumber = favoriteNumber;
    }


    public List<Tweet> getComments() {
        return comments;
    }

    public void setComments(List<Tweet> comments) {
        this.comments = comments;
    }
}
