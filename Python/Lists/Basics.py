#list items can be any type
list1 = ["string", 12, 'chars']
print list1

#use index of particular elements to 
print list1[0]
list1[0] = "new value"

list1[0]= 17
print list1[0]
del list1[0]
print list1

list2=[1,2,3,4,5,6,7]
print list2[1:4]

print "len of list2 : ", len(list2)
#+to concatenate 2 lists together
#can use in and iterations

for x in list2: print x

#this prints 4,5,6,7
print list2[3:]

#this prints 2
print list2[-6]

list3=[]