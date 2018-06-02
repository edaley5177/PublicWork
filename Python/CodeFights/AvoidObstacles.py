# You are given an array of integers representing coordinates of obstacles situated on a straight line.

# Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only to make jumps of the same length represented by some integer.

# Find the minimal length of the jump enough to avoid all the obstacles.

def avoidObstacles(inputArray):

    #I have to find the first integer that is not a multiple of all the numbers in the arra
    #starting at 2
    x=2
  
    z=-1
    while(z==-1):
        i=0#iterator for inner loop to search whole array
        while(i<len(inputArray)):
            if(inputArray[i]%x ==0):
                x+=1
                i=50#restart loop with next x
            i+=1
            
        if(i<50):
            return x
            
                
            
        