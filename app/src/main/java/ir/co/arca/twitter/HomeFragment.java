package ir.co.arca.twitter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeFragment extends Fragment {


    private TwitteViewAdapter twitteViewAdapter;
    private RecyclerView recyclerView;
    private List<Twitte> twitteList = new ArrayList<>();
    private ImageButton newTweet;
    private Intent intent;
    private ImageButton myprofileImage;
    private Intent intent2;

    private CircleImageView circleImageView;
    private Intent intent3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fillMessageList();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupNewTweet(view);
        setupProfile(view);
     //   setupOtherProfile(view);
        setupRecyclerView(view);
    }

    private void fillMessageList() {
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

    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.homeRecyclerView);
        twitteViewAdapter = new TwitteViewAdapter<RecyclerView.ViewHolder>(twitteList , getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(twitteViewAdapter);
    }

    private void setupNewTweet(View view){
        newTweet = view.findViewById(R.id.newTweet);
        intent = new Intent(getActivity(), NewTweet.class);
        newTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

    private void setupProfile(View view){
        myprofileImage = view.findViewById(R.id.imageButton6);
        intent2 = new Intent(getActivity(), MyProfile.class);
        myprofileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });
    }
//    private void setupOtherProfile(View view){
//        circleImageView = view.findViewById(R.id.avatarHome);
//        intent3 = new Intent(getActivity(), OtherProfile.class);
//        circleImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(intent3);
//            }
//        });
//    }
}
