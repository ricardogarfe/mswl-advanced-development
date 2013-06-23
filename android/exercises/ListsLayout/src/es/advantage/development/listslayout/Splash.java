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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class Splash extends Activity {
    private long ms = 0;
    private long splashTime = 2000;
    private boolean splashActive = true;
    private boolean paused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hides the titlebar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash);

        Thread mythread = new Thread() {
            public void run() {
                try {
                    while (splashActive && ms < splashTime) {
                        if (!paused)
                            ms = ms + 100;
                        sleep(100);
                    }
                } catch (Exception e) {
                } finally {
                    Intent intent = new Intent(Splash.this,
                            ComplexListActivity.class);
                    startActivity(intent);
                }
            }
        };
        mythread.start();
    }
}
