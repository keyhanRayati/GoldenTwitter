package ir.co.arca.twitter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class TwitteViewHolder extends RecyclerView.ViewHolder {

    private CircleImageView avatarPic;
    private TextView username;
    private TextView userId;
    private TextView time;
    private TextView textOfTwitte;
    private ImageButton mention;
    private ImageButton retwitte;
    private ImageButton favorite;
    private TextView mentionNumber;
    private TextView retwitteNumber;
    private TextView favoriteNumber;


    public TwitteViewHolder(View itemView) {
        super(itemView);
        avatarPic = itemView.findViewById(R.id.avatarHome);
        userId = itemView.findViewById(R.id.avatarId);
        time = itemView.findViewById(R.id.avatarTime);
        username = itemView.findViewById(R.id.avatarName);
        textOfTwitte = itemView.findViewById(R.id.avatarMessage);
        mention = itemView.findViewById(R.id.mention);
        mentionNumber = itemView.findViewById(R.id.mentionNumber);
        retwitte = itemView.findViewById(R.id.imageView4);
        retwitteNumber = itemView.findViewById(R.id.retwitte);
        favorite = itemView.findViewById(R.id.like);
        favoriteNumber = itemView.findViewById(R.id.likeNumber);
    }



    public void setAvatarPic(CircleImageView avatarPic) {
        this.avatarPic = avatarPic;
    }

    public void setUsername(TextView username) {
        this.username = username;
    }

    public void setUserId(TextView userId) {
        this.userId = userId;
    }

    public void setTime(TextView time) {
        this.time = time;
    }

    public void setTextOfTwitte(TextView textOfTwitte) {
        this.textOfTwitte = textOfTwitte;
    }

    public void setMention(ImageButton mention) {
        this.mention = mention;
    }

    public void setRetwitte(ImageButton retwitte) {
        this.retwitte = retwitte;
    }

    public void setFavorite(ImageButton favorite) {
        this.favorite = favorite;
    }

    public void setMentionNumber(TextView mentionNumber) {
        this.mentionNumber = mentionNumber;
    }

    public void setRetwitteNumber(TextView retwitteNumber) {
        this.retwitteNumber = retwitteNumber;
    }

    public void setFavoriteNumber(TextView favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public CircleImageView getAvatarPic() {
        return avatarPic;
    }

    public TextView getUsername() {
        return username;
    }

    public TextView getUserId() {
        return userId;
    }

    public TextView getTime() {
        return time;
    }

    public TextView getTextOfTwitte() {
        return textOfTwitte;
    }

    public ImageButton getMention() {
        return mention;
    }

    public ImageButton getRetwitte() {
        return retwitte;
    }

    public ImageButton getFavorite() {
        return favorite;
    }

    public TextView getMentionNumber() {
        return mentionNumber;
    }

    public TextView getRetwitteNumber() {
        return retwitteNumber;
    }

    public TextView getFavoriteNumber() {
        return favoriteNumber;
    }




}
