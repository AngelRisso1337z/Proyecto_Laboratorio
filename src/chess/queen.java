/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author HP_AMD_64
 */
public class queen extends pieza {

    public queen() {
    }

    @Override
    public boolean movimiento(String[][] tabla, int x, int y) {
        boolean mov = false;
        if (tabla[y - 1][x - 1].equals("[  ]")) {
            mov = true;
        } else {
            mov = false;
        }
        if (tabla[y - 1][x + 1].equals("[  ]")) {
            mov = true;
        } else {
            mov = false;
        }
        if (tabla[y - 1][x].equals("[  ]")) {
            mov = true;
        } else {
            mov = false;
        }

        return mov;
    }

    @Override
    public boolean movimientob(String[][] tabla, int x, int y) {
        boolean mov = false;
        if (tabla[y + 1][x + 1].equals("[  ]")) {
            mov = true;
        } else {
            mov = false;
        }
        if (tabla[y - 1][x + 1].equals("[  ]")) {
            mov = true;
        } else {
            mov = false;
        }
        if (tabla[y - 1][x].equals("[  ]")) {
            mov = true;
        } else {
            mov = false;
        }
        return mov;
    }

}
