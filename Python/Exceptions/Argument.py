def square(n):
    try:
        print int(n)," squared is: ",int(n)**2
        return
    except ValueError as Argument:
        print "The argument doesn't contain numbers\n", Argument

square("10")
square("xyz")