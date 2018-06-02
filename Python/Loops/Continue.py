#continue in python
for letter in 'Python':
    if letter =='h':
        continue
    print "current letter: ", letter
    
var =10
while var>0:
    var-=1
    if var==5:
        continue
    print "current value of var: ", var

pwd="wrong"
while (True):
    x= raw_input("Password")
    if x!=pwd:
        print "Wrong try again"
        continue
    print "Correct"
    break

