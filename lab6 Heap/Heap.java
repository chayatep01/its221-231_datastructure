import java.util.ArrayList;

public class Heap<T extends Comparable<T>> {

	ArrayList<T> heapArray = new ArrayList<T>();

	Heap() { }

    // Exercise  1  
	void reheapUp(int currentIndex) {
             //add your code here
			int parentIndex = (int) Math.floor((currentIndex -1)/2); 
			if(currentIndex>0) { 
				if(heapArray.get(currentIndex).compareTo(heapArray.get(parentIndex))>0)
				{
					swap(heapArray,parentIndex,currentIndex);
				}
				reheapUp(parentIndex);
			}
 
	}
        
        // Exercise  2  
	void insertHeap(T data) {
		//add your code here
		if(heapArray.size()==0) { heapArray.add(0,data); }
		else { heapArray.add(heapArray.size(),data); }
		reheapUp(heapArray.size() - 1);
	}
       
		// Exercise  3  
	void reheapDown(int currentIndex) {
		 //add your code here
			int leftChild = 2*currentIndex+1;
			int rightChild = 2*currentIndex+2;
			if(leftChild<heapArray.size() && rightChild<heapArray.size()) 
			{
				if(heapArray.get(leftChild).compareTo(heapArray.get(rightChild))>0) { 
					swap(heapArray,currentIndex,leftChild);
					currentIndex = leftChild;
				} else { 
					swap(heapArray,currentIndex,rightChild); 
					currentIndex = rightChild;
				}
				
				leftChild = 2*currentIndex+1;
				rightChild = 2*currentIndex+2;
				
				if(leftChild<heapArray.size()&& rightChild<heapArray.size()) 
				{ 
					reheapDown(currentIndex); 
				}
			}
		}
        // Exercise  4  
	T deleteRoot() {
	//add your code here	
		T temp = heapArray.get(0);
		swap(heapArray,0,heapArray.size()-1);
		heapArray.remove(heapArray.size()-1);
		reheapDown(0);
		return temp;

    }
 

	void makeHeapSort() {
		//add your code here
		while(!heapArray.isEmpty()) {System.out.print( deleteRoot() + " ");}
	}

	int findLevel(int nodeindex) {
		int parent = (nodeindex - 1) / 2;
		int level = 0;

		if (parent > 0)
			level++;

		while (parent > 0) {
			parent = (parent - 1) / 2;
			level++;
		}

		return level;
	}

	void swap(java.util.ArrayList<T> heapArray, int i1, int i2) {
		T temp = heapArray.get(i1);
		heapArray.set(i1, heapArray.get(i2));
		heapArray.set(i2, temp);
	}

	void printHeapArray() {
		for (int i = 0; i < heapArray.size(); i++)
			System.out.print(heapArray.get(i) + " ");
		System.out.println();
	}

}
