import java.awt.EventQueue;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class frame extends JFrame {
String ip;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
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
	public frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 152);
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Your IP:");
		ip = null;
		try(final DatagramSocket socket = new DatagramSocket()){
			  try {
				socket.connect(InetAddress.getByName("1.1.1.1"), 10002);
				ip = socket.getLocalAddress().getHostAddress();
				//System.out.println("IP: " + ip);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			} catch (SocketException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		lblNewLabel.setText(lblNewLabel.getText() + " " + ip);
		lblNewLabel.setBounds(10, 47, 143, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Copy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String myString = "This text will be copied into clipboard";
				StringSelection stringSelection = new StringSelection(ip);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);

			}
		});
		btnNewButton.setBounds(163, 43, 89, 23);
		getContentPane().add(btnNewButton);
	}
}
