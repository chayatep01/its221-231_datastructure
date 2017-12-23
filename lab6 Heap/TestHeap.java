

public class TestHeap {

	public static void main(String[] args) {
		Heap<Integer> H = new Heap<Integer>();

		System.out.println("Ex1-2: Testing insert and reheapUp methods:\n");
		System.out.println("Your HeapArray contains ");
		for (int i = 0; i < 100; i = i + 9)
		H.insertHeap(i);
		H.printHeapArray();

		System.out.println("The correct answer is ");
		System.out.println("99 81 90 54 72 45 36 0 27 18 63 9\n\n");

		// Uncomment the following code to test Ex2
		System.out.println("Ex 3-4: Testing deleteRoot and reheapDown methods:");
		H.deleteRoot();
		System.out.println("Your HeapArray contains ");
		H.printHeapArray();
		System.out.println("The correct answer is ");
		System.out.println("90 81 45 54 72 9 36 0 27 18 63");

		// Uncomment the following code to test Ex3
		System.out.println("\nEx5: Testing HeapSort");
		System.out.println("Your sequence from HeapSort is ");
		H.makeHeapSort();
		System.out.println(" ");
		System.out.println("The correct answer is ");
		System.out.println("90 81 72 63 54 45 36 27 18 9 0\n\n");

		
	}

}
