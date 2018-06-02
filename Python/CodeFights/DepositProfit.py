def depositProfit(deposit, rate, threshold):

    rr= rate/100.0
    i=0
    cb=deposit
    print "rr =: ",rr
    while(cb<threshold):
        cb+= cb*rr
        print "current balance : ", cb
        i+=1
    
    return i