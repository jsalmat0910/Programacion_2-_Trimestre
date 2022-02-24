package es.juanramonsalgueromateos.sudoku;

import java.util.Random;

/**
 *
 * @author Juan Ramón Salguero Mateos
 */
public class Sudoku_Codigo {
    public int[][] matriz = new int[9][9];
        Random azar = new Random();
        int fila = azar.nextInt(9);
        int columna = azar.nextInt(9);
    
    
    public int[][] cargar_juego() {
        
        matriz[0][2] = 9;
        matriz[0][0] = 1;
        matriz[0][5] = 8;
        matriz[0][6] = 5;
        matriz[0][7] = 4;
        matriz[1][8] = 7;
        matriz[2][1] = 5;
        matriz[2][2] = 4;
        matriz[2][4] = 9;
        matriz[2][6] = 1;
        matriz[3][3] = 4;
        matriz[3][5] = 6;
        matriz[3][6] = 3;
        matriz[3][7] = 2;
        matriz[4][1] = 8;
        matriz[4][2] = 2;
        matriz[4][6] = 4;
        matriz[4][7] = 1;
        matriz[5][1] = 3;
        matriz[5][2] = 5;
        matriz[5][3] = 2;
        matriz[5][5] = 1;
        matriz[6][2] = 7;
        matriz[6][4] = 3;
        matriz[6][6] = 2;
        matriz[6][7] = 5;
        matriz[7][0] = 9;
        matriz[7][4] = 1;
        matriz[8][1] = 4;
        matriz[8][2] = 3;
        matriz[8][3] = 8;
        matriz[8][7] = 9;
        return matriz;


    }
    
    
    // Metodo para comprobar los valores.
    public boolean comprobar_valor(String valor1) {

        if (String.valueOf(valor1).equalsIgnoreCase("")) {
            return false;
        } else {
            int valor = Integer.valueOf(valor1);
            if (valor >= 0 && valor < 10) {
                return true;
            } else {
                return false;
            }
        }

    }
    
    
    //Metodo para comrpobar filas.
    public boolean existe_fila(int numero, int fila) {

        boolean resultado = false;
       // int a = matriz[0][2];
        for (int i = 0; i < matriz.length; i++) {
            if (numero == 0) {
            } else {
                if (matriz[fila][i] == numero) {
                    resultado = true;
                    break;
                }
            }
        }
        return resultado;

    }

    //Metodo para comprobar columnas.
    public boolean existe_columna(int numero, int columna) {

        boolean resultado = false;
        //int a = matriz[7][0];
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][columna] == numero) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public boolean existe_caja(int valor, int fila, int columna) {

        //Variables.
        int minimo_fila;
        int maximo_fila;
        int minimo_columna;
        int maximo_columna;
        boolean resultado = false;

        //Determinamos las filas de la caja.
        if (fila >= 0 && fila < 3) {
            minimo_fila = 0;
            maximo_fila = 2;
        } else if (fila >= 3 && fila < 6) {
            minimo_fila = 3;
            maximo_fila = 5;
        } else {
            minimo_fila = 6;
            maximo_fila = 8;
        }

        //Determinamos las columnas de la caja.
        if (columna >= 0 && columna < 3) {
            minimo_columna = 0;
            maximo_columna = 2;
        } else if (columna >= 3 && columna < 6) {
            minimo_columna = 3;
            maximo_columna = 5;
        } else {
            minimo_columna = 6;
            maximo_columna = 8;
        }

        //Recorremos el rango de la caja, y buscamos el valor.
        for (int f = minimo_fila; f <= maximo_fila; f++) {
            for (int c = minimo_columna; c <= maximo_columna; c++) {
                if (valor == 0) {
                } else {
                    if (matriz[f][c] == valor) {
                        resultado = true;
                        break;

                    }
                }
            }
        }
        
        //Regresamos el valor booleano(Azar).
        return resultado;



    }


    //Metodo que detecta si el juego fue terminado.
	public static boolean terminado( int[][] matriz ){

		boolean resultado = true;

		for ( int f = 0; f < matriz.length; f ++)
			for ( int c = 0; c < matriz[0].length; c ++)
				if ( matriz[f][c] == 0 )
					resultado = false;

                              
                              return resultado;

	}

    
}
