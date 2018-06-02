import java.util.ArrayList;

/**
 * A representation of a vertex that may be used in a graph.
 */
public class Vertex {
   // Back reference to the graph that contains this vertex.
   private GraphInterface graph = null;
   public GraphInterface getGraph( ) {
      return graph;
   }
   public void setGraph( GraphInterface newval ) {
      graph = newval;
   }

   // Class level variable counter used to provide unique id.
   public static int counter = 0;
   
   // Unique id for each vertex instance.
   private int id = counter++;   
   public int getId( ) {
      return id;
   }

   // Color assigned to the vertex during graph coloring.
   GraphColor color = null;  
   public GraphColor getColor( ) {
      return color;
   }
   public void setColor( GraphColor newVal ) {
      color = newVal;
   }

   /**
    * @return List of edges containing this vertex
    */
   public ArrayList< Edge > incidentEdges( ) {
      return graph.incidentEdges( this );
   }

   /**
    * @return List of vertices connected to this vertex by an edge.
    */
   public ArrayList< Vertex > adjacentVertices( ) {
      return graph.adjacentVertices( this );
   }
   
   /**
    * Stringify the color of this vertex.
    * RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET, BLACK, WHITE
    */
   private String getColorString( ) {
      if ( getColor( ) == null ) {
         return "";
      } else {
       return "" + getColor( );
     }
   }
   
   /**
    * Stringify this vertex.
    */
   public String toString( ) {
      return "<v" + getId( ) + ":" + getColorString( ) + ">";
   }
   
}
