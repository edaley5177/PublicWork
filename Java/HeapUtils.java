import java.util.*;
import java.io.*;

public class HeapUtils<V extends Comparable<V>> implements HeapUtilsInterface<V>{
	public HeapUtils(){}
	
	public int getIndexOfLeftChild(int parentIndex){
		
		return 2*parentIndex+1;
		
	}
	
	  public int getIndexOfRightChild(int parentIndex){
		
			return 2*parentIndex+2;
		}
	
	   public int getParentIndex(int childIndex){
			 //don't know if we are passed right or left child
			 return (childIndex-1)/2;
		 }
	//my own method that will swap 2 items in the heap
	//put b where a is and a where b is
	public void swap(V[] data, int indexa,int indexb){
		//data[indexa]
		V aspot =data[indexa];
		V bspot = data[indexb];
		//now we have the entries saved to variables
		data[indexa] = bspot;
		data[indexb] = aspot;
	}
	//same thing as bubble up, but this is used for a max heap 
	public void bubbleUpMax(V[] data,int index){
		 if(index<0 || index>data.length){
				 return;
			 }
			 
			 //compare with its parent until it is greater than its parent
			 while(data[index].compareTo(data[getParentIndex(index)]) >0){
				 swap(data,getParentIndex(index),index);
				 index = getParentIndex(index);
			 }
	}
	//used to bubble a value up a min heap
	   public void bubbleUp(V[] data,int index){
			 
			 
			 //first check if index is within the bounds
			 if(index<0 || index>data.length){
				 return;
			 }
			 
			 //compare with its parent until it is greater than its parent
			 while(data[index].compareTo(data[getParentIndex(index)]) <0){
				 swap(data,getParentIndex(index),index);
				 index = getParentIndex(index);
			 }
		
	}
	
		
	   public void bubbleDown(V[] data,int index,int partitionBoundaryIndex){
			 //while index has a left child, and that left child is in the unsorted max heap part of the array
			 //swap with that if needed
			 int hci = 0;//index of the higher child
			 
			 
			 //as long as it has a left 
			 while(getIndexOfLeftChild(index)<partitionBoundaryIndex){
				 
				
						  hci = getIndexOfLeftChild(index);
				 
				 
				
				
				 //then see if index has a right child
				 if(getIndexOfRightChild(index)<partitionBoundaryIndex){
					 //if index has a right child, see if the left child is lower
					 if(data[getIndexOfLeftChild(index)].compareTo(data[getIndexOfRightChild(index)]) <=0)
							 hci=getIndexOfRightChild(index);
				 }
				 	 //once we have found the higher child, swap with that if necessary
				 if(data[index].compareTo(data[hci])<0){
					 swap(data,hci,index);
				 index = hci;
				 }
				 else{
					 //if it is not necessary to swap with that, then the heap property is restored
				 		break;
				 }
			 }
			
			
			
		
		 
		}
		
	   public void InplaceHeapSort (V[] data){
			 int maxIndex =0;
			 //first sort data to be a max heap
			 while(maxIndex<data.length){
				 bubbleUpMax(data,maxIndex);
				 maxIndex++;
			 }
			// System.out.println("Is now a max heap");
			 ///System.out.println(Arrays.toString(data));
			 //now that the max heap, is built, swap the root and the last leaf of the max heap
			 int root =0;
			 int leaf = data.length-1;//last element in max heap, will change as that is changed
			 int els = 0;
		
			 
			 //now swap what's at root with what is at leaf, then move it down
			 while(els<data.length){
				
				 swap(data,root,leaf);
				 
				// System.out.println("In second while loop");
				 //System.out.println("After swapping, leaf and root, before root is bubbled down pbi passed to bd is " + leaf);
				 //System.out.println(Arrays.toString(data));
				 bubbleDown(data,root,leaf);
				 leaf--;
				 els++;
				// System.out.println("els in final min heap " + els);
				 //System.out.println(Arrays.toString(data));
				 
			 }
		

			 
		 }

	public static void main(String args[]){
		
		//first make a heap
		HeapUtils<Integer> obj = new HeapUtils<Integer>();
		Integer[] data ={6,3,1,7,8,2,9,4,5};
		Integer[] bdt = {5,7,8,4,9,10,11,12};
		int rc = obj.getIndexOfRightChild(1);
		int lc = obj.getIndexOfLeftChild(1);
		int par = obj.getParentIndex(1);
		if(rc==4 && lc == 3 && par ==0){
			System.out.println("Pass all the get index methods!!!");
		}
		else{
						System.out.println("Fail :(   right child was " + rc + " left child was " + lc + " parent was " + par );

		}
		obj.bubbleUp(data,5);
		obj.bubbleUp(data,6);
		obj.bubbleUp(data,7);
		obj.bubbleUp(data,8);

		System.out.println("Bubble up test:");
		System.out.println(Arrays.toString(data));
		obj.bubbleDown(bdt,0,4);
		System.out.println();
		System.out.println("Bubble down test:");
		System.out.println(Arrays.toString(bdt));
		
		System.out.println();
		System.out.println("Heap sort test:");

		obj.InplaceHeapSort(data);
		String hep = Arrays.toString(data);
		System.out.println(hep);
		}
	
}
