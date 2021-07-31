str=str(input("Enter list of numbers"))
print("input string",str)

list=str.split(",")
print(list)

li=[]
for i in list :
    li.append(int(i))

    print(li)

firstelement=li[0]
lastelement=li[-1] 

 #Check if last elemenyt matches with last element from input list
if(firstelement==lastelement):
            print(True)
else:
            print(False)       



