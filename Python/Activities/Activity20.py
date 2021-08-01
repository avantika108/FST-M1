import pandas
dataframe=pandas.read_excel('sample.xlsx')

print(dataframe)
print("====================================")
print("No. of rows and cols:", dataframe.shape)

print("===================================")
print("Data in Emails col:")
print(dataframe['Email'])

print("===========================================")
print("First name in Ascending order:")
print(dataframe.sort_values('Firstname'))
