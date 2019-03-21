//Modified and finished by Raul E. Negron.
//provided by Raul Cuevas



package proyecto;

import java.awt.image.BufferedImage;

public enum Cards {
	KING_OF_SPADES ("KS", 10, "BlackjackCards\\Kofspades.png"),
	KING_OF_HEARTS ("KH", 10,"BlackjackCards\\Kofhearts.png"),
	KING_OF_CLUBS ("KC", 10,"BlackjackCards\\Kofclubs.png"),
	KING_OF_DIAMONDS ("KD", 10,"BlackjackCards\\Kofdiamonds.png"),
	
	
	QUEEN_OF_SPADES ("QS", 10,"BlackjackCards\\Qofspades.png"),
	QUEEN_OF_HEARTS ("QH", 10,"BlackjackCards\\Qofhearts.png"),
	QUEEN_OF_CLUBS ("QC", 10,"BlackjackCards\\Qofclubs.png"),
	QUEEN_OF_DIAMONDS ("QD", 10,"BlackjackCards\\Qofdiamonds.png"),
	
	JACK_OF_SPADES ("JS", 10,"BlackjackCards\\Jofspades.png"),
	JACK_OF_HEARTS ("JH", 10,"BlackjackCards\\Jofhearts.png"),
	JACK_OF_CLUBS ("JC", 10,"BlackjackCards\\Jofclubs.png"),
	JACK_OF_DIAMONDS ("JD", 10,"BlackjackCards\\Jofdiamonds.png"),
	
	TEN_OF_SPADES ("10S", 10,"BlackjackCards\\10ofspades.png"),
	TEN_OF_HEARTS ("10H", 10,"BlackjackCards\\10ofhearts.png"),
	TEN_OF_CLUBS ("10C", 10,"BlackjackCards\\10ofclubs.png"),
	TEN_OF_DIAMONDS ("10D", 10,"BlackjackCards\\10ofdiamonds.png"),
	
	NINE_OF_SPADES ("9S", 9,"BlackjackCards\\9ofspades.png"),
	NINE_OF_HEARTS ("9H", 9,"BlackjackCards\\9ofhearts.png"),
	NINE_OF_CLUBS ("9C", 9,"BlackjackCards\\9ofclubs.png"),
	NINE_OF_DIAMONDS ("9D", 9,"BlackjackCards\\9ofdiamonds.png"),
	
	EIGHT_OF_SPADES ("8S", 8,"BlackjackCards\\8ofspades.png"),
	EIGHT_OF_HEARTS ("8H", 8,"BlackjackCards\\8ofhearts.png"),
	EIGHT_OF_CLUBS ("8C", 8,"BlackjackCards\\8ofclubs.png"),
	EIGHT_OF_DIAMONDS ("8D", 8,"BlackjackCards\\8ofdiamonds.png"),
	
	SEVEN_OF_SPADES ("7S", 7,"BlackjackCards\\7ofspades.png"),
	SEVEN_OF_HEARTS ("7H", 7,"BlackjackCards\\7ofhearts.png"),
	SEVEN_OF_CLUBS ("7C", 7,"BlackjackCards\\7ofclubs.png"),
	SEVEN_OF_DIAMONDS ("7D", 7,"BlackjackCards\\7ofdiamonds.png"),
	
	SIX_OF_SPADES ("6S", 6,"BlackjackCards\\6ofspades.png"),
	SIX_OF_HEARTS ("6H", 6,"BlackjackCards\\6ofhearts.png"),
	SIX_OF_CLUBS ("6C", 6,"BlackjackCards\\6ofclubs.png"),
	SIX_OF_DIAMONDS ("6D", 6,"BlackjackCards\\6ofdiamonds.png"),
	
	FIVE_OF_SPADES ("5S", 5,"BlackjackCards\\5ofspades.png"),
	FIVE_OF_HEARTS ("5H", 5,"BlackjackCards\\5ofhearts.png"),
	FIVE_OF_CLUBS ("5C", 5,"BlackjackCards\\5ofclubs.png"),
	FIVE_OF_DIAMONDS ("5D", 5,"BlackjackCards\\5ofdiamonds.png"),
	
	FOUR_OF_SPADES ("4S", 4,"BlackjackCards\\4ofspades.png"),
	FOUR_OF_HEARTS ("4H", 4,"BlackjackCards\\4ofhearts.png"),
	FOUR_OF_CLUBS ("4C", 4,"BlackjackCards\\4ofclubs.png"),
	FOUR_OF_DIAMONDS ("4D", 4,"BlackjackCards\\4ofdiamonds.png"),
	 
	THREE_OF_SPADES ("3S", 3,"BlackjackCards\\3ofspades.png"),
	THREE_OF_HEARTS ("3H", 3,"BlackjackCards\\3ofhearts.png"),
	THREE_OF_CLUBS ("3C", 3,"BlackjackCards\\3ofclubs.png"),
	THREE_OF_DIAMONDS ("3D", 3,"BlackjackCards\\3ofdiamonds.png"),
	
	TWO_OF_SPADES ("2S", 2,"BlackjackCards\\2ofspades.png"),
	TWO_OF_HEARTS ("2H", 2,"BlackjackCards\\2ofhearts.png"),
	TWO_OF_CLUBS ("2C", 2,"BlackjackCards\\2ofclubs.png"),
	TWO_OF_DIAMONDS ("2D", 2,"BlackjackCards\\2ofdiamonds.png"),
	
	ACE_OF_SPADES ("AS", 11,"BlackjackCards\\AceSpades.png"),
	ACE_OF_HEARTS ("AH", 11,"BlackjackCards\\AceHearts.png"),
	ACE_OF_CLUBS ("AC", 11,"BlackjackCards\\AceClubs.png"),
	ACE_OF_DIAMONDS ("AD", 11,"BlackjackCards\\AceDiamonds.png");
	
	private final int value;
	private final String name;
	private final String image;
	
	Cards(String name, int value, String image){
		this.name = name;
		this.value = value;
		this.image = image;
	}
	
	public String getCardName() {
		return this.name;
	}
	
	public int getCardValue() {
		return this.value;
	}
	
	public String getImage(){
		return this.image;
	}
}
