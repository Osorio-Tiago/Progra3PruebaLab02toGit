package javaMVCViews;
import javaMVCControllers.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private javax.swing.JLabel intentosLabel;
    private final LoginController logController;
    private final NotepadController noteController;
    private int intentos;
    private JPasswordField passwordIn;
    private JTextField usernameIn;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		
		  this.intentos = 3;
		  this.logController = new LoginController();
	      this.noteController = new NotepadController();
		
		setTitle("Login Window");
		setResizable(false);
	   
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		passwordIn = new JPasswordField();
		passwordIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			        Character key= e.getKeyChar();
			        if(key.equals('\n'))
			        {
			            checkLogin();
			        }
			}
		});
		passwordIn.setToolTipText("");
		passwordIn.setBounds(28, 268, 197, 32);
		panel.add(passwordIn);
		
		usernameIn = new JTextField();
		usernameIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			        Character key= e.getKeyChar();
			        if(key.equals('\n'))
			        {
			            checkLogin();
			        }
			    }
			}
		);
		usernameIn.setName("Username");
		usernameIn.setToolTipText("");
		usernameIn.setBounds(28, 169, 197, 32);
		panel.add(usernameIn);
		usernameIn.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usernameLabel.setBounds(28, 123, 126, 26);
		panel.add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordLabel.setBounds(28, 222, 126, 26);
		panel.add(passwordLabel);
		
		JButton jLoginButton = new JButton();
		jLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			checkLogin();	
			}
		});
		jLoginButton.setText("Login");
		jLoginButton.setBounds(97, 336, 83, 32);
		panel.add(jLoginButton);
		
		
		
		  intentosLabel = new javax.swing.JLabel();
		intentosLabel.setBounds(161, 418, 141, 25);
		panel.add(intentosLabel);
		
		intentosLabel.setText("Remaining attempts: " + this.intentos);
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.WHITE);
		panel_1.setPreferredSize(new Dimension(350, 350));
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(null);
		
         
		JTextPane robotPana = new JTextPane();
	    robotPana.setBackground(Color.WHITE);
		robotPana.setForeground(new Color(0, 0, 0));
		robotPana.setBorder(null);
		robotPana.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		robotPana.setEditable(false);
		robotPana.setText("                  __\r\n   _(  \\      |@@|\r\n  (__ / \\ __ \\--/  __\r\n       \\___|  ---- |   |    __\r\n              \\  }{  /\\ )_  /  _ \\\r\n              /\\__/\\ \\__ O (__\r\n             (--/\\--)      \\ __ /\r\n             _) (  ) (_\r\n            `---' '---`");
		robotPana.setBounds(44, 104, 306, 358);
		panel_1.add(robotPana);
		
		
		JLabel welcomeLabel = new JLabel("WELCOME TO SECURE NOTEPAD");
		welcomeLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		welcomeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(20, 10, 286, 97);
		panel_1.add(welcomeLabel);
	}
	
	
	   public static void main(String args[]) {
	        /* Set the Nimbus look and feel */
	        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
	        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	         */
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new LoginView().setVisible(true);
	            }
	        });
	    }
	   
	   
	   private void checkLogin(){
		     if(this.logController.succesfullLogin(usernameIn.getText(), passwordIn.getText())) {
		         JOptionPane.showMessageDialog(null,"logging in...", "Successful!", JOptionPane.INFORMATION_MESSAGE);
		         dispose();
		         noteController.startApplication();
		     }
		     else
		     {
		        this.intentos--;
		        this.intentosLabel.setText("Remaining attempts: "+this.intentos);
		        intentosExcedidos();
		        JOptionPane.showMessageDialog(null,"Wrong username or password", "Login failed", JOptionPane.ERROR_MESSAGE);
		     }
		    }
		    
	    private void intentosExcedidos(){
	        if(this.intentos==0)
	        {
	            JOptionPane.showMessageDialog(null,"Number of attempts allowed exceeded.\n The application will close.", "ERROR!",JOptionPane.PLAIN_MESSAGE);
	            System.exit(0);
	        }
	    }
	   
}
