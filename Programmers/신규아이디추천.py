def solution(new_id):
    answer = ''
    
    lower_id = new_id.lower()
    
    replace_id = ''
    for i in lower_id:
        if i.isdigit()==True or i.isalpha()==True or i=='-' or i=='_' or i=='.':
            replace_id += i
            
    deldot_id = ''
    for j in range(len(replace_id)-1):
        if replace_id[j] != '.' or replace_id[j] != replace_id[j+1]:
            deldot_id += replace_id[j]
    deldot_id += replace_id[-1]
    
    strip_id = deldot_id.strip('.')
    
    if strip_id == "":
        strip_id = "a"
    
    if len(strip_id) >= 16:
        strip_id = strip_id[:15].rstrip('.')
    
    while len(strip_id) <= 2:
        strip_id += strip_id[-1]
        
    return strip_id