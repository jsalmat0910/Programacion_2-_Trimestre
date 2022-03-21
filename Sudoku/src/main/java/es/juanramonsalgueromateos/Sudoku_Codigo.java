package es.juanramonsalgueromateos.sudoku;

import java.util.Random;

/**
 *
 * @author Juan Ramón Salguero Mateos
 */
public class Sudoku_Codigo {
    
    Random azar = new Random();
    int nivel = azar.nextInt(3);
    
    //Metodo para cargar el juego.
    public  int[][] cargarJuego(int nivel) {
        int[][] matriz = new int[9][9];
        switch (nivel) {

            case 0:
            // Números del tablero fijos.
                matriz[0][0] = 5;
                matriz[0][1] = 3;
                matriz[0][4] = 7;
                matriz[1][0] = 6;
                matriz[1][3] = 1;
                matriz[1][4] = 9;
                matriz[1][5] = 5;
                matriz[2][1] = 9;
                matriz[2][2] = 8;
                matriz[2][7] = 6;
                matriz[3][0] = 8;
                matriz[3][4] = 6;
                matriz[3][8] = 3;
                matriz[4][0] = 4;
                matriz[4][3] = 8;
                matriz[4][5] = 3;
                matriz[4][8] = 1;
                matriz[5][0] = 7;
                matriz[5][4] = 2;
                matriz[5][8] = 6;
                matriz[6][1] = 6;
                matriz[6][6] = 2;
                matriz[6][7] = 8;
                matriz[7][3] = 4;
                matriz[7][4] = 1;
                matriz[7][5] = 9;
                matriz[7][8] = 5;
                matriz[8][4] = 8;
                matriz[8][7] = 7;
                matriz[8][8] = 9;
            
            // Número para solucion del tablero:
            /*    matriz[0][2] = 4;
                matriz[0][3] = 6;
                matriz[0][5] = 8;
                matriz[0][6] = 9;
                matriz[0][7] = 1;
                matriz[0][8] = 2;
                
                matriz[1][1] = 7;
                matriz[1][2] = 2;
                matriz[1][6] = 3;
                matriz[1][7] = 4;
                matriz[1][8] = 8;
                
                matriz[2][0] = 1;
                matriz[2][3] = 3;
                matriz[2][4] = 4;
                matriz[2][5] = 2;
                matriz[2][6] = 5;
                matriz[2][8] = 7;
                
                matriz[3][1] = 5;
                matriz[3][2] = 9;
                matriz[3][3] = 7;
                matriz[3][5] = 1;
                matriz[3][6] = 4;
                matriz[3][7] = 2;
                
                matriz[4][1] = 2;
                matriz[4][2] = 6;
                matriz[4][4] = 5;
                matriz[4][6] = 7;
                matriz[4][7] = 9;
                
                matriz[5][1] = 1;
                matriz[5][2] = 3;
                matriz[5][3] = 9;
                matriz[5][5] = 4;
                matriz[5][6] = 8;
                matriz[5][7] = 5;
                
                matriz[6][0] = 9;
                matriz[6][2] = 1;
                matriz[6][3] = 5;
                matriz[6][4] = 3;
                matriz[6][5] = 7;
                //matriz[6][8] = 4;
                
                matriz[7][0] = 2;
                matriz[7][1] = 8;
                matriz[7][2] = 7;
                matriz[7][6] = 6;
                matriz[7][7] = 3;
                
                matriz[8][0] = 3;
                matriz[8][1] = 4;
                matriz[8][2] = 5;
                matriz[8][3] = 2;
                matriz[8][5] = 6;
                matriz[8][6] = 1;  */

                break;

            case 1:
            // Números del tablero fijos.
                matriz[0][3] = 4;
                matriz[0][4] = 6;
                matriz[1][0] = 8;
                matriz[1][1] = 4;
                matriz[1][8] = 3;
                matriz[2][1] = 5;
                matriz[2][4] = 8;
                matriz[3][0] = 3;
                matriz[3][1] = 1;
                matriz[3][2] = 2;
                matriz[3][4] = 5;
                matriz[3][6] = 4;
                matriz[4][3] = 3;
                matriz[5][3] = 1;
                matriz[5][5] = 6;
                matriz[6][0] = 2;
                matriz[6][6] = 9;
                matriz[6][7] = 8;
                matriz[7][5] = 7;
                matriz[7][8] = 4;
                matriz[8][1] = 9;
                matriz[8][2] = 5;
                matriz[8][4] = 2;
                matriz[8][7] = 1;
            
            // Número para solucion del tablero:
             /*   matriz[0][0] = 1;
                matriz[0][1] = 2;
                matriz[0][2] = 3;
                matriz[0][5] = 9;
                matriz[0][6] = 7;
                matriz[0][7] = 5;
                matriz[0][8] = 8;
                
                matriz[1][2] = 6;
                matriz[1][3] = 5;
                matriz[1][4] = 7;
                matriz[1][5] = 1;
                matriz[1][6] = 2;
                matriz[1][7] = 9;
                
                matriz[2][0] = 9;
                matriz[2][2] = 7;
                matriz[2][3] = 2;
                matriz[2][5] = 3;
                matriz[2][6] = 6;
                matriz[2][7] = 4;
                matriz[2][8] = 1;
                
                matriz[3][3] = 7;
                matriz[3][5] = 8;
                matriz[3][7] = 6;
                matriz[3][8] = 9;
                
                matriz[4][0] = 4;
                matriz[4][1] = 6;
                matriz[4][2] = 8;
                //matriz[4][4] = 9;
                matriz[4][5] = 2;
                matriz[4][6] = 1;
                matriz[4][7] = 7;
                matriz[4][8] = 5;
                
                matriz[5][0] = 5;
                matriz[5][1] = 7;
                matriz[5][2] = 9;
                matriz[5][4] = 4;
                matriz[5][6] = 8;
                matriz[5][7] = 3;
                matriz[5][8] = 2;
                
                matriz[6][1] = 3;
                matriz[6][2] = 4;
                matriz[6][3] = 6;
                matriz[6][4] = 1;
                matriz[6][5] = 5;
                matriz[6][8] = 7;
                
                matriz[7][0] = 6;
                matriz[7][1] = 8;
                matriz[7][2] = 1;
                matriz[7][3] = 9;
                matriz[7][4] = 3;
                matriz[7][6] = 5;
                matriz[7][7] = 2;
                
                matriz[8][0] = 7;
                matriz[8][3] = 8;
                matriz[8][5] = 4;
                matriz[8][6] = 3;
                matriz[8][8] = 6;    */           
                
                break;
            
            case 2:
            // Números del tablero fijos.
                matriz[0][1] = 7;
                matriz[0][2] = 8;
                matriz[0][7] = 5;
                matriz[1][0] = 6;
                matriz[1][2] = 3;
                matriz[1][4] = 1;
                matriz[1][5] = 5;
                matriz[1][8] = 8;
                matriz[2][1] = 2;
                matriz[2][3] = 4;
                matriz[2][4] = 6;
                matriz[2][7] = 9;
                matriz[2][8] = 7;
                matriz[3][0] = 1;
                matriz[3][5] = 4;
                matriz[4][3] = 1;
                matriz[4][4] = 5;
                matriz[4][6] = 2;
                matriz[4][8] = 6;
                matriz[5][0] = 7;
                matriz[5][2] = 2;
                matriz[5][3] = 6;
                matriz[5][6] = 5;
                matriz[6][1] = 5;
                matriz[6][5] = 1;
                matriz[6][7] = 7;
                matriz[6][8] = 3;
                matriz[7][0] = 8;
                matriz[7][2] = 4;
                matriz[7][5] = 3;
                matriz[8][0] = 9;
                matriz[8][4] = 8;
                matriz[8][6] = 1;
                matriz[8][8] = 2;
               
            // Número para solucion del tablero:
            /*    matriz[0][0] = 4;
                matriz[0][3] = 3;
                matriz[0][4] = 9;
                matriz[0][5] = 2;
                matriz[0][6] = 6;
                matriz[0][8] = 1;
                
                matriz[1][1] = 9;
                matriz[1][3] = 7;
                matriz[1][6] = 4;
                matriz[1][7] = 2;
                
                matriz[2][0] = 5;
                matriz[2][2] = 1;
                matriz[2][5] = 8;
                matriz[2][6] = 3;
                
                matriz[3][1] = 6;
                //matriz[3][2] = 5;
                matriz[3][3] = 8;
                matriz[3][4] = 2;
                matriz[3][6] = 7;
                matriz[3][7] = 3;
                matriz[3][8] = 9;
                
                matriz[4][0] = 3;
                matriz[4][1] = 4;
                matriz[4][2] = 9;
                matriz[4][5] = 7;
                matriz[4][7] = 8;
                
                matriz[5][1] = 8;
                matriz[5][4] = 3;
                matriz[5][5] = 9;
                matriz[5][7] = 1;
                matriz[5][8] = 4;
                
                matriz[6][0] = 2;
                matriz[6][2] = 6;
                matriz[6][3] = 9;
                matriz[6][4] = 4;
                matriz[6][6] = 8;
                
                matriz[7][1] = 1;
                matriz[7][3] = 2;
                matriz[7][4] = 7;
                matriz[7][6] = 9;
                matriz[7][7] = 6;
                matriz[7][8] = 5;
                
                matriz[8][1] = 3;
                matriz[8][2] = 7;
                matriz[8][3] = 5;
                matriz[8][5] = 6;
                matriz[8][7] = 4;*/
                
                break;
                
            case 3:
            // Números del tablero fijos.
                matriz[0][1] = 9;
                matriz[0][5] = 6;
                matriz[0][6] = 1;
                matriz[1][0] = 7;
                matriz[1][1] = 1;
                matriz[1][4] = 9;
                matriz[1][7] = 2;
                matriz[1][8] = 8;
                matriz[2][2] = 8;
                matriz[2][7] = 4;
                matriz[2][8] = 9;
                matriz[3][1] = 6;
                matriz[3][3] = 2;
                matriz[3][4] = 5;
                matriz[3][8] = 1;
                matriz[5][0] = 5;
                matriz[5][4] = 6;
                matriz[5][5] = 9;
                matriz[5][7] = 7;
                matriz[6][0] = 1;
                matriz[6][1] = 2;
                matriz[6][6] = 8;
                matriz[7][0] = 9;
                matriz[7][1] = 8;
                matriz[7][4] = 4;
                matriz[7][7] = 5;
                matriz[7][8] = 2;
                matriz[8][2] = 5;
                matriz[8][3] = 6;
                matriz[8][7] = 1;
                
            // Número para solucion del tablero:
            /*    matriz[0][0] = 4;
                matriz[0][2] = 2;
                matriz[0][3] = 7;
                matriz[0][4] = 8;
                matriz[0][7] = 3;
                matriz[0][8] = 5;
                
                matriz[1][2] = 3;
                matriz[1][3] = 5;
                matriz[1][5] = 4;
                matriz[1][6] = 6;
                
                matriz[2][0] = 6;
                matriz[2][1] = 5;
                matriz[2][3] = 3;
                matriz[2][4] = 1;
                matriz[2][5] = 2;
                matriz[2][6] = 7;
                
                matriz[3][0] = 8;
                matriz[3][2] = 7;
                matriz[3][5] = 3;
                matriz[3][6] = 4;
                matriz[3][7] = 9;
                
                matriz[4][0] = 2;
                //matriz[4][1] = 3;
                matriz[4][2] = 9;
                matriz[4][3] = 4;
                matriz[4][4] = 7;
                matriz[4][5] = 1;
                matriz[4][6] = 5;
                matriz[4][7] = 8;
                matriz[4][8] = 6;
                
                matriz[5][1] = 4;
                matriz[5][2] = 1;
                matriz[5][3] = 8;
                matriz[5][6] = 2;
                matriz[5][8] = 3;
                
                matriz[6][2] = 4;
                matriz[6][3] = 9;
                matriz[6][4] = 3;
                matriz[6][5] = 5;
                matriz[6][7] = 6;
                matriz[6][8] = 7;
                
                matriz[7][2] = 6;
                matriz[7][3] = 1;
                matriz[7][5] = 7;
                matriz[7][6] = 3;
                
                matriz[8][0] = 3;
                matriz[8][1] = 7;
                matriz[8][4] = 2;
                matriz[8][5] = 8;
                matriz[8][6] = 9;
                matriz[8][8] = 4;*/
                
                break;
        }
        return matriz;
    }

