import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from numpy import *
from csv import reader

averageArrayAVL = []
bestArrayAVL = []
worstArrayAVL = []
xValArrayAVL = []
for i in range(0, 10):
    with open("subset"+str(i)+"AVLTree.csv", 'r') as read_obj:
    # pass the file object to reader() to get the reader object
        csv_reader = reader(read_obj)
    # Iterate over each row in the csv using reader object
        total = 0
        min = 0
        max = 1
        count = 0
        for row in csv_reader:
        # row variable is a list that represents a row in csv
            num = int(row[1])
            if num > max:
                max = num
            total += num
            count += 1
    average = total / ((297)*(i+1))
    averageArrayAVL.append(int(average))
    bestArrayAVL.append(int(min))
    worstArrayAVL.append(int(max))
    xValArrayAVL.append(int((i+1)*297))

'''fig1 = plt.figure()
fig2 = plt.figure()
fig3 = plt.figure()
fig4 = plt.figure()
plt1 = fig1.add_subplot(221)
plt2 = fig2.add_subplot(222)
plt3 = fig3.add_subplot(223)
plt4 = fig4.add_subplot(224)'''

plt.figure(200)
plt.scatter(xValArrayAVL, averageArrayAVL)
plt.plot(xValArrayAVL, averageArrayAVL, label = "average case")
plt.scatter(xValArrayAVL, bestArrayAVL)
plt.plot(xValArrayAVL, bestArrayAVL, label = "best case")
plt.scatter(xValArrayAVL, worstArrayAVL)
plt.plot(xValArrayAVL, worstArrayAVL, label = "worst case")
plt.title("AVL Search Count")
plt.legend()




averageArrayAVLInsert = []
bestArrayAVLInsert = []
worstArrayAVLInsert = []
for i in range(0, 10):
    with open("subset"+str(i)+"AVLTreeInsert.csv", 'r') as read_obj:
    # pass the file object to reader() to get the reader object
        csv_reader = reader(read_obj)
    # Iterate over each row in the csv using reader object
        total = 0
        min = 0
        max = 1
        count = 0
        for row in csv_reader:
        # row variable is a list that represents a row in csv
            num = int(row[1])
            if num > max:
                max = num
            total += num
            count += 1
    average = total / ((297)*(i+1))
    averageArrayAVLInsert.append(int(average))
    bestArrayAVLInsert.append(int(min))
    worstArrayAVLInsert.append(int(max))

plt.figure(300)
plt.scatter(xValArrayAVL, averageArrayAVLInsert)
plt.plot(xValArrayAVL, averageArrayAVLInsert, label = "average case")
plt.scatter(xValArrayAVL, bestArrayAVLInsert)
plt.plot(xValArrayAVL, bestArrayAVLInsert, label = "best case")
plt.scatter(xValArrayAVL, worstArrayAVLInsert)
plt.plot(xValArrayAVL, worstArrayAVLInsert, label = "worst case")
plt.title("AVL Insert Count")
plt.legend()

averageArrayBST = []
bestArrayBST = []
worstArrayBST = []
for i in range(0, 10):
    with open("subset"+str(i)+"Tree.csv", 'r') as read_obj:
    # pass the file object to reader() to get the reader object
        csv_reader = reader(read_obj)
    # Iterate over each row in the csv using reader object
        total = 0
        min = 0
        max = 1
        count = 0
        for row in csv_reader:
        # row variable is a list that represents a row in csv
            num = int(row[1])
            if num > max:
                max = num
            total += num
            count += 1
    average = total / ((297)*(i+1))
    averageArrayBST.append(int(average))
    bestArrayBST.append(int(min))
    worstArrayBST.append(int(max))
plt.figure(400)
plt.scatter(xValArrayAVL, averageArrayBST)
plt.plot(xValArrayAVL, averageArrayBST, label = "average case")
plt.scatter(xValArrayAVL, bestArrayBST)
plt.plot(xValArrayAVL, bestArrayBST, label = "best case")
plt.scatter(xValArrayAVL, worstArrayBST)
plt.plot(xValArrayAVL, worstArrayBST, label = "worst case")
plt.title("BST Search Count")
plt.legend()

averageArrayBSTInsert = []
bestArrayBSTInsert = []
worstArrayBSTInsert = []
for i in range(0, 10):
    with open("subset"+str(i)+"TreeInsert.csv", 'r') as read_obj:
    # pass the file object to reader() to get the reader object
        csv_reader = reader(read_obj)
    # Iterate over each row in the csv using reader object
        total = 0
        min = 0
        max = 1
        count = 0
        for row in csv_reader:
        # row variable is a list that represents a row in csv
            num = int(row[1])
            if num > max:
                max = num
            total += num
            count += 1
    average = total / ((297)*(i+1))
    averageArrayBSTInsert.append(int(average))
    bestArrayBSTInsert.append(int(min))
    worstArrayBSTInsert.append(int(max))

plt.figure(500)
plt.scatter(xValArrayAVL, averageArrayBSTInsert)
plt.plot(xValArrayAVL, averageArrayBSTInsert, label = "average case")
plt.scatter(xValArrayAVL, bestArrayBSTInsert)
plt.plot(xValArrayAVL, bestArrayBSTInsert, label = "best case")
plt.scatter(xValArrayAVL, worstArrayBSTInsert)
plt.plot(xValArrayAVL, worstArrayBSTInsert, label = "worst case")
plt.title("BST Insert Count")
plt.legend();

