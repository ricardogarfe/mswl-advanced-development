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

package es.advanced.development.activities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class Actividad2 extends Activity {

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

        returnIntent.putExtra("PARAM", 20);

        setResult(RESULT_OK, returnIntent);

        super.finish();
    }

}
