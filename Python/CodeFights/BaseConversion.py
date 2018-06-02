def baseConversion(n, x):
    #convert n to binary string and look at every 4 bits
    #first print out the ascii value of every character in n
    for t in n:
        print "ASCII of ", t, " is : ", ord(t)
  
    # print "5^0 * ", n[3]
    # print "5^1 * ", n[2]
    # print "5^2 * ", n[1]
    # print "5^3 * ", n[0]
baseConversion("1302", 5)
#baseConversion("1010100101", 2)
baseConversion("z",36)