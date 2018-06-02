#for loops in python
list1=[1,2,3,4,5,6]

for x in list1:
    print x
    
for letter in "Java":
    print "Current Letter:", letter
    
items =["gun", "knife", "lamp", "bullet"]

for thing in items:
    print "Current item: ", thing
    
    
#range function in for loop
for num in range(5):
    print num
    
for num in range(1,4):
    print num
    
for num in range(1,10,2):
    print num
    
#iterating by sequence index
dict={"011": "New Delhi", "022": "Houghton", "033":"Grosse Ile"}

for key in dict:
    print dict[key]
    
for key,value in dict.items():
    print key,value
    
for val in dict.values():
    print val
for key in dict.keys():
    print key
    
#nested loops
list2=[1,2,3]
for x in list1:
    for y in list2:
        print "list 2: ", y
    print "list1: ", x


