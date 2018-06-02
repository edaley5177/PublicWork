import java.util.ArrayList;

/**
 * A representation of an edge that connects two vertices in a graph
 */
public class Edge {

   // Unordered list of vertices connected by this edge.
   ArrayList< Vertex > vertices = new ArrayList< Vertex >( );
   public ArrayList< Vertex > vertices( ) {
      return vertices;
   }
   
   // Stringify this edge.
   public String toString( ) {
      return "<v" + vertices( ).get( 0 ).getId( ) + "-v" + vertices( ).get( 1 ).getId( ) + ">"; 
   }

   /**
    * Constructor: initializes a new edge that connects the specified vertices.
    */
   public Edge( Vertex v1, Vertex v2 ) {
      vertices( ).add( v1 );
      vertices( ).add( v2 );
   }
}
