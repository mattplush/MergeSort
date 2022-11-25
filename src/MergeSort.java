import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/* Java program for Merge Sort */
class MergeSort {
	public static void main(String args[]) throws FileNotFoundException {

		File input = new File("src\\input.txt");
		File output = new File("src\\output.txt");
		int[] array = getArrayOfInts(input);
		int left = 0;
		int right = array.length - 1;
		sort(array,left,right);
		printArray(output,array);
	}	

	public static void merge(int arr[], int start, int middle, int end) {
		int sizeOfLeft = middle - start + 1;
		int sizeOfRight = end - middle;
		int C[] = new int[sizeOfLeft];
		int D[] = new int[sizeOfRight];

		for (int i = 0; i < sizeOfLeft; ++i)
			C[i] = arr[start + i];
		for (int j = 0; j < sizeOfRight; ++j)
			D[j] = arr[middle + 1 + j];

		int i = 0, j = 0;
		int k = start;
			
		while (i < sizeOfLeft && j < sizeOfRight) {
			if (C[i] <= D[j]) {
				arr[k] = C[i];
				i++;
			} else {
				arr[k] = D[j];
				j++;
			}
			k++;
		}

		while (i < sizeOfLeft) {
			arr[k] = C[i];
			i++;
			k++;
		}

		while (j < sizeOfRight) {
			arr[k] = D[j];
			j++;
			k++;
		}
	}

	public static void sort(int arr[], int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			sort(arr, start, middle);
			sort(arr, middle + 1, end);
			merge(arr, start, middle, end);
		}
	}

	public static int[] getArrayOfInts(File input) throws FileNotFoundException {

		Scanner counter = new Scanner(input);
		Scanner scanner = new Scanner(input);

		int n = 0;
		int[] array; 
		
		while (counter.hasNextLine()) {
			++n;
			counter.nextLine();
		}
		counter.close();
		array = new int[n];
		
		for(int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
			
		scanner.close();
		return array;
	}
	
	static void printArray(File output, int array[]) throws FileNotFoundException {
		
		PrintWriter writer = new PrintWriter(output);
		for (int i = 0; i < array.length; ++i) {
			writer.println(array[i]);
			System.out.println(array[i]);
		}
		writer.close();
	}
}
