import java.awt.EventQueue;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class CrapsIntf extends JFrame {

	private JPanel contentPane;
	private static JTextField firstDie;
	private static JTextField secondDie;
	private static JTextField totalDice;
	private static JTextField pointAmnt;
	private static JTextField gameOutcome;
	private static JTextField instructions;
	private JButton exitButton;
	
	static int total, point;
	static Boolean firstRoll = true;
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrapsIntf frame = new CrapsIntf();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CrapsIntf() {
		setTitle("Craps Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel die1Label = new JLabel("Die 1:");
		die1Label.setBounds(119, 40, 45, 13);
		contentPane.add(die1Label);
		
		JLabel die2Label = new JLabel("Die 2:");
		die2Label.setBounds(119, 63, 45, 19);
		contentPane.add(die2Label);
		
		JLabel totalLabel = new JLabel("Total:");
		totalLabel.setBounds(119, 92, 45, 13);
		contentPane.add(totalLabel);
		
		/*JButton rollButton = new JButton("Roll Again");
		rollButton.setBounds(173, 232, 97, 21);
		contentPane.add(rollButton);
		rollButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  rollDice();
			  }
		});*/
		
		
		
		JLabel pointLabel = new JLabel("Point:");
		pointLabel.setBounds(119, 124, 45, 13);
		contentPane.add(pointLabel);
		
		firstDie = new JTextField();
		firstDie.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		firstDie.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		firstDie.setEditable(false);
		firstDie.setHorizontalAlignment(SwingConstants.CENTER);
		firstDie.setBounds(170, 37, 96, 19);
		contentPane.add(firstDie);
		firstDie.setColumns(10);
		
		secondDie = new JTextField();
		secondDie.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		secondDie.setEditable(false);
		secondDie.setHorizontalAlignment(SwingConstants.CENTER);
		secondDie.setBounds(170, 63, 96, 19);
		contentPane.add(secondDie);
		secondDie.setColumns(10);
		
		totalDice = new JTextField();
		totalDice.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		totalDice.setEditable(false);
		totalDice.setHorizontalAlignment(SwingConstants.CENTER);
		totalDice.setBounds(170, 89, 96, 19);
		contentPane.add(totalDice);
		totalDice.setColumns(10);
		
		pointAmnt = new JTextField();
		pointAmnt.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pointAmnt.setEditable(false);
		pointAmnt.setForeground(Color.RED);
		pointAmnt.setHorizontalAlignment(SwingConstants.CENTER);
		pointAmnt.setBounds(170, 121, 96, 19);
		contentPane.add(pointAmnt);
		pointAmnt.setColumns(10);
		
		gameOutcome = new JTextField();
		gameOutcome.setBorder(null);
		gameOutcome.setEditable(false);
		gameOutcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		gameOutcome.setForeground(Color.BLUE);
		gameOutcome.setHorizontalAlignment(SwingConstants.CENTER);
		gameOutcome.setBounds(97, 163, 241, 21);
		contentPane.add(gameOutcome);
		gameOutcome.setColumns(10);
		
		JButton playButton = new JButton("Roll Dice");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play();
			}
		});
		playButton.setBounds(97, 232, 97, 21);
		contentPane.add(playButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(253, 232, 85, 21);
		contentPane.add(exitButton);
		exitButton.addActionListener(e -> System.exit(0));
		
		instructions = new JTextField();
		instructions.setBorder(null);
		instructions.setEditable(false);
		instructions.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		instructions.setForeground(new Color(0, 0, 0));
		instructions.setHorizontalAlignment(SwingConstants.CENTER);
		instructions.setBounds(97, 194, 241, 19);
		contentPane.add(instructions);
		instructions.setColumns(10);
		instructions.setText("Press Roll Dice to Play.");
		
	}
	
	
	public static int rollDice() {
		// Function to return the sum of the dice(total). Each die generates a random number between 1 and 6 inclusive
		int die1, die2, total;
		Random rand = new Random();
		die1 = rand.nextInt((6 - 1) + 1) + 1; 	// set die1 equal to random number 1 - 6
		die2 = rand.nextInt((6 - 1) + 1) + 1;	// set die2 equal to random number 1 - 6
		total = die1 + die2;
		System.out.printf("\nYou rolled %d + %d = %d", die1, die2, total);
		firstDie.setText(Integer.toString(die1));
		secondDie.setText(Integer.toString(die2));
		totalDice.setText(Integer.toString(total));
		return total;
	}
	
	public static void play() {
		
		instructions.setText("Press Roll Dice to Roll Again.");
		gameOutcome.setText("");
		if (firstRoll) {
			
			total = rollDice();
			switch(total) {
			
			// if initial dice roll equals 7 or 11 automatic win
			case 7: case 11:	
				System.out.println("\nYOU WIN!!");
				pointAmnt.setText("");
				gameOutcome.setText("YOU WIN!");
				instructions.setText("Press Roll Dice to Play Again.");
				break;
				
			// if initial dice roll equals 2, 3, or 12 automatic loss
			case 2: case 3: case 12:
				System.out.println("\nYOU LOSE!!");
				pointAmnt.setText("");
				gameOutcome.setText("YOU LOSE!");
				instructions.setText("Press Roll Dice to Play Again.");
				break;
				
			default:
				point = total;			// else point equals total and dice is rolled again
				System.out.printf("\nPoint is: %d", point);
				pointAmnt.setText(Integer.toString(point));
				instructions.setText("Press Roll Dice to Roll Again.");
				firstRoll = false;
				break;
			}
		}
		else {
			total = rollDice();
			
			
			if (total == point) {
				System.out.println("\nYOU WIN!!");
				gameOutcome.setText("YOU WIN!");
				instructions.setText("Press Roll Dice to Play Again.");
				firstRoll = true;
				
			}
			else if (total == 7) {
				System.out.println("\nYOU LOSE!!");
				gameOutcome.setText("YOU LOSE!");
				instructions.setText("Press Roll Dice to Play Again.");
				firstRoll = true;
				
			}
		}
	}
}



