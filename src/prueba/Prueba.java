/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author alex
 */
public class Prueba {
    static final String fin = "0,0";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // determinar segmentos
        List<String> lista = new ArrayList<>();
        String dato;
        int espacios;
        
        try {
            try (Scanner lector = new Scanner(System.in)) {
                espacios = 1;
                do
                {
                    System.out.print("Entrada: ");
                    dato = lector.next();
                    if(!dato.equalsIgnoreCase(fin))
                    {
                        lista.add(dato);
                    }
                }while (!dato.equalsIgnoreCase(fin)); 
            }
            Escribir Escribir = new Escribir();

            Iterator<String> iterator = lista.iterator();
            while (iterator.hasNext()) 
            {
                try 
                {
                    Escribir.crear(iterator.next(), espacios);
                } catch (Exception ex) 
                {
                    System.out.println("Error: "+ex.getMessage());
                }
            }
            
        } catch (Exception ex) 
        {
            System.out.println("Error: "+ex.getMessage());
        }
    }   
}
