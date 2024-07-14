package com.example.kidcashh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    private EditText cardNumber, validThru, nickname;
    private Button confirmPaymentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        cardNumber = findViewById(R.id.cardNumber);
        validThru = findViewById(R.id.validThru);
        nickname = findViewById(R.id.nickname);
        confirmPaymentButton = findViewById(R.id.confirmPaymentButton);

        confirmPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cardNum = cardNumber.getText().toString().trim();
                String validDate = validThru.getText().toString().trim();
                String nick = nickname.getText().toString().trim();

                if (cardNum.isEmpty() || validDate.isEmpty() || nick.isEmpty()) {
                    Toast.makeText(PaymentActivity.this, "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(PaymentActivity.this, PaymentCompletedActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
