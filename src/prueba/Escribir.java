/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author alex
 */
public class Escribir {
    private String[][] matrizA;
    private final int[] pfuno;
    private final int[] pfdos;
    private final int[] pftres;
    private final int[] pfcuatro;
    private final int[] pfcinco;
    static final String x = "x";
    static final String y = "y";
    static final String vertical = "|";
    static final String horizontal = "-";
    // TODO code application logic here
    private int size;
    // Calcular numero de filas
    private int fila;
    private int col;
    private int tfila;
    private int tcol;

    public Escribir() {
        // inicio de variables
        this.pfuno = new int[2];
        this.pfdos = new int[2];
        this.pftres = new int[2];
        this.pfcuatro = new int[2];
        this.pfcinco = new int[2];
    }

    /**
    agregar linea a la matrizA
    matriz impresion
    size tamaño
    fijo posicion fijo
    punto pivote
    caracter caracter de segmento
     */    
    private void agregainea(String[][] matriz, int[] punto, String fijo,
            int size, String caracter) {

        if (fijo.equalsIgnoreCase(x)) 
        {
            for (int y = 1; y <= size; y++) 
            {
                int valor = punto[1] + y;
                matriz[punto[0]][valor] = caracter;
            }
        } 
        else 
        {
            for (int i = 1; i <= size; i++) 
            {
                int valor = punto[0] + i;
                matriz[valor][punto[1]] = caracter;
            }
        }
    }

    /**
    segmento por adicion
     */  
    private void agregarseg(int segmento) {

        switch (segmento) {
            case 1:
                agregainea(this.matrizA, this.pfuno, y,
                        this.size, vertical);
                break;
            case 2:
                agregainea(this.matrizA, this.pfdos, y,
                        this.size, vertical);
                break;
            case 3:
                agregainea(this.matrizA, this.pfcinco, y,
                        this.size, vertical);
                break;
            case 4:
                agregainea(this.matrizA, this.pfcuatro, y,
                        this.size, vertical);
                break;
            case 5:
                agregainea(this.matrizA, this.pfuno, x,
                        this.size, horizontal);
                break;
            case 6:
                agregainea(this.matrizA, this.pfdos, x,
                        this.size, horizontal);
                break;
            case 7:
                agregainea(this.matrizA, this.pftres, x,
                        this.size, horizontal);
                break;
            default:
                break;
        }
    }

    /**
    segmentos por digito
    numero digito
     */
    private void agregadigito(int numero) {

        // Establece los segmentos del numero
        List<Integer> segList = new ArrayList<>();

        switch (numero) {
            case 1:
                segList.add(3);
                segList.add(4);
                break;
            case 2:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                break;
            case 3:
                segList.add(5);
                segList.add(3);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 4:
                segList.add(1);
                segList.add(6);
                segList.add(3);
                segList.add(4);
                break;
            case 5:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(4);
                segList.add(7);
                break;
            case 6:
                segList.add(5);
                segList.add(1);
                segList.add(6);
                segList.add(2);
                segList.add(7);
                segList.add(4);
                break;
            case 7:
                segList.add(5);
                segList.add(3);
                segList.add(4);
                break;
            case 8:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 9:
                segList.add(1);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(6);
                segList.add(7);
                break;
            case 0:
                segList.add(1);
                segList.add(2);
                segList.add(3);
                segList.add(4);
                segList.add(5);
                segList.add(7);
                break;
            default:
                break;
        }

        Iterator<Integer> iterator = segList.iterator();

        while (iterator.hasNext()) {
            agregarseg(iterator.next());
        }
    }

    /**
    imprimir un numero
    size tamaño de segmento
    numi numero a imprimir
    espacio Espacio Entre digitos
     */    
    private void impnum(int size, String numi, int espacio) 
    {
        int pivotex = 0;
        char[] digitos;

        this.size = size;

        this.fila = (2 * this.size) + 3;

        this.col = this.size + 2;

        this.tfila = this.fila;

        this.tcol = (this.col * numi.length())+ (espacio * numi.length());

        //matriz para almacenar numeros
        this.matrizA = new String[this.tfila][this.tcol];

        //arreglo para digitos
        digitos = numi.toCharArray();

        for (int i = 0; i < this.tfila; i++) {
            for (int j = 0; j < this.tcol; j++) {
                this.matrizA[i][j] = " ";
            }
        }

        for (char digito : digitos) {
            
            if( ! Character.isDigit(digito))
            {
                throw new IllegalArgumentException("Caracter " + digito
                    + " no es un digito");
            }

            int numero = Integer.parseInt(String.valueOf(digito));

            //punto constante
            this.pfuno[0] = 0;
            this.pfuno[1] = 0 + pivotex;

            this.pfdos[0] = (this.fila / 2);
            this.pfdos[1] = 0 + pivotex;

            this.pftres[0] = (this.fila - 1);
            this.pftres[1] = 0 + pivotex;

            this.pfcuatro[0] = (this.col - 1);
            this.pfcuatro[1] = (this.fila / 2) + pivotex;

            this.pfcinco[0] = 0;
            this.pfcinco[1] = (this.col - 1) + pivotex;

            pivotex = pivotex + this.col + espacio;

            agregadigito(numero);
        }
        
        for (int i = 0; i < this.tfila; i++) {
            for (int j = 0; j < this.tcol; j++) {
                System.out.print(this.matrizA[i][j]);
            }
            System.out.println();
        }
    }

     /**
     * @param comando size
     * @param espacios entre digitos
     */  
    public void crear(String comando, int espacios) {
        
        String[] parametros;
        
        int tam;

        if (!comando.contains(",")) {
            throw new IllegalArgumentException("Necesario , " + comando+ " no contiene ,");
        }
        
        parametros = comando.split(",");
        
        if(parametros.length>2)
        {
           throw new IllegalArgumentException("Entrada " + comando+ " solo admite una ,"); 
        }
        
        //Valida la cantidad de parametros
        if(parametros.length<2)
        {
           throw new IllegalArgumentException("Entrada " + comando+ " no contiene los parametros necesarios"); 
        }
        
        if(isNumeric(parametros[0]))
        {
            tam = Integer.parseInt(parametros[0]);
            
            if(tam <1 || tam >10)
            {
                throw new IllegalArgumentException("Solo admite entre 1 a 10 ["+tam+ "] diferente");
            }
        }
        else
        {
            throw new IllegalArgumentException("Entrada[" + parametros[0] + "] debe ser numerico");
        }

        impnum(tam, parametros[1],espacios);
    }

    /**
     * @param cadena Cadena
     */  
    static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
}
