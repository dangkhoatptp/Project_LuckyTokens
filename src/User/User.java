package User;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class User {
	private int tokensCount;
	private ArrayList<Integer> tokenList;
	
	public User() {
		tokensCount = ThreadLocalRandom.current().nextInt(1, 5);
		tokenList = new ArrayList<Integer>();
	}
	
	public int getTokensCount() {
		return tokensCount;
	}
	public int setTokensCount(int tc) {
		tokensCount = tc;
		return tokensCount;
	}
	
	public int getTokenList(int index) {
		return tokenList.get(index);
	}
	public int setTokenList(int index, int value) {
		tokenList.set(index, value);
		return tokenList.get(index);
	}
	
	public void randomToken() {
		String str = "Player: số phát sinh là ";
		int randomToken;
		if(tokenList.size() != 0) {
			tokenList.clear();
		}
		
		for(int i = 0 ; i < tokensCount ; ++i) {
			randomToken = ThreadLocalRandom.current().nextInt(-2, 2);
			str += randomToken;
			if(i != tokensCount - 1) {
				str += ", ";
			}
			tokenList.add(randomToken);
		}
		
		System.out.println(str);
	}
	
	public int sumTokens() {
		int sum = 0;
		for(int i = 0 ; i < tokenList.size() ; ++i) {
			sum += tokenList.get(i);
		}
		return sum;
	}

	public static void main(String[] args) {
		
	}

}
