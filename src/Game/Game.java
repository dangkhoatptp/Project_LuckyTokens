package Game;

import User.User;

public class Game {

	public static void main(String[] args) {
		User host = new User();
		User player = new User();
		
		int round = 1;
		int sumTokens = 0;
		
		System.out.println("Player có " + player.getTokensCount());
		System.out.println("Host có " + host.getTokensCount());
		System.out.println("");
		System.out.println("Trò chơi LuckyTokens bắt đầu.");
		
		while(player.getTokensCount() != 0) {
			System.out.println("");
			System.out.println("Vòng " + round);
			
			player.randomToken();
			sumTokens = player.sumTokens();
			
			System.out.println("Tổng là " + sumTokens);
			
			if(sumTokens == 3) {
				System.out.println("Token của Player: " + player.setTokensCount(player.getTokensCount() * 2));
				System.out.println("Token của Host: " + host.getTokensCount());
			} else if(sumTokens > 0 && sumTokens != 3) {
				if(sumTokens >= host.getTokensCount()) {
					System.out.println("Token của Player: " + player.setTokensCount(player.getTokensCount() + host.getTokensCount()));
					System.out.println("Token của Host: " + host.setTokensCount(0));
				} else if(sumTokens < host.getTokensCount()) {
					System.out.println("Token của Player: " + player.setTokensCount(player.getTokensCount() + sumTokens));
					System.out.println("Token của Host: " + host.setTokensCount(host.getTokensCount() - sumTokens));
				}
			} else if(sumTokens == -3) {
				System.out.println("Token của Player: " + player.setTokensCount(player.getTokensCount() / 2));
				System.out.println("Token của Host: " + host.getTokensCount());
			} else if(sumTokens < 0 && sumTokens != -3) {
				sumTokens = -sumTokens;
				if(sumTokens >= player.getTokensCount()) {
					int temp = player.getTokensCount();
					System.out.println("Token của Player: " + player.setTokensCount(0));
					System.out.println("Token của Host: " + host.setTokensCount(host.getTokensCount() + temp));
				} else if(sumTokens < player.getTokensCount()) {
					System.out.println("Token của Player: " + player.setTokensCount(player.getTokensCount() - sumTokens));
					System.out.println("Token của Host: " + host.setTokensCount(host.getTokensCount() + sumTokens));
				}
			} else if(sumTokens == 0) {
				System.out.println("Token của Player: " + player.getTokensCount());
				System.out.println("Token của Host: " + host.getTokensCount());
			}
			
			if(player.getTokensCount() == 0 || host.getTokensCount() == 0) {
				break;
			} else if(player.getTokensCount() != 0 && host.getTokensCount() != 0) {
				++round;
			}
		}
		
		System.out.println("");
		
		if(player.getTokensCount() != 0) {
			System.out.println("Player là người chiến thắng.");
		} else {
			System.out.println("Host là người chiến thắng.");
		}

	}

}
