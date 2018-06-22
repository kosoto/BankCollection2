package view;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CreateCombeBox {
	JPanel centerPan;
	JComboBox<?> combo;
	String[] menu = {"사용자 등록","직원 추가"};
	public void create() {
		centerPan = new JPanel();
		combo = new JComboBox<>(menu);
		//centerPan = new JPanel();
		centerPan.add(combo);
	}

}
