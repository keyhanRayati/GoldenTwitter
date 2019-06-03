package ir.co.arca.twitter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class TwitterActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);
        LoadFragment(new HomeFragment());
        setupBottomNavigation();
    }

//    private void setupToolbar(){
//        toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("Home");
//        toolbar.setTitleTextColor(Color.WHITE);
//        toolbar.setLogo(R.mipmap.ic_launcher_round);
//        setSupportActionBar(toolbar);
//    }

    private void setupBottomNavigation(){
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.home_id);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.home_id:
                        LoadFragment(new HomeFragment());
                        return true;
                    case R.id.search_id:
                        LoadFragment(new SearchFragment());
                        return true;
                    case R.id.notification_id:
                        LoadFragment(new NotificationFragment());
                        return true;
                }
                return false;
            }
        });
    }

    private void LoadFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

}
