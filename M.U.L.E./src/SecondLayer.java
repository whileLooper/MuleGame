import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;


public class SecondLayer extends JPanel{
	JPanel second = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	
	public  SecondLayer(){
		setLayout(null);
		
		JLabel lblPlayer = new JLabel("Player#");
		lblPlayer.setBounds(109, 48, 38, 14);
		add(lblPlayer);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(280, 88, 86, 14);
		add(lblName);
		
		JLabel lblRace = new JLabel("Race");
		lblRace.setBounds(429, 88, 67, 14);
		add(lblRace);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(569, 88, 61, 14);
		add(lblColor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(429, 110, 67, 20);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(569, 110, 61, 20);
		add(comboBox_1);
		
		JButton btnNewButton = new JButton("NEXT\u2192");
		btnNewButton.setBounds(687, 109, 117, 41);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(90, 85, 137, 188);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(280, 110, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		second.setBounds(0, 0, 905, 688);
		second.setLayout(new FormLayout(new ColumnSpec[] {},
			new RowSpec[] {}));
		
	}
}
