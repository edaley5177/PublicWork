#attributes for files
fo = open("Sample", "r")
#file.closed-returns true if file is close, otherwise false
print "is it closed?: ", fo.closed
#file.mode-returns access mode with which file was opened
print "access mode: ", fo.mode
#file.name- returns the name of the file
print "name of file: ", fo.name
#file.softspace -returns false if space explicitly required with print not in python 3