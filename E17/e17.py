def countLetters(i):
    #print("counting i:", i)
    # zero = 0 -- Control statement
    if i == 0:
        return 0
    # 1 -- one == 3
    elif i == 1 or i == 2 or i == 6 or i == 10:
        return 3
    # 2 -- two == 3
    elif i == 3 or i == 8 or i == 7:
        return 5
    elif i == 4 or i == 5 or i == 9:
        return 4
    elif i == 15 or i == 16:
        return 7
    elif i == 13 or i == 14 or i == 18 or i == 19:
        return 8
    elif i == 17:
        return 9
    elif i == 11 or i == 12:
        return 6
    elif 20 <= i <= 39 or 80 <= i <= 99:
        return(6 + countLetters(i%10))
    elif 69 >= i >= 40:
        return(5 + countLetters(i%10))
    elif 79 >= i >= 70:
        return(7 + countLetters(i%10))
    elif i % 100 == 0 and 100 <= i < 1000:
        #print("adding ", countLetters(i/100), " + 7 for i = ", i)
        return(countLetters(i/100) + 7) #hundreds without remainder
    elif i%100 > 0 and i > 100:
        #print("adding ", countLetters(i%100)," and ", countLetters(i-i%100), " + 3 for i = ", i)
        return(countLetters(i%100) + countLetters(i-i%100) + 3) # XXXX HUNDRED AND ######
    elif i == 1000:
        return 11
    else:
        print("You are dumb and did not account for: ", i)
    


bigSum = 0
for i in range(1001):
    c = countLetters(i)
    bigSum += c
    print("numLetters in ", i, "is: ",c, " for new sum: ", bigSum)
print(bigSum)
