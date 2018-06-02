#various functions for strings
str ="This just an example string $%& .. 87"
#x.capitalize()- converts all letters to capital
str.capitalize();
print str
#count(str, beg=0, end=len(string))
sub='i'
print "str.count('i'): ", str.count(sub)
print "str.count('z.): ", str.count('z')
sub='exam'
print "str.count('exam', 10, 40 ): ", str.count(sub, 10,40)
#center(width, fillchar)
#startswith(prefix, beg=0, end=len(string)
print "starts with This:", str.startswith('This')
print str, "this at 8 t an: ", str.startswith('t an', 8)
print str,"5-9= just: ", str.startswith('just',5,9)
#endswith(suffix, beg=0, end=len(string))
print "ends with 87: ", str.endswith("87")
#expandtabs(tabsize=8)
#find(str,beg=0, end=len(string))
#index(str,beg=0, end=len(string)) fails if substring not found
str2 ="exam"
print "index: ", str, sub, str.index(sub)
print str, sub, str.index(sub,10)
#join(seq)
#len(string)
#ljust(width[, fill char])
#max(str)-returns highest ascii value character
print "max char: "+ max(str)
#min(str)-returns lowest ascii value character
print "minchar: " + min(str)
#upper()
#lower()
