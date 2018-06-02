import java.util.ArrayList;
import java.lang.*;

public class Graph extends AbstractGraph {
   // Add a vertex to the graph.
   // No duplicates allowed.
   @Override
   public Vertex addVertex( Vertex v ) {
      // YOUR CODE HERE
		 //first make sure we are not adding one that is already in there
		 if(this.vertices.contains(v)){
			 return null;
		 }
		 //just add it to the master list of vertices
		 this.vertices.add(v);
		 //then return it
      return v;
   }

   // Find an edge in the graph by its vertices
   // Remember, vertices are unordered in an edge.
   @Override
   public Edge findEdge( Vertex v1, Vertex v2 ) {
		 //first check if they are connected
		 if(!areConnected(v1,v2)){
			 return null;
		 }
		 //first create an edge to iterate
		  Edge e = this.edges.get(0);//start at first element
		 int i=0;
		  Edge target = null;
		 //just check through all the edges until i find one that has both vertices
		 while(i< this.edges.size()){
			 if(e.vertices.contains(v1) && e.vertices.contains(v2)){
				 target = e;
				 break;
			 }
			 i++;
			 e = this.edges.get(i);
		 }
      // YOUR CODE HERE
      return target;
   }

   // Return a list of all vertices that are adjacent to the given vertex
   @Override
   public ArrayList< Vertex > adjacentVertices( Vertex v1 ) {
      ArrayList<Vertex> result = new ArrayList<Vertex>();
      // YOUR CODE HERE
		 ArrayList<Edge> thisEdges;
		 //first retrive the list of edges in connected to this vertex
		 //this may be null so we can return an empty list
		 try{
			  thisEdges = v1.incidentEdges();
		 }
		 catch(NullPointerException e){
				return result;
		 }
		 
		 //then itterate through all those and add every vertex that isn't v1
		 //to result
		 Edge e = thisEdges.get(0);
		 int i =0;
		 while(i<thisEdges.size()){
			 if(e.vertices().get(0) != v1){
				 //find the vertex in this edge that isn't v1
				 //then add it to result
				 result.add(e.vertices().get(0));
			 }
			 //otherwise add the other vertex
			 else{
				 result.add(e.vertices().get(1));
			 }
			 // then go to the next edge in the list
			 i++;
			 e = thisEdges.get(i);
		 }
      return result;
   }

   // Color the graph
   // Return the number of colors used
   // or -1 if the graph can't be colored using the specified colors.
   @Override
   public int colorGraph( ArrayList<GraphColor> colors ) {
      int result = 0;
      // YOUR CODE HERE
		 
		 //first retrive a list of all the vertices
		 ArrayList<Vertex> allVerts = this.vertices();
		 //check if that list is bigger than the list of colors passed in
		 if(allVerts.size() > colors.size()){
			 return-1;
		 }
		 //then go through every vertex in that list
		 int i =0;//used in outer while loop
		 while(i<allVerts.size()){
			 //at every vertex get a list of all the adjacent vertices
			 Vertex currVert = allVerts.get(i);
			 ArrayList<Vertex> adVert;//if there are no adjacent vertices to the current vertex
			 //then this line will throw a null pointer exception in which case i can just color it the color i'm currently on
			 try{
				 adVert = currVert.adjacentVertices();
				
			 //if any vertex has more adjacent vertices than there are colors, then return -1
			 if(adVert.size()>colors.size()){
				 return -1;
			 }
			 int c =0;//will iterate over list of colors is the index of color i am on
			 
			 //start at top of array list of colors and see if each color has been used on an adjacent vertex
			 //if so, move to next color and try again, 
			 //if i find a color that has not yet been used, then make the current vertex that color and 
			 //move on the next vertex in the list
			 //now start the inner while loop
			 while(c<colors.size()){
				 //at each adjacent vertex, get the color
				 int j=0;//index of vertex i am checking
				 GraphColor cc = colors.get(c);
				 while(j<adVert.size()){
					 
					 GraphColor cvc = adVert.get(j).getColor();
				 //first if that vertex is not colored move to the next adjacent vertex
				 if(cvc == null){
					 System.out.println("cvc was null");
					 j++;
				 }
				 //if cvc is the color i'm on move to next color and start over
					 else if(cvc == cc){
						 c++;
					 }
					 //otherwise the color i'm on and the color of this adjacent vertex don't match so 
					 //move to next vertex and check that one's color
					 else{
						 j++;
					 }
				 }
				 //if that while loop finishes, then the current color is not used by 
				 //any adjacent vertex, so color the current vertex that color and end this loop
				 allVerts.get(i).setColor(cc);
				 //don't forget to add to result
				 result++;
			 }
			  }
			 catch(NullPointerException e){
				 currVert.setColor(colors.get(i));
				 result++;
			 }
			 i++;
		 
			 }
		 //and try to color them all first check the colors of the adjacent vertices
		 
      return result;
   }
}
