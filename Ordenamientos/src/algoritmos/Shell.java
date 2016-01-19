/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author Andres
 */

public class Shell {
   int intercambios = 0;
   int comparaciones =1;
   public void shell(int A[]){
       
   int salto, aux, i;
   boolean cambios;
   for(salto=A.length/2; salto!=0; salto/=2){
           cambios=true;
           while(cambios){ // Mientras se intercambie algún elemento
                intercambios++;
                       cambios=false;
                       for(i=salto; i< A.length; i++) // se da una pasada
                           
                               if(A[i-salto]>A[i]){ // y si están desordenados
                                   comparaciones++;
                                     aux=A[i]; // se reordenan
                                     A[i]=A[i-salto];
                                     A[i-salto]=aux;
                                     cambios=true; // y se marca como cambio.
                               }
                        }
            }
   
}
   public void shell2(int A[]){
       
   int salto, aux, i;
   boolean cambios;
   for(salto=A.length/2; salto!=0; salto/=2){
           cambios=true;
           while(cambios){ // Mientras se intercambie algún elemento
                intercambios++;
                       cambios=false;
                       for(i=salto; i< A.length; i++) // se da una pasada
                           comparaciones++;
                               if(A[i-salto]<A[i]){ // y si están desordenados
                                     aux=A[i]; // se reordenan
                                     A[i]=A[i-salto];
                                     A[i-salto]=aux;
                                     cambios=true; // y se marca como cambio.
                               }
                        }
            }
   
}
   
   public int getIntercambios(){
       return intercambios;
   
   }
   public int getComparaciones(){
       return comparaciones;
   }
}
