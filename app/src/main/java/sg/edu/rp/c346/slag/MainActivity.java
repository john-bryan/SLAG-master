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
    ContextMenu itemAdhoc;
    ContextMenu itemCheckBin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivSlag = findViewById(R.id.imageView);
        itemHome = findViewById(R.id.itemHome);
        itemAdhoc = findViewById(R.id.itemAdhoc);
        itemCheckBin = findViewById(R.id.itemBinStatus);

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
