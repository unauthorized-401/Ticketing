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
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class HowFail extends JPanel implements ActionListener{
	JButton bt_home=new JButton(new ImageIcon("image/bt_re.png"));
	HowFail(){
		bt_home.setBorderPainted(false);
		bt_home.setBackground(Color.WHITE);
		
		JFrame jf = new JFrame("결제 실패 창");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p = new JPanel(new GridLayout(3,1));
		
		JLabel fail=new JLabel();
		ImageIcon icon = new ImageIcon("image/t_fail.png");
		fail.setIcon(icon);
		fail.setText(null);
		
		p1.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		p3.setBackground(Color.WHITE);
		
		JLabel text = new JLabel("");
		ImageIcon icon1 = new ImageIcon("image/t_howfail.png");
		text.setIcon(icon1);
		text.setText(null);
		
		p1.add(fail);
		p3.add(bt_home);
		p.add(p1);
		p.add(p2);
		GroupLayout gl_p2 = new GroupLayout(p2);
		gl_p2.setHorizontalGroup(
			gl_p2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p2.createSequentialGroup()
					.addGap(288)
					.addComponent(text)
					.addContainerGap(663, Short.MAX_VALUE))
		);
		gl_p2.setVerticalGroup(
			gl_p2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_p2.createSequentialGroup()
					.addGap(53)
					.addComponent(text)
					.addContainerGap(125, Short.MAX_VALUE))
		);
		p2.setLayout(gl_p2);
		p.add(p3);
		jf.getContentPane().add(p);
		
		jf.setSize(1000, 600);
		jf.setLocationRelativeTo(null);
        jf.setVisible(true); 
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        bt_home.addActionListener(this);
	}
	class WClass extends WindowAdapter{
		public void windowClosing(WindowEvent e) { System.exit(0); }
	}
	public static void main(String[] args) {
		new HowFail();
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==bt_home){
			new First();
		}
	}
}