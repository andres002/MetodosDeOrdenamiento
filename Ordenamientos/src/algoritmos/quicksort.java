package algoritmos;

public class quicksort{
int mov=0;
    int inter=1;
  public void quickSort(int arr[], int left, int right) {
    int index = partition(arr, left, right);
    if (left < index - 1)
      quickSort(arr, left, index - 1);
    mov++;
    if (index < right)
      quickSort(arr, index, right);
    mov++;
  }

  private int partition(int arr[], int left, int right){
    int i = left, j = right;
    int tmp;
    int pivot = arr[(left + right) / 2];
    while (i <= j) {
        mov++;
      while (arr[i] < pivot)
        i++;
         mov++;    
      while (arr[j] > pivot)
        j--;
        mov++;   
      if (i <= j) {
          mov=mov+4;
        tmp = arr[i];
        inter=inter+2;
        arr[i] = arr[j];            
        arr[j] = tmp;               
        i++;       
        j--;        
      }
    };
    return i;
    
  }

   public int Getmov(){
      return mov;
  }
  
  public int Getinter(){
      return inter;
  }

}
