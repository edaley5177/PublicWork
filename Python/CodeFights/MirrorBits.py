# Reverse the order of the bits in a given integer.

# Example

# For a = 97, the output should be
# mirrorBits(a) = 67.

# 97 equals to 1100001 in binary, which is 1000011 after mirroring, and that is 67 in base 10.

# For a = 8, the output should be
# mirrorBits(a) = 1.

def mirrorBits(a):
    import math
    power=int(math.log10(a)/math.log10(2))
    i=0
    ret=0
    while(power>=0):
        ret += (a%2) * 2**power
        print "power is :", power, " ret is : ", ret, " a mod 2**power is: ", a%(2**power)
        a/=2
        power-=1
    
    return ret