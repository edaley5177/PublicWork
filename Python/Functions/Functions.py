#how to use functions in python
def add(x,y):
    return x+y
    
print add(5,3)

#pass by reference in python, basically reference = pointer
def changeme (mylist):
    print id(mylist)
    print "Before change: ", mylist
    mylist[2] = 40
    print "after change: ", mylist
    return
def changeme2(mylist):
    mylist=[1,2,3]
    print "inside func: ", mylist
myl = [10,30, 100, 65, 14]
changeme(myl)
changeme2(myl)
print "outside func: ", myl
#id(obj) wil return the location in memory that obj is stored at