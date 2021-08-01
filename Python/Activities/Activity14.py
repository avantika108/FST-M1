def fibo (number):
    if number<=1 :
        return number
    else:
        return (fibo(number-1)) + (fibo(number-2))
n=int(input("Enter numbers:"))
if n<=0:
    print("Please enter positive number")

else:
    print("Fibonacci sequence:")
    for i in range (n):
        print(fibo(i))    