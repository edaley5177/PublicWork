try:
    x=int(raw_input("enter number"))
    y=int(raw_input("enter another number"))
    z=x/y
    print "z= ",z
except (KeyboardInterrupt, ValueError, ZeroDivisionError):
    print "Error occured"