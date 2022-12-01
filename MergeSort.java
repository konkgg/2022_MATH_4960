public class MergeSort {
    // class containing methods relating to MergeSort
    // first goal count inversions

    // Count must be reset everytime get inversions is used see documentation in the countreset method for more info
    private static int count = 0;


    //Create method for merging and counting number of inversions
    public static int getInversions(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }

    // divide and conquer mergeSort
    public static int[] mergeSort(int[] arr, int a, int b)
    {
        if(a == b)
        {
            int[] current = new int[1];
            current[0] = arr[a];
            return current;   
        }
        int middle = (a + b) / 2;

        int[] left = mergeSort(arr, a, middle);
        int[] right = mergeSort(arr, middle + 1, b);

        return merge(left, right);
    }

    public static int[] merge(int[] a, int[] b)
    {
        int i = 0;
        int j = 0;
        int k = 0;
        
        int[] merged = new int[a.length + b.length];

        while(i < a.length && j < b.length)
        {
            if(a[i] <= b[j])
            {
                merged[k] = a[i];
                i++;
                k++;
            }
            else
            {
                //increase the count as we order them for easier inversion counting
                count += (a.length - i);
                merged[k] = b[j];
                j++;
                k++;
            }
        }
        while(i < a.length)
        {
            merged[k] = a[i];
            i++;
            k++; 
        }
        while(j < b.length)
        {
            merged[k] = b[j];
            j++;
            k++;
        }
        return merged;

    }
    public static void resetCount()
    {
        /*  Due to the way these methods are setup currently we must reset the count after each use
            this could technically be avoided if i placed the get inversions within another method or if i create another int to store the count
            Perhaps not resetting the count after each could be useful if i wanted to count the inversions of many permutations and add them up?
        */
        count = 0;
    }

}