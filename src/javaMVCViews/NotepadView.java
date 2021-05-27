package javaMVCViews;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javaMVCControllers.NotepadController;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import java.awt.event.MouseAdapter;
import java.io.File;

import javax.swing.JScrollPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class NotepadView extends JFrame {

	  private JPanel contentPane;
	  private final NotepadController noteControl;
	  private javax.swing.JTextArea textArea;
	
	public NotepadView() {
		
		this.noteControl = new NotepadController();
		
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 14));
		setTitle("Notepad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 476);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.DARK_GRAY);
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		JMenu JMenuBar = new JMenu("File");
		JMenuBar.setPreferredSize(new Dimension(49, 24));
		JMenuBar.setAutoscrolls(true);
		JMenuBar.setBorderPainted(true);
		menuBar.add(JMenuBar);
		
		JMenuItem newMenuItem = new JMenuItem("New");
		newMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int question;
			        if(!textArea.getText().isEmpty()){
			            try {
			                if(noteControl.savedFile(textArea.getText()))
			                {
			                    textArea.setText("");
			                    noteControl.clearPath();
			                }
			                else {
			                    question= JOptionPane.showConfirmDialog(null, "Save file?", "File not saved", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION);
			                    if(question == JOptionPane.NO_OPTION){
			                        textArea.setText(""); 
			                    }
			                    else if(question== JOptionPane.YES_OPTION) {
			                        guardarArchivo(textArea.getText());
			                    }
			                }
			            } catch (Exception ex) {
			                
			            }
			        }
			}
		});
		JMenuBar.add(newMenuItem);
		
		JMenuItem openMenuItem = new JMenuItem("Open");
		openMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc= new JFileChooser();
				fc.showOpenDialog(null);
		        String archivo= fc.getSelectedFile().getAbsolutePath();
		        	try{
		        		textArea.setText(noteControl.getMessage(archivo));
				    } catch(Exception er){
				      JOptionPane.showMessageDialog(null, er, "Read error", JOptionPane.ERROR_MESSAGE);
				      }
				    }
		});
		JMenuBar.add(openMenuItem);
		
		JMenuItem closeMenuItem = new JMenuItem("Close");
		closeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"This option still in development.", ":(", JOptionPane.CLOSED_OPTION);
			}
		});
		JMenuBar.add(closeMenuItem);
		
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
				        if(!noteControl.savedFile(textArea.getText())){
				          noteControl.writeMessageDefault(textArea.getText());
				        }
				  } catch (Exception er) {
				        JOptionPane.showMessageDialog(null, "Save failed", "Error!", JOptionPane.ERROR_MESSAGE);
				    }
		    }
		});
		JMenuBar.add(saveMenuItem);
		
		JMenuItem saveAsMenuItem_ = new JMenuItem("Save As..");
		saveAsMenuItem_.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   guardarArchivo(textArea.getText());
			}
		});
		JMenuBar.add(saveAsMenuItem_);
		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitMenuItem.addMouseListener(new MouseAdapter() {
		});
		JMenuBar.add(exitMenuItem);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		textArea = new javax.swing.JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(textArea);
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
	            java.util.logging.Logger.getLogger(NotepadView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(NotepadView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(NotepadView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(NotepadView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new NotepadView().setVisible(true);
	            }
	        });
	    }
	
	
	 private void guardarArchivo(String message){
	        JFileChooser fc= new JFileChooser();
	        fc.setFileFilter(new FileNameExtensionFilter(".txt", "txt"));
	        fc.showOpenDialog(null);
	        File archivo= fc.getSelectedFile();
	        try{
	            noteControl.writeMessageInDirectory(message, archivo.getAbsolutePath()+fc.getFileFilter().getDescription().replace("All Files",""));
	        } catch(Exception err){
	            JOptionPane.showMessageDialog(null, "Save failed", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

}