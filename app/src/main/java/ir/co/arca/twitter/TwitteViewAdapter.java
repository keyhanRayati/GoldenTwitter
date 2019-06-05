package ir.co.arca.twitter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TwitteViewAdapter<M extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<TwitteViewHolder> {

    List<Twitte> twitteList;
    Context context;

    public TwitteViewAdapter(List<Twitte> twitteList , Context context) {
        this.context = context;
        this.twitteList = twitteList;
    }

    @Override
    public TwitteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_item, parent, false);
        return new TwitteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TwitteViewHolder holder, int position) {
        holder.getAvatarPic().setImageResource(twitteList.get(position).getAvatarPic());
        holder.getUsername().setText(twitteList.get(position).getUsername());
        holder.getUserId().setText(twitteList.get(position).getUserId());
        holder.getTime().setText(twitteList.get(position).getTime());
        holder.getFavorite().setImageResource(twitteList.get(position).getFavorite());
        holder.getFavoriteNumber().setText(twitteList.get(position).getFavoriteNumber());
        holder.getMention().setImageResource(twitteList.get(position).getMention());
        holder.getMentionNumber().setText(twitteList.get(position).getMentionNumber());
        holder.getRetwitte().setImageResource(twitteList.get(position).getRetwitte());
        holder.getRetwitteNumber().setText(twitteList.get(position).getRetwitteNumber());
        holder.getTextOfTwitte().setText(twitteList.get(position).getTextOfTwitte());
        holder.getAvatarPic().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context , OtherProfile.class) );
            }
        });
    }

    @Override
    public int getItemCount() {
        return twitteList.size();
    }
}
