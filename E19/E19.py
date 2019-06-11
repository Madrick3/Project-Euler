def PropDivisors(i):
    properDivisors = [1]
    for j in range(int(float(i)**(1/2))):
        j+=1
        #print(i, j)
        if(i%j==0 and j > 1):
            properDivisors.append(j)
            k = int(i/j)
            if(j != k):
                properDivisors.append(int(i/j))
    #print("properdivs of ", i, "are:", properDivisors)
    return properDivisors

abundantNumbers = []
for i in range(int(28124/2)+1):
    i+=1
    #determine if i is an abudant number
    properDivisors = PropDivisors(i)
    if properDivisors is not None:
        #print("sum is:", sum(properDivisors))
        if(sum(properDivisors) > i):
            abundantNumbers.append(i)
            print(i, " is an abundant number with abundance: ", sum(properDivisors))

sumAbundants = []
for i in range(len(abundantNumbers)):
    a = abundantNumbers[i]
    for j in range(len(abundantNumbers)-a):
        j+=a
        b = abundantNumbers[j]
        c = a + b
        if c not in sumAbundants:
            print("ADDING:", c, "-- ", i, j)
            sumAbundants.append(c)

bigSum = 0
print("BIGADD")
for i in range(28123):
    bigSum+=i
print("BIGSUB")
for i in sumAbundants:
    bigSum-=i
print(bigSum)