import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;  
import javax.swing.*;    
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
public class TaskPractice extends JFrame {
    static JFrame f;
    static JPanel j;
    static JButton b;
    static JButton b2;
    static JButton b3;
    static JLabel l;
    static JTextField textBox;
    static JButton bShop;
	private static double money = 100; // main money amount
	private static double boostPrice = 50; // the price for an upgrade in shop that increases
										// money gained from a crate
	private static double lessPrice = 50; // the price for an upgrade that decreases the cost 
	private static double caseMedCost = 200; // the base cost for medium case
	private static double caseEndCost = 100000; // the base cost for medium case

			// of cases
	private static double caseCost = 20; // the base cost for basic case
	private static double moneyOutcome = 1; // some variable. not sure.
	private static double moneyBoost = 1; // some variable.
	private static int rebirthAmount = 0; // amount of current rebirhts
	private static double rebirthCost = 1; // cost it takes to buy another rebirth
	private static double rebirthCostIncrease = 1; //variable that increases rebirth cost
	private static double rebirthBoost = 1; // the boost of rebirthing onto your money gain
	
	public static void main(String[] args) {
		  f = new JFrame("Professional Case Gambling Software");
	        f.setSize(500, 500);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.setLayout(new BorderLayout());

	        j = new JPanel(new FlowLayout());
	        b = new JButton("Open Basic");
	        b2 = new JButton("Open Intermediate");
	        b3 = new JButton("Open End");
	        l = new JLabel("Money: " + money);
	        bShop = new JButton("Shop");
	        textBox = new JTextField("Enter Response Here");
	        textBox.selectAll();
	        ///////////////////////////////////////////////////////////////////          
	        b.addActionListener(new ActionListener() { // start costs 20
	            public void actionPerformed(ActionEvent e) {
	            	if (money >=caseCost) {
	            		money -= caseCost;
	        			Random random = new Random();
	        			int randomnumber = random.nextInt(10) + 1;
	        			System.out.println("you got the number " + (randomnumber));
	        			if (randomnumber == 10) {
	        				System.out.println("you just got a the rarest number");
	        				money += (90 * moneyOutcome * rebirthBoost);

	        			} else if (randomnumber == 1 || randomnumber == 2 || randomnumber == 3 || randomnumber == 4
	        					|| randomnumber == 5 | randomnumber == 6 || randomnumber == 7) {
	        				System.out.println("this is a common number");
	        				money += (10 * moneyOutcome * rebirthBoost);
	        			} else {
	        				System.out.println("thats a pretty rare number");
	        				money += (25 * moneyOutcome * rebirthBoost);

	        			}
	            	}
	        		
        			l.setText("Money: " + money);
        	System.out.println("hi");	            }
	        });
	        b2.addActionListener(new ActionListener() { // med costs 200
	            public void actionPerformed(ActionEvent e) {
	            	System.out.println("button 2 pressed");
	            	if (money >=caseMedCost) {
	            		money -= caseMedCost;
	        			Random random = new Random();
	        			int randomnumber = random.nextInt(10) + 1;
	        			System.out.println("you got the number " + (randomnumber));
	        			if (randomnumber == 10) {
	        				System.out.println("you just got a the rarest number");
	        				money += (900 * moneyOutcome * rebirthBoost);

	        			} else if (randomnumber == 1 || randomnumber == 2 || randomnumber == 3 || randomnumber == 4
	        					|| randomnumber == 5 | randomnumber == 6 || randomnumber == 7) {
	        				System.out.println("this is a common number");
	        				money += (100 * moneyOutcome * rebirthBoost);
	        			} else {
	        				System.out.println("thats a pretty rare number");
	        				money += (250 * moneyOutcome * rebirthBoost);

	        			}
	            	}
	        		
        			l.setText("Money: " + money);
	            }
	           });
	        b3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) { // final case costs 100k
	            	System.out.println("button 3 pressed");
	            	if (money >=caseEndCost) {
	            		money -= caseEndCost;
	        			Random random = new Random();
	        			int randomnumber = random.nextInt(10) + 1;
	        			System.out.println("you got the number " + (randomnumber));
	        			if (randomnumber == 10) {
	        				System.out.println("you just got a the rarest number");
	        				money += (2000000 * moneyOutcome * rebirthBoost); // 2 mil for rarest

	        			} else if (randomnumber == 1 || randomnumber == 2 || randomnumber == 3 || randomnumber == 4
	        					|| randomnumber == 5 | randomnumber == 6 || randomnumber == 7) {
	        				System.out.println("this is a common number");
	        				money += (1 * moneyOutcome * rebirthBoost); // 1 for most common
	        			} else {
	        				System.out.println("thats a pretty rare number");
	        				money += (1 * moneyOutcome * rebirthBoost);

	        			}
	            	}
	        		
        			l.setText("Money: " + money);
	            }
	           });
	        ///////////////////////////////////////////////////////////////////

	        j.add(b);
	        j.add(b2);
	        j.add(b3);
	       // j.add(bShop);
	        f.add(j, BorderLayout.NORTH);
	        f.add(l, BorderLayout.CENTER);
	        bShop.setBounds(10,10,10,10);
	       // f.add(bShop);
	        //conlan added this textbox \/
	        f.add(textBox, BorderLayout.SOUTH);
	        l.setBounds(10,30,40,10);
	        
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
	        
		gamblego();
        // frame base
       
        
	}
	private class Listener implements ActionListener 
	{ 
		public void actionPerformed(ActionEvent e) 
	    {   
			System.out.println("button clicked" );
	    } 
	} 

	
	public static void Reset() {

		rebirthBoost += .25;
		rebirthCost *= (5 * rebirthCostIncrease);
		moneyBoost = 1;
		moneyOutcome = 1;
		money = 200;
		boostPrice = 50;
		lessPrice = 50;
		caseCost = 20;
		rebirthAmount += 1;
		rebirthCostIncrease += 2.5;
		System.out.println("Congrats, you successfully rebirthed! You now have a boost of "+(rebirthBoost)+(" on any earnings."));
		gamblego();
		
	}
	public static void Rebirth() {
		    System.out.println("Welcome to rebirth, you are currently at "+(rebirthAmount)+(" rebirths."));
		    System.out.println("Rebirthing Deletes your current progress and starts you anew, with a slight boost to make you progress faster.");
		    System.out.println("Would you like to rebirth? It will cost " +(rebirthCost));
		    Scanner scanner = new Scanner(System.in);
		    String response = scanner.nextLine();
		    if (response.equals("y")) {
		    	System.out.println("Are you SURE? This will delete all upgrades and cash you currently own.");
		    	System.out.println("Type 'I Am Sure.' if you want to continue.");
		    	String confirmation = scanner.nextLine();
		    	if (confirmation.equals("I Am Sure.")&&(money>=rebirthCost)){
		    		Reset();
		    	}
		    		else {
		    		System.out.println("Response was not 'I Am Sure', or you dont have enough money. sending back to main menu.");
		    		gamblego();
		    	}
		    	
		    }
		    else {
		    	System.out.println("response was not 'y' so I will be sending you back to the main menu.");
		    	gamblego();
		    } 
		  }
	public static void gamblego() {
		System.out.println("Your current balance is " + (money));
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want to Gamble?(G) Or go to Shop(S)? Or maybe Rebirth.");
		String response = scanner.nextLine();
		if (response.equals("G") && (money >= caseCost)) { // syntax for or is || and syntax for and is &&.
			cases();
		}
		else if (response.equals("S")) {
			shop();
			
		}	
    else if (response.equals("R")){
      Rebirth();
    }
		else {
			gamblego();
		}	
	}
	public static void cases() {
		Scanner casecheck = new Scanner(System.in);
		System.out.println("What case? Basic ('b'), x, z");
		String whatcase = casecheck.nextLine();
		if (whatcase.equals("b")) {
			money -= caseCost;
			Random random = new Random();
			int randomnumber = random.nextInt(10) + 1;
			System.out.println("you got the number " + (randomnumber));
			if (randomnumber == 10) {
				System.out.println("you just got a the rarest number");
				money += (150 * moneyOutcome * rebirthBoost);
				gamblego();

			} else if (randomnumber == 1 || randomnumber == 2 || randomnumber == 3 || randomnumber == 4
					|| randomnumber == 5 | randomnumber == 6 || randomnumber == 7) {
				System.out.println("this is a common number");
				money += (10 * moneyOutcome * rebirthBoost);
				gamblego();
			} else {
				System.out.println("thats a pretty rare number");
				money += (20 * moneyOutcome * rebirthBoost);
				gamblego();

			}
		}
		


	}
	public static void shop() {
		System.out.println("Welcome to shop, Buy or Leave?");
		Scanner shopscannerone = new Scanner(System.in);
		String shopresponse = shopscannerone.nextLine();
		if (shopresponse.equals("Buy")) {
			System.out.println("Buy : Luck | Cost | ");
			System.out.println("Cost : "+(boostPrice)+(lessPrice));
			String buyresponse = shopscannerone.nextLine();
			if (buyresponse.equals("Luck")&&(money>=boostPrice)) {
				money -= boostPrice;
				moneyOutcome = (moneyBoost + 0.1);
				boostPrice *= 2;
				System.out.println("Bought upgrade");
				shop();

			}
			else if (buyresponse.equals("Cost")&&(money>=lessPrice)) {
				money -= lessPrice;
				caseCost -= 2;
				lessPrice *= 2;
				System.out.println("Bought upgrade");
				shop();
			}
			else {
				shop();
			}
		}
		else if (shopresponse.equals("Leave")) {
			gamblego();
		}
		else {
		shop();
		}
	
	}

}


