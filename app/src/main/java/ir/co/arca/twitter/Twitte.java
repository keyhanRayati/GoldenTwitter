package ir.co.arca.twitter;

import android.widget.ImageButton;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Twitte {

    private int avatarPic;
    private String username;
    private String userId;
    private String time;
    private String textOfTwitte;
    private int mention;
    private int retwitte;
    private int favorite;
    private String mentionNumber;
    private String retwitteNumber;
    private String favoriteNumber;


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



    public Twitte(int avatarPic, String username, String userId,
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







}
