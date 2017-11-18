/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Chess {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("JUGAR AJEDREZ");
        String[][] tabla = {
            {"[rb]", "[hb]", "[bb]", "[kb]", "[qb]", "[bb]", "[hb]", "[rb]"},
            {"[pb]", "[pb]", "[pb]", "[pb]", "[pb]", "[pb]", "[pb]", "[pb]"},
            {"[  ]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]"},
            {"[  ]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]"},
            {"[  ]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]"},
            {"[  ]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]", "[  ]"},
            {"[pw]", "[pw]", "[pw]", "[pw]", "[pw]", "[pw]", "[pw]", "[pw]"},
            {"[rw]", "[hw]", "[bw]", "[kw]", "[qw]", "[bw]", "[hw]", "[rw]"}};
        Jugar(tabla);

    }

    public static void Jugar(String[][] tabla) {
        boolean turno = false;
        boolean ganar = false;
        boolean mov = false;
        char r = 'n';
        int x = 1;
        int y = 1;
        int ban1 = 0, banq = 0;
        while (ganar == false) {
            if (turno == false) {
                System.out.println();
                System.out.println("turno jugador 1");
                imp(tabla, 0, 0);
                try {
                    System.out.println("ingrese que pieza desea mover, en X y Y: ");
                    x = sc.nextInt();
                    y = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("ocurrio un error en el input");
                } catch (Exception e) {
                    System.out.println("ocurrio un error fatal, caso");
                    e.printStackTrace();
                }

                if (tabla[y][x].equals("[pw]") || tabla[y][x].equals("[rw]")
                        || tabla[y][x].equals("[qw]") || tabla[y][x].equals("[kw]") || tabla[y][x].equals("[bw]"
                ) || tabla[y][x].equals("[hw]")) {
                    if (tabla[y][x].equals("[pw]")) {
                        pawn p = new pawn();
                        do {
                            System.out.println("desea mover esta pieza? s/n ");
                            r = sc.next().charAt(0);
                            if (r == 's' || r == 'S') {
                                mov = p.movimiento(tabla, x, y);
                                if (mov) {
                                    tabla[y][x] = "[  ]";
                                    tabla[y - 1][x] = "[pw]";
                                } else {
                                    System.out.println("movimiento illegal, va el siguiente jugador");
                                    turno = true;
                                    break;
                                }

                            } else {
                                try {
                                    System.out.println("ingrese que pieza desea mover, en X y Y: ");
                                    x = sc.nextInt();
                                    y = sc.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("ocurrio un error en el input");
                                } catch (Exception e) {
                                    System.out.println("ocurrio un error fatal, caso");
                                    e.printStackTrace();
                                }
                            }
                        } while (r == 'n');
                    } else if (tabla[y][x].equals("[qw]")) {
                        queen q = new queen();
                        System.out.println("ingrese 1 si es movimiento en X, 0 si va en cruz ");
                        int bool = sc.nextInt();
                        while (bool != 1 && bool != 0) {
                            System.out.println("numero no valido,intente de nuevo");
                            bool = sc.nextInt();
                        }
                        if (bool == 1) {
                            System.out.println("1 derecha,0 izquierda");
                            banq = sc.nextInt();
                            while (banq != 1 && banq != 0) {
                                System.out.println("1 derecha, 0 izquierda");
                            }
                            if (banq == 1) {
                                System.out.println("ingrese cuantos espacios se va a mover");
                                int movq = sc.nextInt();

                                while (movq > tabla.length) {
                                    System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                    movq = sc.nextInt();
                                }
                                System.out.println("1 arriba, 0 abajo");
                                int mova = sc.nextInt();
                                while (mova != 1 && mova != 0) {
                                    System.out.println("1 arriba 0 abajo");
                                    mova = sc.nextInt();
                                }
                                if (mova == 1) {
                                    mov = q.movimiento(tabla, x, y);
                                    if (mov) {
                                        tabla[y][x] = "[  ]";
                                        tabla[y + movq][x + movq] = "[qw]";
                                    } else {
                                        System.out.println("movimiento illegal, va el siguiente jugador");
                                        turno = true;
                                        break;
                                    }
                                } else {
                                    mov = q.movimiento(tabla, x, y);
                                    if (mov) {
                                        tabla[y][x] = "[  ]";
                                        tabla[y - movq][x - movq] = "[qw]";
                                    } else {
                                        System.out.println("movimiento illegal, va el siguiente jugador");
                                        turno = true;
                                        break;
                                    }
                                }

                            } else {
                                System.out.println("ingrese cuantos espacios se va a mover");
                                int movq = sc.nextInt();
                                while (movq > tabla.length) {
                                    System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                    movq = sc.nextInt();
                                }
                                if (mov) {
                                    tabla[y][x] = "[  ]";
                                    tabla[y + movq][x - movq] = "[qw]";
                                } else {
                                    System.out.println("movimiento illegal, va el siguiente jugador");
                                    turno = true;
                                    break;
                                }
                            }

                        } else {
                            //CRUZ
                            System.out.println("1 a los lados,0 a arriba");
                            banq = sc.nextInt();
                            while (banq != 1 && banq != 0) {
                                System.out.println("1 a los lados, 0 a arriba");
                                banq = sc.nextInt();
                            }
                            if (banq == 1) {
                                System.out.println("ingrese cuantos espacios se va a mover");
                                int movq = sc.nextInt();

                                while (movq > tabla.length) {
                                    System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                    movq = sc.nextInt();
                                }
                                q.movimiento(tabla, x, y);
                                if (mov) {
                                    tabla[y][x] = "[qw]";
                                    tabla[y - movq][x] = "[  ]";
                                } else {
                                    System.out.println("movimiento illegal, no puede estar ahi");
                                    turno = true;
                                }
                            } else {

                                System.out.println("ingrese cuantos espacios se va a mover");
                                int movq = sc.nextInt();
                                while (movq > tabla.length) {
                                    System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                    movq = sc.nextInt();
                                }
                                if (mov) {
                                    tabla[y][x] = "[  ]";
                                    tabla[y + movq][x] = "[qw]";
                                } else {
                                    System.out.println("movimiento illegal, va el siguiente jugador");
                                    turno = true;
                                    break;
                                }
                            }
                        }//cruz
                    } else if (tabla[y][x].equals("[bw]")) {
                        bishop re = new bishop();
                        System.out.println("ingrese 1 si es movimiento en X, 0 si va en cruz ");
                        int bool = sc.nextInt();
                        while (bool != 1 && bool != 0) {
                            System.out.println("numero no valido,intente de nuevo");
                            bool = sc.nextInt();
                        }
                        if (bool == 1) {
                            System.out.println("1 derecha,0 izquierda");
                            banq = sc.nextInt();
                            while (banq != 1 && banq != 0) {
                                System.out.println("1 derecha, 0 izquierda");
                            }
                            if (banq == 1) {
                                System.out.println("ingrese cuantos espacios se va a mover");
                                int movq = sc.nextInt();

                                while (movq > tabla.length) {
                                    System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                    movq = sc.nextInt();
                                }
                                System.out.println("1 arriba, 0 abajo");
                                int mova = sc.nextInt();
                                while (mova != 1 && mova != 0) {
                                    System.out.println("1 arriba 0 abajo");
                                    mova = sc.nextInt();
                                }
                                if (mova == 1) {
                                    mov = re.movimiento(tabla, x, y);
                                    if (mov) {
                                        tabla[y][x] = "[  ]";
                                        tabla[y + movq][x + movq] = "[bw]";
                                    } else {
                                        System.out.println("movimiento illegal, va el siguiente jugador");
                                        turno = true;
                                        break;
                                    }
                                } else {
                                    mov = re.movimiento(tabla, x, y);
                                    if (mov) {
                                        tabla[y][x] = "[  ]";
                                        tabla[y - movq][x - movq] = "[bw]";
                                    } else {
                                        System.out.println("movimiento illegal, va el siguiente jugador");
                                        turno = true;
                                        break;
                                    }
                                }

                            } else {
                                System.out.println("ingrese cuantos espacios se va a mover");
                                int movq = sc.nextInt();
                                while (movq > tabla.length) {
                                    System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                    movq = sc.nextInt();
                                }
                                if (mov) {
                                    tabla[y][x] = "[  ]";
                                    tabla[y + movq][x - movq] = "[bw]";
                                } else {
                                    System.out.println("movimiento illegal, va el siguiente jugador");
                                    turno = true;
                                    break;
                                }
                            }
                        }
                    } else if (tabla[x][y].equals("[rw]")) {
                        rook qe = new rook();
                        System.out.println("1 a los lados,0 a arriba");
                        banq = sc.nextInt();
                        while (banq != 1 && banq != 0) {
                            System.out.println("1 a los lados, 0 a arriba");
                            banq = sc.nextInt();
                        }
                        if (banq == 1) {
                            System.out.println("ingrese cuantos espacios se va a mover");
                            int movq = sc.nextInt();

                            while (movq > tabla.length) {
                                System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                movq = sc.nextInt();
                            }
                            qe.movimiento(tabla, x, y);
                            if (mov) {
                                tabla[y][x] = "[rw]";
                                tabla[y - movq][x] = "[  ]";
                            } else {
                                System.out.println("movimiento illegal, no puede estar ahi");
                                turno = true;
                            }
                        } else {

                            System.out.println("ingrese cuantos espacios se va a mover");
                            int movq = sc.nextInt();
                            while (movq > tabla.length) {
                                System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                movq = sc.nextInt();
                            }
                            if (mov) {
                                tabla[y][x] = "[  ]";
                                tabla[y + movq][x] = "[rw]";
                            } else {
                                System.out.println("movimiento illegal, va el siguiente jugador");
                                turno = true;
                                break;
                            }
                        }
                    }else if(tabla[x][y].equals("[kw]")){
                        
                    }

                } else {
                    System.out.println("esta no es su pieza, va el otro jugador");
                    turno = true;
                }
            } else {
                if (tabla[y][x].equals("[pb]") || tabla[y][x].equals("[rb]")
                        || tabla[y][x].equals("[qb]") || tabla[y][x].equals("[kb]") || tabla[y][x].equals("[bb]"
                ) || tabla[y][x].equals("[hb]")) {
                    if (tabla[y][x].equals("[pb]")) {
                        pawn p = new pawn();
                        do {
                            System.out.println("desea mover esta pieza? s/n ");
                            r = sc.next().charAt(0);
                            if (r == 's' || r == 'S') {
                                mov = p.movimientob(tabla, x, y);
                                if (mov) {
                                    tabla[y][x] = "[  ]";
                                    tabla[y + 1][x] = "[pw]";
                                } else {
                                    System.out.println("movimiento illegal, va el siguiente jugador");
                                    turno = true;
                                    break;
                                }

                            } else {
                                try {
                                    System.out.println("ingrese que pieza desea mover, en X y Y: ");
                                    x = sc.nextInt();
                                    y = sc.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("ocurrio un error en el input");
                                } catch (Exception e) {
                                    System.out.println("ocurrio un error fatal, caso");
                                    e.printStackTrace();
                                }
                            }
                        } while (r == 'n');
                    } else if (tabla[y][x].equals("[qb]")) {
                        queen q = new queen();
                        System.out.println("ingrese 1 si es movimiento en X, 0 si va en cruz ");
                        int bool = sc.nextInt();
                        while (bool != 1 && bool != 0) {
                            System.out.println("numero no valido,intente de nuevo");
                            bool = sc.nextInt();
                        }
                        if (bool == 1) {
                            System.out.println("1 derecha,0 izquierda");
                            banq = sc.nextInt();
                            while (banq != 1 && banq != 0) {
                                System.out.println("1 derecha, 0 izquierda");
                            }
                            if (banq == 1) {
                                System.out.println("ingrese cuantos espacios se va a mover");
                                int movq = sc.nextInt();

                                while (movq > tabla.length) {
                                    System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                    movq = sc.nextInt();
                                }
                                System.out.println("1 arriba, 0 abajo");
                                int mova = sc.nextInt();
                                while (mova != 1 && mova != 0) {
                                    System.out.println("1 arriba 0 abajo");
                                    mova = sc.nextInt();
                                }
                                if (mova == 1) {
                                    mov = q.movimientob(tabla, x, y);
                                    if (mov) {
                                        tabla[y][x] = "[  ]";
                                        tabla[y + movq][x + movq] = "[qb]";
                                    } else {
                                        System.out.println("movimiento illegal, va el siguiente jugador");
                                        turno = true;
                                        break;
                                    }
                                } else {
                                    mov = q.movimiento(tabla, x, y);
                                    if (mov) {
                                        tabla[y][x] = "[  ]";
                                        tabla[y - movq][x - movq] = "[qb]";
                                    } else {
                                        System.out.println("movimiento illegal, va el siguiente jugador");
                                        turno = true;
                                        break;
                                    }
                                }

                            } else {
                                System.out.println("ingrese cuantos espacios se va a mover");
                                int movq = sc.nextInt();
                                while (movq > tabla.length) {
                                    System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                    movq = sc.nextInt();
                                }
                                if (mov) {
                                    tabla[y][x] = "[  ]";
                                    tabla[y + movq][x - movq] = "[qb]";
                                } else {
                                    System.out.println("movimiento illegal, va el siguiente jugador");
                                    turno = true;
                                    break;
                                }
                            }

                        } else {
                            //CRUZ
                            System.out.println("1 a los lados,0 a arriba");
                            banq = sc.nextInt();
                            while (banq != 1 && banq != 0) {
                                System.out.println("1 a los lados, 0 a arriba");
                                banq = sc.nextInt();
                            }
                            if (banq == 1) {
                                System.out.println("ingrese cuantos espacios se va a mover");
                                int movq = sc.nextInt();

                                while (movq > tabla.length) {
                                    System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                    movq = sc.nextInt();
                                }
                                q.movimiento(tabla, x, y);
                                if (mov) {
                                    tabla[y][x] = "[qb]";
                                    tabla[y - movq][x] = "[  ]";
                                } else {
                                    System.out.println("movimiento illegal, no puede estar ahi");
                                    turno = true;
                                }
                            } else {

                                System.out.println("ingrese cuantos espacios se va a mover");
                                int movq = sc.nextInt();
                                while (movq > tabla.length) {
                                    System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                    movq = sc.nextInt();
                                }
                                if (mov) {
                                    tabla[y][x] = "[  ]";
                                    tabla[y + movq][x] = "[qb]";
                                } else {
                                    System.out.println("movimiento illegal, va el siguiente jugador");
                                    turno = true;
                                    break;
                                }
                            }
                        }//cruz
                    } else if (tabla[y][x].equals("[bb]")) {
                        bishop re = new bishop();
                        System.out.println("ingrese 1 si es movimiento en X, 0 si va en cruz ");
                        int bool = sc.nextInt();
                        while (bool != 1 && bool != 0) {
                            System.out.println("numero no valido,intente de nuevo");
                            bool = sc.nextInt();
                        }
                        if (bool == 1) {
                            System.out.println("1 derecha,0 izquierda");
                            banq = sc.nextInt();
                            while (banq != 1 && banq != 0) {
                                System.out.println("1 derecha, 0 izquierda");
                            }
                            if (banq == 1) {
                                System.out.println("ingrese cuantos espacios se va a mover");
                                int movq = sc.nextInt();

                                while (movq > tabla.length) {
                                    System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                    movq = sc.nextInt();
                                }
                                System.out.println("1 arriba, 0 abajo");
                                int mova = sc.nextInt();
                                while (mova != 1 && mova != 0) {
                                    System.out.println("1 arriba 0 abajo");
                                    mova = sc.nextInt();
                                }
                                if (mova == 1) {
                                    mov = re.movimiento(tabla, x, y);
                                    if (mov) {
                                        tabla[y][x] = "[  ]";
                                        tabla[y + movq][x + movq] = "[bb]";
                                    } else {
                                        System.out.println("movimiento illegal, va el siguiente jugador");
                                        turno = true;
                                        break;
                                    }
                                } else {
                                    mov = re.movimientob(tabla, x, y);
                                    if (mov) {
                                        tabla[y][x] = "[  ]";
                                        tabla[y - movq][x - movq] = "[bb]";
                                    } else {
                                        System.out.println("movimiento illegal, va el siguiente jugador");
                                        turno = true;
                                        break;
                                    }
                                }

                            } else {
                                System.out.println("ingrese cuantos espacios se va a mover");
                                int movq = sc.nextInt();
                                while (movq > tabla.length) {
                                    System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                    movq = sc.nextInt();
                                }
                                if (mov) {
                                    tabla[y][x] = "[  ]";
                                    tabla[y + movq][x - movq] = "[bw]";
                                } else {
                                    System.out.println("movimiento illegal, va el siguiente jugador");
                                    turno = true;
                                    break;
                                }
                            }
                        }
                    } else if (tabla[x][y].equals("[rb]")) {
                        rook qe = new rook();
                        System.out.println("1 arriba,0 a los lados");
                        banq = sc.nextInt();
                        while (banq != 1 && banq != 0) {
                            System.out.println("1 arriba, 0 a los lados");
                            banq = sc.nextInt();
                        }
                        if (banq == 1) {
                            System.out.println("ingrese cuantos espacios se va a mover");
                            int movq = sc.nextInt();

                            while (movq > tabla.length) {
                                System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                movq = sc.nextInt();
                            }
                            qe.movimiento(tabla, x, y);
                            if (mov) {
                                tabla[y][x] = "[rb]";
                                tabla[y - movq][x] = "[  ]";
                            } else {
                                System.out.println("movimiento illegal, no puede estar ahi");
                                turno = true;
                            }
                        } else {

                            System.out.println("ingrese cuantos espacios se va a mover");
                            int movq = sc.nextInt();
                            while (movq > tabla.length) {
                                System.out.println("esto pondria la pieza afuera de la tabla\n intente de nuevo");
                                movq = sc.nextInt();
                            }
                            if (mov) {
                                tabla[y][x] = "[  ]";
                                tabla[y + movq][x] = "[rb]";
                            } else {
                                System.out.println("movimiento illegal, va el siguiente jugador");
                                turno = true;
                                break;
                            }
                        }
                    }

                } else {
                    System.out.println("esta no es su pieza, va el otro jugador");
                    turno = true;
                }

            }
        }
    }

    public static void imp(String[][] tab, int fil, int col) {
        if (fil == tab.length - 1 && col == tab[0].length - 1) {
            System.out.print(tab[fil][col]);
        } else if (col == tab[0].length - 1) {
            System.out.println(tab[fil][col]);
            imp(tab, fil + 1, 0);
        } else {
            System.out.print(tab[fil][col]);
            imp(tab, fil, col + 1);
        }

    }

}
