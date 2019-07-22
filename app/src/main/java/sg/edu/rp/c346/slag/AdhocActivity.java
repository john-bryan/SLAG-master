package sg.edu.rp.c346.slag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AdhocActivity extends AppCompatActivity {

    MyDBHandler mDataBaseHelper;
    TextView tvTotal;
    EditText etName;
    EditText etAdd;
    EditText etItems;
    ListView lvItems;
    Button btnAdd;
    Button btnSubmit;
    ArrayList<String> alItems;
    ArrayAdapter<String> aaItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhoc);

        MyDBHandler mydbHandler = new MyDBHandler(this);
        mDataBaseHelper = new MyDBHandler(this);

        tvTotal = findViewById(R.id.tvTotal);
        etName = findViewById(R.id.etName);
        etAdd = findViewById(R.id.etAddress);
        etItems = findViewById(R.id.etItems);
        lvItems = findViewById(R.id.lvItems);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubmit = findViewById(R.id.btnSubmit);

        alItems = new ArrayList<>();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alItems.add(etItems.getText().toString());
                tvTotal.setText("Total no. of items Collected: " + alItems.size());
                aaItems = new ArrayAdapter<>(AdhocActivity.this, android.R.layout.simple_list_item_1, alItems);
                lvItems.setAdapter(aaItems);
                etItems.setText("");
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iHome = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(iHome);

                String name = etName.getText().toString();
                String add = etAdd.getText().toString();
                String items = etItems.getText().toString();

                if(etName.length() != 0 && etAdd.length() != 0 && etItems.length() != 0) {
                    AddData(name);
                    AddData(add);
                    AddData(items);
                    Toast.makeText(AdhocActivity.this, "Submitted to database", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(AdhocActivity.this, "Please complete the form", Toast.LENGTH_LONG);
                }

            }
        });


    }

    public void AddData(String newEntry){
        boolean insertData = mDataBaseHelper.addHandler(newEntry);

        if(insertData){
            Toast.makeText(this, "Record added successfully", Toast.LENGTH_LONG);
        }
        else {
            Toast.makeText(this, "Record Adding Failed", Toast.LENGTH_LONG);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.itemHome:
                //Toast.makeText(this, "Home - selected.", Toast.LENGTH_SHORT).show();
                Intent iHome = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(iHome);
                return true;
            case R.id.itemAdhoc:
                //Toast.makeText(this, "About Us - selected.", Toast.LENGTH_SHORT).show();
                Intent iAdhoc = new Intent(getApplicationContext(),AdhocActivity.class);
                startActivity(iAdhoc);
                return true;
            case R.id.itemBinStatus:
                Intent iBinStat = new Intent(getApplicationContext(),BinStatus.class);
                startActivity(iBinStat);
            case R.id.itemAdhocList:
                Intent iAdhocList = new Intent(getApplicationContext(),BinStatus.class);
                startActivity(iAdhocList);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
