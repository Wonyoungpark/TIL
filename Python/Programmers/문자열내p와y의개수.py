def solution(s):
    answer = True
    str = s.lower()
    if str.count("p") ==0 and str.count("y")==0:
        return True
    elif str.count("p") == str.count("y"):
        return True
    else: return False