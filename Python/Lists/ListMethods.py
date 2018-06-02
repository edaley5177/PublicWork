#useful methods with lists
list1=["C++", "Java","Python"]
#list.append(obj) appends an object to the list
list1.append("C")
print "after adding C :", list1
#list.count(obj) returns the number of times that obj appears in list

#list.extend(seq) appends contents of seq to list
list2=list(range(6))
list1.extend(list2)
print "after extending: ", list1
#list.index(obj) returns the lowest index that obj appears at
print "index of Java", list1.index("Java")
#list.insert(index,obj) inserts obj into list at index 
list1.insert(3,"other")
print "after insertion: ", list1
#list.pop(obj=list[4]) removes and returns object at index 4

#list.remove(obj) remove obj from list
list1.remove('C++')
print "after removing c++: ",list1
#len(list) returns total lenght of list

#max(list), min(list) return min or max of a list

#list(seq) convert a sequence
str1="heythere"
listLast=list(str1)

print listLast