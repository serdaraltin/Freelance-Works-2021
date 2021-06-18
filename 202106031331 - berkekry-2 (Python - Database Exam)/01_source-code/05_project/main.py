import sqlite3
import os.path
from os import path
from os import system

veritabani = "veritabani.sqlite"

def veritabani_olustur():
    connection = sqlite3.connect(veritabani)
    cursor = connection.cursor()
    sql_file = open("veritabani.sql")
    sql_as_string = sql_file.read()
    cursor.executescript(sql_as_string)
    print("Veritabani olusturuldu")


if path.exists(veritabani) == False:
    veritabani_olustur()


connection = None
try:
    connection = sqlite3.connect(veritabani)
except Error as e:
    print(e)

cursor = connection.cursor()

system('clear')
print("\n\n")

sorgu = """
Select * From kullanici
"""

cursor.execute(sorgu)
#cursor.execute("Select *from ")
rows = cursor.fetchall()

print("Sorgu >> ",sorgu)
for row in rows:
    print(row)

print("\n\n")