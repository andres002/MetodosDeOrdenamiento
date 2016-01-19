package algoritmos;

public class quicksort{
int mov=0;
    int inter=0;
  public void quickSort(int arr[], int left, int right) {
    int index = partition(arr, left, right);
    if (left < index - 1)
      quickSort(arr, left, index - 1);
    if (index < right)
      quickSort(arr, index, right);
  }

  private int partition(int arr[], int left, int right){
    int i = left, j = right;
    int tmp;
    int pivot = arr[(left + right) / 2];
    while (i <= j) {
        mov++;
      while (arr[i] < pivot)
        i++;
      while (arr[j] > pivot)
        j--;
    
      if (i <= j) {
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
         inter++;
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
