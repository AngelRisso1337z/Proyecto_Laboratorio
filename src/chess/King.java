/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

public class King extends pieza{

    @Override
    public boolean movimiento(String[][] tabla, int x, int y) {
        boolean mov=false;
        if (tabla[y-1][x].equals("[  ]")) {
            mov=true;
        }
        if (tabla[y][x+1].equals("[  ]")) {
            mov=true;
        }
        if (tabla[y+1][x].equals("[  ]")) {
            mov=true;
        }
        if (tabla[y-1][x-1].equals("[  ]")) {
            mov=true;
        }
        if (tabla[y+1][x+1].equals("[  ]")) {
            mov=true;
        }
        return mov;
    }

    @Override
    public boolean movimientob(String[][] tabla, int x, int y) {
        boolean mov=false;
        if (tabla[y-1][x].equals("[  ]")) {
            mov=true;
        }
        if (tabla[y][x+1].equals("[  ]")) {
            mov=true;
        }
        if (tabla[y+1][x].equals("[  ]")) {
            mov=true;
        }
        if (tabla[y-1][x-1].equals("[  ]")) {
            mov=true;
        }
        if (tabla[y+1][x+1].equals("[  ]")) {
            mov=true;
        }
        return mov;
    }
    
}
