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

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private final int REQUEST_CODE_ACTIVIDAD_2 = 2;
    private final int REQUEST_CODE_ACTIVIDAD_3 = 3;

    private final String phone = "666-666-666";

    private final String PARAM = "PARAM";

    private Button buttonStack;
    private Button buttonActividad2;
    private Button buttonActividad3;
    private Button buttonBrowser;
    private Button buttonCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpButtonsIntent();
    }

    public void setUpButtonsIntent() {

        buttonStack = (Button) this.findViewById(R.id.buttonStack);

        if (buttonStack != null) {
            buttonStack.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(MainActivity.this,
                            StackActivity.class);
                    startActivity(intent);
                }
            });
        }

        buttonActividad2 = (Button) this.findViewById(R.id.buttonActividad2);

        if (buttonActividad2 != null) {
            buttonActividad2.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(MainActivity.this,
                            Actividad2.class);
                    intent.putExtra("TITLE", "Activity2 from Main Activity");
                    // intent.putExtra("TEMP", 80.2);
                    startActivityForResult(intent, REQUEST_CODE_ACTIVIDAD_2);
                }
            });
        }

        buttonActividad3 = (Button) this.findViewById(R.id.buttonActividad3);

        if (buttonActividad3 != null) {
            buttonActividad3.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(MainActivity.this,
                            Actividad3.class);
                    intent.putExtra("TITLE", "Activity3 from Main Activity");
                    // intent.putExtra("TEMP", 80.2);
                    startActivityForResult(intent, REQUEST_CODE_ACTIVIDAD_3);
                }
            });
        }

        buttonBrowser = (Button) this.findViewById(R.id.buttonBrowser);

        if (buttonBrowser != null) {
            buttonBrowser.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    String url = "http://www.google.com";
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            });
        }

        buttonCall = (Button) this.findViewById(R.id.buttonCall);

        if (buttonCall != null) {
            buttonCall.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phone));
                    startActivity(callIntent);
                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {

            if (requestCode == REQUEST_CODE_ACTIVIDAD_2) {

                Integer value = data.getIntExtra(this.PARAM, -1);

                Toast.makeText(this,
                        "Come back from activity 2:\t" + String.valueOf(value),
                        Toast.LENGTH_SHORT).show();

            } else if (requestCode == REQUEST_CODE_ACTIVIDAD_3) {

                Integer value = data.getIntExtra(this.PARAM, -1);

                Toast.makeText(this,
                        "Come back from activity 3:\t" + String.valueOf(value),
                        Toast.LENGTH_SHORT).show();
            }

        }
    }
}