    //Metodo para no sobreescribir valores en el juego.
    public  boolean origen(int fila, int columna, int[][] matriz) {

        boolean resultado = false;
        if (matriz[fila][columna] != 0) {
            resultado = true;
        }

        return resultado;

    }

    //Metodo que detecta si el juego fue terminado.
    public  boolean terminado(int[][] matriz) {

        boolean resultado = true;

        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[0].length; c++) {
                if (matriz[f][c] == 0) {
                    resultado = false;
                }
            }
        }


        return resultado;

    }

    //Metodo que imprime un mensaje con borde.
    public  void mensaje(String mensaje) {
        //Cabecera
        System.out.println(" ");
        System.out.print("Resultado: ");
        //Cuerpo.
        System.out.print(mensaje);
        System.out.println(" ");
        System.out.println(" ");
    }

    //Metodo que imprime el vector.
    public  void imprimeVector(int[][] matriz) {


        System.out.println("  -----------  -----------  -----------  ");

        for (int f = 0; f < matriz.length; f++) {

            System.out.print(" | ");

            for (int c = 0; c < matriz.length; c++) {

                if (matriz[f][c] != 0) {
                    System.out.print(matriz[f][c]);
                } else {
                    System.out.print(" ");
                }

                if (origen(f, c, cargarJuego(nivel))) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }

                if (c == 2 || c == 5) {
                    System.out.print("|| ");
                } else {
                    System.out.print("| ");
                }

            }
            System.out.println();
            if (f != 2 && f != 5) {
                System.out.print("  -----------  -----------  -----------  ");
            } else {
                System.out.print("  :::::::::::::::::::::::::::::::::::::: ");
            }
            System.out.println();
        }
    }

    //Metodo para comprobar filas.
    public  boolean existeFila(int numero, int fila, int[][] matriz) {

        boolean resultado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[(fila - 1)][i] == numero) {
                resultado = true;
                break;
            }
        }
        return resultado;

    }

    //Metodo para comprobar columnas.
    public  boolean existeColumna(int numero, int columna, int[][] matriz) {

        boolean resultado = false;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][(columna - 1)] == numero) {
                resultado = true;
                break;
            }
        }

        //Comprobamos si es 0.
        if (numero == 0) {
            resultado = false;
        }

        return resultado;

    }

    // Metodo para comprobar indices.
    public  boolean comprobarIndice(int indice) {

        if (indice > 0 && indice < 10) {
            return true;
        } else {
            return false;
        }

    }

    // Metodo para comprobar los valores.
    public  boolean comprobarValor(int valor) {

        if (valor >= 0 && valor < 10) {
            return true;
        } else {
            return false;
        }

    }

    //Metodo para comprobar las cajas.
    public  boolean existeCaja(int valor, int fila, int columna, int[][] matriz) {

        //Variables.
        int minimo_fila;
        int maximo_fila;
        int minimo_columna;
        int maximo_columna;
        boolean resultado = false;

        //Determinamos las filas de la caja.
        if (fila > 0 && fila < 4) {
            minimo_fila = 0;
            maximo_fila = 2;
        } else if (fila > 3 && fila < 7) {
            minimo_fila = 3;
            maximo_fila = 5;
        } else {
            minimo_fila = 6;
            maximo_fila = 8;
        }

        //Determinamos las columnas de la caja.
        if (columna > 0 && columna < 4) {
            minimo_columna = 0;
            maximo_columna = 2;
        } else if (columna > 3 && columna < 7) {
            minimo_columna = 3;
            maximo_columna = 5;
        } else {
            minimo_columna = 6;
            maximo_columna = 8;
        }

        //Recorremos el rango de la caja, y  buscamos el valor.
        for (int f = minimo_fila; f <= maximo_fila; f++) {
            for (int c = minimo_columna; c <= maximo_columna; c++) {
                if (matriz[f][c] == valor) {
                    resultado = true;
                    break;

                }
            }
        }


        //Comprobamos si es 0.
        if (valor == 0) {
            resultado = false;
        }

        //Regresamos el valor booleano(Azar).
        return resultado;
    }
    
}
