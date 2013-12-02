package com.algorithms.fpgrowth;


import java.util.ArrayList;
import java.util.List;


public class FPNode_Strings {
	 // item id
	String itemID = null; 
	// support of that node
	int counter = 1;  
	
	// reference to the parent node or null if this is the root
	FPNode_Strings parent = null; 
	// references to the child(s) of that node if there is some
	List<FPNode_Strings> childs = new ArrayList<FPNode_Strings>();
	
	FPNode_Strings nodeLink = null; // link to next node with the same item id (for the header table).
	
	/**
	 * Default constructor
	 */
	FPNode_Strings(){
		
	}

	/**
	 * Return the immediate child of this node having a given ID.
	 * If there is no such child, return null;
	 */
	FPNode_Strings getChildWithID(String id) {
		// for each child node
		for(FPNode_Strings child : childs){
			// if the id is the one that we are looking for
			if(child.itemID.equals(id)){
				// return that node
				return child;
			}
		}
		// if not found, return null
		return null;
	}

}
