def solution(data, ext, val_ext, sort_by):
    answer = []
    d_str = ['code','date','maximum','remain']
    for d in data:
        idx = d_str.index(ext)
        if d[idx]<val_ext:
            answer.append(d)
    idx = d_str.index(sort_by)
    answer.sort(key=lambda x:x[idx])
    return answer