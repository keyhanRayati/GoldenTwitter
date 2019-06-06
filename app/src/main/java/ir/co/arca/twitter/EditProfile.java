package ir.co.arca.twitter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EditProfile extends AppCompatActivity {

    private ImageView imageViewBack;

    private void clickOnBack(){
        imageViewBack = findViewById(R.id.backButtonInEdit);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        clickOnBack();
    }
}
