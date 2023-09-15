import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
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
	private static double money = 100;
	private static double boostprice = 50;
	private static double lessprice = 50;
	private static double casecost = 20;
	private static double moneyoutcome = 1;
	private static double moneyboost = 1;
	private static int rebirthamount = 0;
	private static double rebirthcost = 1;
	private static double rebirthcostincrease = 1;
	private static double rebirthboost = 1;
	
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
	        textBox = new JTextField("Enter Response Here");
	        textBox.selectAll();
	        ///////////////////////////////////////////////////////////////////          
	        b.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (money >=casecost) {
	            		money -= casecost;
	        			Random random = new Random();
	        			int randomnumber = random.nextInt(10) + 1;
	        			System.out.println("you got the number " + (randomnumber));
	        			if (randomnumber == 10) {
	        				System.out.println("you just got a the rarest number");
	        				money += (90 * moneyoutcome * rebirthboost);

	        			} else if (randomnumber == 1 || randomnumber == 2 || randomnumber == 3 || randomnumber == 4
	        					|| randomnumber == 5 | randomnumber == 6 || randomnumber == 7) {
	        				System.out.println("this is a common number");
	        				money += (10 * moneyoutcome * rebirthboost);
	        			} else {
	        				System.out.println("thats a pretty rare number");
	        				money += (25 * moneyoutcome * rebirthboost);

	        			}
	            	}
	        		
        			l.setText("Money: " + money);
        	System.out.println("hi");	            }
	        });
	        b2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	System.out.println("button 2 pressed");
	            	
	            }
	           });
	        b3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	System.out.println("button 3 pressed");
	            	
	            }
	           });
	        ///////////////////////////////////////////////////////////////////

	        
	        
	        
	        
	        j.add(b);
	        j.add(b2);
	        j.add(b3);
	        f.add(j, BorderLayout.NORTH);
	        f.add(l, BorderLayout.CENTER);
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

		rebirthboost += .25;
		rebirthcost *= (5 * rebirthcostincrease);
		moneyboost = 1;
		moneyoutcome = 1;
		money = 200;
		boostprice = 50;
		lessprice = 50;
		casecost = 20;
		rebirthamount += 1;
		rebirthcostincrease += 2.5;
		System.out.println("Congrats, you successfully rebirthed! You now have a boost of "+(rebirthboost)+(" on any earnings."));
		gamblego();
		
	}
	public static void Rebirth() {
		    System.out.println("Welcome to rebirth, you are currently at "+(rebirthamount)+(" rebirths."));
		    System.out.println("Rebirthing Deletes your current progress and starts you anew, with a slight boost to make you progress faster.");
		    System.out.println("Would you like to rebirth? It will cost " +(rebirthcost));
		    Scanner scanner = new Scanner(System.in);
		    String response = scanner.nextLine();
		    if (response.equals("y")) {
		    	System.out.println("Are you SURE? This will delete all upgrades and cash you currently own.");
		    	System.out.println("Type 'I Am Sure.' if you want to continue.");
		    	String confirmation = scanner.nextLine();
		    	if (confirmation.equals("I Am Sure.")&&(money>=rebirthcost)){
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
		if (response.equals("G") && (money >= casecost)) { // syntax for or is || and syntax for and is &&.
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
			money -= casecost;
			Random random = new Random();
			int randomnumber = random.nextInt(10) + 1;
			System.out.println("you got the number " + (randomnumber));
			if (randomnumber == 10) {
				System.out.println("you just got a the rarest number");
				money += (150 * moneyoutcome * rebirthboost);
				gamblego();

			} else if (randomnumber == 1 || randomnumber == 2 || randomnumber == 3 || randomnumber == 4
					|| randomnumber == 5 | randomnumber == 6 || randomnumber == 7) {
				System.out.println("this is a common number");
				money += (10 * moneyoutcome * rebirthboost);
				gamblego();
			} else {
				System.out.println("thats a pretty rare number");
				money += (20 * moneyoutcome * rebirthboost);
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
			System.out.println("Cost : "+(boostprice)+(lessprice));
			String buyresponse = shopscannerone.nextLine();
			if (buyresponse.equals("Luck")&&(money>=boostprice)) {
				money -= boostprice;
				moneyoutcome = (moneyboost + 0.1);
				boostprice *= 2;
				System.out.println("Bought upgrade");
				shop();

			}
			else if (buyresponse.equals("Cost")&&(money>=lessprice)) {
				money -= lessprice;
				casecost -= 2;
				lessprice *= 2;
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


