package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Sample1 extends JFrame{
	public Sample1(String title) {
		super(title);
		setSize(500, 500);
		setLocation(300, 300);
		this.setLayout(new BorderLayout(10,10));
		JPanel pan1 = new JPanel();
		pan1.setSize(500, 100);
		pan1.setBackground(Color.yellow);
		this.add(pan1,BorderLayout.NORTH);
		setVisible(true);
		
		
	/*	JButton btn1 = new JButton("일반계좌개설");
		pan1.add(btn1);*/
		
	/*	JLabel lab1 = new JLabel("관리자화면");
		JLabel lab2 = new JLabel("회원관리");
		JLabel lab3 = new JLabel("계좌관리");
		lab2.setBounds(10, 30, 150, 20);
		lab3.setBounds(10, 40, 150, 20);*/
	/*	pan1.add(lab1);
		pan1.add(lab2);
		pan1.add(lab3);*/
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public static void main(String[] args) {
		new Sample1("샘플");
	}
}
