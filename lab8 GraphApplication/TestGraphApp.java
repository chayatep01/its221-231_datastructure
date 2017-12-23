package lab8;


public class TestGraphApp {

    public static void main(String[] args) {
         

        GraphApp<String> myGraph = new GraphApp<String>();
        myGraph.insertVertex("A");
        myGraph.insertVertex("B");
        myGraph.insertVertex("C");
        myGraph.insertVertex("D");
        myGraph.insertVertex("E");
        myGraph.insertVertex("F");

        myGraph.insertEdge("A", "B", 6);
        myGraph.insertEdge("B", "A", 6);
        myGraph.insertEdge("A", "C", 3);
        myGraph.insertEdge("C", "A", 3);
        myGraph.insertEdge("B", "C", 2);
        myGraph.insertEdge("C", "B", 2);
        myGraph.insertEdge("B", "D", 5);
        myGraph.insertEdge("D", "B", 5);
        myGraph.insertEdge("C", "D", 3);
        myGraph.insertEdge("D", "C", 3);
        myGraph.insertEdge("C", "E", 4);
        myGraph.insertEdge("E", "C", 4);
        myGraph.insertEdge("D", "E", 2);
        myGraph.insertEdge("E", "D", 2);
        myGraph.insertEdge("D", "F", 3);
        myGraph.insertEdge("F", "D", 3);
        myGraph.insertEdge("E", "F", 5);
        myGraph.insertEdge("F", "E", 5);

        System.out.println("Your graph is :");
       
         
        // ------------------------------- end Ex.1 --------------------------------------

        // -------------------------------  Ex.2 and 3 --------------------------------------

        // For Ex. 2 and 3 uncomment this part and test your code here.

        GraphApp minSPT = new GraphApp();
        minSPT = myGraph.findMinSPT();
        System.out.println();
        System.out.println("Your the minimum spanning tree of the graph:");
        minSPT.print();
        System.out.println("The correct answer is:\nA: C-3\nB: C-2\nC: A-3 B-2 D-3\nE: D-2\nD: C-3 E-2 F-3\nF: D-3\nThe graph consists of 6 vertices and 10 edges.");

        // ------------------------------- end Ex.2 and 3 --------------------------------------*/

        // -------------------------------  Ex.4 and 5--------------------------------------

        // For Ex. 4 uncomment this part and test your code here.

        GraphApp<String> shortestPath = new GraphApp<String>();
        shortestPath = myGraph.findShortestPath("A", "F");
        System.out.println();
        System.out.println("Your shortest path from A to F:");
        shortestPath.printPath("A", "F");
        System.out.println("The correct answer is A->C->D->F with distance 9");
 
        // ------------------------------- end --------------------------------------

    }
}
