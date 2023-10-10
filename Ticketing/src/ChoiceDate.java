import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import DB.MemberDAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

public class ChoiceDate extends JPanel implements ActionListener{
	JButton b_next = new JButton(new ImageIcon("image/bt_dcheck.png"));
	Choice ch_month,ch_day,ch_inning;
	
	JButton logo=new JButton(new ImageIcon("image/xsmall_logo.png"));
	ChoiceDate(){
		logo.setBorderPainted(false);
		logo.setBackground(Color.WHITE);
		
		b_next.setBorderPainted(false);
		b_next.setBackground(Color.WHITE);
		
		JFrame jf = new JFrame("������, ȸ�� ����â");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel dp = new JPanel(new GridLayout(5,1));
		JPanel up = new JPanel();
		JPanel p=new JPanel(new GridLayout(2,1));
		
		p1.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		up.setBackground(Color.WHITE);
		dp.setBackground(Color.WHITE);
		
		ch_month = new Choice();
		ch_day = new Choice();
		ch_inning = new Choice();
		
		if(CurrInfo.getType().equals("����")){
			for(int i = 11; i <= 11; i++) ch_month.addItem(Integer.toString(i));
			for(int i = 5; i <= 6; i++) ch_day.addItem(Integer.toString(i));
			for(int i = 1; i <= 2; i++) ch_inning.addItem(Integer.toString(i));
		}else if(CurrInfo.getType().equals("������")){
			for(int i = 10; i <= 11; i++) ch_month.addItem(Integer.toString(i));
			for(int i = 3; i <= 6; i++) ch_day.addItem(Integer.toString(i));
			for(int i = 1; i <= 2; i++) ch_inning.addItem(Integer.toString(i));
		}else if(CurrInfo.getType().equals("�ܼ�Ʈ")){
			for(int i = 4; i <= 4; i++) ch_month.addItem(Integer.toString(i));
			for(int i = 2; i <= 3; i++) ch_day.addItem(Integer.toString(i));
			for(int i = 1; i <= 2; i++) ch_inning.addItem(Integer.toString(i));
		}else if(CurrInfo.getType().equals("�̱����ܼ�Ʈ")){
			for(int i = 3; i <= 3; i++) ch_month.addItem(Integer.toString(i));
			for(int i = 18; i <= 20; i++) ch_day.addItem(Integer.toString(i));
			for(int i = 1; i <= 1; i++) ch_inning.addItem(Integer.toString(i));
		}
		
		JLabel lb_month = new JLabel("��");
		JLabel lb_day = new JLabel("��");
		JLabel lb_episode = new JLabel("ȸ");
		
		lb_month.setFont(new Font("���� ����",Font.PLAIN,16));
		lb_day.setFont(new Font("���� ����",Font.PLAIN,16));
		lb_episode.setFont(new Font("���� ����",Font.PLAIN,16));
		
		JLabel l1=new JLabel("     ");
		JLabel l2=new JLabel("     ");
		
		JLabel title=new JLabel();
		ImageIcon icon = new ImageIcon("image/t_chdate.png");
		title.setIcon(icon);
		title.setText(null);
		
		p1.add(ch_month);
		p1.add(lb_month);
		p1.add(l1);
		p1.add(ch_day);
		p1.add(lb_day);
		p1.add(l2);
		p1.add(ch_inning);
		p1.add(lb_episode);
		p2.add(b_next);
		dp.add(p1);
		dp.add(p2);
		dp.setBorder(new TitledBorder(""));
		p.add(up);
		GroupLayout gl_up = new GroupLayout(up);
		gl_up.setHorizontalGroup(
			gl_up.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_up.createSequentialGroup()
					.addGroup(gl_up.createParallelGroup(Alignment.LEADING)
						.addComponent(logo)
						.addGroup(gl_up.createSequentialGroup()
							.addGap(368)
							.addComponent(title)))
					.addContainerGap(583, Short.MAX_VALUE))
		);
		gl_up.setVerticalGroup(
			gl_up.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_up.createSequentialGroup()
					.addComponent(logo)
					.addPreferredGap(ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
					.addComponent(title))
		);
		up.setLayout(gl_up);
		p.add(dp);
		jf.getContentPane().add(p);
		
		jf.setSize(1000, 600);
		jf.setLocationRelativeTo(null);
        jf.setVisible(true); 
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        b_next.addActionListener(this);
        logo.addActionListener(this);
	}
	class WClass extends WindowAdapter{
		public void windowClosing(WindowEvent e) { System.exit(0); }
	}
	public static void main(String[] args) {
		new ChoiceDate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CurrInfo.setMonth(Integer.parseInt(ch_month.getSelectedItem()));
		CurrInfo.setDay(Integer.parseInt(ch_day.getSelectedItem()));
		CurrInfo.setInning(Integer.parseInt(ch_inning.getSelectedItem()));
		
		if(e.getSource()==b_next)
		{
			new Seat();
		}else if(e.getSource()==logo){
			new m_Menu();
		}
	}
}