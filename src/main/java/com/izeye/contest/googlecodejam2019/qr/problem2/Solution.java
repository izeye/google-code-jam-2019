package com.izeye.contest.googlecodejam2019.qr.problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solution for Qualification Round 2019 2nd problem, "You Can Go Your Own Way".
 *
 * See https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/00000000000881da
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

				String path = br.readLine();
				StringBuilder myPath = new StringBuilder(path.length());
				char[] moves = path.toCharArray();
				for (char move : moves) {
					myPath.append(move == 'S' ? 'E' : 'S');
				}
				System.out.printf("Case #%d: %s%n", i + 1, myPath);
			}
		}
	}

}
