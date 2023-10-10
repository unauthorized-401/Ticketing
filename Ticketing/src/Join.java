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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import DB.Member;
import DB.MemberDAO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Join extends JPanel implements ActionListener{
	Member mb=new Member();
	MemberDAO mdao=new MemberDAO();
	
	String str_name=null;
	String str_id=null;
	String str_pwd=null;
	String str_tel=null;
	
	JFrame jf = new JFrame("회원가입 창");
	JLabel lb_name = new JLabel("이름 ");
	JLabel lb_id = new JLabel("아이디 ");
	JLabel lb_pw = new JLabel("비밀번호 ");
	JLabel lb_phone = new JLabel("전화번호 ");
	JTextField tf_name = new JTextField(20);
	JTextField tf_id = new JTextField(20);
	JPasswordField tf_pw = new JPasswordField(20);
	JTextField tf_phone = new JTextField(20);
	JButton b_check = new JButton("중복확인");
	JButton b_join = new JButton("가  입");
	public Join() {
		lb_name.setForeground(new Color(104,104,104));
		lb_name.setFont(new Font("맑은 고딕",Font.BOLD,14));
		lb_id.setForeground(new Color(104,104,104));
		lb_id.setFont(new Font("맑은 고딕",Font.BOLD,14));
		lb_pw.setForeground(new Color(104,104,104));
		lb_pw.setFont(new Font("맑은 고딕",Font.BOLD,14));
		lb_phone.setForeground(new Color(104,104,104));
		lb_phone.setFont(new Font("맑은 고딕",Font.BOLD,14));
		
		b_check.setBorderPainted(false);
		b_check.setBackground(new Color(247,105,176));
		b_check.setFont(new Font("맑은 고딕",Font.BOLD,14));
		b_check.setForeground(Color.WHITE);
		b_join.setBorderPainted(false);
		b_join.setForeground(Color.WHITE);
		b_join.setFont(new Font("맑은 고딕",Font.BOLD,14));
		b_join.setBackground(new Color(109,97,198));
		
		JPanel u_p = new JPanel();
		JPanel p = new JPanel();
		JPanel p_1 = new JPanel();
		JPanel p_3 = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JPanel p6 = new JPanel(new GridLayout(5, 1));
		JPanel p7 = new JPanel(new GridLayout(2, 1));
		
		JPanel d_p = new JPanel(new GridLayout(1, 3));
		
		p.setBackground(Color.WHITE);
		p_1.setBackground(Color.WHITE);
		p_3.setBackground(Color.WHITE);
		p1.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		p3.setBackground(Color.WHITE);
		p4.setBackground(Color.WHITE);
		p5.setBackground(Color.WHITE);
		u_p.setBackground(Color.WHITE);
		
		JLabel jl=new JLabel();
		ImageIcon icon = new ImageIcon("image/small_Logo.png");
		jl.setIcon(icon);
		jl.setText(null);
		
		JLabel j2=new JLabel();
		ImageIcon icon2 = new ImageIcon("image/t_join.png");
		j2.setIcon(icon2);
		j2.setText(null);
		p1.add(lb_name);
		p1.add(tf_name);
		p2.add(lb_id);
		p2.add(tf_id);
		p3.add(lb_pw);
		p3.add(tf_pw);
		p4.add(lb_phone);
		p4.add(tf_phone);
		p5.add(b_check);
		p5.add(b_join);
		p6.add(p1);
		p6.add(p2);
		p6.add(p3);
		p6.add(p4);
		p6.add(p5);
		d_p.add(p6);
		d_p.setBorder(new TitledBorder(""));
		p7.add(u_p);
		GroupLayout gl_u_p = new GroupLayout(u_p);
		gl_u_p.setHorizontalGroup(
			gl_u_p.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_u_p.createSequentialGroup()
					.addGroup(gl_u_p.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_u_p.createSequentialGroup()
							.addGap(21)
							.addComponent(jl))
						.addGroup(gl_u_p.createSequentialGroup()
							.addGap(321)
							.addComponent(j2)))
					.addContainerGap(630, Short.MAX_VALUE))
		);
		gl_u_p.setVerticalGroup(
			gl_u_p.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_u_p.createSequentialGroup()
					.addContainerGap()
					.addComponent(jl)
					.addPreferredGap(ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
					.addComponent(j2))
		);
		u_p.setLayout(gl_u_p);
		p7.add(d_p);
		jf.getContentPane().add(p7);
		
		jf.setSize(1000, 600);
		jf.setLocationRelativeTo(null);
        jf.setVisible(true); 

        b_check.addActionListener(this);
        b_join.addActionListener(this);
	}
	class WClass extends WindowAdapter{
		public void windowClosing(WindowEvent e) { System.exit(0); }
	}
	public static void main(String[] args) {
		new Join();
	}
	public void getData(){
		mb.setName(str_name);
		mb.setId(str_id);
		mb.setPwd(str_pwd);
		mb.setTel(str_tel);
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean checkId;
		
		str_name=tf_name.getText();
		str_id=tf_id.getText();
		str_pwd=tf_pw.getText();
		str_tel=tf_phone.getText();
		
		if(e.getSource()==b_join){
			try{
				checkId=mdao.CheckId(str_id);
				
				if(str_name.equals(""))throw new NameException();
				else if(str_id.equals(""))throw new IdException();
				else if(str_pwd.equals(""))throw new PwdException();
				else if(str_tel.equals(""))throw new TelException();
				else if(checkId) throw new ExistException();
				
				getData();
				mdao.insertMember(mb);
				JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");
				jf.dispose();
				
			}catch(NameException e2){
				JOptionPane.showMessageDialog(this, "이름을 입력해주세요!");
			}catch(IdException e1){
				JOptionPane.showMessageDialog(this, "아이디를 입력해주세요!");
			}catch(PwdException e1){
				JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요!");
			}catch(TelException e1){
				JOptionPane.showMessageDialog(this, "전화번호를 입력해주세요!");
			}catch(ExistException e1){
				JOptionPane.showMessageDialog(this, "해당 아이디가 존재합니다!");
			}
			
		}else if(e.getSource()==b_check)
		{
			try{
				checkId=mdao.CheckId(str_id);
				if(str_id.equals("")){
					throw new IdException();
				}else if(checkId){
					JOptionPane.showMessageDialog(this, "해당 아이디가 존재합니다!");
				}else{
					JOptionPane.showMessageDialog(this, "사용가능한 아이디입니다.");
				}
			}catch(IdException e1){
				JOptionPane.showMessageDialog(this, "아이디를 입력해주세요!");
			}
		}
	}
}
class NameException extends Exception{
	public NameException(){
	}
}
class IdException extends Exception{
	public IdException(){
	}
}
class PwdException extends Exception{
	public PwdException(){
	}
}
class TelException extends Exception{
	public TelException(){
	}
}
class ExistException extends Exception{
	public ExistException(){
	}
}