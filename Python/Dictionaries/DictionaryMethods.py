#methods that can be used with dictionaries
#dict.clear()-removes all elements from a dictionary
dict={"letter":"l", "number":"517"}
#dict.copy()-returns a shallow copy of dict means that the copy an orginal are pointing to smae mem location

print dict.copy()
#dict.fromkeys() -create a new dictionary with keys

#dict.get(key,default=none)-returns value or default if key not in dict
print dict.get("letter")
print dict.get("not", default="none")
#dict.items() returns a list of tuple pairs
print dict.items()

#dict.keys() returns a list of keys

#dict.setdefault(key, default=None) set dict[key] = default if key is not already in dict

# dict.update(dict2) adds dict2's key-value pairs to dict