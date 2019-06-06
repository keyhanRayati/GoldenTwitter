package ir.co.arca.twitter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Following extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter<RecyclerView.ViewHolder> recyclerViewAdapter;
    private List<Message> messageList = new ArrayList<>();
    private ImageView imageView;
    private Intent intent;
//    private CircleImageView circleImageView;
//    private Intent intent3;

//    public void gotoMyprofile(){
//        imageView = findViewById(R.id.followerPic);
//        intent = new Intent(this, MyProfile.class);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(intent);
//            }
//        });
//
//    }

    private void back(){
        imageView = findViewById(R.id.followerPic);
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
        setContentView(R.layout.activity_following);
        fillMessageList();
        back();
        //   gotoMyprofile();
        setupRecyclerView();
    }

    private void fillMessageList(){
        for (int i = 0; i < 100 ; i++) {
            messageList.add(new Message(R.drawable.default_avatar, "Keyhan"+i , "@_say10__"));
        }
    }

    private void setupRecyclerView(){
        recyclerView = findViewById(R.id.recyclerViewOnfolloerPage);
        recyclerViewAdapter = new RecyclerViewAdapter<RecyclerView.ViewHolder>(messageList , this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
