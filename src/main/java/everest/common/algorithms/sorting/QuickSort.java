package everest.common.algorithms.sorting;

import org.springframework.stereotype.Component;

@Component
public class QuickSort
{
    public void sort(double[] array) 
    {     
        if(array == null || array.length == 0) 
        {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }
    
    private void quickSort(double[] array, int lowerIndex, int higherIndex) 
    {    
        int i = lowerIndex;
        int j = higherIndex;
        
        double pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
        
        while (i <= j) 
        {    
            while(array[i] < pivot) 
            {
                i++;
            }
            while(array[j] > pivot) 
            {
                j--;
            }
            if (i <= j) 
            {
                swap(array, i, j);
                
                i++;
                j--;
            }
        }
        
        if (lowerIndex < j)
            quickSort(array, lowerIndex, j);
        
        if (i < higherIndex)
            quickSort(array, i, higherIndex);
    }
 
    private void swap(double[] array, int i, int j) 
    {
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
