def solution(binomial):
    b = binomial.split(" ")
    if b[1]=="+": return int(b[0])+int(b[2])
    elif b[1]=="-": return int(b[0])-int(b[2])
    else: return int(b[0])*int(b[2])