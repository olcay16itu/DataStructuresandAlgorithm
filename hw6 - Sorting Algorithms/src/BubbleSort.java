public class BubbleSort extends SortAlgorithm {

	public BubbleSort(int input_array[]) {
		super(input_array);
	}
	
    @Override
    public void sort() {
        boolean swap; // Flag to track if any swap occurred during a pass
        for(int i = 0; i < arr.length - 1; i++) {
            swap = false; // Initialize swap flag for each pass
            for(int j = 0; j < arr.length - i - 1; j++) {
                // Compare adjacent elements and swap if necessary
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1); // Swap elements
                    swap = true; // Set swap flag to true
                }
                comparison_counter++; // Increment comparison counter
            }
            // If no swaps occurred in a pass, the array is already sorted
            if(!swap) {
                break; // Exit the loop
            }
        }
    }

    
    @Override
    public void print() {
    	System.out.print("Bubble Sort\t=>\t");
    	super.print();
    }
}
