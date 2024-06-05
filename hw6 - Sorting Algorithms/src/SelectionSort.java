public class SelectionSort extends SortAlgorithm {

	public SelectionSort(int input_array[]) {
		super(input_array);
	}

    @Override
    public void sort() {
        for(int i = 0; i < arr.length - 1; i++) {
            int min_index = i; // Initialize the index of the minimum element
            for(int j = min_index + 1; j < arr.length; j++) {
                // Find the index of the minimum element in the unsorted portion
                if(arr[j] < arr[min_index]) {
                    min_index = j; // Update the index of the minimum element
                }
                comparison_counter++; // Increment comparison counter
            }
            swap(i, min_index); // Swap the minimum element with the current element
        }
    }


    @Override
    public void print() {
    	System.out.print("Selection Sort\t=>\t");
    	super.print();
    }
}
