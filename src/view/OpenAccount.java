package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import controller.AccountController;
import domain.*;

public class OpenAccount extends JFrame{
	private static final long serialVersionUID = 1L;
	JLabel topLab, idLab,passLab, nameLab;
	JTextField idTxt, passTxt, nameTxt;
	JButton addBtn;
	JPanel bottomPan, centerPan, idPan, passPan, 
		namePan;
	JComboBox<?> combo;
	String[] menu = {"일반 계좌 생성","마이너스 계좌 생성"};
	public OpenAccount() {
		makeGui(); //화면구성
		this.setSize(400, 300);
		this.setVisible(true);
	}
	
	public void makeGui() {
		topLab = new JLabel("계좌생성", JLabel.CENTER);
		
		combo = new JComboBox<>(menu);
		idLab = new JLabel("I D : ", JLabel.CENTER);
		idTxt = new JTextField(15);
		idPan = new JPanel();
		idPan.add(idLab);
		idPan.add(idTxt);
		
		passLab = new JLabel("비밀번호 : ");
		passTxt = new JTextField(15);
		passPan = new JPanel();
		passPan.add(passLab);
		passPan.add(passTxt);

		nameLab = new JLabel("이 름 : ");
		nameTxt = new JTextField(15);
		namePan = new JPanel();
		namePan.add(nameLab);
		namePan.add(nameTxt);
		
				centerPan = new JPanel();
		centerPan.setLayout(new GridLayout(8, 1));
		centerPan.add(combo);
		centerPan.add(idPan);
		centerPan.add(passPan);
		centerPan.add(namePan);
		
		addBtn = new JButton("추가");
		
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AccountBean member = new AccountBean();
				member.setUid(idTxt.getText());
				member.setName(nameTxt.getText());
				member.setPass(passTxt.getText());
							
				if(((String) combo.getSelectedItem()).equals(menu[0])) {
					AccountController.getInstance().account( member);
				}else {
					//new AdminServiceImpl().createStaff( member);
				}
			}
		});
		

		bottomPan = new JPanel();
		bottomPan.add(addBtn);
		
		add(topLab, "North");
		add(centerPan, "Center");
		add(bottomPan, "South");
	}
}
