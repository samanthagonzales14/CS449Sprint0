
public class myFunctions {
	// Functions converted from a CS 201 Lab (lab 13) I did. Originally written for C++
	
	public void mySwap (int[] arr, int a, int b) {
		// Function to swap the values at two given index positions
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public int myMin(int[] arr) {
		// Function to return the minimum value in an array
		int lowest = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < lowest) {
				lowest = arr[i];
			}
		}
		return lowest;
	}
	public int myMax(int[] arr) {
		// Function to return the maximum value in an array
		int highest = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > highest) {
				highest = arr[i];
			}
		}
		return highest;		
	}
	public int mySearch(int[] arr, int a) {
		// Function to return index of a number to be searched for in array
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == a) {
				return i;
			}
		}
		return -1; // returns -1 if not found
	}
public static void main(String[] args) {
	
}
}
