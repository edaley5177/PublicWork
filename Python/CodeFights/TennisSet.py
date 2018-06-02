# In tennis, a set is finished when one of the players wins 6 games and the other one wins less than 5, or, if both players win at least 5 games, until one of the players wins 7 games.

# Determine if it is possible for a tennis set to be finished with the score score1 : score2.
def tennisSet(score1, score2):
    if(score1==score2):
        return False

    if(score1 >7 or score2>7):
        return False
    if((score1==6  and score2<=4 ) or (score2==6 and score1<=4) ):
        return True
    
    if((score1>6 and score2<=4) or (score2>6 and score1<=4)):
        return False
    
    if((score1 ==7 and score2 >=5 ) or (score2==7 and score1 >=5)):
        return True
    
    if((score1>=5 or score2>=5) and (score1==7 or score2==7)):
        return True
    return False
        