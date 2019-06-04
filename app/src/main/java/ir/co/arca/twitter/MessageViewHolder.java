package ir.co.arca.twitter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    private CircleImageView avatar;
    private TextView name;

    public CircleImageView getAvatar() {
        return avatar;
    }

    public TextView getName() {
        return name;
    }

    public TextView getLastMessage() {
        return lastMessage;
    }

    private TextView lastMessage;

    public MessageViewHolder(View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.avatarName);
        lastMessage = itemView.findViewById(R.id.lastMessage);
    }
}
