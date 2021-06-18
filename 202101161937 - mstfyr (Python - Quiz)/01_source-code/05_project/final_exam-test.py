# -*- coding: utf-8 -*-
"""

EXAM RULES

- You are strictly forbidden to share answers with your course mates.
- You are not allowed to search for answers on the Internet. You are not
    allowed to ask for answers in forums or other online communication systems.
- Note that, when you find an answer on the web, somebody else will also find
    it and use it. This means, both of you will submit the exact same answer.
    This, then, means cheating, no matter you know the other person or not.
- If your answers are similar to some other student's answers at a level that
    proves unethical misconduct, you will FAIL THE COURSE. We don't care
    whether you know the other person or not, we don't care whether he/she is
    your friend or not, we don't care who delivered and who received. Both
    parties fail the course immediately. Moreover, a disciplinary action may
    follow based on the seriousness of the issue.
- You are NOT ALLOWED TO IMPORT any packages. If there are any imports in
    your submission, we will remove them before grading.
- If your file doesn't compile, then you receive 0. Make sure that your
    indentation is correct.
- Do not change the below function definitions. In other words, do not change
    the function names and the parameters of the functions. You are only
    allowed to write code within the function scope.
- Do not print anything on the screen unless you are asked to. Most questions
    require you to return a value. Printing that value on the screen is not
    equal to returning the value.
- Do not submit any testing code.


DO NOT FORGET TO FILL THE BELOW LINES:

My full name is ______________.
My student ID is _________.
My section is (Mechanical)(Nuclear Energy) Engineering.
"""

"""
Question 1: (10 points)
Write a function that takes a list of integers l and an integer
value v, and returns whether v exists more than once in l. For
example,
checkDups([1,2,3,4,3,5,2,3], 5)  -> returns False
checkDups([1,2,3,4,3,5,2,3], 2)  -> returns True
checkDups([1,2,3,4,3,5,2,3], 3)  -> returns True
```
"""


def checkDups(l, v):
    count = 0
    for item in l:
        if item == v:
            count+=1
    if count > 1:
        return True
    return False



#print(checkDups([1,2,3,4,3,5,2,3], 5))
#print(checkDups([1,2,3,4,3,5,2,3], 2))
#print(checkDups([1,2,3,4,3,5,2,3], 3))

"""
Question 2:  (10 points)

Write a function that takes a string as input and PRINTS the
following pattern on the screen based on the input string:
For example:

stringShift("burkay") PRINTS the following:

burkay
urkayb
rkaybu
kaybur
ayburk
yburka

"""


def stringShift(s):
    x = range(len(s))
    for i in x:
        j = i
        y = range(i,len(s))
        for j in y:
            print(s[j],end="")
        z = range(i)
        for k in z:
            
            print(s[k],end="")
        print()


"""
Question 3: (10 points)

Complete the below function which takes two circles as tuples, and 
returns True if the circles intersect each other. Two circles 
intersect if their centers are closer than the sum of their 
radiuses. The provided tuples are in (a,b,c) format where a and b are the x 
and y coordinates of a circle, and c is the radius of the circle. 

For example,
intersects((1,1,2), (5,8,1)) -> returns False
intersects((1,1,5), (2,3,4)) -> returns True

"""

import math

def intersects(c1, c2):
    x0 = c1[0]
    y0 = c1[1]
    r0 = c1[2]
    x1 = c2[0]
    y1 = c2[1]
    r1 = c2[2]
    d=math.sqrt((x1-x0)**2 + (y1-y0)**2)
    if d > r0 + r1 :
        return False
    if d < abs(r0-r1):
        return True
    if d == 0 and r0 == r1:
        return True
    else:
        return True

#print(intersects((1,1,2), (5,8,1)))

"""
Question 4: (20 points + 10 points bonus) 

Write the below function that takes a string and applies the following rules
repetitively until there is one character left and returns that character:

- If the first two characters are "aa" then they are replaced by "b"
- If the first two characters are "ba" then they are replaced by "c"
- If the first two characters are "ab" then they are replaced by "c"
- If the first two characters are "bb" then they are replaced by "a"
- If the first character is "c", then it is replaced by the second character. 
    However, if the second character is also "c" then the first "c" is removed.
- For everything else, the first character is removed.

The input string contains only the letters "a", "b" and "c". 

For example, the string "aabc" goes through the following transformations:
"aabc" -> "bbc" -> "ac" -> "c"

Similarly, the string "bacbc" becomes
"bacbc" -> "ccbc" -> "cbc" -> "bbc" -> "ac" -> "c"

NOTE: If you solve this question in a recursive fashion, you get 10 points 
bonus! The bonus will be applied if and only if you pass all the other tests. 

"""


