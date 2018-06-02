#Modules can be used to ogranize your code
#if __name__ =="__main__": will be true if module is not imported from somewhere
    #main()
    
def fibo(n):
    result =[]
    a, b=0,1
    while b<n:
        result.append(b)
        a, b=b, a+b
    return result

def hello():
    print("hey")
    return
if __name__=="__main__":
    print fibo(100)