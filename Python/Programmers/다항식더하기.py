def solution(polynomial):
    variable = polynomial.split("+")
    variable.sort()
    digit = 0
    x = 0
    
    for var in variable:
        var = var.strip()
        if var.isdigit(): digit+=int(var)
        else:
            x+= int(var[:-1] or 1)
    
    if x==0: x = ''
    elif x==1: x = 'x'
    else: x = str(x)+'x'
    
    if digit==0: return x
    elif x: return x+' + '+str(digit)
    else: return str(digit)