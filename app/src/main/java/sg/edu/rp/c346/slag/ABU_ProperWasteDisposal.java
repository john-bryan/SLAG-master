package sg.edu.rp.c346.slag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ABU_ProperWasteDisposal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abu__proper_waste_disposal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemHome:
                //Toast.makeText(this, "Home - selected.", Toast.LENGTH_SHORT).show();
                Intent iHome = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(iHome);
                return true;
            case R.id.itemAboutUs:
                //Toast.makeText(this, "About Us - selected.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subItemAboutUs1:
                //Toast.makeText(this, "Our Mission - selected.", Toast.LENGTH_SHORT).show();
                Intent iSubItemAboutUs1 = new Intent(getApplicationContext(), ABU_OurMission.class);
                startActivity(iSubItemAboutUs1);
                return true;
            case R.id.subItemAboutUs2:
                Toast.makeText(this, "Our Adhoc Services - selected.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subItemAboutUs3:
                //Toast.makeText(this, "Importance of Proper Disposal - selected.", Toast.LENGTH_SHORT).show();
                Intent iSubItemAboutUs3 = new Intent(getApplicationContext(), ABU_ProperWasteDisposal.class);
                startActivity(iSubItemAboutUs3);
                return true;
            case R.id.itemCollection:
                Toast.makeText(this, "Collection - selected.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subCollection1:
                Toast.makeText(this, "List of Collectable E-Waste - selected.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subCollection2:
                Toast.makeText(this, "Locate our Bins - selected.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemContactUs:
                Toast.makeText(this, "Contact Us - selected.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemSignUp:
                Toast.makeText(this, "Sign Up - selected.", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
