# An IP address is a numerical label assigned to each device (e.g., computer, printer) participating in a computer network that uses the Internet Protocol for communication. There are two versions of the Internet protocol, and thus two versions of addresses. One of them is the IPv4 address.

# IPv4 addresses are represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255 inclusive, separated by dots, e.g., 172.16.254.1.

# Given a string, find out if it satisfies the IPv4 address naming rules.
def isIPv4Address(inputString):
        if(inputString.count('.') != 3):
        	return False
        if(inputString.startswith('.')):
                return False
        if(len(inputString)>15):
                return False
                
        
        first3=''#the first set of digits
        second3=''#the next set digits
        third3=''# the third set of digits
        last3=''#the last set of digits
        
        i=0#iterator for while loop
        while(inputString[i]!= '.'):
                first3+=inputString[i]
                i+=1
        i+=1      
        while(inputString[i]!='.'):
                second3+=inputString[i]
                i+=1
        i+=1
        while(inputString[i]!='.'):
                third3+=inputString[i]
                i+=1
        i+=1
        while(i<len(inputString)):
                last3+=inputString[i]
                i+=1
          
        
        print "first 3 digits are ", first3, " second 3: ", second3, " third set: ", third3, " last set: ", last3
        try:
                
                if(int(first3)<256 and int(second3) <256 and int(third3)<256 and int(last3)<256):
                        return True
                return False
        except ValueError:
                return False
                
                
                