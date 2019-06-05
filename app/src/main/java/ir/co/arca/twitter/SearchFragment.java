package ir.co.arca.twitter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter<RecyclerView.ViewHolder> recyclerViewAdapter;
    private List<Message> messageList = new ArrayList<>();
    private ImageView imageView;
    private Intent intent;
    private CircleImageView circleImageView;
    private Intent intent3;

    public void gotoMyprofile(View view){
        imageView = view.findViewById(R.id.myProfileInSearchFragment);
        intent = new Intent(getContext(), MyProfile.class);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fillMessageList();
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(view);
        gotoMyprofile(view);
        //setupOtherProfile(view);
    }

    private void fillMessageList(){
        for (int i = 0; i < 100 ; i++) {
            messageList.add(new Message(R.drawable.default_avatar, "Keyhan"+i , "@_say10__"));
        }
    }

    private void setupRecyclerView(View view){
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter<RecyclerView.ViewHolder>(messageList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

//    private void setupOtherProfile(View view){
//        circleImageView = view.findViewById(R.id.avatar);
//        intent3 = new Intent(getActivity(), OtherProfile.class);
//        circleImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(intent3);
//            }
//        });
//    }
}
