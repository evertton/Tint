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
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import io.github.evertton.tint.io.github.evertton.tint.model.Paleta;
import io.github.evertton.tint.io.github.evertton.tint.model.PaletaAdapter;

public class MainActivity extends AppCompatActivity {

    public ListView paletaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updatePaletaList();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()

                               {
                                   @Override
                                   public void onClick(View view) {
                                       openCriarPaleta();
                                   }
                               }

        );
    }

    private void openCriarPaleta() {
        Intent intent = new Intent(this, CriarPaletaActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void showPaleta(int id) {
        Intent intent = new Intent(this, MostrarPaletaActivity.class);
        intent.putExtra("idList", id);
        startActivity(intent);
    }

    private void updatePaletaList() {
        paletaList = (ListView) findViewById(R.id.paleta_list);

        PaletaAdapter adapter = new PaletaAdapter(this, Paleta.lista);

        paletaList.setAdapter(adapter);

        paletaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                showPaleta(position);

            }

        });
    }

}
