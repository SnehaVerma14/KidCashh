package com.example.kidcashh;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TransactionHistoryActivity extends AppCompatActivity {

    private ListView transactionListView;
    private ArrayList<String> transactions;
    private double totalSpend = 0.0;
    private double totalAmountInBank = 10000.0; // Example total amount in bank

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);

        transactionListView = findViewById(R.id.transactionListView);
        transactions = new ArrayList<>();

        // Sample transaction data
        transactions.add("Toys - ₹200 on 01/07/2024");
        transactions.add("Books - ₹150 on 02/07/2024");
        transactions.add("Stationery - ₹100 on 03/07/2024");

        for (String transaction : transactions) {
            String[] parts = transaction.split(" - ");
            String[] amountDate = parts[1].split(" on ");
            totalSpend += Double.parseDouble(amountDate[0].substring(2)); // Extract amount
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, transactions);
        transactionListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_payment:
                // Navigate to PaymentActivity
                // Intent intent = new Intent(this, PaymentActivity.class);
                // startActivity(intent);
                return true;
            case R.id.menu_savings:
                double savings = totalAmountInBank - totalSpend;
                Toast.makeText(this, "Savings: ₹" + savings, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
