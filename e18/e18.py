import csv
fp  = open("names.txt", "r")
text = fp.read()
print(text)
splitNames = text.split("\",\"", -1)
i = 0
for name in splitNames:
    print(i, ": ", name)
    i += 1
splitNames[0] = splitNames[0].strip("\"")
splitNames[5162] = splitNames[5162].strip("\"")

#now we have a vector of names -- now we just need to alphabetize them
splitNames.sort()
i = 0
for name in splitNames:
    print(i, ": ", name)
    i += 1

#now we determine the score for each name
totalScore = 0
i = 0
for name in splitNames:
    tempScore = 0
    for char in name:
        #print("A", ord("A"))
        tempScore += (ord(char)-64)
        #print("char: ", char)
    i += 1
    tempScore *= i
    totalScore += tempScore
    print("new total is: ", totalScore, " after adding i: ", i, " * ", tempScore/i)
