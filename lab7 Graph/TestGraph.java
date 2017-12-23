package lab7;

public class TestGraph {
	 
    public static void main(String[] args) {
        Graph<String> G = new Graph<String>();
 
        // Testing insertVertex()
        
        System.out.println("Testing insertVertex()");
        G.insertVertex("A");
        G.insertVertex("B");
        G.insertVertex("C");
 
        G.print();
 
        System.out.println("The correct answer is\nA \n| \nB \n| \nC \nThe graph consists of 3 vertices and 0 edges.\n");
        
         
        // Testing insertEdge()
        
        System.out.println("Testing insertEdge()");
         
        G.insertEdge("A","B",1);
        G.insertEdge("A","E",3);
        G.insertEdge("D","C",6);
 
        G.print();
 
        System.out.println("The correct answer is\nA-->E,3-->B,1 \n| \nB \n| \nC \n| \nE \n| \nD-->C,6 \nThe graph consists of 5 vertices and 3 edges.\n");
        
 
        // Testing deleteEdge()
        
        System.out.println("Testing deleteEdge()");
        G.deleteEdge("F","G");
        G.deleteEdge("A","C");
        G.deleteEdge("B","A");
         
        // Note: 3 deletions above tried to delete non-existed edge. 
        // You should prevent the error in such the case. 
        G.deleteEdge("D","C");
        G.deleteEdge("A","B");
 
        G.print();
 
        System.out.println("The correct answer is\nA-->E,3 \n| \nB \n| \nC \n| \nE \n| \nD \nThe graph consists of 5 vertices and 1 edges.\n");
        
 
        // Testing deleteVertex()
        
        System.out.println("Testing deleteVertex()");
        G.insertEdge("A","B",10);
        G.insertEdge("E","A",2);
        G.insertEdge("D", "A",1);
        G.insertEdge("D","C",2);
        G.insertEdge("B","C",5);
        G.insertEdge("B","A",4);
        G.deleteVertex("A");
 
        G.print();
        System.out.println("The correct answer is\nB-->C,5\n| \nC \n| \nE \n| \nD-->C,2 \nThe graph consists of 4 vertices and 2 edges.\n");
 
        G.deleteVertex("B");
 
        G.print();
        System.out.println("The correct answer is\nC \n| \nE \n| \nD-->C,2 \nThe graph consists of 3 vertices and 1 edges.\n");
        
    }
 
}