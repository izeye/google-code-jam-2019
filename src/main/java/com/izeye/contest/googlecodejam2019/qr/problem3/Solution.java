package com.izeye.contest.googlecodejam2019.qr.problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
				Long firstValue = new Long(values[0]);
				Long secondValue = new Long(values[1]);

				Long secondPrime = gcd(firstValue, secondValue);
				Long firstPrime = firstValue / secondPrime;
				Long thirdPrime = secondValue / secondPrime;

				List<Long> primes = new ArrayList<>();
				primes.add(firstPrime);
				primes.add(secondPrime);
				primes.add(thirdPrime);
				for (int j = 2; j < values.length; j++) {
					Long value = new Long(values[j]);
					Long prime = value / primes.get(primes.size() - 1);
					primes.add(prime);
				}
				SortedSet<Long> sortedPrimes = new TreeSet<>(primes);
				SortedMap<Long, Character> alphabetByPrime = new TreeMap<>();
				char c = 'A';
				for (Long prime : sortedPrimes) {
					alphabetByPrime.put(prime, c);
					c++;
				}
				StringBuilder plaintext = new StringBuilder();
				for (Long prime : primes) {
					plaintext.append(alphabetByPrime.get(prime));
				}
				System.out.printf("Case #%d: %s%n", i + 1, plaintext);
			}
		}
	}

	private static Long gcd(Long first, Long second) {
		if (second == 0) {
			return first;
		}
		return gcd(second, first % second);
	}

}
