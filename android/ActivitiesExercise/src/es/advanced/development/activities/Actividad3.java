package es.advanced.development.activities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class Actividad3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        TextView textViewActividad2 = (TextView) this
                .findViewById(R.id.textViewActividades);

        Intent intentFromActivity = getIntent();

        if (intentFromActivity != null) {

            String title = intentFromActivity.getStringExtra("TITLE");
            if (title != null) {
                textViewActividad2.setText(title);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_actividades, menu);
        return true;
    }

    @Override
    public void finish() {

        Intent returnIntent = new Intent();

        returnIntent.putExtra("PARAM", 30);

        setResult(RESULT_OK, returnIntent);

        super.finish();
    }

}
