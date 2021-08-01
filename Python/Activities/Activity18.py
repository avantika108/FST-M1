import pandas
dataframe=pandas.read_csv('sample.csv')
print("Reading sample.csv")
print(dataframe)
print("===================")
print("Usernames:")
print(dataframe["Usernames"])

print("=========================")
print("Username and password:")
	
print("Username: ", dataframe["Usernames"][1], " | ", "Password: ", dataframe["Passwords"][1])


print("================================")
print("Data sorted in ascending usernames:")
print(dataframe.sort_values('Usernames'))


print("===========================================")
print("Dta sorted in descending passwords:")
print(dataframe.sort_values('Passwords',ascending=False))


