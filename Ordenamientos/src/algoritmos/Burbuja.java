package algoritmos;

public class Burbuja{

	public void burbuja(int arreglo[]){
    	long contador = 0;

        for(int i = 0; i < arreglo.length - 1; i++){
            for(int j = 0; j < arreglo.length - 1; j++){
                if (arreglo[j] > arreglo[j + 1])
                {
                    int tmp = arreglo[j+1];
                    arreglo[j+1] = arreglo[j];
                    arreglo[j] = tmp;
                    
                }
                contador++;              
            }
        }

        for(int i = 0;i < arreglo.length; i++)
        {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println("Contador: " + contador);


    }
}