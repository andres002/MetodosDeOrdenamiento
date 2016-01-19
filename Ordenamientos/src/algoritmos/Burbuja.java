package algoritmos;

public class Burbuja {

    public void burbuja(int arreglo[]){
    	long contador = 0;
        long contaInter = 0;
 		int i, j, aux;
         for(i=0;i<arreglo.length-1;i++){

              for(j=0;j<arreglo.length-i-1;j++){
              	contador++;
                   if(arreglo[j+1]<arreglo[j]){
                      aux=arreglo[j+1];
                      arreglo[j+1]=arreglo[j];
                      arreglo[j]=aux;
                      contaInter++;
                   }
               }
           }

        for(int x = 0;x < arreglo.length; x++)
        {
            System.out.print(arreglo[x] + " ");
        }
        System.out.println("Compaciones: " + contador);
        System.out.println("Intercambios: " + contaInter);


    }

}
