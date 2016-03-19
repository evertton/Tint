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

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import io.github.evertton.tint.io.github.evertton.tint.model.CorAdapter;
import io.github.evertton.tint.io.github.evertton.tint.model.Paleta;

public class MostrarPaletaActivity extends AppCompatActivity {

    public ListView colorsList;
    private Paleta paleta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_paleta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_mostrar_paleta);
        setSupportActionBar(toolbar);

        paleta = Paleta.lista.get(this.getIntent().getIntExtra("idList", 0));

        setTitle(paleta.getNome());

        showColors();

    }

    private void showColors() {

        colorsList = (ListView) findViewById(R.id.colors_list);

        CorAdapter adapter = new CorAdapter(this, paleta.getCores());

        colorsList.setAdapter(adapter);

        colorsList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position,
                                           long id) {

                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("cor", paleta.getCores().get(position));
                clipboard.setPrimaryClip(clip);

                Snackbar.make(view, "Cor copiada para área de transferência!", Snackbar.LENGTH_LONG).show();

                return true;
            }

        });

        colorsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openCor((int) id);
            }

        });

    }

    private void openCor(int id) {
        Intent intent = new Intent(this, CorActivity.class);
        intent.putExtra("cor", paleta.getCores().get(id));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mostrar_paleta, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.adicionar_cor_action) {
            this.finish();
            Intent intent = new Intent(this, AdicionarCorActivity.class);
            intent.putExtra("idPaleta", paleta.getId());
            intent.putExtra("parent", 1);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
