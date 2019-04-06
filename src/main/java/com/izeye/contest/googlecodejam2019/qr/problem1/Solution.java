package com.izeye.contest.googlecodejam2019.qr.problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solution for Qualification Round 2019 1st problem, "Foregone Solution".
 *
 * See https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/0000000000088231
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
				String coins = br.readLine();
				String[] split = split(coins);
				System.out.printf("Case #%d: %s %s%n", i + 1, split[0], split[1]);
			}
		}
	}

	private static String[] split(String coins) {
		StringBuilder firstCoins = new StringBuilder();
		StringBuilder secondCoins = new StringBuilder();
		char[] digits = coins.toCharArray();
		for (char digit : digits) {
			if (digit == '4') {
				firstCoins.append('3');
				secondCoins.append('1');
			}
			else {
				firstCoins.append(digit);
				if (secondCoins.length() > 0) {
					secondCoins.append('0');
				}
			}
		}
		return new String[] { firstCoins.toString(), secondCoins.toString() };
	}

}
