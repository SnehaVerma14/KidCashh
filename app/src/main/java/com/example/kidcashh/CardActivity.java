package com.example.kidcashh;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CardActivity extends AppCompatActivity {

    private ImageView virtualCardImage;
    private boolean isZoomedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        virtualCardImage = findViewById(R.id.virtualCardImage);

        virtualCardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isZoomedIn) {
                    virtualCardImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    Toast.makeText(CardActivity.this, "Zoomed Out", Toast.LENGTH_SHORT).show();
                } else {
                    virtualCardImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    Toast.makeText(CardActivity.this, "Zoomed In", Toast.LENGTH_SHORT).show();
                }
                isZoomedIn = !isZoomedIn;
            }
        });
    }
}
