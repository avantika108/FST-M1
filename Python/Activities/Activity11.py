fruits=dict(banana=40,orange=100,apple=200,pear=160,strawberry=200,cherry=250)
print(fruits)
check=input("What fruit you are looking for:")

if check in fruits:
        print("Available")
else:
        print(False)   