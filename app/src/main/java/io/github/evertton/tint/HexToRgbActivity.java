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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Definição da atividade HEX para RGB.
 *
 * @author Evertton de Lima <e.everttonlima@gmail.com>
 */
public class HexToRgbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex_to_rgb);
    }
}
