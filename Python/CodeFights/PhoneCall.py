# Some phone usage rate may be described as follows:

# first minute of a call costs min1 cents,
# each minute from the 2nd up to 10th (inclusive) costs min2_10 cents
# each minute after 10th costs min11 cents.
# You have s cents on your account before the call. 
#What is the duration of the longest call (in minutes rounded down to the nearest integer) you can have?
def phoneCall(min1, min2_10, min11, s):
    minsTalking =0
    s-=min1
    if(s>0):
        #continue with 2-10 minute rate
        minsTalking+=1
        print "after talking for 1 minute, I have ", s, " cents left "
        print "s/min210 is : ", s/min2_10
        if(s>=min2_10*9):
            minsTalking+=9
            
        else:
            return minsTalking + (s/min2_10)
        s-=min2_10*9
        print "I just talked for 10 minutes I have ", s, " cents left"
        print "which is enough for another: ", s/min11, " minutes"
        return minsTalking +(s/min11)
    elif(s==0):
        return 1
    else:
        return 0
        
 