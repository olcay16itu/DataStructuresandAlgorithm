public class QuickSort extends SortAlgorithm {

	public QuickSort(int input_array[]) {
		super(input_array);
	}

    private int partition(int low, int high){
        // Select the pivot element (here, the last element)
        int pivot = arr[high];

        // Initialize the index of smaller element
        int i = (low - 1);

        // Iterate through the array from low to high-1
        for (int j = low; j <= high - 1; j++) {
            // If current element is smaller than or equal to the pivot
            if (arr[j] < pivot) {
                // Increment index of smaller element
                i++;
                // Swap arr[i] and arr[j]
                swap(i, j);
            }
            comparison_counter++; // Increment comparison counter
        }
        // Swap the pivot element (arr[high]) with the element at (i + 1)
        swap(i + 1, high);
        // Return the partition index
        return (i + 1);
    }

    private void sort(int low, int high){
        // Recursive function to sort the array
        if (low < high) {
            // Partition the array around pivot and get partition index
            int pi = partition(low, high);
            // Recursively sort elements before partition and after partition
            sort(low, pi - 1);
            sort(pi + 1, high);
        }
    }


    @Override
    public void sort() {
    	sort(0,arr.length-1);
    }

    @Override
    public void print() {
    	System.out.print("Quick Sort\t=>\t");
    	super.print();
    }
}
