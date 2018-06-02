# Call two arms equally strong if the heaviest weights they each are able to lift are equal.

# Call two people equally strong if their strongest arms are equally strong (the strongest arm can be both the right and the left), and so are their weakest arms.

# Given your and your friend's arms' lifting capabilities find out if you two are equally strong.\


def areEquallyStrong(yourLeft, yourRight, friendsLeft, friendsRight):
	myWeak = min(yourLeft, yourRight)#my weakest arm
	myStrength=max(yourLeft, yourRight)#my strongest arm
	friendsWeak=min(friendsLeft, friendsRight)#friends weakest arm
	friendsStrength=max(friendsLeft, friendsRight)#friends strongest arm
	if(myStrength==friendsStrength and myWeak==friendsWeak):
        	return True
	return False