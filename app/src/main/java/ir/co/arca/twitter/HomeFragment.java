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

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    private TwitteViewAdapter twitteViewAdapter;
    private RecyclerView recyclerView;
    private List<Twitte> twitteList = new ArrayList<>();
    private ImageButton newTweet;
    private Intent intent;


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
        setupRecyclerView(view);
    }

    private void fillMessageList() {
        for (int i = 0; i < 50; i++) {
            twitteList.add(new Twitte(R.drawable.avatar_picture, "Keyhan", "@_say10__",
                    "32m", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters",
                    R.drawable.ic_mention, R.drawable.ic_renew,
                    R.drawable.ic_favorite, "4", "4",
                    "4"));
        }
    }

    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.homeRecyclerView);
        twitteViewAdapter = new TwitteViewAdapter<RecyclerView.ViewHolder>(twitteList);
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
}
