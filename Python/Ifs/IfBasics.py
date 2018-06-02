#if, if...else, nested if

#can use all functions use comparison operators and membership operators

discount =0
amount =int(input("Enter amount"))
#this is an if ...else statement
if amount>1000:
    discount=amount*0.10
else:
    discount=amount*0.05
print "Discount: ", discount
print "net : ", amount-discount


#if, elif, and else
#elif is an optional statement
#else if, else if...
a=int(input("2nd amount"))

if a>10:
    print "greater than 10"
elif a>5:
    print "A 5-10"
elif a>1:
    print "a1-5"
else:
    print "a is very low"