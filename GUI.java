import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.KeyStroke; 
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

public class GUI implements ActionListener{
    JFrame frame;
    JPanel panel1,panel2,panel3,panel4,panel5;
    DefaultTableModel dtm;
    JTable table;
    JLabel label1,label2,label3;
    JTextField tf1,tf2,tf3;
    JCheckBox cbox;
    JRadioButton rb1,rb2;
    JButton btn1,btn2,btn3,btn4;
    JMenu mFile, mEdit,mHelp;
    JMenuItem exitMi,clearMi,searchMi,addMi,removeMi,aboutMi;
    JMenuBar mb;

    public GUI(){

        frame = new JFrame("Phonebook");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        panel1 = new JPanel();
        dtm = new DefaultTableModel(26,0);
        table = new JTable(dtm);
        dtm.addColumn("Forename");
        dtm.addColumn("Surename");
        dtm.addColumn("Phone");
        dtm.addColumn("Private");
        //dtm.addRow(new Object[] {"#","Player","Score","Date"});
        // panel1.setBorder();
        panel1.setLayout(new FlowLayout());
        panel1.add(new JScrollPane(table));
        frame.add(panel1);

        // ----------------------------------

        panel2 = new JPanel();
        label1 = new JLabel();
        label1.setText("First Name");
        panel2.add(label1);

        tf1 = new JTextField();
        panel2.add(tf1);

        label2 = new JLabel();
        label2.setText("Last Name");
        panel2.add(label2);

        tf2 = new JTextField();
        panel2.add(tf2);

        label3 = new JLabel();
        label3.setText("Phone Number");
        panel2.add(label3);

        tf3 = new JTextField();
        panel2.add(tf3);

        cbox= new JCheckBox("Private");
        panel2.add(cbox);
        panel2.setLayout(new GridLayout(4,2));

        // ---------------------------------

        panel3 = new JPanel();
        rb1 = new JRadioButton("Forename,Surename");
        panel3.add(rb1);
        rb2 = new JRadioButton("Surename,Forename");
        panel3.add(rb2);
        panel3.setLayout(new GridLayout(2,1));

        // ---------------------------------

        panel4= new JPanel();
        btn1 = new JButton("CLEAR");
        btn2 = new JButton("SEARCH");
        btn3 = new JButton("ADD");
        btn4 = new JButton("REMOVE");
        panel4.add(btn1);
        panel4.add(btn2);
        panel4.add(btn3);
        panel4.add(btn4);
        panel4.setLayout(new GridLayout(2,2));

        // ---------------------------------

        panel5= new JPanel();
        panel5.add(panel2);
        panel5.add(panel3);
        panel5.add(panel4);

        panel5.setLayout(new GridLayout(3,1));
        frame.add(panel5);
        // ----------------------------------
        exitMi = new JMenuItem("Exit");
        mFile = new JMenu("File");
        mFile.add(exitMi);

        clearMi = new JMenuItem("Clear");
        searchMi = new JMenuItem("Search");
        addMi = new JMenuItem("Add");
        removeMi = new JMenuItem("Remove");
        mEdit = new JMenu("Edit");
        mEdit.add(clearMi);
        mEdit.add(searchMi);
        mEdit.addSeparator();
        mEdit.add(addMi);
        mEdit.add(removeMi);

        aboutMi = new JMenuItem("About Us  ");
        mHelp = new JMenu("Help");
        mHelp.add(aboutMi);
        //Close 
        //MNEMONICS//
        mFile.setMnemonic(KeyEvent.VK_F);
        exitMi.setMnemonic(KeyEvent.VK_E);
        clearMi.setMnemonic(KeyEvent.VK_C);
        searchMi.setMnemonic(KeyEvent.VK_S);
        addMi.setMnemonic(KeyEvent.VK_A);
        removeMi.setMnemonic(KeyEvent.VK_R);

        exitMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        clearMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
        searchMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        addMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        removeMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
        //--------//

        mb = new JMenuBar();
        mb.add(mFile);
        mb.add(mEdit);
        mb.add(mHelp);

        // ----------------------------------

        exitMi.setToolTipText("Exit");
        clearMi.setToolTipText("Clear this table");
        addMi.setToolTipText("Add into this table");
        searchMi.setToolTipText("Search from this table");
        removeMi.setToolTipText("Remove from this table");
        aboutMi.setToolTipText("About Us");
        tf1.setToolTipText("Enter first name");
        tf2.setToolTipText("Enter last name");
        tf3.setToolTipText("Enter phone number");

        // ----------------------------------

        TitledBorder pnlBorder1 = new TitledBorder("Name");
        panel1.setBorder(pnlBorder1);

        TitledBorder pnlBorder2 = new TitledBorder("Info");
        panel2.setBorder(pnlBorder2);

        TitledBorder pnlBorder3 = new TitledBorder("File as:");
        panel3.setBorder(pnlBorder3);

        //----------------------------------

        frame.add(panel1,BorderLayout.WEST);
        frame.add(panel5,BorderLayout.CENTER);
        frame.add(mb,BorderLayout.NORTH);

        //----------------------------------

        rb1.addActionListener(this);
        rb2.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        aboutMi.addActionListener(this);
        addMi.addActionListener(this);
        removeMi.addActionListener(this);
        searchMi.addActionListener(this);
        clearMi.addActionListener(this);
        exitMi.addActionListener(this);
        //----------------------------------
        frame.setSize(700,500);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btn1 || e.getSource()==clearMi){
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
        }
        if(e.getSource()==btn2 || e.getSource()==searchMi){
            // create a dialog Box 
            JDialog d = new JDialog(frame, "Sorry !"); 
            d.setLayout(new FlowLayout());

            // create a label 
            JLabel l1 = new JLabel("Search functionality will be supported in the professional version.");
            JLabel l2 = new JLabel("Thanks you for choosing us");

            d.add(l1);
            d.add(l2);

            // setsize of dialog 
            d.setSize(400, 100); 
            d.setVisible(true);
        }

