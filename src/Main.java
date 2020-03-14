import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea inputField;
	private JTextArea outputField;

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
		setBounds(100, 100, 1154, 770);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1500, 1500));
		contentPane.setSize(new Dimension(1500, 1500));
		contentPane.setPreferredSize(new Dimension(1500, 1500));
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton onClick = new JButton("Convert");
		onClick.setBorder(null);
		onClick.setForeground(Color.WHITE);
		onClick.setBackground(Color.DARK_GRAY);

		onClick.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Find sr = new Find();
				outputField.setText(sr.replaceRules(inputField.getText()));
			}

		});
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		inputField = new JTextArea();
		inputField.setForeground(Color.WHITE);
		inputField.setCaretColor(Color.WHITE);
		inputField.setBackground(Color.DARK_GRAY);
		inputField.setBorder(null);
		contentPane.add(inputField);

		outputField = new JTextArea();
		outputField.setBorder(null);
		contentPane.add(outputField);
		contentPane.add(onClick);
	}
}
