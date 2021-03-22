def checktime(time,list):
    checkpoint = 0
    start = time
    end = time + 1000
    
    for i in list:
        if i[1] >= start and i[0] < end:
            checkpoint += 1
    return checkpoint


def solution(lines):
    list = []
    answer = 1
    
    for line in lines:
        days,times,speeds = line.split()
        times = times.split(':')
        speeds = float(speeds[:-1])*1000
        endTime = (int(times[0])*3600 + int(times[1])*60 + float(times[2]))*1000
        startTime = endTime - speeds + 1
        list.append([startTime,endTime])
    
    for i in list:
        answer = max(answer,checktime(i[0],list), checktime(i[1],list))
    
    return answer