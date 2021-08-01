try:
    print(x)
except NameError:
    print("variable x is not defined")
else:
    print("Something else went wrong")        