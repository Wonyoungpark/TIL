from datetime import datetime
from collections import defaultdict
import math

def solution(fees, records):
    answer = []
    result = defaultdict(int)
    stack = {}
    record = [r.split(" ") for r in records]
    
    for r in record:
        if r[2]=='IN':
            stack[r[1]]=r[0]
        else:
            out = stack.pop(r[1])
            diff = datetime.strptime(r[0],"%H:%M")-datetime.strptime(out,"%H:%M")
            minutes = diff.total_seconds()/60
            result[r[1]]+=minutes
                
    for k,v in stack.items():
        diff = datetime.strptime("23:59","%H:%M")-datetime.strptime(v,"%H:%M")
        minutes = diff.total_seconds()/60
        result[k]+=minutes
    
    for car,minutes in result.items():
        if minutes<=fees[0]: result[car]=fees[1]
        else:
            over = math.ceil((minutes-fees[0])/fees[2])*fees[3]
            result[car]=(fees[1]+over)
    
    answer = list(dict(sorted(result.items())).values())
    return answer