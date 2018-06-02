//import static org.junit.Assert.*;

import java.security.SecureRandom;
import java.util.ArrayList;

//import org.junit.Test;

public class GraphTest {

   public static void addEdgeTestbyNumberOfEdges() {
      Graph mygraph = new Graph( );
      Vertex v0 = new Vertex( );
      Vertex v1 = new Vertex( );
      Vertex v2 = new Vertex( );
      mygraph.addVertex( v0 );
      mygraph.addVertex( v1 );
      mygraph.addVertex( v2 );
      mygraph.addEdge( v0, v1 );
      mygraph.addEdge( v1, v2 );
      mygraph.addEdge( v2, v0 );
      int numEdges = mygraph.edges( ).size( );
      if (numEdges != 3) {
         System.out.println( "Added 3 edges but graph = " + mygraph );
      }
   }

   public static void toStringTest( Object thing ) {
      if ( thing.toString( ).equals( thing.getClass( ).getName( ) + '@' + Integer.toHexString( thing.hashCode( ) ) ) ) {
         System.out.println( "FAILED: " + thing.getClass( ).getName( ) + ".toString was not overloaded." );
      }
   }

   public static void testToString( ) {
         // create a test graph, vertices and edges
         Graph graph = new Graph( );
         Vertex v0 = new Vertex( );
         Vertex v1 = new Vertex( );
         Vertex v2 = new Vertex( );
         Edge e0 = new Edge( v0, v1 );
         Edge e1 = new Edge( v1, v2 );
         toStringTest( graph );
         toStringTest( v1 );
         toStringTest( e1 );
   }

	
   public static void testVertexIdCheck( ) {
      // create a test graph and vertices
      Graph graph = new Graph( );
      Vertex v0 = new Vertex( );
      Vertex v1 = new Vertex( );
      Vertex v2 = new Vertex( );

      // add vertices to the graph
      graph.addVertex( v0 );
      graph.addVertex( v1 );

      // ensure they are ID'd properly
      if (v1.getId( ) - v0.getId( ) != 1) {
         System.out.println( "Added two vertices [" + v0 + ", " + v1
                        + "]. Their IDs did not differ by 1 as expected." );
      }
      if (v2.getId( ) - v1.getId( ) != 1) {
         System.out.println( "Added two vertices [" + v1 + ", " + v2
                        + "]. Their IDs did not differ by 1 as expected." );
      }
   }

   public static void removeEdgeTestbyNumberOfEdges( ) {
      Graph mygraph = new Graph( );
      Vertex v0 = new Vertex( );
      Vertex v1 = new Vertex( );
      Vertex v2 = new Vertex( );
      mygraph.addVertex( v0 );
      mygraph.addVertex( v1 );
      mygraph.addVertex( v2 );
      Edge e0 = mygraph.addEdge( v0, v1 );
      mygraph.addEdge( v1, v2 );
      Edge e2 = mygraph.addEdge( v2, v0 );
      mygraph.removeEdge( e0 );
      mygraph.removeEdge( e2 );
      int numEdges = mygraph.edges( ).size( );
      if (numEdges != 1) {
         System.out.println( "Added 3 edges, removed 2 but graph = " + mygraph );
      }
   }

   public static void addVertexTestbyNumberOfVertices( ) {
      Graph mygraph = new Graph( );
      Vertex v0 = new Vertex( );
      Vertex v1 = new Vertex( );
      Vertex v2 = new Vertex( );
      mygraph.addVertex( v0 );
      mygraph.addVertex( v1 );
      mygraph.addVertex( v2 );
      int numVertices = mygraph.vertices( ).size( );
      if (numVertices != 3) {
         System.out.println( "Added 3 vertices but graph = " + mygraph );
      }
   }

   public static void addVertexTestbyContains( ) {
      Graph mygraph = new Graph( );
      ArrayList< Vertex > myvertices = new ArrayList< Vertex >( );
      for( int i = 0; i < 100; i++ ) {
         myvertices.add( mygraph.addVertex( new Vertex( ) ) );
      }
      boolean itWorks = true;
      for( Vertex v : mygraph.vertices( ) ) {
         itWorks = itWorks && myvertices.contains( v );
      }
      if (!itWorks) {
         System.out.println( "Added 100 vertices but did not find them all in the graph "
                        + mygraph );
      }
      if (myvertices.size( ) != mygraph.vertices( ).size( )) {
         System.out.println( "Added 100 vertices graph vertices was not the same size "
                        + mygraph );
      }
   }
	
