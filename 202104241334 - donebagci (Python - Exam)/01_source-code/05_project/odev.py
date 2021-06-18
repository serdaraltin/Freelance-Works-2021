
"""
Question 2: (20 Points)
Write a function that takes a string as its only argument and returns a sorted
list of characters used in the string. The resulting list should only contain
lower case letters and each letter should exist only once. Also, the resulting
list shouldn't contain any spaces or punctuation marks, such as ",;.!?". For 
example, 
strLetters("We are, the Champions!") returns
['a', 'c', 'e', 'h', 'i', 'm', 'n', 'o', 'p', 'r', 's', 't', 'w']
"""


def strLetters(iStr):
    lowerStr = iStr.lower()
    sortedStr = sorted(lowerStr)
    newStr = "".join(sortedStr)
    
    lst = []

    for char in newStr:
        if ord(char) >= 97 and ord(char) <= 122:
            lst.append(char)

    rvalue = list(dict.fromkeys(lst))

    return rvalue

#test amaclidir, siliniz (30)
#print(strLetters("We are, the Champions!"))

"""
Question 3: (20 Points)
Write a function that takes two arguments: stock and ingr (short for 
ingredients) and returns the missing ingredients in stock. stock is 
a dictionary containing (key,value) pairs in the form of ("potato", 5).
The key is the name of an ingredient, and the vlaue is its existing
amount. ingr is a list of tuples, where each tuple represents the required
amount of an ingredient. For example, ("cheese", 3) means we need 3 units of 
cheese for this recipe. Your function checks whether we have enough of each item
in the stock. If an item is missing or not enough then your function returns 
the missing amount within a list of all such items. If all items are in stock, then you return an empty list. For example:

stock = {"salt":100, "sugar":100, "flour":50, "apple":3, "cream":10}
ingr = [("sugar",50), ("flour", 120), ("apple",5)]

checkStock(stock, ingr) should return 

[("flour",70), ("apple",2)]

which means we need 70 more units of flour and 2 more apples for this recipe.
Note that it is possible for an item to not exist in the stock.
"""

def checkStock(stock, ingr):
    rvalue = []

    for element in ingr:
        name = element[0]
        quan = element[1]

        if stock.get(name) < quan:
            req = quan - stock.get(name)
            rvalue.append((name,req))

    return rvalue


#test amaclidir, siliniz (69-75)

#stock = {"salt":100, "sugar":100, "flour":50, "apple":3, "cream":10}
#ingr = [("sugar",50), ("flour", 120), ("apple",5)]

#print(checkStock(stock, ingr))

"""
Question 4: (20 Points)
Assume a generic recursive relation is defined as :
A[i] = p*A[i-1] + q
where p and q are coefficients of the relation. 
Write a function that takes the first three numbers in this relation as a list,
such as [A[0], A[1], A[2]]
and computes p and q, and returns A[3]. For example, given [1,3,5] your 
function should return 7, because the numbers 1,3,5 are produced by the 
series:
A[i] = A[i-1] + 2
where p is 1 and q is 2, and then the next number in the series becomes 7. You 
can assume that p and q are always integers. You can also assume that p and q 
are determinable in any test case.
"""


def recursionSolver(values):
    p = values[0]
    q = values[1] - values[0]
    
    vLen = len(values)
    rvalue = p*values[vLen-1]+q

    return rvalue

#test amaclidir, siliniz (103)
#print(recursionSolver([1,3,5]))



"""
Question 5: (25 Points)
A 2D matrix can be represented as a list and a column count value in Python. 
For example, the 3x3 matrix

1 2 3
4 5 6
7 8 9

can be row-wise represented as ([1,2,3,4,5,6,7,8,9], 3), where the number 3 
represents the number of columns in the matrix. Similarly,

1 3 5
2 4 6

becomes ([1,3,5,2,4,6], 3). 

A submatrix can be defined as an (l,r,t,b) tuple, where l and r are left and 
right column indices, and t and b are top and bottom row indices (all 
inclusive). Write a function that takes a tuple containing the list 
representing a matrix, and the column count of the matrix, along with another 
tuple representing a specific submatrix, and returns the list representation of 
the submatrix along with its column count as a tuple. For example, given

submatrix(([1,2,3,4,5,6,7,8,9,10,11,12], 4), (1,2,0,1)) returns:

([2,3,6,7], 2)

because, ([1,2,3,4,5,6,7,8,9,10,11,12], 4) represents:

1  2  3  4
5  6  7  8
9 10 11 12

and (1,2,0,1) represents the submatrix between column indices 1 and 2 (both inclusive), and row indices 0 and 1 (both inclusive). So, the result becomes

2 3 
6 7

which corresponds to ([2,3,6,7],2).
"""

def submatrix(matrix, indices):
    colLen = matrix[1]
    linMatrix = matrix[0]

    line = []
    newMatrix = []

    counter = 1
    for element in linMatrix:
        line.append(element)
        if counter == colLen:
            newMatrix.append(line)
            line = []
            counter = 0
        
        counter += 1

    col =  indices[0:int(len(indices)/2):]
    row = indices[int(len(indices)/2)::]

    addMatrix = []
    counter = 1


    for r in row:
        for c in col:
            addMatrix.append(newMatrix[r][c])

    rvalue = (addMatrix,len(row))

    return rvalue

#test amaclidir, siliniz (182)
#print(submatrix(([1,2,3,4,5,6,7,8,9,10,11,12], 4), (1,2,0,1)))
print(submatrix(([1,2,3,4,5,6,7,8,9],3),(1,1,1,1)))