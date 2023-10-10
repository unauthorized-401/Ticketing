import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import DB.MemberDAO;

public class m_Menu extends JPanel implements ActionListener{
	JButton bt_login=new JButton(new ImageIcon("image/login.png"));
	JButton bt_check=new JButton(new ImageIcon("image/check.png"));
	JButton bt_withdraw=new JButton(new ImageIcon("image/withdraw.png"));
	JButton bt_cancel=new JButton(new ImageIcon("image/cancel.png"));
	JButton bt_logout=new JButton(new ImageIcon("image/logout.png"));
	
	MemberDAO mdo=new MemberDAO();
	public m_Menu(){
		bt_login.setBorderPainted(false);
		bt_login.setBackground(Color.WHITE);
		bt_check.setBorderPainted(false);
		bt_check.setBackground(Color.WHITE);
		bt_withdraw.setBorderPainted(false);
		bt_withdraw.setBackground(Color.WHITE);
		bt_cancel.setBorderPainted(false);
		bt_cancel.setBackground(Color.WHITE);
		bt_logout.setBorderPainted(false);
		bt_logout.setBackground(Color.WHITE);
		
		JFrame jf = new JFrame("YEAH24_m");
		JPanel p1=new JPanel();
		JPanel p2=new JPanel(new GridLayout(6,1));
		JPanel p3=new JPanel(new GridLayout(2,1));
		
		JPanel b1=new JPanel();
		JPanel b2=new JPanel();
		JPanel b3=new JPanel();
		JPanel b4=new JPanel();
		JPanel b5=new JPanel();
		
		b1.setBackground(Color.WHITE);
		b2.setBackground(Color.WHITE);
		b3.setBackground(Color.WHITE);
		b4.setBackground(Color.WHITE);
		b5.setBackground(Color.WHITE);
		
		JLabel jl=new JLabel();
		ImageIcon icon = new ImageIcon("image/Logo.png");
		jl.setIcon(icon);
		jl.setText(null);
		
		p1.setBackground(Color.WHITE);
		p1.add(jl);
		b1.add(bt_login);
		b2.add(bt_check);
		b3.add(bt_cancel);
		b4.add(bt_logout);
		b5.add(bt_withdraw);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.setBackground(Color.WHITE);
		p3.add(p1);
		p3.add(p2);
		jf.add(p3);
		jf.setVisible(true);
		jf.setSize(1000, 600);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		bt_login.addActionListener(this);
		bt_check.addActionListener(this);
		bt_cancel.addActionListener(this);
		bt_logout.addActionListener(this);
		bt_withdraw.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new m_Menu();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==bt_login)
		{
			if(!mdo.FindBook(CurrInfo.getCurrId())&&CurrInfo.getCurrId().equals(""))
			{
				new Login();
			}else if(mdo.FindBook(CurrInfo.getCurrId())){
				JOptionPane.showMessageDialog(this, "1인 1매 예매가능합니다!");
			}else if(!CurrInfo.getCurrId().equals(""))
			{
				new ChoiceType();
			}
		}else if(ae.getSource()==bt_check)
		{
			if(CurrInfo.getCurrId().equals(""))
			{
				JOptionPane.showMessageDialog(this, "로그인 한 뒤 이용가능합니다!");
				new Login();
			}else{
				new List();
			}
		}else if(ae.getSource()==bt_cancel){
			if(CurrInfo.getCurrId().equals("")){
				JOptionPane.showMessageDialog(this, "로그인 한 뒤 이용가능합니다!");
				new Login();
			}else{
				if(!mdo.FindBook(CurrInfo.getCurrId())){
					JOptionPane.showMessageDialog(this, "예매내역이 없습니다!");
				}else{
					 int x = JOptionPane.showConfirmDialog(this,"정말 취소하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
			           
			            if (x == JOptionPane.OK_OPTION){
			                mdo.BookCancel(CurrInfo.getCurrId());
			                CurrInfo.setAmount(0);
			                CurrInfo.setArea("");
			                CurrInfo.setBank("");
			                CurrInfo.setDay(0);
			                CurrInfo.setHowtime(0);
			                CurrInfo.setInning(0);
			                CurrInfo.setMonth(0);
			                CurrInfo.setPayment("");
			                CurrInfo.setSeatnum(0);
			                CurrInfo.setSeattime(0);
			                CurrInfo.setType("");
			            }else{
			                JOptionPane.showMessageDialog(this, "예매취소를 취소하였습니다.");
			            }
				}
			}
		}else if(ae.getSource()==bt_logout){
			if(CurrInfo.getCurrId().equals(""))
			{
				JOptionPane.showMessageDialog(this, "로그인상태가 아닙니다!");
			}else{
				 int x = JOptionPane.showConfirmDialog(this,"로그아웃 하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
		           
		            if (x == JOptionPane.OK_OPTION){
		                CurrInfo.setAmount(0);
		                CurrInfo.setArea("");
		                CurrInfo.setBank("");
		                CurrInfo.setCurrId("");
		                CurrInfo.setDay(0);
		                CurrInfo.setHowtime(0);
		                CurrInfo.setInning(0);
		                CurrInfo.setMonth(0);
		                CurrInfo.setPayment("");
		                CurrInfo.setPwd("");
		                CurrInfo.setSeatnum(0);
		                CurrInfo.setSeattime(0);
		                CurrInfo.setType("");
		            }else{
		                JOptionPane.showMessageDialog(this, "로그아웃을 취소하였습니다.");
		            }
			}
		}else if(ae.getSource()==bt_withdraw)
		{
			if(CurrInfo.getCurrId().equals(""))
			{
				JOptionPane.showMessageDialog(this, "로그인 한 뒤 이용가능합니다!");
				new Login();
			}else{
				 int x = JOptionPane.showConfirmDialog(this,"정말 탈퇴하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
		           
		            if (x == JOptionPane.OK_OPTION){
		                mdo.deleteMember(CurrInfo.getCurrId(),CurrInfo.getPwd());
		                CurrInfo.setAmount(0);
		                CurrInfo.setArea("");
		                CurrInfo.setBank("");
		                CurrInfo.setCurrId("");
		                CurrInfo.setDay(0);
		                CurrInfo.setHowtime(0);
		                CurrInfo.setInning(0);
		                CurrInfo.setMonth(0);
		                CurrInfo.setPayment("");
		                CurrInfo.setPwd("");
		                CurrInfo.setSeatnum(0);
		                CurrInfo.setSeattime(0);
		                CurrInfo.setType("");
		            }else{
		                JOptionPane.showMessageDialog(this, "탈퇴를 취소하였습니다.");
		            }
			}
		}
	}

}
