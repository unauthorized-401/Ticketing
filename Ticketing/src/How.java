import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import DB.MemberDAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

public class How extends JPanel implements ActionListener, Runnable{
	ButtonGroup bg_pay = new ButtonGroup();
	JRadioButton rad_card = new JRadioButton("신용카드", false);
	JRadioButton rad_deposit = new JRadioButton("무통장입금", false);
	Choice ch_bank = new Choice();
	JLabel lb_money = new JLabel("0");
	
	private int view_time=CurrInfo.getHowtime();
	
	JLabel timer=new JLabel();
	static long start = 0, end = 0, time = 0;
	
	JButton b_payment = new JButton(new ImageIcon("image/bt_pay.png"));
	How(){
		start = System.currentTimeMillis();
		
		lb_money.setFont(new Font("맑은 고딕",Font.BOLD,14));
		rad_card.setFont(new Font("맑은 고딕",Font.BOLD,14));
		rad_deposit.setFont(new Font("맑은 고딕",Font.BOLD,14));
		rad_card.setBackground(Color.WHITE);
		rad_deposit.setBackground(Color.WHITE);
		
		b_payment.setBorderPainted(false);
		b_payment.setBackground(Color.WHITE);

		JFrame jf = new JFrame("결제창");
		JPanel u_p = new JPanel();
		JPanel p_1 = new JPanel();
		JPanel p_2 = new JPanel();
		JPanel p_3 = new JPanel();
		JPanel p_4 = new JPanel();
		JPanel p_5 = new JPanel();
		JPanel bt_p = new JPanel();
		JPanel gri_p = new JPanel(new GridLayout(4,1));
		JPanel gri_p1 = new JPanel(new GridLayout(2,1));
		JPanel d_p = new JPanel();
		
		u_p.setBackground(Color.WHITE);
		p_1.setBackground(Color.WHITE);
		p_2.setBackground(Color.WHITE);
		p_3.setBackground(Color.WHITE);
		p_4.setBackground(Color.WHITE);
		p_5.setBackground(Color.WHITE);
		bt_p.setBackground(Color.WHITE);
		gri_p.setBackground(Color.WHITE);
		d_p.setBackground(Color.WHITE);
		
		JLabel newline1 = new JLabel("\n");
		
		ch_bank.addItem("선택");
		ch_bank.addItem("국민은행");
		ch_bank.addItem("신한은행");
		ch_bank.addItem("기업은행");
		ch_bank.addItem("농협은행");
		ch_bank.addItem("우리은행");
		JLabel newline2 = new JLabel("\n");
		JLabel l1 = new JLabel("최종 결제금액 : ");
		JLabel won = new JLabel("원");
		
		lb_money.setText(Integer.toString(CurrInfo.getAmount()));
		
		l1.setFont(new Font("맑은 고딕",Font.BOLD,14));
		won.setFont(new Font("맑은 고딕",Font.BOLD,14));
		
		JLabel title=new JLabel();
		ImageIcon icon = new ImageIcon("image/howtopay.png");
		title.setIcon(icon);
		title.setText(null);
		
		JLabel logo=new JLabel();
		ImageIcon icon1 = new ImageIcon("image/xsmall_logo.png");
		logo.setIcon(icon1);
		logo.setText(null);
		
		u_p.add(newline1);
		jf.getContentPane().add(u_p, BorderLayout.NORTH);
		bg_pay.add(rad_card);
		bg_pay.add(rad_deposit);
		p_1.add(rad_card);
		p_1.add(rad_deposit);
		p_2.add(ch_bank);
		p_2.add(newline2);
		p_3.add(l1);
		p_3.add(lb_money);
		p_3.add(won);
		gri_p.add(p_1);
		gri_p.add(p_2);
		gri_p.add(p_3);
		bt_p.add(b_payment);
		gri_p.add(bt_p);
		gri_p1.add(p_4);
		
		timer.setForeground(Color.RED);
		timer.setFont(new Font("맑은 고딕",Font.BOLD,30));
		GroupLayout gl_p_4 = new GroupLayout(p_4);
		gl_p_4.setHorizontalGroup(
			gl_p_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p_4.createSequentialGroup()
					.addGroup(gl_p_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_p_4.createSequentialGroup()
							.addGap(474)
							.addComponent(timer))
						.addGroup(gl_p_4.createSequentialGroup()
							.addGap(403)
							.addComponent(title)))
					.addContainerGap(482, Short.MAX_VALUE))
		);
		gl_p_4.setVerticalGroup(
			gl_p_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_p_4.createSequentialGroup()
					.addContainerGap(185, Short.MAX_VALUE)
					.addComponent(timer)
					.addGap(54)
					.addComponent(title))
		);
		p_4.setLayout(gl_p_4);
		gri_p1.add(gri_p);
		jf.getContentPane().add(gri_p1, BorderLayout.CENTER);
		jf.getContentPane().add(d_p, BorderLayout.SOUTH);
		GroupLayout gl_d_p = new GroupLayout(d_p);
		gl_d_p.setHorizontalGroup(
			gl_d_p.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_d_p.createSequentialGroup()
					.addContainerGap(916, Short.MAX_VALUE)
					.addComponent(logo)
					.addGap(35))
		);
		gl_d_p.setVerticalGroup(
			gl_d_p.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_d_p.createSequentialGroup()
					.addComponent(logo)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		d_p.setLayout(gl_d_p);
		
		jf.setSize(1000, 600);
		jf.setLocationRelativeTo(null);
		gri_p.setBorder(new TitledBorder(""));
        jf.setVisible(true); 
        //jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        b_payment.addActionListener(this);
        
        new Thread(this).start();
	}
	public void run() { 
		view_time+=1;
		while( true ) { 
			try { 
				view_time--;
				if( view_time < 0 ) { 
		        	view_time = 0; 
		        }  
		        timer.setText( "00 : 0"+view_time); 
		        Thread.sleep(1000); 
		        } catch(Exception e) { 
		        e.printStackTrace(); 
		    } 
		} 
    } 
	class WClass extends WindowAdapter{
		public void windowClosing(WindowEvent e) { System.exit(0); }
	}
	public static void main(String[] args) {
		new How();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		end = System.currentTimeMillis();
		time = (long) ((end - start) / 1000.0);
		if(time >= CurrInfo.getHowtime()) new HowFail();
		else{ 
			try {
				if(rad_card.isSelected()){
					CurrInfo.setPayment(rad_card.getLabel());
				}else if(rad_deposit.isSelected()){
					CurrInfo.setPayment(rad_deposit.getLabel());
				}else{
						throw new MyException();
				}
				if(ch_bank.getSelectedItem().equals("선택")){
						throw new MyException1();
					
				}else {
					CurrInfo.setBank(ch_bank.getSelectedItem());
				}
			} catch (MyException e1) { 
			} catch (MyException1 e1) { }
			if(e.getSource()==b_payment)
			{
				if(!CurrInfo.getPayment().equals("")&&!CurrInfo.getBank().equals("")){
					new Success();
				}
			}
		}
	}
}
class MyException extends Exception{
	String reason = "";
	public MyException() { JOptionPane.showMessageDialog(null, "결제방법을 선택해주세요.", "오류창", JOptionPane.ERROR_MESSAGE); } 
	public String toString(){
		return reason;
	}
}
class MyException1 extends Exception{
	String reason = "";
	public MyException1() { JOptionPane.showMessageDialog(null, "은행을 선택해주세요.", "오류창", JOptionPane.ERROR_MESSAGE); } 
	public String toString(){
		return reason;
	}
}