#examples for using command line args
#len(sys.argv) returns the number of arguments a.k.a. argv
#sys.argv[0] is the name of the script
#sys.argv[1] is the first argument exactly like c and  C++
import sys
print 'Number of arguments:', len(sys.argv), 'arguments.'
print 'Agument List:', str(sys.argv)
x=int(sys.argv[1])
y=int(sys.argv[2])
z=x+y
print "x= ",x,"y= ",y, "z= ", z

string1="string1"
string2="heyyyyyy"
comb = string1+string2

print (comb)