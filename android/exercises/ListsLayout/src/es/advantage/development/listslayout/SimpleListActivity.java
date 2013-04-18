package es.advantage.development.listslayout;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

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
}
