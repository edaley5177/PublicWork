
#tuples are sequences 
print "len(1,2,3)", len((1,2,3))

tup1= ('math', 'humanities', 'science', 'physics')
tup2=(100,117,514,715,420,315)
print "1 max: ", max(tup1), " 2 max: ", max(tup2)


print "1 min: ", min(tup1), " 2 min: ", min(tup2)

list1=['bio','subs','math','numbers']
liToTup=tuple(list1)

print "List to tuple: ", liToTup

print "tuple from string: ", tuple("hello world")

# a list of comma seperated items with no delimiters defaults to a tuple
h = "one", 2, 3.14, 15, 'another'
print "type of h: ", type(h)

print "comparing 1 and 2: ", cmp(tup1, tup2)