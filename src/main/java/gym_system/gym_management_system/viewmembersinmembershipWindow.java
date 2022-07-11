package gym_system.gym_management_system;

import Gym_Components.Member;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class viewmembersinmembershipWindow extends JFrame{
    private JComboBox comboBox1;
    private JButton searchButton;
    private JTextPane textPane1;
    private JButton backToMenuButton;
    private JPanel viewmembersinmembershipPanel;

    private void updateTextPane(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Document doc = textPane1.getDocument();
                try {
                    doc.insertString(doc.getLength(), text, null);
                } catch (BadLocationException e) {
                    throw new RuntimeException(e);
                }
                textPane1.setCaretPosition(doc.getLength() - 1);
            }
        });
    }

    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override
            public void write(final int b) throws IOException {
                updateTextPane(String.valueOf((char) b));
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                updateTextPane(new String(b, off, len));
            }

            @Override
            public void write(byte[] b) throws IOException {
                write(b, 0, b.length);
            }
        };

        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }



    viewmembersinmembershipWindow() {

        setContentPane(viewmembersinmembershipPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("View Members in a Membership");
        setVisible(true);
        setLocationRelativeTo(null);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                redirectSystemStreams();
                String enteredMembership = ((String) comboBox1.getItemAt(comboBox1.getSelectedIndex())).toUpperCase(Locale.ROOT);
                boolean is_found=false;
                System.out.println("Members using "+ (String) comboBox1.getItemAt(comboBox1.getSelectedIndex()) + " membership are:");
                for (Member P : GymSystem.getMembers()) {
                    if (P.getMembership_type().equals(enteredMembership)) {
                        System.out.println( P.get_name());
                        is_found=true;
                        break;
                    }
                }
                if (!is_found){
                    System.out.println("No members using this membership type");
                }
                System.out.println("\n----------------------------------------------" +
                        "----------------------------------------------------\n");
            }
        });

        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                membersmanagmentWindow membersmanagmentwindow = new membersmanagmentWindow();
            }
        });
    }
}

