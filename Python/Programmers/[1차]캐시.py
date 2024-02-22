def solution(cacheSize, cities):
    answer = 0
    caches = []
    
    if cacheSize==0: return 5*len(cities)

    for city in cities:
        city = city.lower()
        if city in caches:
            caches.remove(city)
            answer+=1
        else:
            answer+=5
        if len(caches)==cacheSize:
            caches.pop(0)
        caches.append(city)
            
    return answer