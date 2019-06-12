package ir.co.arca.twitter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

public class TwitteViewAdapter<M extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<TwitteViewHolder> {

    List<Tweet> tweetList;
    Context context;

    public TwitteViewAdapter(List<Tweet> tweetList, Context context) {
        this.context = context;
        this.tweetList = tweetList;
    }

    @Override
    public TwitteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_item, parent, false);
        return new TwitteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TwitteViewHolder holder, final int position) {
        holder.getAvatarPic().setImageResource(tweetList.get(position).getAvatarPic());
        holder.getUsername().setText(tweetList.get(position).getUsername());
        holder.getUserId().setText(tweetList.get(position).getUserId());
        holder.getTime().setText(tweetList.get(position).getTime());
        holder.getFavorite().setImageResource(tweetList.get(position).getFavorite());
        holder.getFavoriteNumber().setText(tweetList.get(position).getFavoriteNumber());
        holder.getMention().setImageResource(tweetList.get(position).getMention());
        holder.getMentionNumber().setText(tweetList.get(position).getMentionNumber());
        holder.getRetwitte().setImageResource(tweetList.get(position).getRetwitte());
        holder.getRetwitteNumber().setText(tweetList.get(position).getRetwitteNumber());
        holder.getTextOfTwitte().setText(tweetList.get(position).getTextOfTwitte());
        holder.getMention().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, Show_this_tweet.class);
                intent.putExtra("cm",(Serializable) tweetList.get(position).getComments());
                context.startActivity(intent);
            }
        });
        holder.getMentionNumber().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context, Show_this_tweet.class);
                intent.putExtra("cm",(Serializable) tweetList.get(position).getComments());
                context.startActivity(intent);
            }
        });
        holder.getTextOfTwitte().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, Show_this_tweet.class));
            }
        });
//        Toast toast = Toast.makeText(context ,  context.getClass().toString() , Toast.LENGTH_LONG );
//        toast.show();
        if (context.getClass().getSimpleName().equals("MyProfile") || context.getClass().getSimpleName().equals("OtherProfile")) { }
        else {
            holder.getAvatarPic().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, OtherProfile.class));
                }
            });
            holder.getUsername().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, OtherProfile.class));
                }
            });
            holder.getUserId().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, OtherProfile.class));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }
}
