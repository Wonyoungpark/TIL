def solution(phone_book):
    answer = True
    
    phone_book.sort()
    for a, b in zip(phone_book,phone_book[1:]):
        if b.startswith(a):
            return False
    
    # for i in phone_book:
    #     phone_book.remove(i)
    #     for j in phone_book:
    #         if j.startswith(i):
    #             return False
    return answer