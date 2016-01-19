package algoritmos;

import java.util.*;
public class Insercion {
    int movimientos=0;
    int comparaciones=0;

    public int[] ordenarInsercion(int[] array){     
        int aux;
        for (int i = 1; i < array.length; i++) {
             movimientos++;
            aux = array[i];
            
            for (int j = i-1; j >=0 && array[j]>aux; j--) {
                comparaciones=comparaciones+1;
                array[j+1]=array[j];
            //    movimientos=movimientos+1;
                array[j]=aux;
                 movimientos++;
            }  
        }
        return array;
    }
    
    
    public int getMov(){
        System.out.println("mov " + movimientos);
        return movimientos;
    }
    
    public int getComp(){
        System.out.println("comp "+ comparaciones);
        return comparaciones;
    }
}