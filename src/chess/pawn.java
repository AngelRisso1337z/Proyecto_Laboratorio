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
public class pawn extends pieza {

    public pawn() {
        super();
    }

    public pawn(boolean mover, int movx, int movy) {
        super(mover, movx, movy);
    }

    @Override
    public boolean movimiento(String[][] tabla, int x, int y) {
        boolean mov = false;

        mov = tabla[y-1][x].equals("[  ]");

        return mov;
    }

    @Override
    public boolean movimientob(String[][] tabla, int x, int y) {
        boolean mov = false;

        mov = tabla[y+1][x].equals("[  ]");

        return mov;
    }
}
