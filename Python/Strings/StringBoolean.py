#boolean functions that can be performed on strings
#x.isalnum()-returns T if the string x contans only numbers and letters
str1="numbers 789 and letters"
if str1.isalnum():
    print "str1 is aplhanumeric"
str1= "just letters"
print "now its not", str1.isalnum()
#x.isalpha()-returns T if the string x contains only letters
print "true because only letters", str1.isalpha()

#x.isdigit()-returns T if the string x contains only numbers
nums = "14587"
print "only numbers ", nums.isdigit()

#islower(x)-returns T if all letters in x are lowercase
print "str1 all lower ", str1.islower()

#isnumeric(x)-returns T if the string x contatins numbers or special numeric characters
str1="45th" 
print "nums numeric: ", nums.isnumeric() " str1 not: ", str1.isnumeric()
#isspace(x)- returns T if the string x is only white space
str1="this has a space"
print str1.isspace()
str1= " "
print str1.isspace()
#istitle(x)- returns T if each word in string is starts with an upper case letter
tit= "Every Word Starts"
print tit.istitle()
#isupper(x)-returns T if the string x contains only Upper case letters
upper = "EVERY LETTER IS BIG"
print upper.isupper()