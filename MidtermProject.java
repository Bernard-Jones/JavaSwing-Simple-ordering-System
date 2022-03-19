package guiprojectpackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MidtermProject {

	private JFrame frame;
	private JTextField txt_quantity;
	private ButtonGroup bg = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MidtermProject window = new MidtermProject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MidtermProject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 511, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_Pizza = new JLabel("Pizza Project");
		lbl_Pizza.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbl_Pizza.setBounds(157, 27, 173, 49);
		frame.getContentPane().add(lbl_Pizza);
		
		JLabel lblNewLabel = new JLabel("Order");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(73, 90, 57, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton rb_regular = new JRadioButton("Regular (Php 100)");
		rb_regular.setSelected(true);
		rb_regular.setBounds(101, 127, 133, 23);
		frame.getContentPane().add(rb_regular);
		bg.add(rb_regular);
		
		JRadioButton rb_special = new JRadioButton("Special (Php 120)");
		rb_special.setBounds(101, 153, 133, 23);
		frame.getContentPane().add(rb_special);
		bg.add(rb_special);
		
		JRadioButton rb_SuperSpecial = new JRadioButton("Super special (Php 200)");
		rb_SuperSpecial.setBounds(101, 179, 189, 23);
		frame.getContentPane().add(rb_SuperSpecial);
		bg.add(rb_SuperSpecial);
		
		JLabel lbl_addons = new JLabel("add-ons");
		lbl_addons.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_addons.setBounds(73, 223, 57, 30);
		frame.getContentPane().add(lbl_addons);
		
		JCheckBox chbox_cheese = new JCheckBox("Cheese (+Php 10)");
		chbox_cheese.setBounds(101, 260, 150, 23);
		frame.getContentPane().add(chbox_cheese);
		
		JCheckBox chbox_bacon = new JCheckBox("Bacon (+Php 15)");
		chbox_bacon.setBounds(101, 285, 189, 23);
		frame.getContentPane().add(chbox_bacon);
		
		JCheckBox chbox_pepperoni = new JCheckBox("Pepperoni (+Php 20)");
		chbox_pepperoni.setBounds(101, 310, 229, 23);
		frame.getContentPane().add(chbox_pepperoni);
		
		JLabel lbl_membership = new JLabel("Membership");
		lbl_membership.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_membership.setBounds(73, 356, 80, 30);
		frame.getContentPane().add(lbl_membership);
		
		JComboBox<Object> cb_membership = new JComboBox<Object>();
		cb_membership.setModel(new DefaultComboBoxModel<Object>(new String[] {"No", "Yes"}));
		cb_membership.setBounds(163, 362, 108, 22);
		frame.getContentPane().add(cb_membership);
		
		txt_quantity = new JTextField();
		txt_quantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE)){
					e.consume();
				}
			}
		});
		txt_quantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_quantity.setBounds(140, 408, 150, 30);
		frame.getContentPane().add(txt_quantity);
		txt_quantity.setColumns(10);
		
		JLabel lbl_quantity = new JLabel("Quantity");
		lbl_quantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_quantity.setBounds(73, 406, 80, 30);
		frame.getContentPane().add(lbl_quantity);
		
		JLabel lbl_error = new JLabel("");
		lbl_error.setForeground(Color.RED);
		lbl_error.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_error.setBounds(73, 449, 281, 30);
		frame.getContentPane().add(lbl_error);
		
		JButton btn_submit = new JButton("Submit");
		btn_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int total = 0;
				int member = 5;
				int fresult;
				
				
				
				//order 
				if (rb_regular.isSelected()) {
					total = total + 100;
				}
				else if (rb_special.isSelected()) {
					total =  total + 120;
				}
				else {
					total = total + 200;
				}
				
				//add-ons
				if (chbox_cheese.isSelected() && chbox_bacon.isSelected() && chbox_pepperoni.isSelected()) {
					total = total + 45;
				}
				else if (chbox_cheese.isSelected() && chbox_bacon.isSelected()) {
					total = total + 25;
				}
				else if (chbox_cheese.isSelected() && chbox_pepperoni.isSelected()) {
					total = total + 30;
				}
				else if (chbox_bacon.isSelected() && chbox_pepperoni.isSelected()){
					total = total + 35;
				}
				else if (chbox_cheese.isSelected()) {
					total = total + 10;
				}
				else if (chbox_bacon.isSelected()) {
					total = total + 15;
				}
				else if (chbox_pepperoni.isSelected()) {
					total = total + 20;
				}
				else {
					total = total + 0;
				}
				
				
				
				
				
				
				
				
				
				if (txt_quantity.getText().isEmpty()) {
					lbl_error.setText("Please enter quantity");
				}
				else {
					int quantity = Integer.parseInt(txt_quantity.getText());
					
					//membership discount
					if (cb_membership.getSelectedItem().equals("Yes")) {
					fresult = total * quantity - member;			
				}
				else {
					fresult = total * quantity;
				}
					
					//result
				JOptionPane.showMessageDialog(null,"Total amount: " + fresult);
				}
					
			}
		});
		btn_submit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_submit.setBounds(157, 504, 89, 23);
		frame.getContentPane().add(btn_submit);
		
		
	}
}
