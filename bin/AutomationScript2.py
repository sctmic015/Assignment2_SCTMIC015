## Author: SCTMIC015
## Python script for creating random subsets of of the original text file and inputting information
## LSArrayAppTest and LSBSTAppTest to obtain output
## The script works via the command line and collates the csv files that the java programs produce

import random
import os
import subprocess
import glob



f1 = open("Load_Shedding_All_Areas_Schedule_and_Map.clean.final-1.txt", "r")
all_lines = f1.readlines()
for i in range (10):
    line = "subset" + str(i) + ".txt"
    changeFile = open(line, "a+")
    lines = random.sample(all_lines, (i+1) * 297)
    for j in lines:
        line = j
        changeFile.write(j)


for i in range(10):
    arrayLine = "subset" + str(i)
    bstLine = "subset" + str(i)
    subprocess.call(['java','LSAVLAppTest',arrayLine])
    subprocess.call(['java','LSBSTAppTest',bstLine])


fout=open("combinedAVL2.csv","a")
# first file:
fout.write("subset0" + '\n')
for line in open("subset0AVLTree.csv"):
    fout.write(line)
# now the rest:
for num in range(1,10):
    f = open("subset"+str(num)+"AVLTree.csv")
    #f.next() # skip the header
    fout.write("Subset" + str(num) + '\n')
    for line in f:
        fout.write(line)
    f.close() # not really needed
fout.close()

fout2=open("combinedTrees2.csv","a")
# first file:
fout2.write("subset0" + '\n')
for line in open("subset0Tree.csv"):
    fout2.write(line)
# now the rest:
for num in range(1,10):
    f = open("subset"+str(num)+"Tree.csv")
    #f.next() # skip the header
    fout2.write("Subset" + str(num) + '\n')
    for line in f:
        fout2.write(line)
    f.close() # not really needed
fout2.close()

fout3=open("combinedAVL2Insert.csv","a")
# first file:
fout3.write("subset0" + '\n')
for line in open("subset0AVLTreeInsert.csv"):
    fout3.write(line)
# now the rest:
for num in range(1,10):
    f = open("subset"+str(num)+"AVLTreeInsert.csv")
    #f.next() # skip the header
    fout3.write("Subset" + str(num) + '\n')
    for line in f:
        fout3.write(line)
    f.close() # not really needed
fout3.close()

fout4=open("combinedTreesInsert.csv","a")
# first file:
fout4.write("subset0" + '\n')
for line in open("subset0TreeInsert.csv"):
    fout4.write(line)
# now the rest:
for num in range(1,10):
    f = open("subset"+str(num)+"TreeInsert.csv")
    #f.next() # skip the header
    fout4.write("Subset" + str(num) + '\n')
    for line in f:
        fout4.write(line)
    f.close() # not really needed
fout4.close()

os.system('python3 graphs.py')
