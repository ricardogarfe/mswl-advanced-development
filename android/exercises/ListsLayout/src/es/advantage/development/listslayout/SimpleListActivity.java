package es.advantage.development.listslayout;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleListActivity extends ListActivity {

    private ListView listView;
    private ListAdapter listAdapter;
    private String[] testValues = new String[] { "URJC", "EOI", "Android" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Retrive ListView.
        listView = (ListView) findViewById(android.R.id.list);

        // Simple List Adapter.
        listAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, testValues);

        listView.setAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);

        Toast.makeText(this, String.valueOf(position) + " - "
                + testValues[position], Toast.LENGTH_SHORT).show();
    }
}
