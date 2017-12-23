package lab8;
public class GraphApp<T> extends Stack<T>
{    AdjList<T> firstList;
	int vertexCount;
	int edgeCount;
	AdjList<T> lastList;
        int minWeight = 0;   // New property for Lab 11

        private class Member<T>
	{    T adjVertex;
		int weight;
		Member<T> nextMember;
		

		Member(){}

		Member(T toV, int weight)
		{  adjVertex = toV;
		   this.weight = weight;
		}
	}
 /* Ex1: add new properties parent and distance to AdjList  */
  private class AdjList<T>
	{    AdjList<T> nextList;
		T data;
		int outdegree;
		Member<T> firstMember;
          //define the new properties here
			T parent = null;
			int distance = 0;

		AdjList(){}
		AdjList(T newVertex)
		{
			data = newVertex;
		}
	}


/* Ex 2 Complete the method addMinAdjVertex that take a minspt graph as an input. The method adds a smallest weight edge adjacent to vertices that are not yet in the minspt */

     void addMinAdjVertex(GraphApp<T> minspt) 
     {
        int min = Integer.MAX_VALUE;
        T fromVertex = null;
        T toVertex = null;
        AdjList<T> currentList = minspt.firstList;
        //currentList ==vertex ,  currentMember == edge
        while (currentList != null) {
          //start at the firstMember of each List in the current minspt.   
          Member<T> currentMember = getFirstMember(currentList.data);
         
           
/* traverse to the right to check whether the edge weight is smaller than min. If it is smaller and this adjVertex isnít in minspt, update min, fromVertex, and toVertex */
          
        
            while (currentMember != null) {  
            		//add your code here
            		if(currentMember.weight < min && minspt.searchVertex(currentMember.adjVertex)==null) {
            			min = currentMember.weight;
            			fromVertex = currentList.data;
            			toVertex =  currentMember.adjVertex;
            		}
            		currentMember = currentMember.nextMember;
            }
            
            currentList = currentList.nextList;
        }

        if (fromVertex == null) {
        System.err.println("The given graph cannot have a spanning tree.");
        }
        
        /*After search all lines of AdjList, update the edges FromVertex and toVertex to the minspt with min weight*/
       //add your code here 
        minspt.insertVertex(toVertex);
        minspt.insertEdge(fromVertex, toVertex, min);
        minspt.insertEdge(toVertex, fromVertex, min);
        minspt.minWeight += min;
    }
//-------------------------------------------------------------------------
/* Ex 3 The methods findMinSPT repeatedly calls addMinAdjVertex(minspt) when the vertexCount in minspt is still less than the vertexCount of Graph */

    GraphApp<T> findMinSPT() {

        GraphApp<T> minspt = new GraphApp<T>();
        minspt.insertVertex(firstList.data);

        //add your code here
       while(minspt.vertexCount!= vertexCount) {
    	   			addMinAdjVertex(minspt);
       }
        
        return minspt;
    }
    
    
// -------------------- Ex.4 and 5--------------------------
    GraphApp<T> findShortestPath(T fromV, T toV) {
        //construct an empty graph called Dijkstra
        GraphApp<T> dijkstra = new GraphApp<T>();             
        dijkstra.insertVertex(fromV); //put fromV to dijkstra graph
        dijkstra.lastList.distance = 0; //set distance at fromV =0
      
        
        while (dijkstra.searchVertex(toV)==null) {
            int min = Integer.MAX_VALUE;
            int cumdist = 0;
            T toVertex = null;
            T fromVertex = null;
            T currentVertex;
            AdjList<T> currentList = dijkstra.firstList;
            while (currentList != null) {
                currentVertex = currentList.data;
                Member<T> tempMember = getFirstMember(currentVertex);
                                 
                //This while loop searches on edges of current adjList
                while (tempMember != null)  { 
/* calculate cumulative distance (cumdist) at tempMember.      if the toVertex isnít in the Dijkstra graph and cumdist less than min, update the min, fromVertex, and toVertex */
                	//add your code here
                		if(dijkstra.searchVertex(tempMember.adjVertex)==null&& currentList.distance+tempMember.weight<min){
	                    	min=currentList.distance+tempMember.weight;
	                    	fromVertex=currentVertex;
	                    	toVertex=tempMember.adjVertex;
                		}
                 	tempMember=tempMember.nextMember;
                	}
                currentList = currentList.nextList;
            }
/*insert toVertex to Dijkstra graph and update distance and parent of the selected vertex */
            //add your code here
            dijkstra.insertVertex(toVertex);
            dijkstra.insertEdge(fromVertex, toVertex, min);
            AdjList<T> temp=dijkstra.searchVertex(toVertex);
            temp.distance=min;
            temp.parent=fromVertex;
        }
        return dijkstra;
    }


