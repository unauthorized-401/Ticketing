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
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import DB.Member;
import DB.MemberDAO;

public class Find extends JPanel implements ActionListener{
	JTextField tf_name = new JTextField(10);
	JTextField tf_phone = new JTextField(10);
	JButton b_check = new JButton(new ImageIcon("image/bt_fcheck.png"));
	public Find(){
		b_check.setBorderPainted(false);
		b_check.setBackground(Color.WHITE);
		
		JFrame jf = new JFrame("아이디 비밀번호 찾기 창");
		
		JPanel up = new JPanel(new GridLayout(3,3));
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel(new GridLayout(6, 1));
		JPanel p6 = new JPanel(new GridLayout(2,1));
		
		JPanel p_2 = new JPanel();
		JPanel p_3 = new JPanel();
		JPanel p_4 = new JPanel();
		JPanel p_5 = new JPanel();
		JPanel p_6 = new JPanel();
		JPanel p_7 = new JPanel();
		
		up.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		p3.setBackground(Color.WHITE);
		p4.setBackground(Color.WHITE);
		p5.setBackground(Color.WHITE);
		p6.setBackground(Color.WHITE);
		p_2.setBackground(Color.WHITE);
		p_3.setBackground(Color.WHITE);
		p_4.setBackground(Color.WHITE);
		p_5.setBackground(Color.WHITE);
		p_6.setBackground(Color.WHITE);
		p_7.setBackground(Color.WHITE);
		
		JLabel lb_name = new JLabel("이름 ");
		JLabel lb_phone = new JLabel("전화번호 ");
		
		lb_name.setFont(new Font("맑은 고딕",Font.BOLD,14));
		lb_name.setForeground(new Color(104,104,104));
		lb_phone.setFont(new Font("맑은 고딕",Font.BOLD,14));
		lb_phone.setForeground(new Color(104,104,104));
		
		JLabel jl=new JLabel();
		ImageIcon icon = new ImageIcon("image/small_Logo.png");
		jl.setIcon(icon);
		jl.setText(null);
		
		JLabel j2=new JLabel();
		ImageIcon icon2 = new ImageIcon("image/t_find.png");
		j2.setIcon(icon2);
		j2.setText(null);
		
		up.add(jl);
		up.add(p_2);
		up.add(p_3);
		up.add(p_4);
		up.add(p_5);
		up.add(p_6);
		up.add(p_7);
		up.add(j2);
		p2.add(lb_name);
		p2.add(tf_name);
		p3.add(lb_phone);
		p3.add(tf_phone);
		p4.add(b_check);
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);
		p6.add(up);
		p6.add(p5);
		p5.setBorder(new TitledBorder(""));
		jf.add(p6);
		
		jf.setSize(1000, 600);
		jf.setLocationRelativeTo(null);
        jf.setVisible(true); 
        b_check.addActionListener(this);
	}
	class WClass extends WindowAdapter{
		public void windowClosing(WindowEvent e) { System.exit(0); }
	}
	public static void main(String[] args) {
		new Find();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s_id="", s_pwd="";
		char[] id, pwd;
		if(e.getSource()==b_check)
		{
			String str_name=tf_name.getText();
			String str_phone=tf_phone.getText();
			
			Member mb=new Member();
			MemberDAO mdao=new MemberDAO();
			
			boolean check=true;
			
			check=mdao.FindIdPwd(str_name, str_phone);
			
			if(check==true)
			{
				mb=mdao.getMemberIdPwd(str_name, str_phone);
		
				id = mb.getId().toCharArray();
				pwd = mb.getPwd().toCharArray();
				
				for(int i = id.length / 2; i < id.length; i++) id[i] = '*';
				for(int i = pwd.length / 2; i < pwd.length; i++) pwd[i] = '*';
				
				for(int i=0;i<id.length;i++)
				{
					s_id+=id[i];
				}
				for(int i=0;i<pwd.length;i++)
				{
					s_pwd+=pwd[i];
				}
				
				JOptionPane.showMessageDialog(this, "아이디 : "+s_id+"\n비밀번호 : "+s_pwd);
			}else{
				JOptionPane.showMessageDialog(this, "입력하신 정보의 계정이 없습니다.");
			}
		}
	}
}