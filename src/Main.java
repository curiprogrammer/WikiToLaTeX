import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField inputField;
	private JTextField outputField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Wikipedia to LaTeX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton onClick = new JButton("Convert");
		onClick.setForeground(Color.WHITE);
		onClick.setBackground(Color.DARK_GRAY);

		inputField = new JTextField();
		inputField.setColumns(10);

		outputField = new JTextField();
		outputField.setForeground(Color.WHITE);
		outputField.setBackground(Color.DARK_GRAY);
		outputField.setEditable(false);
		outputField.setColumns(10);

		onClick.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Find sr = new Find();
				String txt = inputField.getText();
				outputField.setText(sr.replaceRules(txt));
			}

		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(inputField, Alignment.LEADING).addComponent(outputField,
										Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE))
						.addContainerGap(22, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addContainerGap(181, Short.MAX_VALUE).addComponent(onClick).addGap(161)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(inputField, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(outputField, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(onClick).addGap(37)));
		contentPane.setLayout(gl_contentPane);
	}
}
