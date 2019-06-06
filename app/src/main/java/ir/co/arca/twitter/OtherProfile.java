package ir.co.arca.twitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OtherProfile extends AppCompatActivity {
    private TwitteViewAdapter twitteViewAdapter;
    private RecyclerView recyclerView;
    private List<Twitte> twitteList = new ArrayList<>();

    private Intent intent;
    private ImageView imageView;

    private Intent intent1;
    private TextView textView1;

    private Intent intent2;
    private TextView textView2;



    private void folower1(){
        textView1 = findViewById(R.id.follower);
        intent1 = new Intent(OtherProfile.this , Followers.class);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
    }
    private void folower2(){
        textView2 = findViewById(R.id.followerNumber);
        intent2 = new Intent(OtherProfile.this , Followers.class);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });
    }
    private Intent intent3;
    private TextView textView3;

    private Intent intent4;
    private TextView textView4;
    private void followings1(){
        textView3 = findViewById(R.id.following);
        intent3 = new Intent(OtherProfile.this , Following.class);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });
    }
    private void followings2(){
        textView4 = findViewById(R.id.folloingNumber);
        intent4 = new Intent(OtherProfile.this , Following.class);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent4);
            }
        });
    }

    private void back(){
        imageView = findViewById(R.id.backButtonOtherProfile);
      //  intent = new Intent(OtherProfile.this, TwitterActivity.class);
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
        setContentView(R.layout.activity_other_profile);
        folower1();
        folower2();
        followings1();
        followings2();
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
        recyclerView = findViewById (R.id.otherProfileRecyclerView);
        twitteViewAdapter = new TwitteViewAdapter(twitteList ,  this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this );
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(twitteViewAdapter);
    }

}
