def shapeArea(n):

  #recursively 
  #base case
  if(n==1):
    return 1
  #recursive case
  else:
    return shapeArea(n-1) + 4*(n-1)
    
shapeArea(9000)