    void printPath(T fromV, T toV) {
        Stack<T> S = new Stack();
        S.push(toV);
        System.out.println("toV is " +toV);
        T parent= searchVertex(toV).parent;
        System.out.println("parent = " +parent);
        System.out.print("\nShortest path from " + fromV + " to " + toV + " is ");
        while (parent != null) {
             System.out.println("parent = " +parent);
            S.push(parent);
            parent = searchVertex(parent).parent;
           
        }


        while (!S.isEmpty()) {
            System.out.print(S.pop());
            if (!S.isEmpty()) {
                System.out.print("->");
            }
        }

        System.out.print(" with distance " + searchVertex(toV).distance + "\n");
    }

    // --------------------- end Ex.4 and 5 ------------------------




	void insertVertex(T newVertex)
	{
		AdjList<T> temp = new AdjList<T>();
		temp.data = newVertex;
		if (vertexCount == 0)
		{
			firstList = temp;
			lastList = temp;
		} else
		{
			lastList.nextList = temp;
			lastList = temp;
		}
		vertexCount++;
	}

	AdjList<T> searchVertex(T data)
	{
		AdjList<T> current = firstList;
		while (current != null)
		{
			if (current.data.equals(data))
			{
				return current;
			} else
			{
				current = current.nextList;
			}
		}
		return null;
	}

	void insertEdge(T fromData, T toData, int weight)
	{
		AdjList<T> fromVertex = searchVertex(fromData);
		AdjList<T> toVertex = searchVertex(toData);
		if (fromVertex != null && toVertex != null)
                {
		Member<T> newMember = new Member<T>(toData, weight);
		newMember.nextMember = fromVertex.firstMember;
		fromVertex.firstMember = newMember;
		fromVertex.outdegree++;
		edgeCount++;
                }
	}

	void deleteEdge(T fromData, T toData)
	{
		AdjList<T> fromVertex = searchVertex(fromData);

		if (fromVertex == null)
		{
			return;
		}

		if(fromVertex.firstMember==null)
			return;
		while (fromVertex.firstMember!=null && toData.equals(fromVertex.firstMember.adjVertex))
		{
			fromVertex.firstMember = fromVertex.firstMember.nextMember;
			fromVertex.outdegree--;
			edgeCount--;
		}

		Member<T> temp = fromVertex.firstMember;
		while (temp!=null && temp.nextMember != null)
		{
			if (temp.nextMember.adjVertex.equals(toData))
			{
				temp.nextMember = temp.nextMember.nextMember;
				fromVertex.outdegree--;
				edgeCount--;
			} else
			{
				temp = temp.nextMember;
			}
		}
	}

	void deleteVertex(T vertex)
	{
		AdjList<T> currentVertex = firstList;
		AdjList<T> prev = currentVertex;

		if (currentVertex == null)
			return;
		while (currentVertex != null)
		{
			deleteEdge(currentVertex.data, vertex);
			if(currentVertex.data.equals(vertex))
			{
				if(currentVertex == firstList)
					firstList = currentVertex.nextList;
				else if (currentVertex == lastList)
					lastList = prev;
				else
					prev.nextList = currentVertex.nextList;



				edgeCount-=currentVertex.outdegree;
				vertexCount--;
			}
                        // take care of the case that the vertex to be deleted is the last one
                           if(currentVertex.nextList==null && currentVertex.data.equals(vertex)) // if it is the last one
                           {   prev.nextList = null;
                               return;
                           }
                          else
                           {
                           prev = currentVertex;
			   currentVertex = currentVertex.nextList;
                    }
		}


	}

	void print() {
		AdjList<T> currentList = firstList;
		while (currentList != null) {
			System.out.print(currentList.data +":");
			Member<T> cMem = currentList.firstMember;
			while (cMem != null) {
				System.out.print(" " + cMem.adjVertex);
				System.out.print("-" + cMem.weight);
				cMem = cMem.nextMember;
			}
			System.out.println(" ");
			currentList = currentList.nextList;
		//	if (currentList != null)
			//	System.out.println("|");
		}
		System.out.println("The graph consists of " + vertexCount
				+ " vertices " + "and " + edgeCount + " edges.");
	}

            Member<T> getFirstMember(T v) {
        AdjList<T> current = firstList;

        while (current.nextList != null) {
            if (current.data.equals(v)) {
                return current.firstMember;
            } else {
                current = current.nextList;
            }
        }
        //it it is in the last
        if (current.data.equals(v)) {
            return current.firstMember;
        } else {
            return null;
        }
    }



   }

