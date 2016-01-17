package algoritmos;

import java.util.*;
public class Insercion {
    int Mov=0;
    int Comp=1;

    public int[] ordenarInsercion(int[] array){     
        int aux;
        
        for (int i = 1; i < array.length; i++) {
            aux = array[i];
            Comp=Comp+1;
            for (int j = i-1; j >=0 && array[j]>aux; j--) {
                Comp=Comp+1;
                array[j+1]=array[j];
                Mov=Mov+1;
                array[j]=aux;
                 Mov=Mov+1;
                 
            }  
        }
        return array;
    }
    
    
    public int getMov(){
        return Mov;
    }
    
    public int getComp(){
        return Comp;
    }
}