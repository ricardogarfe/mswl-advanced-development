package es.advantage.development.maps;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
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
import es.advantage.development.maps.model.Node;

public class ComplexListActivity extends ListActivity {
    private MyAdapter mAdapter = null;

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

    /**
     * Item seleccionado para mostrar en el mapa.
     */
    protected void onListItemClick(ListView l, View v, int position, long id) {

        boolean advertise = ((position + 1) % 3 == 0);

        if (advertise) {

            Toast.makeText(this,
                    this.getResources().getString(R.string.publicidad),
                    Toast.LENGTH_SHORT).show();

        } else {

            position = position - ((position + 1) / 3);

            Node selectedNode = mArray.get(position);

            // Create a new intent to call MapsActivity With GeoPoint.
            Intent intentMapsExercise = new Intent(ComplexListActivity.this,
                    MapsExerciseActivity.class);
            intentMapsExercise.putExtra("node", selectedNode);

            startActivity(intentMapsExercise);
        }
    }

    private void setData() {

        mArray.clear();

        Node mynode = new Node();

        // Restaurant 1

        mynode.mTitle = this.getResources().getString(R.string.title1);
        mynode.mDescription = this.getResources().getString(
                R.string.description1);
        mynode.mImageResource = R.drawable.image1;

        mynode.mLon = -5.855475;
        mynode.mLat = 43.355864;

        mArray.add(mynode);

        // Restaurant 2
        Node mynode2 = new Node();

        mynode2.mTitle = this.getResources().getString(R.string.title2);
        mynode2.mDescription = this.getResources().getString(
                R.string.description2);
        mynode2.mImageResource = R.drawable.image2;

        mynode2.mLon = -3.688957970842623;
        mynode2.mLat = 40.40615564778484;

        mArray.add(mynode2);

        // Restaurant 3
        Node mynode3 = new Node();

        mynode3.mTitle = this.getResources().getString(R.string.title3);
        mynode3.mDescription = this.getResources().getString(
                R.string.description3);
        mynode3.mImageResource = R.drawable.image3;

        mynode3.mLon = -1.976704;
        mynode3.mLat = 43.317669;

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