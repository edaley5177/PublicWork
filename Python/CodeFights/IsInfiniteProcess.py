# Given integers a and b, determine whether the following pseudocode results in an infinite loop

# while a is not equal to b do
#   increase a by 1
#   decrease b by 1
# Assume that the program is executed on a virtual machine which can store arbitrary long numbers and execute forever.

def isInfiniteProcess(a, b):

    if(a>b):
        return True
    
    if(a==b):
        return False
    if((a%2 ==0 and b%2==1) or (a%2==1 and b%2==0)):
        return True
    return False