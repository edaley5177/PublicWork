# Two arrays are called similar if one can be obtained from another by swapping at most one pair of elements in one of the arrays.

# Given two arrays a and b, check whether they are similar.
def areSimilar(a, b):
	ret=0
	fe=-1#index of first elelement to swap
	se=-1#index of second element to swap
	i=0
	while(i<len(a)):
		if (a[i] == b[i]):
			i+=1
		else:
                        if(ret==0):
                                fe=i
                        elif(ret==1):
                                se=i
                        ret +=1
                        i+=1
	print "after while fe = ", fe, " and se = ", se
	if(ret >2):return False
	
        #otherwise swap the two different indicies and see if they are equal
	temp = a[fe]
	a[fe]=a[se]
	a[se]=temp
	
	if(a==b):
        
        	return True
	return False