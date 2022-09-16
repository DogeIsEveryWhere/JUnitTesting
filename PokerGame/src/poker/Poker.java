package poker;

public class Poker {
	// Precondition: A hand of n cards have been sorted by card number.
	public boolean [] visited;
	public boolean isFullHouse = false;
	public boolean isFullHouse(String cards[], int n) {
		if(cards != null) {
			visited = new boolean [cards.length];
		}
		
		// 0 ,1 ,2 ,3 ,4 
		return isThreeOfaKind(cards, n) && isTwoPairs(cards, n);
	}

	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isThreeOfaKind(String cards[], int n) {
		for (int i=0; i<n-2; i++) {
			if (cards[i].charAt(1) == cards[i+1].charAt(1) &&
					cards[i+1].charAt(1) == cards[i+2].charAt(1) && visited[i] != true && visited[i+1] != true && visited[i+2] != true ) {
				visited[i] = true;
				visited[i+1] = true;
				visited[i+2] = true;
				isFullHouse =true;
				return true;
			}
		}

		return false;
	}

	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isTwoPairs(String cards[], int n) {
		int count = 0;
		for (int i=0; i<n-1; i++) {
			
			if (cards[i].charAt(1) == cards[i+1].charAt(1) && visited[i] != true && visited[i+1] != true) {
				count++;
				i++;
			}
		}
		if(count == 1 && isFullHouse == true) {
			return true;
		}
		if (count == 2)
			return true;
		else
			return false;
	}
	
	public static void main(String args[]) {
		System.out.println(new Poker().isFullHouse(
			new String[] {"C2", "D2", "H2", "S3", "S4"}, 5));
		System.out.println(new Poker().isFullHouse(null,0));
	}
}
// end of Poker.java
