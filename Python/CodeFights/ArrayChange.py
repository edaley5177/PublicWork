#You are given an array of integers. On each move you are allowed to increase exactly one of its element by one. Find the minimal number of moves required to obtain a strictly increasing sequence from the input.

def arrayChange(inputArray):

	#for each number i, where in[i] is >in[i+1], get the dif in[i]-in[i+1] +1 add that total and in[i+i]
	currTot=0
	i=0
	while(i<len(inputArray)-1):
		if(inputArray[i]>=inputArray[i+1]):
			dif =inputArray[i]-inputArray[i+1]+1
			currTot+=dif
			inputArray[i+1]+=dif 
            	i+=1
    	return currTot