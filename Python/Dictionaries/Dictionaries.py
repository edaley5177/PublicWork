#a dictionary is a set of key value pairs
#value has no restrictions, it can be any python object
#a key must map to only one value, it must be immutable a.k.a. the same key can't be used twice in the same dictionary
dict ={'Name':'Eamonn', 'Djname':"E$"}
print dict
dict['Djname'] = "Emoney"
print dict

dict['Nickname'] = "aim"#add a new key value pair
print dict

del dict['Name']
print dict

#functions with dictionaries
#len(dict) how many total key value pairs are there in the dictionary
print len(dict)
#str(dict) makes a string representation of dict
print str(dict)