fig, axs = plt.subplots(2,1)
data1 = [[averageArrayAVL[0], bestArrayAVL[0], worstArrayAVL[0], averageArrayBST[0], bestArrayBST[0],worstArrayBST[0]],
         [averageArrayAVL[1], bestArrayAVL[1], worstArrayAVL[1], averageArrayBST[1], bestArrayBST[1],worstArrayBST[1]],
         [averageArrayAVL[2], bestArrayAVL[2], worstArrayAVL[2], averageArrayBST[2], bestArrayBST[2],worstArrayBST[2]],
         [averageArrayAVL[3], bestArrayAVL[3], worstArrayAVL[3], averageArrayBST[3], bestArrayBST[3],worstArrayBST[3]],
         [averageArrayAVL[4], bestArrayAVL[4], worstArrayAVL[4], averageArrayBST[4], bestArrayBST[4],worstArrayBST[4]],
         [averageArrayAVL[5], bestArrayAVL[5], worstArrayAVL[5], averageArrayBST[5], bestArrayBST[5],worstArrayBST[5]],
         [averageArrayAVL[6], bestArrayAVL[6], worstArrayAVL[6], averageArrayBST[6], bestArrayBST[6],worstArrayBST[6]],
         [averageArrayAVL[7], bestArrayAVL[7], worstArrayAVL[7], averageArrayBST[7], bestArrayBST[7],worstArrayBST[7]],
         [averageArrayAVL[8], bestArrayAVL[8], worstArrayAVL[8], averageArrayBST[8], bestArrayBST[8],worstArrayBST[8]],
         [averageArrayAVL[9], bestArrayAVL[9], worstArrayAVL[9], averageArrayBST[9], bestArrayBST[9],worstArrayBST[9]]]

columns = ('average case AVL', 'best case AVL', 'worst case AVL', 'average case BST', 'best case BST', 'worst case BST')
rows = ['297', '594', '891', '1188', '1485', '1782', '2079', '2376', '2673', '2970']

#axs[0].axis('tight')
axs[0].axis('off')
axs[1].axis('off')

the_table = axs[0].table(cellText=data1,
                      rowLabels=rows,
                      colLabels=columns,
                      loc='center')

fig, axs2 = plt.subplots(2,1)
data1 = [[averageArrayAVLInsert[0], bestArrayAVLInsert[0], worstArrayAVLInsert[0], averageArrayBSTInsert[0], bestArrayBSTInsert[0],worstArrayBSTInsert[0]],
         [averageArrayAVLInsert[1], bestArrayAVLInsert[1], worstArrayAVLInsert[1], averageArrayBSTInsert[1], bestArrayBSTInsert[1],worstArrayBSTInsert[1]],
         [averageArrayAVLInsert[2], bestArrayAVLInsert[2], worstArrayAVLInsert[2], averageArrayBSTInsert[2], bestArrayBSTInsert[2],worstArrayBSTInsert[2]],
         [averageArrayAVLInsert[3], bestArrayAVLInsert[3], worstArrayAVLInsert[3], averageArrayBSTInsert[3], bestArrayBSTInsert[3],worstArrayBSTInsert[3]],
         [averageArrayAVLInsert[4], bestArrayAVLInsert[4], worstArrayAVLInsert[4], averageArrayBSTInsert[4], bestArrayBSTInsert[4],worstArrayBSTInsert[4]],
         [averageArrayAVLInsert[5], bestArrayAVLInsert[5], worstArrayAVLInsert[5], averageArrayBSTInsert[5], bestArrayBSTInsert[5],worstArrayBSTInsert[5]],
         [averageArrayAVLInsert[6], bestArrayAVLInsert[6], worstArrayAVLInsert[6], averageArrayBSTInsert[6], bestArrayBSTInsert[6],worstArrayBSTInsert[6]],
         [averageArrayAVLInsert[7], bestArrayAVLInsert[7], worstArrayAVLInsert[7], averageArrayBSTInsert[7], bestArrayBSTInsert[7],worstArrayBSTInsert[7]],
         [averageArrayAVLInsert[8], bestArrayAVLInsert[8], worstArrayAVLInsert[8], averageArrayBSTInsert[8], bestArrayBSTInsert[8],worstArrayBSTInsert[8]],
         [averageArrayAVLInsert[9], bestArrayAVLInsert[9], worstArrayAVLInsert[9], averageArrayBSTInsert[9], bestArrayBSTInsert[9],worstArrayBSTInsert[9]]]

columns = ('average case AVL Insert', 'best case AVL Insert', 'worst case AVL Insert', 'average case BST Insert', 'best case BST Insert', 'worst case BST Insert')
rows = ['297', '594', '891', '1188', '1485', '1782', '2079', '2376', '2673', '2970']

#axs[0].axis('tight')
axs2[0].axis('off')
axs2[1].axis('off')

the_table = axs2[0].table(cellText=data1,
                      rowLabels=rows,
                      colLabels=columns,
                      loc='center')


plt.show()
