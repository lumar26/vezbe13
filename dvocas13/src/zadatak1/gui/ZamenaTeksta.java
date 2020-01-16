package zadatak1.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZamenaTeksta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblZamenjen;
	private JLabel lblZamena;
	private JTextField txtZamenjen;
	private JTextField txtZamena;
	
	private TekstEditorGUI glavnaForma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ZamenaTeksta dialog = new ZamenaTeksta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ZamenaTeksta() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblZamenjen());
		contentPanel.add(getLblZamena());
		contentPanel.add(getTxtZamenjen());
		contentPanel.add(getTxtZamena());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String zamenjen = txtZamenjen.getText();
						String zamena = txtZamena.getText();
						glavnaForma.zameniStringove(zamenjen,  zamena);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public TekstEditorGUI getGlavnaForma() {
		return glavnaForma;
	}

	public void setGlavnaForma(TekstEditorGUI glavnaForma) {
		this.glavnaForma = glavnaForma;
	}

	private JLabel getLblZamenjen() {
		if (lblZamenjen == null) {
			lblZamenjen = new JLabel("String koji se menja");
			lblZamenjen.setBounds(46, 60, 137, 16);
		}
		return lblZamenjen;
	}
	private JLabel getLblZamena() {
		if (lblZamena == null) {
			lblZamena = new JLabel("String kojim se menja");
			lblZamena.setBounds(46, 102, 137, 16);
		}
		return lblZamena;
	}
	private JTextField getTxtZamenjen() {
		if (txtZamenjen == null) {
			txtZamenjen = new JTextField();
			txtZamenjen.setBounds(195, 57, 185, 22);
			txtZamenjen.setColumns(10);
		}
		return txtZamenjen;
	}
	private JTextField getTxtZamena() {
		if (txtZamena == null) {
			txtZamena = new JTextField();
			txtZamena.setColumns(10);
			txtZamena.setBounds(195, 99, 185, 22);
		}
		return txtZamena;
	}
}
