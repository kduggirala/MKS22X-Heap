
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
	private static void pushUp(int[]data,int index) {
		int parent;
		while (index > 0) {
			parent = (index - 1) / 2;
			if (data[index] > data[parent]) {
				swap(data, index, parent);
				index = parent;
			}
			else {
				break;
			}
		}
	}
	/*
	     - precondition: index is between 0 and data.length-1 inclusive.
	*/

	//We will discuss this today:
	public static void heapify(int[] a) {
		heapifyHelp(a, 0);
	}
	    //- convert the array into a valid heap. [ should be O(n) ]
	private static void heapifyHelp(int[] a, int index) {
		if (2 * index + 1 < a.length) { //if it is has children
			heapifyHelp(a, 2 * index + 1);
			heapifyHelp(a, 2 * index + 2);
			pushDown(a, a.length, index);
		}
	}
	
	public static void heapsort(int[] a) {
		heapify(a);
		for (int i = a.length - 1; i > 0; i--) {
			swap(a, 0, i);
			pushDown(a, i, 0);
		}
	}
	   // - sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]
}
