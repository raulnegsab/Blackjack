//By Raul E. Negron Sabo
//841124959

package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import proyecto.Deck.EmptyDeckException;

import java.awt.SystemColor;

public class Dealer extends JFrame {
	
	//JFrame
	private JFrame DWindow = new JFrame();
	
	//Variables
	private ServerSocket server;
	private ServerSocket sockServer;
	private Socket accept;
	private JScrollPane scroll;
	private int DealerHandStart;
	private int DealerHandEnd;
	private int playerHandValue;
	private Deck d; 
	private int ace;
	private boolean bust = false;
	
	
	
	private JTextArea txtArea;
	
	
	public Dealer() throws EmptyDeckException, IOException {
	super("Dealer");
	
	//Area for socket txt
	txtArea = new JTextArea();
	txtArea.setBackground(SystemColor.controlHighlight);
	txtArea.setEditable(false);
	scroll = new JScrollPane(txtArea);
	getContentPane().add(scroll, BorderLayout.CENTER);
	
	
	this.ace = 0;
	this.d = new Deck(1);
	Cards[] c = new Cards[2];
	
	
	//Dealers initial Hand
	c[0] = d.DrawTopCard();
	c[1] = d.DrawTopCard();
	
	this.DealerHandStart = c[0].getCardValue() + c[1].getCardValue();
	this.DealerHandEnd = this.DealerHandStart; 
	
	
	if(c[0].getCardValue() == 11){
		ace++;
	}
	if( c[1].getCardValue() == 11 ) {
		ace++;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
	}
	
	
		//Generate Dealers second value DealerHandEnd
	private void DealerGo() throws EmptyDeckException {
	
		if( this.DealerHandEnd <= 16 ) {
			this.DealerHandEnd += d.DrawTopCard().getCardValue();
			DealerGo();
		}
			if(this.DealerHandEnd > 21 && this.ace > 0 ) {
				this.DealerHandEnd -= 10;
				this.ace--;
				DealerGo();
		} else if(this.DealerHandEnd > 21 && this.ace == 0){
			dealerBust();
		}
			
		
			
	}
	
	//Dealer goes over 21
	private void dealerBust() {
		this.bust = true;
		
	}

	//Server class
	public void Server() throws IOException, EmptyDeckException {
		
		server = new ServerSocket(2222);
		
		txtArea.append("Waiting for Client...");
		
		accept = server.accept();
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PrintStream p = new PrintStream(accept.getOutputStream());
		
		
		
		
		//Dealer hand
		int temp = this.DealerHandStart;
		p.println(temp);
		
		txtArea.append("Connection Succesful.");
		txtArea.append("\nDealer has: " + this.DealerHandStart);
	
		BufferedReader br1 = new BufferedReader(new InputStreamReader(accept.getInputStream()));
		//Player hand
		String msg = br1.readLine();	
		int num = Integer.parseInt(msg);
		txtArea.append("\nPlayer has: " + num);
		
		DealerGo();
		
		p.println(this.DealerHandEnd);	
		
		if(this.bust == true)
			txtArea.append("\nDealer busts");
		
		txtArea.append("\nDealer has: " + this.DealerHandEnd);
		
		p.println(this.DealerHandEnd);
		
		
		p.close();
		
		br.close();
		
	}
	
	public static void main(String args[]) throws IOException, EmptyDeckException{
		
		Dealer dl = new Dealer();
		
		
		
		
		
		
		dl.setSize(250, 250);
		
		dl.setVisible(true);
		dl.setDefaultCloseOperation(EXIT_ON_CLOSE);
		dl.Server();
		
		
		
		
	}

}
