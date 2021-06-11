def solution(record):
    answer = []
    user = {}

    for msg in record:
        words = msg.split()
        if (words[0] == "Enter") | (words[0] == "Change"):
            user[words[1]] = words[2]
    
    for msg in record:
        words = msg.split()
        if words[0] == "Enter":
            answer.append("{}님이 들어왔습니다.".format(user[words[1]]))
        elif words[0] == "Leave":
            answer.append("{}님이 나갔습니다.".format(user[words[1]]))
    return answer


# def find_id(stack,lists):
#     cnt = 0
#     answer = []
#     for i in stack:
#         if lists[1] in i:
#             answer.append(cnt)
#         cnt += 1
#     return answer

# def change_language(stack):
#     answer = []
#     for s in stack:
#         if s[0] == "Enter": answer.append(s[2]+"님이 들어왔습니다.")
#         else:
#             answer.append(s[2]+"님이 나갔습니다.")
#     return answer

# def solution(record):
#     stack = []
#     for words in record:
#         lists = words.split()
#         index = find_id(stack,lists)
#         if words.startswith("Enter"):
#             if index == []:
#                 stack.append(lists)
#             else:
#                 for i in index:
#                     stack[i].pop()
#                     stack[i].append(lists[2])
#                 stack.append(lists)
#         elif words.startswith("Leave"):
#             lists.append(stack[index[0]][2])
#             stack.append(lists)
#         else:
#             for i in index:
#                 stack[i].pop()
#                 stack[i].append(lists[2])
                
#     answer = change_language(stack)
#     return answer