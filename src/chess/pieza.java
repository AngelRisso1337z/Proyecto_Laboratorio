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
public abstract class pieza {

    private boolean mover;
    private int movx;
    private int movy;

    public pieza() {
    }
    

    public pieza(boolean mover, int movx, int movy) {
        this.mover = mover;
        this.movx = movx;
        this.movy = movy;
    }

    public boolean Mover() {
        return mover;
    }

    public boolean isMover() {
        return mover;
    }

    public void setMover(boolean mover) {
        this.mover = mover;
    }

    public int getMovx() {
        return movx;
    }

    public void setMovx(int movx) {
        this.movx = movx;
    }

    public int getMovy() {
        return movy;
    }

    public void setMovy(int movy) {
        this.movy = movy;
    }

    
        
    public abstract boolean movimiento(String [][]tabla,int x, int y);
    public abstract boolean  movimientob(String [][]tabla,int x, int y);
}
