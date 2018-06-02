import time;

ticks = time.time()
print "Number of seconds since 1/1/1970 : ", ticks

print time.localtime()
print time.asctime(time.localtime())#this will print all info in time tuple in a more readable format

#time.altzone -off set for a different time zone

#time.clock()-returns the current cpu time as a floating point time
print "current cpu time: ", time.clock()
#time.mktime(timeTuple)-accepts time tuple and converts it to seconds since epoch
t =(2018,4,26,16,30,56,3,116,0)
d= time.mktime(t)
print "my birthday this year was at ticks:  ", d
#time.sleep(x)-suspends the calling thread for x seconds

#time.strftime(timetuple)-returns string representing instant
