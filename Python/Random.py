#different ways to get a random number
import random
#choice(seq)-returns a random item from a list, tuple, or string
list = ["thing1", "thing2", "thing3"]
print "choice (list):", random.choice(list) 
string = "Hello world!"
print "random character: ", random.choice(string)
#randrange([start], stop[,step])-returns a random element from this range
print "randrange(1, 100,2 ): ", random.randrange(1,100,2), "random even number 1-100"
print "randrange(100): ", random.randrange(100)
#random()-returns a randome float r where 0<= r<1
print "random(): ", random.random()


#seed([x])-sets the seed for random numbers call this before using any others listed here
random.seed()
print "random number with default seed: ", random.random()
#random.seed(10)#better to just use default seed, giving it a seed returns the same number every time
print "random number with seed 10: ", random.random()

#random.seed("hello")
print "random string seed", random.random()
#shuffle(lst)-randomizes the items of a list, makes it easy to test a sorting algortihm
random.shuffle(list)
print "shuffle(list): ", list 
#uniform(x,y)-returns a random float r where x<=r <y
print "uniform(4,10): ", random.uniform(1,1000)