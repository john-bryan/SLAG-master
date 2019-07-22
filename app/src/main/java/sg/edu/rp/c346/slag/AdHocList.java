package sg.edu.rp.c346.slag;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class AdHocList extends AppCompatActivity {

    ListView lv;
    MyDBHandler mDatabaseHelper;
    ArrayList<AdHoc> alAdhoc;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_hoc_list);

        lv = findViewById(R.id.lvList);
        mDatabaseHelper = new MyDBHandler(this);
        populateListView();

    }

    private void populateListView() {
        Cursor data = mDatabaseHelper.loadHandler();
        alAdhoc = new ArrayList<AdHoc>();
        while(data.moveToNext()){
            alAdhoc.add(data.getString(1));
            alAdhoc.add(data.getString(2));
            alAdhoc.add(data.getString(3));
        }

        adapter = new CustomAdapter(this, R.layout.newlayout, alAdhoc);
        lv.setAdapter(adapter);

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
