package com.example.kidcashh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private ListView cartListView;
    private TextView totalAmountText;
    private Button payButton;
    private ArrayList<String> cartItems;
    private int totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);
        totalAmountText = findViewById(R.id.totalAmountText);
        payButton = findViewById(R.id.payButton);

        // For demonstration, let's assume we have a few items in the cart
        cartItems = new ArrayList<>();
        cartItems.add("Toy 1 - ₹100");
        cartItems.add("Toy 2 - ₹150");

        // Calculate total amount
        totalAmount = 0;
        for (String item : cartItems) {
            String[] parts = item.split("₹");
            totalAmount += Integer.parseInt(parts[1]);
        }
        totalAmountText.setText("Total: ₹" + totalAmount);

        // Set up the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cartItems);
        cartListView.setAdapter(adapter);

        // Set up pay button click listener
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalAmount > 0) {
                    Intent intent = new Intent(CartActivity.this, PaymentActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(CartActivity.this, "Your cart is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