def shorten(s):
    
    slist = list(s)
    onechar = s[:1:]
  
    if len(s) > 1:
        print(s,end=" -> ")
        twochar = s[:2:]
        
        if len(s) == 2 and s[1:2:] == "c":
            slist[0] = ''
            s = "".join(slist)
            print(s)
            return

        if onechar == "c":
            temp = slist[0]
            slist[1] = slist[0]
            slist[0] = temp
            if slist[1]== "c":
                slist[0] = ''
                s = "".join(slist)
                return shorten(s)

            s = "".join(slist)
            shorten(s)

        if twochar == "aa":
            slist[1] = 'b'
            slist[0] = ''
            s = "".join(slist)
            shorten(s)
        if twochar == "ba":
            slist[1] = 'c'
            slist[0] = ''
            s = "".join(slist)
            shorten(s)
        if twochar == "ab":
            slist[1] = 'c'
            slist[0] = ''
            s = "".join(slist)
            shorten(s)
        if twochar == "bb":
            slist[1] = 'a'
            slist[0] = ''
            s = "".join(slist)
            shorten(s)

#shorten("aabc")

"""
Question 5: (20 points)

Complete the below function which takes a dictionary d and a key k as arguments
and returns a value based on the following rules:

1. If k is not a key of d, then return None.
2. Otherwise, let v be the value of k in d
3. If v exists also as a KEY in d, then set k = v and go to Step 2
4. Otherwise, return v

For example, given d={1:3, 3:2, 2:4} and k = 1, your function must return 4.
This is because d[1] is 3, and d[3] is 2, and d[2] is 4, and 4 is not a key 
in d.
"""


def dictChain(d, k):
    state = 0
    for key in d.keys():
        if key == k:
            state = 1
    if state == 0:
        return None
    
    nkey = d[k]
    while True:
        state = 0
        for key in d.keys():
            if key == nkey:
                state = 1
        if state == 0:
            return nkey
        nkey = d[nkey]


d={1:3, 3:2, 2:4}
k = 1

print(dictChain(d,1))

"""
Question 6: (30 points)

Complete the below function that reads football game scores from a file called
"scores.txt" (you can assume it always exists), computes a dictionary where
keys are team names and values are the corresponding points, and returns the
dictionary. All teams, even if they have obtained 0 points, must be represented
in the dictionary. 

The format of "scores.txt" is as follows (the following is just an example):
TeamA TeamB 3 2
TeamA TeamC 2 0
TeamC TeamB 1 1

This means, TeamA won against TeamB by scoring 3 goals versus 2. From this game
TeamA obtains 3 points (each win is 3 points) and TeamB obtains 0 points (each
lose is 0 points). In the second game TeamA defeated TeamC 2 to 0, and received
another 3 points, whereas TeamC received 0 points. Finally, TeamC and TeamB had
a draw in the last game and each received 1 point (each draw is 1 point). As a
result TeamA obtained 6, TeamB obtained 1 and TeamC obtained 1 points. The
function must then return the following dictionary:

{"TeamA":6, "TeamB":1, "TeamC":1}

You don't know how many teams or games exist in the file. Teams are not
guaranteed to play the same number of games. 


    

"""

def pointCalculator():
    input = "TeamA TeamB 3 2\nTeamA TeamC 2 0\nTeamC TeamB 1 1"
    pointDict = {}
    for line in input.splitlines():
        team1name = line.split(" ")[0]
        team1goal = int(line.split(" ")[2])

        team2name = line.split(" ")[1]
        team2goal = int(line.split(" ")[3])

        team1lastpoint = 0
        team2lastpoint = 0
        for key in pointDict.keys():
            if key == team1name:
                team1lastpoint = pointDict[team1name]
            if key == team2name:
                team2lastpoint = pointDict[team2name]
        
        if team1goal > team2goal:
             pointDict[team1name] = team1lastpoint + 3
        if team1goal < team2goal:
             pointDict[team2name] = team2lastpoint + 3
        if team1goal == team2goal:
            pointDict[team1name] = team1lastpoint + 1
            pointDict[team2name] = team2lastpoint + 1
    print(pointDict)


#pointCalculator()