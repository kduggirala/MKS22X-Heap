
public class MyHeap {
	//We discussed these 2 methods already:
	private static void swap(int[] data, int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	private static void pushDown(int[]data,int size,int index) {
		int child1, child2;
		while (index < size) {
			child1 = (2 * index) + 1;
			child2 = child1 + 1;
			if (child2 < size) {
				if (data[child1] > data[child2]) {
					if (data[child1] > data[index]) {
						swap(data, child1, index);
						index = child1;
					}
					else {
						break;
					}
				}
				else {
					if (data[child2] > data[index]) {
						swap(data, child2, index);
						index = child2;
					}
					else {
						break;
					}
				}
			}
			else {
				if (child1 < size) {
					if (data[child1] > data[index]) {
						swap(data, child1, index);
					}
					break;
				}
				else {
					break;
				}
			}
		}
	}
	/*     - size  is the number of elements in the data array.  
	     - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
	     - precondition: index is between 0 and size-1 inclusive
	     - precondition: size is between 0 and data.length-1 inclusive.
	*/
	private static void pushUp(int[]data,int index) {}
	/*
	     - precondition: index is between 0 and data.length-1 inclusive.
	*/

	//We will discuss this today:
	public static void heapify(int[] a) {}
	    //- convert the array into a valid heap. [ should be O(n) ]

	public static void heapsort(int[] a) {}
	   // - sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]


}
