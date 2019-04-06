package com.izeye.contest.googlecodejam2019.qr.problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Solution for Qualification Round 2019 3rd problem, "Cryptopangrams".
 *
 * See https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/000000000008830b
 *
 * NOTE:
 * This works with the sample input but didn't work on submission with RE (Runtime Error).
 * I have no idea as there's no feedback.
 *
 * @author Johnny Lim
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		try (
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		) {
			int testCaseCount = Integer.parseInt(br.readLine());
			for (int i = 0; i < testCaseCount; i++) {
				// Unnecessary to read.
				br.readLine();

				String ciphertext = br.readLine();
				String[] values = ciphertext.split(" ");
				BigInteger firstValue = new BigInteger(values[0]);
				BigInteger secondValue = new BigInteger(values[1]);

				BigInteger secondPrime = firstValue.gcd(secondValue);
				BigInteger firstPrime = firstValue.divide(secondPrime);
				BigInteger thirdPrime = secondValue.divide(secondPrime);

				List<BigInteger> primes = new ArrayList<>();
				primes.add(firstPrime);
				primes.add(secondPrime);
				primes.add(thirdPrime);
				for (int j = 2; j < values.length; j++) {
					BigInteger value = new BigInteger(values[j]);
					BigInteger prime = value.divide(primes.get(primes.size() - 1));
					primes.add(prime);
				}
				SortedSet<BigInteger> sortedPrimes = new TreeSet<>(primes);
				SortedMap<BigInteger, Character> alphabetByPrime = new TreeMap<>();
				char c = 'A';
				for (BigInteger prime : sortedPrimes) {
					alphabetByPrime.put(prime, c);
					c++;
				}
				StringBuilder plaintext = new StringBuilder();
				for (BigInteger prime : primes) {
					plaintext.append(alphabetByPrime.get(prime));
				}
				System.out.printf("Case #%d: %s%n", i + 1, plaintext);
			}
		}
	}

}
