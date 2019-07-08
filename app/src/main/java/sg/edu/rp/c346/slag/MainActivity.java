package sg.edu.rp.c346.slag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //private WebView webView;
    ImageView ivSlag;

    ContextMenu itemHome;
    ContextMenu itemAboutUs;
    ContextMenu itemCollection;
    ContextMenu itemContact;
    ContextMenu itemSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivSlag = findViewById(R.id.imageView);
        itemHome = findViewById(R.id.itemHome);
        itemAboutUs = findViewById(R.id.itemAboutUs);
        itemCollection = findViewById(R.id.itemCollection);
        itemContact = findViewById(R.id.itemContactUs);
        itemSignUp = findViewById(R.id.itemSignUp);

        //webView = (WebView) findViewById(R.id.webView);
        //webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("https://10.0.2.2:44379");
        //webView.loadUrl("https://www.google.com/");
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
            case R.id.itemAboutUs:
                //Toast.makeText(this, "About Us - selected.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subItemAboutUs1:
                //Toast.makeText(this, "Our Mission - selected.", Toast.LENGTH_SHORT).show();
                Intent iSubItemAboutUs1 = new Intent(getApplicationContext(),ABU_OurMission.class);
                startActivity(iSubItemAboutUs1);
                return true;
            case R.id.subItemAboutUs2:
                //Toast.makeText(this, "Our Adhoc Services - selected.", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.subItemAboutUs3:
                //Toast.makeText(this, "Importance of Proper Disposal - selected.", Toast.LENGTH_SHORT).show();
                Intent iSubItemAboutUs3 = new Intent(getApplicationContext(),ABU_ProperWasteDisposal.class);
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
                //Toast.makeText(this, "Contact Us - selected.", Toast.LENGTH_SHORT).show();
                Intent iContact = new Intent(getApplicationContext(),ContactUs.class);
                startActivity(iContact);
                return true;
            case R.id.itemSignUp:
                Toast.makeText(this, "Sign Up - selected.", Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
