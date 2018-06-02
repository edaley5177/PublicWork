try:
#put code here
    fh=open("testfile", "r")
    fh.write("this is a test")
except IOError:
    #if try fails this will be executed to handle the exception
    print "Can't find file or read data"
#can have mutiple try except blocks, you may want to handle different exceptions differently

else:
    #use this for code that doesn't need protection for exceptions
    #this will execute if try executed without errors
    print "Successfully wrote"