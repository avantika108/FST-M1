import pandas
from pandas import ExcelWriter
from pandas.core.frame import DataFrame

data={
    'Firstname':["Satvik","Avinash","Lahri"],
    'Lastname':["Shah","Kati","Rath"],
    'Email':["satshah@example.com","avinashk@example.com","lahri.rath@example.com"],
    'Phonenumber':["4537829158","5892184058","4528727830"]
}

dataframe=pandas.DataFrame(data)
print(dataframe)
writer=ExcelWriter("sample.xlsx")
dataframe.to_excel(writer,"Sheet1", index=False)
writer.save()