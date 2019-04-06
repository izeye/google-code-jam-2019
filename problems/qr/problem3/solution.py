# NOTE:
# This works with the sample input but didn't work on submission with RE (Runtime Error).
# I have no idea as there's no feedback.
import math

testCaseCount = int(input())
for i in range(1, testCaseCount + 1):
    input()
    ciphertext = input()
    values = ciphertext.split(" ")
    firstValue = int(values[0])
    secondValue = int(values[1])

    secondPrime = math.gcd(firstValue, secondValue)
    firstPrime = firstValue // secondPrime
    thirdPrime = secondValue // secondPrime

    primes = []
    primes.append(firstPrime)
    primes.append(secondPrime)
    primes.append(thirdPrime)
    for j in range(2, len(values)):
        value = int(values[j])
        prime = value // primes[len(primes) - 1]
        primes.append(prime)
    sortedPrimes = sorted(set(primes))
    c = 'A'
    alphabetByPrime = {}
    for prime in sortedPrimes:
        alphabetByPrime[prime] = c;
        c = chr(ord(c) + 1)
    plaintext = ''.join(map(lambda prime: alphabetByPrime[prime], primes))
    print("Case #{}: {}".format(i, plaintext))
