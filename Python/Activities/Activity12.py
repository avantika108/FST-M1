#Calculate sum of no. from 0 to 10

def sum(n) :
    if n:
        return n+sum(n-1)
    else:
        return 0

res=sum(10)

print(res);            

