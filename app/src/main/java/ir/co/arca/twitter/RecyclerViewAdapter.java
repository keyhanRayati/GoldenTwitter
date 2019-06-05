package ir.co.arca.twitter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class RecyclerViewAdapter<M extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<MessageViewHolder> {

    List<Message> messageList;
    Context context;
    public RecyclerViewAdapter(List<Message> messageList , Context context) {
        this.context = context;
        this.messageList = messageList;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_list_item, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        holder.getAvatar().setImageResource(messageList.get(position).getAvatar());
        holder.getName().setText(messageList.get(position).getName());
        holder.getLastMessage().setText(messageList.get(position).getLastMessage());
        holder.getAvatar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, OtherProfile.class));
            }
        });
    }


    @Override
    public int getItemCount() {
        return messageList.size();
    }


}
