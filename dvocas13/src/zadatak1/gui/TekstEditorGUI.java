package zadatak1.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import zadatak1.poslovna_logika.TekstDemo;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TekstEditorGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelWest;
	private JLabel lblImeFajla;
	private JTextField txtImeFajla;
	private JButton btnUcitaj;
	private JButton btnObrisi;
	private JButton btnSacuvaj;
	private JButton btnZameni;
	private JButton btnAnaliza;
	private JButton btnIzadji;
	private JTextArea textArea;
	
	private TekstDemo tekstDemo = new TekstDemo();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TekstEditorGUI frame = new TekstEditorGUI();
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
	public TekstEditorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelWest(), BorderLayout.WEST);
		contentPane.add(getTextArea(), BorderLayout.CENTER);
	}

	private JPanel getPanelWest() {
		if (panelWest == null) {
			panelWest = new JPanel();
			panelWest.setPreferredSize(new Dimension(120, 120));
			panelWest.add(getLblImeFajla());
			panelWest.add(getTxtImeFajla());
			panelWest.add(getBtnUcitaj());
			panelWest.add(getBtnObrisi());
			panelWest.add(getBtnSacuvaj());
			panelWest.add(getBtnZameni());
			panelWest.add(getBtnAnaliza());
			panelWest.add(getBtnIzadji());
		}
		return panelWest;
	}
	private JLabel getLblImeFajla() {
		if (lblImeFajla == null) {
			lblImeFajla = new JLabel("Ime fajla");
		}
		return lblImeFajla;
	}
	private JTextField getTxtImeFajla() {
		if (txtImeFajla == null) {
			txtImeFajla = new JTextField();
			txtImeFajla.setColumns(10);
		}
		return txtImeFajla;
	}
	private JButton getBtnUcitaj() {
		if (btnUcitaj == null) {
			btnUcitaj = new JButton("Ucitaj");
			btnUcitaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						textArea.setText(tekstDemo.ucitajTekst(txtImeFajla.getText()));
					} catch (IOException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Greska pri ucitvanju teksta iz fajla", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnUcitaj;
	}
	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textArea.setText(null);
				}
			});
		}
		return btnObrisi;
	}
	private JButton getBtnSacuvaj() {
		if (btnSacuvaj == null) {
			btnSacuvaj = new JButton("Sacuvaj");
			btnSacuvaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						tekstDemo.upisiTekst(txtImeFajla.getText(), textArea.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Greska pri upisivanju teksta u fajl", "Greska", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return btnSacuvaj;
	}
	private JButton getBtnZameni() {
		if (btnZameni == null) {
			btnZameni = new JButton("Zameni");
			btnZameni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ZamenaTeksta dialog = new ZamenaTeksta();
					dialog.setGlavnaForma(TekstEditorGUI.this);
					dialog.setVisible(true);
				}
			});
		}
		return btnZameni;
	}
	private JButton getBtnAnaliza() {
		if (btnAnaliza == null) {
			btnAnaliza = new JButton("Analiza");
		}
		return btnAnaliza;
	}
	private JButton getBtnIzadji() {
		if (btnIzadji == null) {
			btnIzadji = new JButton("Izadji");
		}
		return btnIzadji;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	
	public void zameniStringove(String s1, String s2) {
		String stariTekst = textArea.getText();
		textArea.setText(stariTekst.replaceAll(s1, s2));
	}
}
