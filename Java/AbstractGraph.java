import java.util.ArrayList;

public abstract class AbstractGraph implements GraphInterface {
   // List of all vertices in the graph
   protected ArrayList< Vertex > vertices = new ArrayList< Vertex >( );
   // Return a list of all vertices in the graph
   public ArrayList< Vertex > vertices( ) {
      return vertices;
   }

   // Add a vertex to the graph.
   // No duplicates allowed.
   public abstract Vertex addVertex( Vertex v );

   // Remove a vertex from the graph
   public boolean removeVertex( Vertex v ) {
      for ( Edge e: incidentEdges( v ) ) {
         removeEdge( e );
      }
      return vertices( ).remove( v );
   }

   // List of edges in the graph
   protected ArrayList< Edge > edges = new ArrayList< Edge >( );
   // Return a list of edges in the graph
   public ArrayList< Edge > edges( ) {
      return edges;
   }

   // Add an edge to a graph
   public Edge addEdge( Vertex v1, Vertex v2 ) {
      return addEdge( new Edge( v1, v2 ) );
   }
   public Edge addEdge( Edge e ) {
      if ( !areConnected( e.vertices( ).get( 0 ), e.vertices( ).get( 1 ) ) ) {
         edges( ).add( e );
      }
      return e;
   }

   // Remove an edge from the graph
   public boolean removeEdge( Vertex v1, Vertex v2 ) {
      Edge e = findEdge( v1, v2 );
      return removeEdge( e );
   }
   public boolean removeEdge( Edge e ) {
      return edges( ).remove( e );
   }

   // Find an edge in the graph by its vertices
   // Remember, vertices are unordered in an edge.
   public abstract Edge findEdge( Vertex v1, Vertex v2 );

   // Return true if two vertices are connected by an edge
   public boolean areConnected( Vertex v1, Vertex v2 ) {
      return adjacentVertices( v1 ).contains( v2 );
   }

   // Return a list of all vertices that are adjacent to the given vertex
   public abstract ArrayList< Vertex > adjacentVertices( Vertex v1 );

   // Find all edges that connect to the given vertex
   public ArrayList< Edge > incidentEdges( Vertex v1 ) {
      ArrayList< Edge > result = new ArrayList< Edge >( );
      for ( Edge e: edges( ) ) {
         if ( ( e.vertices( ).get( 0 ).equals( v1 ) ) ||
                        ( e.vertices( ).get( 1 ).equals( v1 ) ) ) {
            result.add( e );
         }
      }
      return result;
   }

   // Stringify the grapg
   @Override
   public String toString( ) {
      return "<Graph:" + vertices( ) + ", " + edges + ">";
   }

   // Color the graph
   // Return the number of colors used
   // or -1 if the graph can't be colored using the specified colors.
   public abstract int colorGraph( ArrayList< GraphColor > colors );

}
