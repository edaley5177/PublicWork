# You are given two numbers a and b where 0 ≤ a ≤ b. Imagine you construct an array of all the integers from a to b inclusive. You need to count the number of 1s in the binary representations of all the numbers in the array.
def howManyOnes(x):
    #given an integer x, return the number of 1s in the binary representation of that int
    ret =0
    while(x>0):
        ret+=x%2
        x/=2
        
    return ret

def rangeBitCount(a, b):
    
    tot=0
    for x in range(a,b+1):
        tot+=howManyOnes(x)
    return tot
    