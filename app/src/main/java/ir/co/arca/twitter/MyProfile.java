package ir.co.arca.twitter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MyProfile extends AppCompatActivity {
    private TwitteViewAdapter twitteViewAdapter;
    private RecyclerView recyclerView;
    private List<Twitte> twitteList = new ArrayList<>();

    private Intent intent;
    private ImageView imageView;

    private void back(){
       imageView = findViewById(R.id.backButtonMyProfile);
       intent = new Intent(MyProfile.this, TwitterActivity.class);
       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(intent);
           }
       });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_profile);
        back();
        filltweetlist();
        setupRecyclerView();
    }

    private void filltweetlist(){
        twitteList.add(new Twitte(R.drawable.default_avatar, "Keyhan", "@_say10__",
                "32m", "It is a page when looking at its it has a more-or-less normal distribution of letters",
                R.drawable.ic_mention, R.drawable.ic_renew,
                R.drawable.ic_favorite, "4", "4",
                "4"));
        twitteList.add(new Twitte(R.drawable.default_avatar, "Keyhan", "@_say10__",
                "32m", "It is a long estd\n" +
                " by the readable\n" +
                " content of a page \n" +
                "when looki The point of \n" +
                "using Ipsum is\n " +
                "that it has a more-or-less nl di\n" +
                "stributiof letters",
                R.drawable.ic_mention, R.drawable.ic_renew,
                R.drawable.ic_favorite, "4", "4",
                "4"));
        for (int i = 0; i < 50; i++) {
            twitteList.add(new Twitte(R.drawable.default_avatar, "Keyhan", "@_say10__",
                    "32m", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters",
                    R.drawable.ic_mention, R.drawable.ic_renew,
                    R.drawable.ic_favorite, "4", "4",
                    "4"));
        }
    }

    private void setupRecyclerView(){
        recyclerView = findViewById (R.id.myProfileRecyclerView);
        twitteViewAdapter = new TwitteViewAdapter(twitteList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this );
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(twitteViewAdapter);
    }



}
