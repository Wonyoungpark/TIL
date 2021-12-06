def solution(arr1, arr2):
    answer = []
    
    for a1,a2 in zip(arr1,arr2):
        answer.append([x+y for x,y in zip(a1,a2)])
    return answer