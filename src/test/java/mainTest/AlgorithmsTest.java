package mainTest;

import java.util.Arrays;
import everest.common.algorithms.sorting.QuickSort;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class AlgorithmsTest 
{
    double[] numbers;
 
    @Test
    void quickSortNullArrayTest()
    {
        numbers = null;
        QuickSort.getInstance().sort(numbers);
        assertNull(numbers);
    }
    
    @Test
    void quickSortEmptyArrayTest()
    {
        numbers = new double[0];
        QuickSort.getInstance().sort(numbers);
        assertEquals(0, numbers.length);
    }
    
    @Test
    void quickSortSortTest()
    {
        numbers = new double[]{8.0, 6.0, 3.0, -4.0, 12.0, -32.2, 44.2, 0.0, -30.0, 12.0, 8.1};
        double[] testNumbers = numbers;
 
        QuickSort.getInstance().sort(numbers);
        Arrays.sort(testNumbers);
        assertArrayEquals(testNumbers, numbers);
    }
}
