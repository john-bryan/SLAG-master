package sg.edu.rp.c346.slag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<AdHoc> adHocArrayList;

    public CustomAdapter(Context context, int resource, ArrayList<AdHoc> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        adHocArrayList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvName = rowView.findViewById(R.id.tvName);
        TextView tvAddress = rowView.findViewById(R.id.tvAddress);
        TextView tvItems = rowView.findViewById(R.id.tvItemsCollected);

        // Obtain the Android Version information based on the position
        AdHoc currentVersion = adHocArrayList.get(position);

        // Set values to the TextView to display the corresponding information
        tvName.setText(currentVersion.getName());
        tvAddress.setText(currentVersion.getAddress());
        tvItems.setText(currentVersion.getItemsCollected());

        return rowView;
    }

}
