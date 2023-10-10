import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import DB.Member;
import DB.MemberDAO;

public class List extends JPanel implements ActionListener{
	JButton bt_home=new JButton(new ImageIcon("image/xsmall_logo.png"));
	
	Member mb=new Member();
	MemberDAO mdo=new MemberDAO();
	List(){
		mb=mdo.getMember(CurrInfo.getCurrId());
		
		JFrame jf = new JFrame("¿¹¸Å ³»¿ª");
		
			if(mb.getBank()==null){
				JOptionPane.showMessageDialog(this, "¿¹¸Å³»¿ªÀÌ ¾ø½À´Ï´Ù!");
			}else{
				bt_home.setBorderPainted(false);
				bt_home.setBackground(Color.WHITE);
				
				//JPanel u_p=new JPanel();
				JPanel p1=new JPanel();
				JPanel p2=new JPanel();
				JPanel p3=new JPanel();
				JPanel p4=new JPanel();
				JPanel p5=new JPanel();
				JPanel p6=new JPanel();
				JPanel p7=new JPanel();
				JPanel gri_p=new JPanel(new GridLayout(9,1));
				JPanel b_p=new JPanel();
				JPanel b_p1=new JPanel();
				
				b_p.setBackground(Color.WHITE);
				p1.setBackground(Color.WHITE);
				p2.setBackground(Color.WHITE);
				p3.setBackground(Color.WHITE);
				p4.setBackground(Color.WHITE);
				p5.setBackground(Color.WHITE);
				p6.setBackground(Color.WHITE);
				p7.setBackground(Color.WHITE);
				b_p1.setBackground(Color.WHITE);
				
				JLabel list=new JLabel();
				ImageIcon icon = new ImageIcon("image/t_list.png");
				list.setIcon(icon);
				list.setText(null);
				
				JLabel l_name=new JLabel("¿¹¸ÅÀÚ : ");
				JLabel l_call=new JLabel("ÀüÈ­¹øÈ£ : ");
				JLabel l_showtype=new JLabel("°ø¿¬ ÀÌ¸§ : ");
				JLabel l_month=new JLabel("¿ù");
				JLabel l_day=new JLabel("ÀÏ");
				JLabel l_inning=new JLabel("È¸");
				JLabel l_area=new JLabel("±¸¿ª");
				JLabel l_seatnum=new JLabel("¹ø");
				JLabel l_payment=new JLabel("°áÁ¦¹æ½Ä : ");
				JLabel l_bank=new JLabel(", ");
				JLabel l_amount=new JLabel("¿ø");
				JLabel name=new JLabel(mb.getName());
				JLabel call=new JLabel(mb.getTel());
				JLabel showtype=new JLabel(mb.getShowtype());
				JLabel month=new JLabel(Integer.toString(mb.getMonth()));
				JLabel day=new JLabel(Integer.toString(mb.getDay()));
				JLabel inning=new JLabel(Integer.toString(mb.getInning()));
				JLabel area=new JLabel(mb.getArea());
				JLabel seatnum=new JLabel(Integer.toString(mb.getSeatnum()));
				JLabel payment=new JLabel(mb.getPayment());
				JLabel bank=new JLabel(mb.getBank());
				JLabel amount=new JLabel(Integer.toString(mb.getAmount()));
				
				l_name.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				l_call.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				l_showtype.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				l_month.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				l_day.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				l_inning.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				l_area.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				l_seatnum.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				l_payment.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				l_bank.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				l_amount.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				name.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				call.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				showtype.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				month.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				day.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				inning.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				area.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				seatnum.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				payment.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				bank.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				amount.setFont(new Font("¸¼Àº °íµñ",Font.BOLD,16));
				
				jf.setSize(1000, 600);
				jf.setLocationRelativeTo(null);
		        jf.setVisible(true);
		        gri_p.add(b_p);
		        GroupLayout gl_b_p = new GroupLayout(b_p);
		        gl_b_p.setHorizontalGroup(
		        	gl_b_p.createParallelGroup(Alignment.LEADING)
		        		.addGroup(gl_b_p.createSequentialGroup()
		        			.addGap(21)
		        			.addComponent(list)
		        			.addContainerGap(930, Short.MAX_VALUE))
		        );
		        gl_b_p.setVerticalGroup(
		        	gl_b_p.createParallelGroup(Alignment.LEADING)
		        		.addGroup(gl_b_p.createSequentialGroup()
		        			.addContainerGap()
		        			.addComponent(list)
		        			.addContainerGap(43, Short.MAX_VALUE))
		        );
		        b_p.setLayout(gl_b_p);
		        p1.add(l_name);
		        p1.add(name);
		        p2.add(l_call);
		        p2.add(call);
		        p3.add(l_showtype);
		        p3.add(showtype);
		        p4.add(month);
		        p4.add(l_month);
		        p4.add(day);
		        p4.add(l_day);
		        p4.add(inning);
		        p4.add(l_inning);
		        p5.add(area);
		        p5.add(l_area);
		        p5.add(seatnum);
		        p5.add(l_seatnum);
		        p6.add(l_payment);
		        p6.add(payment);
		        p6.add(l_bank);
		        p6.add(bank);
		        p7.add(amount);
		        p7.add(l_amount);
		        gri_p.add(p1);
		        gri_p.add(p2);
		        gri_p.add(p3);
		        gri_p.add(p4);
		        gri_p.add(p5);
		        gri_p.add(p6);
		        gri_p.add(p7);
		        gri_p.add(b_p1);
		        GroupLayout gl_b_p1 = new GroupLayout(b_p1);
		        gl_b_p1.setHorizontalGroup(
		        	gl_b_p1.createParallelGroup(Alignment.LEADING)
		        		.addGroup(Alignment.TRAILING, gl_b_p1.createSequentialGroup()
		        			.addContainerGap(922, Short.MAX_VALUE)
		        			.addComponent(bt_home)
		        			.addGap(29))
		        );
		        gl_b_p1.setVerticalGroup(
		        	gl_b_p1.createParallelGroup(Alignment.LEADING)
		        		.addGroup(gl_b_p1.createSequentialGroup()
		        			.addComponent(bt_home)
		        			.addContainerGap(53, Short.MAX_VALUE))
		        );
		        b_p1.setLayout(gl_b_p1);
		        //p.add(u_p);
		        //p.add(gri_p);
		        jf.getContentPane().add(gri_p);
		        bt_home.addActionListener(this);
			}
	}
	class WClass extends WindowAdapter{
		public void windowClosing(WindowEvent e) { System.exit(0); }
	}
	public static void main(String[] args) {
		new List();
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==bt_home){
			new m_Menu();
		}
	}
}