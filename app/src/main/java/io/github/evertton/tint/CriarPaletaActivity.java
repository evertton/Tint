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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import io.github.evertton.tint.io.github.evertton.tint.model.Paleta;

public class CriarPaletaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_paleta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_paleta);
        setSupportActionBar(toolbar);
    }

    private void startAdicionarCor(int idLast) {
        this.finish();
        Intent intent = new Intent(this, AdicionarCorActivity.class);
        intent.putExtra("idPaleta", idLast);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_criar_paleta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.criar_paleta_action) {
            EditText et = (EditText) findViewById(R.id.cnome_paleta);
            Paleta.lista.add(new Paleta(et.getText().toString()));
            startAdicionarCor(Paleta.lista.size() - 1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
