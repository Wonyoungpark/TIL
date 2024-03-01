def solution(files):
    answer = []
    names = []
    
    for file in files:
        file_name=["","",""]
        i=0
        for e,f in enumerate(file):
            if i==0 and not f.isdigit():
                file_name[i]+=f
            elif f.isdigit():
                i=1
                file_name[i]+=f
            else:
                file_name[2]+=file[e:]
                i=0
                break
        names.append(file_name)
        
    names.sort(key=lambda x:(x[0].lower(),int(x[1])))
    
    for name in names:
        answer.append(''.join(name))
    return answer