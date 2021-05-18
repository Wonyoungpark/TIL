## ClasspathDemo2.class 실행
---
### srcbin/ClasspathDemo2.class이고 srcbin/item2.class일 경우
```python
>>> java ClasspathDemo2
Hello world
```

---
### srcbin/ClasspathDemo2.class이고 srcbin/lib/item2.class일 경우
```python
>>> java -classpath ".:lib" ClasspathDemo2
Hello world
```

---
### srcbin/lib/ClasspathDemo2.class이고 srcbin/lib/item2.class일 경우
```python
>>> java -classpath "lib" ClasspathDemo2
Hello world
```