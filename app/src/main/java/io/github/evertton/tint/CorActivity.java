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

public class CorActivity extends AppCompatActivity {

    String cor;
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

    private void openRgbToHex() {
        Intent intent = new Intent(this, RgbToHexActivity.class);
        startActivity(intent);
    }

    private void openHexToRgb() {
        Intent intent = new Intent(this, HexToRgbActivity.class);
        startActivity(intent);
    }

    private String toRGB(String cor) {
        String corRGB = "rgb( ";

        corRGB += Integer.valueOf(cor.substring(1, 3), 16) + ", ";
        corRGB += Integer.valueOf(cor.substring(3, 5), 16) + ", ";
        corRGB += Integer.valueOf(cor.substring(5, 7), 16) + " )";

        return corRGB;
    }

    private void clip(String cor, View view) {
        ClipData clip = ClipData.newPlainText("cor", cor);
        clipboard.setPrimaryClip(clip);
        Snackbar.make(view, "Cor copiada para área de transferência!", Snackbar.LENGTH_LONG).show();
    }

}
