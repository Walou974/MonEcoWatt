import sqlite3

db = sqlite3.connect('ecowatt.db')
c = db.cursor()

tags = c.execute("SELECT * from Infos").fetchall()

cont = []

for i in tags:
    cont.append(i)

with open("db_liss.txt", "w") as f:
    for i in cont:
       f.write(str(i)+"\n")
    f.close
