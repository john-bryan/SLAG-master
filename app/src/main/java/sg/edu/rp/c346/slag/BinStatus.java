package sg.edu.rp.c346.slag;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class BinStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bin_status);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        int counter = 80;
        Button btnSend = findViewById(R.id.btnSend);
        progressBar.setMax(100);
        progressBar.setProgress(counter);

            if (counter >= 80){
                progressBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
            }




        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BinStatus.this, "Sending alert to personnel", Toast.LENGTH_LONG).show();
            }
        });

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
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
