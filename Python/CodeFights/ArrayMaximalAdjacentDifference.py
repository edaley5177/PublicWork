# Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.
def arrayMaximalAdjacentDifference(inputArray):

	currHighDiff=-1#the current highest difference between any 2 adjacent elements
    
	x=1
	while(x<len(inputArray) -1):
		if(inputArray[x+1] is None):
        		break
        	if(max(abs(inputArray[x-1]-inputArray[x]), abs(inputArray[x]-inputArray[x+1])) > currHighDiff):
			currHighDiff = max(abs(inputArray[x-1]-inputArray[x]), abs(inputArray[x]-inputArray[x+1]))
        	x+=1

	return currHighDiff