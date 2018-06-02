#a list of mathematical functions in python

#import math is not needed for abs(x), max, min, pow, and round
#abs(x)- returns the absolute value of x
print "abs (-45:)", abs(-45)#import math is not needed for abs
print "abs(100.23)", abs(100.23)
#ceil(x)- returns the smallest integer not < x
import math
print "ceil(-45.17): ", math.ceil(-45.17)
print "ceil (100.12): ", math.ceil(100.12)
print "ceil (100.72): ", math.ceil(100.72)
print "ceil(pi): ", math.ceil(math.pi)
#exp(x)- returns e^x
print "exp(-45.17): ", math.exp(-45.17)
print "exp (100.12): ", math.exp(100.12)
print "exp (1): ", math.exp(1)
print "exp(pi): ", math.exp(math.pi)
#floor(x)-returns the largest integer not > x
print "floor(-45.17): ", math.floor(-45.17)
print "floor (100.12): ", math.floor(100.12)
print "floor (100.72): ", math.floor(100.72)
print "floor(pi): ", math.floor(math.pi)
#log(x)-returns the natural log of x, x>0
print "log (100.12): ", math.log(100.12)
print "log (100.72): ", math.log(100.72)
print "log(pi): ", math.log(math.pi)
#log10(x)-returns the base-10 logarithm of x
print "log10 (100.12): ", math.log10(100.12)
print "log10 (100.72): ", math.log10(100.72)
print "log10(pi): ", math.log10(math.pi)
#max(x1,x2,...xn)-returns the largest of all n arguments
print "max(23, 15, 16, 17, 54): ", max(23,15,17,16,54)
#min(x1,x,2,...xn)-returns the smallest of all in arguments
print "min(23,15,17,16,54): ", min(23,15,16,17,54)
#pow(x,y)-returns the value of x^y
five =5
two=2
print "2^5: ", pow(two,five)
print "8^16", pow(8, 16)
#round(x[,n])-returns x rounded to n digits from the decimal point. 0.5 =1
#with no argument after , will round to nearest integer
print "round(70.23456): ", round(70.23456)
print "round(70.23456, 1): ", round(70.23456, 1)
print "round(100.000056, 4): ", round(100.000056,4)
print "round(-100.000056, 4): ", round(-100.000056, 4)
#sqrt(x)-returns the square root of x x>0
print "sqrt(100): ", math.sqrt(100)
print "sqrt(17): ", math.sqrt(17)
