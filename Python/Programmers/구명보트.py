def solution(people, limit):
    answer = len(people)
    sort_list = sorted(people,reverse=True)
    s,e = 0,len(sort_list)-1
    while s < e:
        if sort_list[s]+sort_list[e] <= limit:
            e -= 1
            answer -= 1
        s += 1
    
    # answer = 0
    # people.sort()
    # test=[]
    # while people:
    #     if (sum(test)+people[0]) <= limit:
    #         test.append(people[0])
    #         people.pop(0)
    #         answer+=1
    #     else:
    #         test=[]
        
    return answer