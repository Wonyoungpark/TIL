from datetime import datetime
from dateutil.relativedelta import relativedelta

def solution(today, terms, privacies):
    answer = []
    d_time = datetime.strptime(today,'%Y.%m.%d')
    
    t_dic = {}
    for t in terms:
        t_list = t.split()
        t_dic[t_list[0]] = int(t_list[1])
    
    for e,p in enumerate(privacies):
        p_time = datetime.strptime(p[:-2],'%Y.%m.%d')
        t = p_time + relativedelta(months=t_dic[p[-1]])
        if (d_time>=t): answer.append(e+1)
    return answer