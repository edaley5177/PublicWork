def addBorder(picture):
    askertisk = '*'
    #picture is a list of strings
    e=0
    while(e<len(picture)):
        temp=list(picture[e])
        temp.insert(0,askertisk)
        temp.append(askertisk)
        picture[e]=''.join(temp)
        print "after adding * e is: ", picture[e]
        e+=1
        
    #make the first and last element in the list a string of askertisks
    print "after for, picture is : ", picture
    picture.insert(0,askertisk* len(picture[0]))
    
     
    picture.insert(len(picture), askertisk*len(picture[0]))
    return picture