   public static void removeVertexTestbyContains( ) {
      Graph mygraph = new Graph( );
      ArrayList< Vertex > myvertices = new ArrayList< Vertex >( );
      for( int i = 0; i < 100; i++ ) {
         myvertices.add( mygraph.addVertex( new Vertex( ) ) );
      }
      for( int i = 0; i < 30; i++ ) {
         Vertex v = myvertices.get( i * 2 );
         mygraph.removeVertex( v );
         myvertices.remove( v );
      }
      boolean itWorks = true;
      for( Vertex v : mygraph.vertices( ) ) {
         itWorks = itWorks && myvertices.contains( v );
      }
      if (!itWorks) {
         System.out.println( "Added 100 vertices, removed 30, but did not find them all remaining in the graph "
                        + mygraph );
      }
      if (myvertices.size( ) != mygraph.vertices( ).size( )) {
         System.out.println( "Added 100 vertices, removed 30, graph vertices was not the same size "
                        + mygraph );
      }
   }

   public static void removeVertexTestbyNumberOfVertices( ) {
      Graph mygraph = new Graph( );
      Vertex v0 = new Vertex( );
      Vertex v1 = new Vertex( );
      Vertex v2 = new Vertex( );
      mygraph.addVertex( v0 );
      mygraph.addVertex( v1 );
      mygraph.addVertex( v2 );
      mygraph.removeVertex( v0 );
      mygraph.removeVertex( v2 );
      int numVertices = mygraph.vertices( ).size( );
      if (numVertices != 1) {
         System.out.println( "Added 3 vertices, removed 2 but graph = " + mygraph );
      }
   }

   public static void removeVertexAndEdgesTest( ) {
      Graph mygraph = new Graph( );
      Vertex v0 = new Vertex( );
      Vertex v1 = new Vertex( );
      Vertex v2 = new Vertex( );
      mygraph.addVertex( v0 );
      mygraph.addVertex( v1 );
      mygraph.addVertex( v2 );
      mygraph.addEdge( v0, v1 );
      mygraph.addEdge( v1, v2 );
      mygraph.addEdge( v2, v0 );
      mygraph.removeVertex( v2 );
      int numVertices = mygraph.vertices( ).size( );
      int numEdges = mygraph.edges( ).size( );
      if (numVertices != 2 || numEdges != 1) {
         System.out.println( "Added 3 vertices and 3 edges, removed 1 vertext and should only have 1 edge remaining but graph = " + mygraph );
      }
   }

   public static void colorGraphTestUsesSomeColors( ) {
      ArrayList< GraphColor > colors = new ArrayList< GraphColor >( );
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      Graph mygraph = new Graph( );
      Vertex v0 = new Vertex( );
      Vertex v1 = new Vertex( );
      Vertex v2 = new Vertex( );
      mygraph.addVertex( v0 );
      mygraph.addVertex( v1 );
      mygraph.addVertex( v2 );
      mygraph.addEdge( v0, v1 );
      mygraph.addEdge( v1, v2 );
      mygraph.addEdge( v2, v0 );
      int numColors = mygraph.colorGraph( colors );
      if (numColors != 3) {
         System.out.println( "colorGraph( " + colors + " ) expected = 3 returned = "
                        + numColors + " for " + mygraph );
      }
   }

  
   public static void colorGraphTestUsesAllColors( ) {
      ArrayList< GraphColor > colors = new ArrayList< GraphColor >( );
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      Graph mygraph = new Graph( );
      Vertex v0 = new Vertex( );
      Vertex v1 = new Vertex( );
      Vertex v2 = new Vertex( );
      mygraph.addVertex( v0 );
      mygraph.addVertex( v1 );
      mygraph.addVertex( v2 );
      mygraph.addEdge( v0, v1 );
      mygraph.addEdge( v1, v2 );
      mygraph.addEdge( v2, v0 );
      int numColors = mygraph.colorGraph( colors );
      if (numColors != 3) {
         System.out.println( "colorGraph( " + colors + " ) expected = 3 returned = "
                        + numColors + " for " + mygraph );
      }
   }

