#different kinds of function arguments in python

#required arguments
def printme(str):
    print str
    return
printme("Printed")

#keyword arguments
def keyword(name, age):
    print "name: ", name, "Age: ", age
    return
keyword("eamonn", 15)
keyword(age=78, name="myName")

#default arguments
def default(name, age=89):
    print "name : ", name, "age:", age
    return
default("eamonn")
default("other", 17)

#variable length arguments
def variable(required, *notReq):
    print "required: ", required
    for var in notReq:
        print var
    return
variable("ti")
variable("that", 56, 54, "this")