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
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Definição da atividade Cor.
 *
 * @author Evertton de Lima <e.everttonlima@gmail.com>
 */
public class CorActivity extends AppCompatActivity {

    /**
     * Armazena a cor sobre a qual serão exibidas informações extras nessa atividade.
     */
    String cor;
    /**
     * Define um gerenciador de área de colagem, para que o usuário possa copiar cores
     * ao clicar em botões ou pressioná-la e segurá-la na listagem.
     */
    ClipboardManager clipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cor = this.getIntent().getStringExtra("cor");

        setTitle(cor);

        TextView tv = (TextView) findViewById(R.id.cor);
        tv.setBackgroundColor(Color.parseColor(cor));

        clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);


        Button getHEX = (Button) findViewById(R.id.cor_get_hex);
        getHEX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clip(cor, view);
            }
        });

        Button getRGB = (Button) findViewById(R.id.cor_get_rgb);
        getRGB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clip(toRGB(cor), view);
            }
        });

        Button comoHexRgb = (Button) findViewById(R.id.como_hex_rgb);
        comoHexRgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHexToRgb();
            }
        });

        Button comoRgbHex = (Button) findViewById(R.id.como_rgb_hex);
        comoRgbHex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRgbToHex();
            }
        });

    }

    /**
     * Abre a atividade RGB to HEX.
     */
    private void openRgbToHex() {
        Intent intent = new Intent(this, RgbToHexActivity.class);
        startActivity(intent);
    }

    /**
     * Abre a atividade HEX to RGB.
     */
    private void openHexToRgb() {
        Intent intent = new Intent(this, HexToRgbActivity.class);
        startActivity(intent);
    }

    /**
     * Converte uma cor hexadecimal para rgb.
     *
     * @param cor em hexadecimal
     * @return correspondente em rgb
     */
    private String toRGB(String cor) {
        String corRGB = "rgb( ";

        corRGB += Integer.valueOf(cor.substring(1, 3), 16) + ", ";
        corRGB += Integer.valueOf(cor.substring(3, 5), 16) + ", ";
        corRGB += Integer.valueOf(cor.substring(5, 7), 16) + " )";

        return corRGB;
    }

    /**
     * Copia uma cor para a área de transferência.
     *
     * @param cor  a cor que deverá ser copiada na área de transferência
     * @param view a view que promoveu a ação de cópia
     */
    private void clip(String cor, View view) {
        ClipData clip = ClipData.newPlainText("cor", cor);
        clipboard.setPrimaryClip(clip);
        Snackbar.make(view, "Cor copiada para área de transferência!", Snackbar.LENGTH_LONG).show();
    }

}
