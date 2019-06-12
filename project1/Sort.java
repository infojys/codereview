import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.System.in;
import java.lang.Integer;

class Sort{
	
	public static void main(String args[]) throws IOException {
		
		int choice = 0;
		
		java.io.BufferedReader buffer_reader = new new BufferedReader(new InputStreamReader(System.in));
				
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		do{
			
		  System.out.println("\n\n\n1.Bubble Sort\n2.Selection Sort\n3.Insertion Sort.\n4.Quick Sort.\n5.Merge Sort.\n6.Exit.");
		  
		  choice = Integer.parseInt(buffer_reader.readLine());
		  
		  if(choice == 6) return;
		  
		  System.out.println("Enter count of number.");
		  
		  int countOfNumber = Integer.parseInt(buffer_reader.readLine());
		  int numberArray[] = new int[countOfNumber];
		  
		  for(int i=0; i<countOfNumber; i++) {
			  numberArray[i] = Integer.parseInt(buffer_reader.readLine());
		  }
		  
		  switch(choice) {
		  	case 1:
				doBinarySort(numberArray, countOfNumber);
				break;
			case 2:
				doSelectionSort(numberArray, countOfNumber);
				break;
			case 3:
				doInsertionSort(numberArray, countOfNumber);
				break;
			case 4:
				int start = 0;
				int end = countOfNumber-1;
				doQuickSort(numberArray, start, end);
				print(numberArray, countOfNumber);
				break;
			case 5:
				doMergeSort(numberArray, countOfNumber);
				print(numberArray, countOfNumber);	
				break;
			default:
				break;
		 }
		
	  }while(choice != 6);
	}
	public static void doBinarySort(int numberArray[],int countOfNumber) {
		int temp;
		for(int i=0; i<countOfNumber-1; i++) {
			for(int j=0; j<countOfNumber-1; j++){
				if(numberArray[j] > numberArray[(j+1)]){
					temp = numberArray[j];
					numberArray[j] = numberArray[(j+1)];
					numberArray[(j+1)] = temp;
				}
			}
		}
		print(numberArray, countOfNumber);
	}
	public static void doSelectionSort(int numberArray[], int countOfNumber) {
		int imin = 0;
		int temp = 0;
		
		for (int i=0; i<countOfNumber-1; i++) {
			imin = i;
			for(int j=i+1; j<n; j++) {
				if(numberArray[j] < numberArray[imin])
					imin = j;
			}
			temp = numberArray[i];
			numberArray[i] = numberArray[imin];
			numberArray[imin] = temp;
		}
		print(numberArray, countOfNumber);
	}
	public static void doInsertionSort(int numberArray[], int countOfNumber) {
		for(int i=1; i<n; i++) {
			int val = numberArray[i];
			int hole = i;
			while(hole > 0 && numberArray[hole-1] > val) {
				numberArray[hole] = numberArray[hole-1];
				hole = hole-1;
			}
			numberArray[hole] = val;
		}
		print(numberArray, countOfNumber);
	}
	public static void doMergeSort(int numberArray[], int countOfNumber) {
		
		if(countOfNumber <= 1) return;
		int mid = countOfNumber/2;
		int left[] = new int[mid];
		int right[] = new int[countOfNumber-mid];
		for(int i=0; i<mid; i++) {
			left[i] = numberArray[i];
		}
		for(int i=mid; i<n; i++) {
			right[i-mid] = numberArray[i];
		}
		doMergeSort(left, mid);
		doMergeSort(right, countOfNumber-mid);
		merge(left, right, numberArray);
	}
	public static void merge(int left[], int right[], int numberArray[]) {
		int nL = left.length;
		int nR = right.length;
		int i,j,k;
		i=j=k=0;
		
		while(i < nL && j < nR) {
			if(left[i] <= right[j]) {
				numberArray[k] = left[i];
				i++;
				k++;
			}else {
				numberArray[k] = right[j];
				j++;
				k++;
			}
		}
		while(i < nL) {
			numberArray[k] = left[i];
			i++;
			k++;
		}
		while(j < nR) {
			numberArray[k] = right[j];
			j++;
			k++;
		}
	}
	public static void doQuickSort(int numberArray[], int start, int end) {
		if(start < end) {
			int pIndex = findQuickPartitionIndex(numberArray, start, end);
			doQuickSort(numberArray, start, pIndex-1);
			doQuickSort(numberArray, pIndex+1, end);
		}else {
			return;
		}
	}
	public static int findQuickPartitionIndex(int numberArray[], int start, int end) {
		int temp = 0;
		int pivot = numberArray[end];
		int pIndex = start;
		
		for(int i=start; i<end; i++) {
			if(numberArray[i] <= pivot) {
				
				//swap numberArray[i],apindex
				temp = numberArray[i];
				numberArray[i] = numberArray[pIndex];
				numberArray[pIndex] = temp;
				pIndex++;
			}
		}
		
		temp = numberArray[pIndex];
		numberArray[pIndex] = numberArray[end];
		numberArray[end] = temp;
		
		return pIndex;
	}
	public static void print(int numberArray[], int countOfNumber) {
		System.out.println();
		for(int i=0; i<countOfNumber; i++) {
			System.out.print(numberArray[i] + "\t");
		}
	}
}
