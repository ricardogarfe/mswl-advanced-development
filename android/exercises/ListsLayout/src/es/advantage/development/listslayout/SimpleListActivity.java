/*
 * Copyright [2013] [Ricardo García Fernández] [ricardogarfe@gmail.com]
 * 
 * This file is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This file is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package es.advantage.development.listslayout;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleListActivity extends ListActivity {

    private ListView listView;
    private ListAdapter listAdapter;
    private String[] testValues = new String[] { "URJC", "EOI", "Android" };

    private String TAG = getClass().getSimpleName();

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

        Toast.makeText(this,
                String.valueOf(position) + " - " + testValues[position],
                Toast.LENGTH_SHORT).show();

        Log.d(TAG, "Postition:\t" + String.valueOf(position));
        Log.d(TAG, "Value:\t" + testValues[position]);
    }
}
