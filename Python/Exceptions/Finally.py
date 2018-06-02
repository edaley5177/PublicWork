try:
    #this will execute
    #will go to finally when an exception occcurs
    fh =open("testfile","w")
    try:
        fh.write("this is my test")
    
    finally:
    #what goes here will forsure be executed
    #can't use except if you use finally, can't use else if you use finally
        print "Going to close the file"
        fh.close()
except IOError:
    print "can't find file or read data"