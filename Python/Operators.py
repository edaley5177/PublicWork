#different kinds of operators in python
c=0;
#Arithmetic operators
#+ addition
#- subtraction
#* multiplication
#/ division
#% mod
#**exponent
c=10//3
print "2**8: " , 2**8
#//floor division - the digits after the decimal point are removed
print "10//3: ", c
#Comparison operators
#>,<,<=...
#Assignment Operators
#=, /=,*=,-=,+=, **=

#Logical Operators
#or logical or
#and logical and
#not logical not

#Bitwise Operators
#& perform binary and operation on two arguments
#| perform binary or operation
#^ binary xor
#~x flips the bits of x
#<< binary left shift
#>> binary right shift

#Membership Operators
#x in y returns T if x is a member of the "list" y 
#x not in y returns T if x is not in the "Set" y
# can be used in tuples, lists, or strings

a=10
b=20
list =[1,2,3,4,5]
print list
if (a in list):
    print "a is in the given list"
else:
    print "a is not in the given list"
    
if (b not in list):
    print "b is not in the list"
else:
    print "b is in the list"
#Identity Operators
#x is y returns 1 if id(x)==id(y), aka they point to the same memory location
x=20
y=x
print "x= ", x, ": ", id(x), "y= ", y, ": ", id(y)
if (x is y):
    print "x and y point to same mem location"
else: 
    print "x and y point to different locations"
    
y =90
print "x= ", x, ": ", id(x), "y= ", y, ": ", id(y)

#x is not y returns 1 if they each point to a different memory location
if (x is not y):
    print "x and y are in different memory locations"
else:
    print "x and y are in the same place in memory"
    
#presedence in python
#when in doubt use ()
#from highes presednece to lowest, in same () will be evaluated l to r
#(**),(~),(*,/,%,//), (+,-),(<<, >>),(&), (^,|), (<=, >=...), (==,!=), (assignment), (identity), (membership), (and, or, not)