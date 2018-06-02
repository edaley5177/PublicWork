# Consider an arithmetic expression of the form a#b=c. Check whether it is possible to replace # with one of the four signs: +, -, * or / to obtain a correct expression.
def arithmeticExpression(a, b, c):

    #just try all 4 possible replace ments
    if(a+b==c or a-b==c or a*b==c):
        return True
    # division is a special case, there can't be a remainder
    if(a/b ==c and a%b==0):
        return True
    
    return False