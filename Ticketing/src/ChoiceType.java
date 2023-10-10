import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DB.MemberDAO;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ChoiceType extends JPanel implements ActionListener{
	private int SeatTime;
	private int HowTime; 
	
	JButton b1 = new JButton("¼±ÅÃ");
	JButton b2 = new JButton("¼±ÅÃ");
	JButton b3 = new JButton("¼±ÅÃ");
	JButton b4 = new JButton("¼±ÅÃ");
	
	JButton logo=new JButton(new ImageIcon("image/xsmall_logo.png"));
	public ChoiceType(){
		
		logo.setBorderPainted(false);
		logo.setBackground(Color.WHITE);
		
		b1.setBorderPainted(false);
		b1.setBackground(new Color(238,43,88));
		b1.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		b1.setForeground(Color.WHITE);
		b2.setBorderPainted(false);
		b2.setBackground(new Color(238,43,88));
		b2.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		b2.setForeground(Color.WHITE);
		b3.setBorderPainted(false);
		b3.setBackground(new Color(238,43,88));
		b3.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		b3.setForeground(Color.WHITE);
		b4.setBorderPainted(false);
		b4.setBackground(new Color(238,43,88));
		b4.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,15));
		b4.setForeground(Color.WHITE);
		
		JFrame jf = new JFrame("°ø¿¬Á¾·ù ¼±ÅÃ Ã¢");
		
		JPanel p=new JPanel(new GridLayout(2,1));
		JPanel tp=new JPanel();
		JPanel up = new JPanel(new FlowLayout());
		JPanel dp = new JPanel(new GridLayout(1,4));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		
		up.setBackground(Color.WHITE);
		p1.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		p3.setBackground(Color.WHITE);
		p4.setBackground(Color.WHITE);
		
		JLabel l2 = new JLabel("¹ÂÁöÄÃ");
		JLabel l3 = new JLabel("ÄÜ¼­Æ®");
		JLabel l4 = new JLabel("ÀÌ±×Á¶ÄÜ¼­Æ®");
		JLabel s1 = new JLabel("¡Ú");
		JLabel s2 = new JLabel("¡Ú¡Ú");
		JLabel s3 = new JLabel("¡Ú¡Ú¡Ú");
		JLabel s4 = new JLabel("¡Ú¡Ú¡Ú¡Ú¡Ú");
		l2.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,20));
		l3.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,20));
		l4.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,20));
		
		s1.setFont(new Font("±¼¸²",Font.BOLD,20));
		s1.setForeground(new Color(32,32,181));
		
		s2.setFont(new Font("±¼¸²",Font.BOLD,20));
		s2.setForeground(new Color(62,221,54));
		
		s3.setFont(new Font("±¼¸²",Font.BOLD,20));
		s3.setForeground(new Color(255,139,0));
		
		s4.setFont(new Font("±¼¸²",Font.BOLD,20));
		s4.setForeground(new Color(255,0,0));
		
		JLabel ll=new JLabel("     ");
		JLabel ll1=new JLabel("     ");
		JLabel ll2=new JLabel("     ");
		JLabel ll3=new JLabel("     ");
		
		JLabel play=new JLabel();
		ImageIcon icon1 = new ImageIcon("image/play.png");
		play.setIcon(icon1);
		play.setText(null);
		play.setPreferredSize(new Dimension(200, 280));
		
		JLabel musical=new JLabel();
		ImageIcon icon2 = new ImageIcon("image/lesmisera.png");
		musical.setIcon(icon2);
		musical.setText(null);
		musical.setPreferredSize(new Dimension(200, 280));
		
		JLabel con=new JLabel();
		ImageIcon icon3 = new ImageIcon("image/blockbcon.png");
		con.setIcon(icon3);
		con.setText(null);
		con.setPreferredSize(new Dimension(200, 280));
		
		JLabel exo=new JLabel();
		ImageIcon icon4 = new ImageIcon("image/exocon.png");
		exo.setIcon(icon4);
		exo.setText(null);
		exo.setPreferredSize(new Dimension(200, 280));
		
		up.add(ll);
		up.add(play);
		up.add(ll1);
		up.add(musical);
		up.add(ll2);
		up.add(con);
		up.add(ll3);
		up.add(exo);
		dp.add(p1);
		JLabel l1 = new JLabel("¿¬±Ø");
		
		l1.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,20));
		p4.add(l1);
		GroupLayout gl_p1 = new GroupLayout(p1);
		gl_p1.setHorizontalGroup(
			gl_p1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p1.createSequentialGroup()
					.addContainerGap(125, Short.MAX_VALUE)
					.addGroup(gl_p1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_p1.createSequentialGroup()
							.addGroup(gl_p1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_p1.createSequentialGroup()
									.addGap(10)
									.addComponent(s1))
								.addComponent(l1))
							.addGap(26))
						.addGroup(Alignment.TRAILING, gl_p1.createSequentialGroup()
							.addComponent(b1)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(l1)
					.addGap(6))
		);
		gl_p1.setVerticalGroup(
			gl_p1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p1.createSequentialGroup()
					.addGroup(gl_p1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_p1.createSequentialGroup()
							.addContainerGap()
							.addComponent(l1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(b1))
						.addGroup(gl_p1.createSequentialGroup()
							.addGap(43)
							.addComponent(l1)))
					.addContainerGap(207, Short.MAX_VALUE))
		);
		p1.setLayout(gl_p1);
		dp.add(p2);
		GroupLayout gl_p2 = new GroupLayout(p2);
		gl_p2.setHorizontalGroup(
			gl_p2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_p2.createSequentialGroup()
					.addContainerGap(95, Short.MAX_VALUE)
					.addGroup(gl_p2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_p2.createSequentialGroup()
							.addGap(10)
							.addComponent(s2))
						.addComponent(b2)
						.addComponent(l2))
					.addGap(71))
		);
		gl_p2.setVerticalGroup(
			gl_p2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p2.createSequentialGroup()
					.addContainerGap()
					.addComponent(l2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s2)
					.addGap(13)
					.addComponent(b2)
					.addContainerGap(171, Short.MAX_VALUE))
		);
		p2.setLayout(gl_p2);
		dp.add(p3);
		GroupLayout gl_p3 = new GroupLayout(p3);
		gl_p3.setHorizontalGroup(
			gl_p3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_p3.createSequentialGroup()
					.addContainerGap(97, Short.MAX_VALUE)
					.addGroup(gl_p3.createParallelGroup(Alignment.LEADING)
						.addComponent(s3)
						.addComponent(b3)
						.addComponent(l3))
					.addGap(86))
		);
		gl_p3.setVerticalGroup(
			gl_p3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p3.createSequentialGroup()
					.addContainerGap()
					.addComponent(l3)
					.addGap(10)
					.addComponent(s3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(b3)
					.addContainerGap(170, Short.MAX_VALUE))
		);
		p3.setLayout(gl_p3);
		dp.add(p4);
		GroupLayout gl_p4 = new GroupLayout(p4);
		gl_p4.setHorizontalGroup(
			gl_p4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p4.createSequentialGroup()
					.addGroup(gl_p4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_p4.createSequentialGroup()
							.addGap(67)
							.addComponent(b4))
						.addGroup(gl_p4.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_p4.createParallelGroup(Alignment.LEADING)
								.addComponent(l4)
								.addGroup(gl_p4.createSequentialGroup()
									.addGap(10)
									.addComponent(s4)))))
					.addContainerGap(91, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_p4.createSequentialGroup()
					.addContainerGap(177, Short.MAX_VALUE)
					.addComponent(logo)
					.addGap(36))
		);
		gl_p4.setVerticalGroup(
			gl_p4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p4.createSequentialGroup()
					.addContainerGap()
					.addComponent(l4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s4)
					.addGap(13)
					.addComponent(b4)
					.addPreferredGap(ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
					.addComponent(logo)
					.addContainerGap())
		);
		p4.setLayout(gl_p4);
		
		p.add(up);
		p.add(dp);
		jf.getContentPane().add(p);
		
		jf.setSize(1000, 600);
		jf.setLocationRelativeTo(null);
        jf.setVisible(true); 
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        logo.addActionListener(this);
	}
	class WClass extends WindowAdapter{
		public void windowClosing(WindowEvent e) { System.exit(0); }
	}
	public static void main(String[] args) {
		new ChoiceType();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==logo){
			new m_Menu();
		}else{
			if(e.getSource()==b1)
			{
				CurrInfo.setAmount(30500);
				CurrInfo.setType("¿¬±Ø");
				CurrInfo.setSeattime(4);
				CurrInfo.setHowtime(4);
			}else if(e.getSource()==b2)
			{
				CurrInfo.setAmount(58500);
				CurrInfo.setType("¹ÂÁöÄÃ");
				CurrInfo.setSeattime(3);
				CurrInfo.setHowtime(3);
			}else if(e.getSource()==b3)
			{
				CurrInfo.setAmount(91500);
				CurrInfo.setType("ÄÜ¼­Æ®");
				CurrInfo.setSeattime(2);
				CurrInfo.setHowtime(2);
			}else if(e.getSource()==b4)
			{
				CurrInfo.setAmount(113500);
				CurrInfo.setType("ÀÌ±×Á¶ÄÜ¼­Æ®");
				CurrInfo.setSeattime(1);
				CurrInfo.setHowtime(1);
			}else if(e.getSource()==logo){
				new m_Menu();
			}
			new ChoiceDate();
		}
	}
}