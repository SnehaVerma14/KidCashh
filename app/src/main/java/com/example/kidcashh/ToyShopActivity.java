package com.example.kidcashh;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ToyShopActivity extends AppCompatActivity {

    private ImageView toyImage1, toyImage2, toyImage3, toyImage4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toy_shop);

        toyImage1 = findViewById(R.id.toyImage1);
        toyImage2 = findViewById(R.id.toyImage2);
        toyImage3 = findViewById(R.id.toyImage3);
        toyImage4 = findViewById(R.id.toyImage4);

        View.OnClickListener toyClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.toyImage1:
                        Toast.makeText(ToyShopActivity.this, "Toy 1 Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.toyImage2:
                        Toast.makeText(ToyShopActivity.this, "Toy 2 Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.toyImage3:
                        Toast.makeText(ToyShopActivity.this, "Toy 3 Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.toyImage4:
                        Toast.makeText(ToyShopActivity.this, "Toy 4 Selected", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        toyImage1.setOnClickListener(toyClickListener);
        toyImage2.setOnClickListener(toyClickListener);
        toyImage3.setOnClickListener(toyClickListener);
        toyImage4.setOnClickListener(toyClickListener);
    }
}