   private static final SecureRandom random = new SecureRandom( );

   public static < T extends Enum< ? >> T randomEnum( Class< T > clazz ) {
      int x = random.nextInt( clazz.getEnumConstants( ).length );
      return clazz.getEnumConstants( )[ x ];
   }

   public static boolean addNewColor( ArrayList< GraphColor > list, GraphColor c ) {
      boolean result = false;
      if (!list.contains( c )) {
         result = true;
         list.add( c );
      }
      return result;
   }

   public static void colorGraphTestCannotColor( ) {
      ArrayList< GraphColor > colors = new ArrayList< GraphColor >( );
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      Graph mygraph = new Graph( );
      Vertex v0 = new Vertex( );
      Vertex v1 = new Vertex( );
      Vertex v2 = new Vertex( );
      mygraph.addVertex( v0 );
      mygraph.addVertex( v1 );
      mygraph.addVertex( v2 );
      mygraph.addEdge( v0, v1 );
      mygraph.addEdge( v1, v2 );
      mygraph.addEdge( v2, v0 );
      int numColors = mygraph.colorGraph( colors );
      if (numColors != -1) {
         System.out.println( "colorGraph( " + colors + " ) expected = -1 returned = "
                        + numColors + " for " + mygraph );
      }
   }

   public static void removeVertexGraphColorTestbyContains( ) {
      Graph mygraph = new Graph( );
      ArrayList< Vertex > myvertices = new ArrayList< Vertex >( );
      ArrayList< GraphColor > colors = new ArrayList< GraphColor >( );
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      while( !addNewColor( colors, randomEnum( GraphColor.class ) ) )
         ;
      for( int i = 0; i < 100; i++ ) {
         myvertices.add( mygraph.addVertex( new Vertex( ) ) );
				//System.out.println("i is " + i);
         if (i > 0) {
					 //System.out.println("i >0");
            mygraph.addEdge( myvertices.get( i - 1 ), myvertices.get( i ) );
         }
      }
      for( int i = 0; i < 30; i++ ) {
         Vertex v = myvertices.get( i * 2 );
         mygraph.removeVertex( v );
         myvertices.remove( v );
      }
      mygraph.colorGraph( colors );
      boolean itWorks = true;
      for( Vertex v : mygraph.vertices( ) ) {
         itWorks = itWorks && myvertices.contains( v );
      }
      if (!itWorks) {
         System.out.println( "Added 100 vertices, removed 30, but did not find them all remaining in the graph "
                        + mygraph );
      }
      if (myvertices.size( ) != mygraph.vertices( ).size( )) {
         System.out.println( "Added 100 vertices, removed 30, graph vertices was not the same size "
                        + mygraph );
      }
   }
	public static void main(String[] args){
	
		addEdgeTestbyNumberOfEdges();
		removeVertexGraphColorTestbyContains();
		colorGraphTestCannotColor();
		colorGraphTestUsesAllColors();
		colorGraphTestUsesSomeColors();
		removeVertexAndEdgesTest();
		removeVertexTestbyNumberOfVertices();
		removeVertexTestbyContains();
		addVertexTestbyContains();
		addVertexTestbyNumberOfVertices();
		removeEdgeTestbyNumberOfEdges();
		testVertexIdCheck();
		testToString();
	/*	ArrayList< GraphColor > colors = new ArrayList< GraphColor >( );
colors.add( GraphColor.RED );
colors.add( GraphColor.GREEN );
colors.add( GraphColor.BLUE );
Graph mygraph = new Graph( );
Vertex v0 = new Vertex( );
Vertex v1 = new Vertex( );
Vertex v2 = new Vertex( );  
mygraph.addVertex( v0 );
mygraph.addVertex( v1 );
mygraph.addVertex( v2 );
mygraph.addEdge( v0, v1 );
mygraph.addEdge( v1, v2 );
mygraph.addEdge( v2, v0 );
int numColors = mygraph.colorGraph( colors );
System.out.println( "Numer of Colors = " + numColors );
System.out.println( mygraph );*/
	}

}
