def solution(s):
    bigg=[]
    lis = []
    for i in s:
        if i.islower()==False:
            bigg.append(i)
            s = s.replace(i,'')
        else: lis.append(i)
            
    lis.sort(reverse=True)
    bigg.sort(reverse=True)
    lis.extend(bigg)
    return ''.join(lis)