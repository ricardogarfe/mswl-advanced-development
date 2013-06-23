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

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ComplexListActivity extends ListActivity {
    private MyAdapter mAdapter = null;

    // We define a structure to save the data
    public class Node {
        public String mTitle;
        public String mDescription;
        public Integer mImageResource;
    }

    // ArrayList
    private static ArrayList<Node> mArray = new ArrayList<Node>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData();

        mAdapter = new MyAdapter(this);
        setListAdapter(mAdapter);

    }

    protected void onListItemClick(ListView l, View v, int position, long id) {

        // Create a new intent to call other Activity.
        // Using the methods "putExtra" we can
        // send data to the new activity

        Toast.makeText(this, mArray.get(position).mTitle, Toast.LENGTH_SHORT)
                .show();
    }

    private void setData() {

        mArray.clear();

        Node mynode = new Node();

        // Restaurant 1

        mynode.mTitle = this.getResources().getString(R.string.title1);
        mynode.mDescription = this.getResources().getString(
                R.string.description1);
        mynode.mImageResource = R.drawable.image1;

        mArray.add(mynode);

        // Restaurant 2
        Node mynode2 = new Node();

        mynode2.mTitle = this.getResources().getString(R.string.title2);
        mynode2.mDescription = this.getResources().getString(
                R.string.description2);
        mynode2.mImageResource = R.drawable.image2;

        mArray.add(mynode2);

        // Restaurant 3
        Node mynode3 = new Node();

        mynode3.mTitle = this.getResources().getString(R.string.title3);
        mynode3.mDescription = this.getResources().getString(
                R.string.description3);
        mynode3.mImageResource = R.drawable.image3;

        mArray.add(mynode3);

        mArray.addAll(mArray);

    }

    public static class MyAdapter extends BaseAdapter {

        private Context mContext;

        public MyAdapter(Context context) {
            // TODO Auto-generated constructor stub
            // Contexto para obtener el acceso a los elementos de la UI.
            mContext = context;
        }

        @Override
        public int getCount() {
            return mArray.size() + (mArray.size() / 2) + (mArray.size() % 2);
        }

        @Override
        public Object getItem(int position) {
            return mArray.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            // Identificadores diferentes, bbdd, etc...
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view;

            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            boolean advertise = ((position + 1) % 3 == 0);

            if (advertise) {

                view = inflater.inflate(R.layout.publicidad_item, null);

                TextView titleTextView = (TextView) view
                        .findViewById(R.id.publicidad);
                titleTextView.setText(R.string.publicidad);
                titleTextView.setBackgroundColor(Color.YELLOW);

            } else {

                position = position - ((position + 1) / 3);

                view = inflater.inflate(R.layout.complex_list_main, null);

                // Dar valores a los Widgets del elemento complejo de la lista
                // descrito en complex_list_main.xml
                TextView titleTextView = (TextView) view
                        .findViewById(R.id.title);
                titleTextView.setText(mArray.get(position).mTitle);

                TextView descriptionTextView = (TextView) view
                        .findViewById(R.id.description);
                descriptionTextView.setText(mArray.get(position).mDescription);

                ImageView imageViewLogo = (ImageView) view
                        .findViewById(R.id.image);
                imageViewLogo.setImageDrawable(mContext.getResources()
                        .getDrawable(mArray.get(position).mImageResource));

            }
            return view;
        }

    }
}