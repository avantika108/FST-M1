# Given lists

list1=[2,4,5,12,25]
list2=[3,6,8,9,11,15]

print("First list", list1)
print("Second list", list2)

thirdlist=[]

for i in list1:
    if(i % 2 != 0):
        thirdlist.append(i)
for i in list2:
    if(i % 2 == 0) :
        thirdlist.append(i)

print("result is")
print(thirdlist)          

