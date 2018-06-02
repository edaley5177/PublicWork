#opening and closing files

#fileObj=open(filename, acessMode(opt), buffering(opt))
fileObj=open("Sample", "w")
#filename=string value that contains the name of the file
#accessMode=how the file should be opened, read write append etc
#r-open for reading only
#rb-open for reading only in binfary format
#r+, w+-open for reading and writing
#rb+, wb+-reading and writing in binary format
#w-open for writing only
#wb-open for writing only in binary format
#a-opens file for appending
#ab-opens file for appending in binary format
#a+-opens file for appending and reading
#ab+-opens file for appending and reading in binary format
#buffering: 0 = no buffering
#1=line buffereing will be performed while accessing the file
#>1=Buffering will be performed with the indicated size
#<0 = buffering size is set by system, default behavior


fileObj.write("Welcome")
fileObj.write(" to file writing\n")
fileObj.write("I've found a practical use for newline")
#fileObj.close() to close file when done using it
fileObj.close()