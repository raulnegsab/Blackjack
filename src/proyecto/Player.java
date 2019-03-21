//By Raul E. Negron
//841124959


package proyecto;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Image;
import java.awt.Panel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import proyecto.Deck.EmptyDeckException;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Player extends JFrame {
	
	//JFrame
	public static JFrame window = new JFrame();
	private static int x= 1000;
	private static int y = 300;
	
	//contador para las A
	public static int ace = 0;
	//Variables del programa
	public static Cards[] c;
	private String Name;
	private Double money;
	private String[] image;
	private Cards[] hand;
	private int handValue;
	private Socket client; // socket to communicate with server
	private JTextField textmuny;
	private JTextField txtSum;
	private JTextArea txtArea;
	private JScrollPane scroll;
	public JLabel[] label;
	private boolean bust;
	private PrintStream p;
	private BufferedReader br1;
	
	
	
	private static int i;
	private JTextField Skttxt;
	
	
	//player class
	public Player() throws EmptyDeckException {
		super("Blackjack");
		getContentPane().setBackground(new Color(0, 204, 102));
		getContentPane().setLayout(null);
		
		
		//initialized variables
		this.money = 25.00;
		this.i = 2;
		this.hand = new Cards[8];
		Deck d = new Deck(1);
		label = new JLabel[8];
		this.handValue = 0;
		c = new Cards[8];
		this.bust = false;
		
		
		//Cards for JLabels
		c[0] = d.DrawTopCard();
		c[1] = d.DrawTopCard();
		c[2] = d.DrawTopCard();
		c[3] = d.DrawTopCard();
		c[4] = d.DrawTopCard();
		c[5] = d.DrawTopCard();
		c[6] = d.DrawTopCard();
		c[7] = d.DrawTopCard();
		
		 
		//button for Hit()
		JButton btnHit = new JButton("Hit");
		btnHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hit(d.DrawTopCard());
					
					
				} catch (EmptyDeckException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnHit.setBounds(0, 239, 89, 23);
		getContentPane().add(btnHit);
		
		
		//button "Stay"
		JButton btnNewButton = new JButton("Stay");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtArea.append("\nPlayer Stayed. ");
				txtArea.append("\nPlayer has: " + handValue);
				try {
		
					endTurn();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			
		});
		btnNewButton.setBounds(87, 239, 89, 23);
		getContentPane().add(btnNewButton);
		
		//field for money
		textmuny = new JTextField();
		textmuny.setEditable(false);
		textmuny.setBackground(new Color(0, 204, 102));
		textmuny.setText("$" + this.money + " ");
		textmuny.setBounds(90, 218, 86, 20);
		getContentPane().add(textmuny);
		textmuny.setColumns(10);
		
		
		//txtbox for handValue
		txtSum = new JTextField();
		txtSum.setEditable(false);
		txtSum.setBackground(new Color(0, 204, 102));
		txtSum.setBounds(3, 218, 86, 20);
		getContentPane().add(txtSum);
		txtSum.setColumns(10);
		
		//Area for socket txt
		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setBackground(new Color(51, 204, 51));
		scroll = new JScrollPane(txtArea);
		scroll.setBounds(619, 136, 233, 124);
		getContentPane().add(scroll);
		
			
		
		//check for ace in first hand
		if(c[0].getCardValue() == 11)
			this.ace++;
		
		if(c[1].getCardValue() == 11)
			this.ace++;
		
		 this.handValue += c[0].getCardValue() + c[1].getCardValue();
		 
		 txtSum.setText("Total:  " + this.handValue +"");
		 
		 
		 // Card labels
		 label[0] = new JLabel("");
		 ImageIcon image1 = new ImageIcon(c[0].getImage());
		 Image img1 = image1.getImage();
		 Image newimg1 = img1.getScaledInstance(100, 120, img1.SCALE_DEFAULT);
		 image1 = new ImageIcon(newimg1);
		 label[0].setIcon(image1);
		 label[0].setBounds(0, 0, 100, 120);
		 label[0].setVisible(true);
		 getContentPane().add(label[0]);
		 
		 
		 label[1] = new JLabel("");
		 ImageIcon image2 = new ImageIcon(c[1].getImage());
		 Image img2 = image2.getImage();
		 Image newimg2 = img2.getScaledInstance(100, 120, img2.SCALE_DEFAULT);
		 image2 = new ImageIcon(newimg2);
		 label[1].setIcon(image2);
		 label[1].setBounds(100, 0, 100, 120);
		 label[1].setVisible(true);
		 getContentPane().add(label[1]);
		 

		 
		 label[2] = new JLabel("");
		 ImageIcon image3 = new ImageIcon(c[2].getImage());
		 Image img3 = image3.getImage();
		 Image newimg3 = img3.getScaledInstance(100, 120, img3.SCALE_DEFAULT);
		 image3 = new ImageIcon(newimg3);
		 label[2].setIcon(image3);
		 label[2].setBounds(200, 0, 100, 120);
		 label[2].setVisible(false);
		 getContentPane().add(label[2]);
		 
		 
		 label[3] = new JLabel("");
		 ImageIcon image4 = new ImageIcon(c[3].getImage());
		 Image img4 = image4.getImage();
		 Image newimg4 = img4.getScaledInstance(100, 120, img4.SCALE_DEFAULT);
		 image4 = new ImageIcon(newimg4);
		 label[3].setIcon(image4);
		 label[3].setBounds(300, 0, 100, 120);
		 label[3].setVisible(false);
		 getContentPane().add(label[3]);
		 
		 
		 label[4] = new JLabel("");
		 ImageIcon image5 = new ImageIcon(c[4].getImage());
		 Image img5 = image5.getImage();
		 Image newimg5 = img5.getScaledInstance(100, 120, img5.SCALE_DEFAULT);
		 image5 = new ImageIcon(newimg5);
		 label[4].setIcon(image5);
		 label[4].setBounds(400, 0, 100, 120);
		 label[4].setVisible(false);
		 getContentPane().add(label[4]);
		
		 
		 label[5] = new JLabel("");
		 ImageIcon image6 = new ImageIcon(c[5].getImage());
		 Image img6 = image6.getImage();
		 Image newimg6 = img6.getScaledInstance(100, 120, img6.SCALE_DEFAULT);
		 image6 = new ImageIcon(newimg6);
		 label[5].setIcon(image6);
		 label[5].setBounds(500, 0, 100, 120);
		 label[5].setVisible(false);
		 getContentPane().add(label[5]);
		
		 
		 label[6] = new JLabel("");
		 ImageIcon image7 = new ImageIcon(c[6].getImage());
		 Image img7 = image7.getImage();
		 Image newimg7 = img7.getScaledInstance(100, 120, img7.SCALE_DEFAULT);
		 image7 = new ImageIcon(newimg7);
		 label[6].setIcon(image7);
		 label[6].setBounds(600, 0, 100, 120);
		 label[6].setVisible(false);
		 getContentPane().add(label[6]);
		 
		 
		 label[7] = new JLabel("");
		 ImageIcon image8 = new ImageIcon(c[7].getImage());
		 Image img8 = image8.getImage();
		 Image newimg8 = img8.getScaledInstance(100, 120, img8.SCALE_DEFAULT);
		 image8 = new ImageIcon(newimg8);
		 label[7].setIcon(image8);
		 label[7].setBounds(700, 0, 100, 120);
		 label[7].setVisible(false);
		 getContentPane().add(label[7]);
		 
		
		//Extra hand to check for A's without affecting the labels 
		 for (int h = 0; h < hand.length; h++) {
			 
			 hand[h] = c[h];
			
		}	
	}
	
	//Client Socket
	public void Socket(String ip ) throws IOException {
		
		
		try {
			client = new Socket(ip, 2222);
			
			
			PrintStream p = new PrintStream(client.getOutputStream());
			
			
			BufferedReader br1 = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			String msg = br1.readLine();
			
			int number = Integer.parseInt(msg);
			
			txtArea.append("Dealer has " + number);
			
			System.out.println(number);
			
			
			
			
			
		} catch (IOException e) {
			
			
			e.printStackTrace();
		}

		
	}
	
	
	
	

	public String getName() {
		return this.Name;
	}

	public Double getMoney() {
		return this.money;
	}

	public void gainMoney(Double munny) {
		this.money += munny;
	}

	
	//hit method
	public void hit(Cards card) throws IOException{
		recieveCard(this.c[this.i]);
		
		System.out.println(this.c[this.i].getImage());
		System.out.println(this.i);
		this.i++;
	}
	private void recieveCard(Cards card) throws IOException{
		
		this.handValue += card.getCardValue();
		
		if(card.getCardValue() == 11)
			this.ace++;
		
		
		if(this.handValue > 21) {
			int value = this.handValue;
			if(this.ace > 0){
			this.handValue = this.handValue - 10;
			value = this.handValue;
			ace--;;
			
			} if( value > 21 && this.ace == 0)
				bust();
		
	}
		
		
		txtSum.setText("Total: " + this.handValue + "");
		
		label[this.i].setVisible(true);
			
		
		
		
	}

	


	
	
	//compares hand with dealers
	private void endTurn() throws IOException {
		//dealers end hand
		
		p = new PrintStream(this.client.getOutputStream());
		
		p.println(this.handValue);
		
		
		this.br1 = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
		String str = this.br1.readLine();
		
		
		int num = Integer.parseInt(str);
		txtArea.append("\nDealer has: " + str);
		if((this.handValue > num && this.handValue <= 21) || num > 21 ){
			youWin();
		} else if(this.handValue == num){
			txtArea.append("\nHouse always wins ties, sorry.");
			youLose();
		}
		else
			youLose();
		
		
	}
	


	//You Lose
	private void youLose() {
		txtArea.append("\nYou Lose!");
		textmuny.setText("$" + (this.money - 5));
		closeConnection();
	}

	//You WIn
	private void youWin() {
		txtArea.append("\nYou win!");
		textmuny.setText("$" + (this.money + 5));
		closeConnection();
		
	}
	
		private void bust() throws IOException {
		
		
		txtSum.setText("Total: " + this.handValue);
		
		txtArea.append("\nPlayer busts");
		
		p = new PrintStream(this.client.getOutputStream());
		
		p.println(this.handValue);
		
		
		this.br1 = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
		
		String str = this.br1.readLine();
		int num = Integer.parseInt(str);
		
		txtArea.append("\nDealer has: " + num);
		
		youLose();
	}

		//close the socket
	private void closeConnection() 
	{
		txtArea.append( "\nGame Over" );

		try 
		{
			this.br1.close();
			this.p.close();
			client.close(); // close socket
		} // end try
		catch ( IOException ioException ) 
		{} // end catch
	} // end method closeConnection
	public static void main(String args[]) throws EmptyDeckException, IOException {
		
		Player ply = new Player();
		
		System.out.println("Please input server ip.");
//		Scanner scan = new Scanner(System.in);
//		
//		String ip = scan.nextLine();
		
		
		
		ply.setSize(x, y);
		
		
		
		
		ply.setVisible(true);
		ply.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		ply.Socket("127.0.0.1");
		
		
	}



	
}
