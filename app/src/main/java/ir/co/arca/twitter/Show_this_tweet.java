package ir.co.arca.twitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Show_this_tweet extends AppCompatActivity {

    private TwitteViewAdapter twitteViewAdapter;
    private RecyclerView recyclerView;
    private List<Tweet> tweetList = new ArrayList<>();
    private ImageButton newTweet;
    private Intent intent;
    private ImageButton myprofileImage;
    private Intent intent2;

    private CircleImageView circleImageView;
    private Intent intent3;
    private ImageView imageView;
    private void back(){
        imageView = findViewById(R.id.backInShowTweetPic);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_this_tweet);
         tweetList = (List<Tweet>) getIntent().getSerializableExtra("cm");
      //  fillMessageList();
        back();
        setupRecyclerView();
    }


    private void fillMessageList() {

        for (int i = 0; i < 3; i++) {
            tweetList.add(new Tweet(R.drawable.default_avatar, "Keyhan"+i, "@_say10__"+i,
                    "32m", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters",
                    R.drawable.ic_mention, R.drawable.ic_renew,
                    R.drawable.ic_favorite, "4", "4",
                    "4"));
        }
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerOfShowTweet);
        twitteViewAdapter = new TwitteViewAdapter<RecyclerView.ViewHolder>(tweetList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(twitteViewAdapter);
    }

}
