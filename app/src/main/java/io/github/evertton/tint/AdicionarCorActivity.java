/*
This file is part of Tint.

    Tint is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Tint is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Tint.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.evertton.tint;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.github.evertton.tint.io.github.evertton.tint.model.Paleta;

public class AdicionarCorActivity extends AppCompatActivity {

    private Paleta paleta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_cor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_cor);
        setSupportActionBar(toolbar);

        paleta = Paleta.lista.get(this.getIntent().getIntExtra("idPaleta", 0));

        setTitle(paleta.getNome());

        Button criar = (Button) findViewById(R.id.add_cor);
        criar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = (EditText) findViewById(R.id.hex_cor);

                addCor(et.getText().toString());

                et.setText("");

                esconderTeclado();

                Snackbar.make(view, "Cor adicionada!", Snackbar.LENGTH_LONG).show();
            }
        });

    }

    private void esconderTeclado() {
        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        IBinder teclado = null;
        try {
            teclado = getCurrentFocus().getWindowToken();
        } catch (Exception e) {
            // ignore a exceção
        }

        if (teclado != null)
            inputManager.hideSoftInputFromWindow(teclado, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void addCor(String text) {
        paleta.addCor(text);
        TextView tv = (TextView) findViewById(R.id.added_cores);
        tv.setText(tv.getText() + "\n" + text + "\n");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adicionar_cor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.concluir_cor_action) {
            this.finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
