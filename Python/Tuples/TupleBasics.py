tup1=('physics', 'chemsitry', 1994, 2000)
tup2=(1,2,3,4,5,6,7)
print tup1, tup2
print "tup1[0]: ", tup1[0]

print "tup2[1:5]: ", tup2[1:5]

print "update example"

tup1 =(12, 34.56)
tup2=("abc", 'wxyz')

#tup1[0]=100

tup3 = tup1+tup2

print "new tuple: ", tup3
#tuples are immutable, so trying to delete or update a specific element is not allowed