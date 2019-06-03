package ir.co.arca.twitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_Activity extends AppCompatActivity {

    private Button loginButton;
    private Button signUpButton;
    private Intent intent1;
    private Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        startSignupActivity();
        startTwitterActivity();
    }

    public void startSignupActivity(){
        signUpButton = findViewById(R.id.signUpBtn);
        intent1 = new Intent(Login_Activity.this, Signup_Activity.class);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent1);
            }
        });
    }

    public void startTwitterActivity(){
        loginButton = findViewById(R.id.LoginBtn);
        intent2 = new Intent(Login_Activity.this, TwitterActivity.class);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });

    }

}
