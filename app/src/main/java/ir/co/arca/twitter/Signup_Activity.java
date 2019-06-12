package ir.co.arca.twitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Signup_Activity extends AppCompatActivity {
    private Intent intent1 ;
    private Button button1 ;

    private void but1(){
        button1 = findViewById(R.id.signUpEndBtn);
        intent1 = new Intent(Signup_Activity.this , TwitterActivity.class);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new ApiService(Signup_Activity.this).signup("", "", "", "", new ApiService.OnServerCallback() {
                    @Override
                    public void onSuccess() {
                        startActivity(intent1);
                    }

                    @Override
                    public void onFailed() {

                    }
                });

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_);
        but1();
    }
}
