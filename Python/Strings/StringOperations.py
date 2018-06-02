#operations on strings
#+ concatenation
x = "this is x"
y = "this is y"
print x+y

y+=x
print "after adding x, this is y: ", y
#* repetition
#a*9 will return string a nine times
a = "hello"
print a*3
# [] slice
#a[x] returns character in spot x of string a
print a[1]
# a[x:y] returns characters in from x to y not including y
print a[1:4]

#h in a gives 1
#m not in a gives 1

#r/ R prints the raw string ignores esc characters

print r'\n'
print R'\n'
