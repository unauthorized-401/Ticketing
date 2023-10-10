import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import DB.MemberDAO;

public class First extends JPanel implements ActionListener{
	JButton bt_member=new JButton(new ImageIcon("image/member.png"));
	JButton bt_nomember=new JButton(new ImageIcon("image/nomember.png"));
	
	MemberDAO mdo=new MemberDAO();
	public First(){
		bt_member.setBorderPainted(false);
		bt_member.setBackground(Color.WHITE);
		bt_nomember.setBorderPainted(false);
		bt_nomember.setBackground(Color.WHITE);
		
		JFrame jf = new JFrame("YEAH24");
		JPanel p1=new JPanel();
		JPanel p2=new JPanel(new GridLayout(5,1));
		JPanel p3=new JPanel(new GridLayout(2,1));
		
		JPanel b1=new JPanel();
		JPanel b2=new JPanel();
		
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		
		JLabel jl=new JLabel();
		ImageIcon icon = new ImageIcon("image/Logo.png");
		jl.setIcon(icon);
		jl.setText(null);
		
		p1.setBackground(Color.WHITE);
		p1.add(jl);
		b1.add(bt_member);
		b2.add(bt_nomember);
		p2.add(b1);
		p2.add(b2);
		p2.setBackground(Color.WHITE);
		p3.add(p1);
		p3.add(p2);
		jf.add(p3);
		jf.setVisible(true);
		jf.setSize(1000, 600);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		bt_member.addActionListener(this);
		bt_nomember.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new First();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==bt_member)
		{
			new m_Menu();
			CurrInfo.setChmem(true);
		}else if(ae.getSource()==bt_nomember){
			new ChoiceType();
			CurrInfo.setChmem(false);
		}
	}
}
