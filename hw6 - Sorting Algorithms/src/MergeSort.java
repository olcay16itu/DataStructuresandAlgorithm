public class MergeSort extends SortAlgorithm {
	
	public MergeSort(int input_array[]) {
		super(input_array);
	}

    private void merge(int l, int m, int r){
        // Calculate sizes of two subarrays
        int la_length = m - l + 1;
        int ra_length = r - m;

        // Create temporary arrays
        int L[] = new int[la_length];
        int R[] = new int[ra_length];

        // Copy data to temporary arrays
        for (int i = 0; i < la_length; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < ra_length; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temporary arrays back into arr[l..r]
        int i = 0, j = 0;
        int k = l;
        while (i < la_length && j < ra_length) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            comparison_counter++; // Increment comparison counter
        }

        // Copy remaining elements of L[] if any
        while (i < la_length) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < ra_length) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private void sort(int l, int r){
        // Recursive function to divide the array into subarrays
        if (l < r) {
            int m = l + (r - l) / 2; // Calculate the middle index

            // Sort first and second halves
            sort(l, m);
            sort(m + 1, r);

            // Merge the sorted halves
            merge(l, m, r);
        }
    }
    
    @Override
    public void sort() {
    	sort(0,arr.length-1);
    }
    
    @Override
    public void print() {
    	System.out.print("Merge Sort\t=>\t");
    	super.print();
    }
}