        if(e.getSource()==btn3 || e.getSource()==addMi){
            //Validations//
            boolean res1=Pattern.matches("[a-z,A-Z]",tf1.getText());
            boolean res2=Pattern.matches("[a-z,A-Z]",tf2.getText());
            boolean res3=Pattern.matches("[98][0-9]{9}",tf3.getText());
            //--------//
            try{
                if(res1==false || res2==false || res3==false){
                    if(res1==false){
                        JDialog d = new JDialog(frame, "Error"); 
                        d.setLayout(new FlowLayout());

                        // create a label 
                        JLabel l1 = new JLabel("Please re-check your First Name");
                        JButton b1 = new JButton("Try Again");

                        d.add(l1);
                        d.add(b1);

                        // setsize of dialog 
                        d.setSize(250, 100); 
                        d.setVisible(true);

                        b1.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                    d.dispose();
                                }

                            });

                    }
                    else if(res2==false){
                        JDialog d = new JDialog(frame, "Error"); 
                        d.setLayout(new FlowLayout());

                        // create a label 
                        JLabel l1 = new JLabel("Please re-check your Second Name");
                        JButton b1 = new JButton("Try Again");

                        d.add(l1);
                        d.add(b1);

                        // setsize of dialog 
                        d.setSize(250, 100); 
                        d.setVisible(true);

                        b1.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                    d.dispose();
                                }

                            });

                    }
                    else if(res3==false){
                        JDialog d = new JDialog(frame, "Error"); 
                        d.setLayout(new FlowLayout());

                        // create a label 
                        JLabel l1 = new JLabel("Please re-check your phone number");
                        JButton b1 = new JButton("Try Again");

                        d.add(l1);
                        d.add(b1);

                        // setsize of dialog 
                        d.setSize(250, 100); 
                        d.setVisible(true);

                        b1.addActionListener(new ActionListener(){
                                public void actionPerformed(ActionEvent e){
                                    d.dispose();
                                }

                            });

                    }
                }

                else{
                    if(cbox.isSelected()==true ){
                        dtm.insertRow(0,new Object[]{tf1.getText(),tf2.getText(),tf3.getText(),"Yes"});
                    }
                    else{
                        dtm.insertRow(0,new Object[]{tf1.getText(),tf2.getText(),tf3.getText()});
                    }
                }
            }
            catch(Exception ex){}
        }

        if(e.getSource()==btn4 || e.getSource()==removeMi){
            dtm.removeRow(0);
        }
        if(e.getSource()==rb1){
            if(rb1.isSelected()==true){
                rb1.setEnabled(false);
                rb2.setEnabled(false);
            }
        }
        if(e.getSource()==rb2){
            if(rb2.isSelected()==true){
                table.moveColumn(0,1);
                rb1.setEnabled(false);
                rb2.setEnabled(false);
            }
        }
        if(e.getSource()==exitMi){
            frame.dispose();
        }
        if(e.getSource()==aboutMi){
            // create a dialog Box 
            JDialog d = new JDialog(frame, "About Us"); 
            d.setLayout(new FlowLayout());

            // create a label 
            JLabel l1 = new JLabel("This is still in trial version !");
            JLabel l2 = new JLabel("Thanks you for choosing us");

            d.add(l1);
            d.add(l2);

            // setsize of dialog 
            d.setSize(200, 100); 
            d.setVisible(true);

        }
    }

    public static void main (String args[]){
        GUI obj=new GUI();
    }
}