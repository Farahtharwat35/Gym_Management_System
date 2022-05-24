package gym_system.gym_management_system;

        import Gym_Components.Member;
        import System_Users.Person;

        import javax.swing.*;
        import javax.swing.text.BadLocationException;
        import javax.swing.text.Document;
        import java.io.IOException;
        import java.io.OutputStream;
        import java.io.PrintStream;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.Scanner;

public class viewallmembers2Window extends JFrame {
    private JPanel viewallmembers2Panel;
    private JLabel lbl_view_all_members;
    private JTextPane textPane1;

    private JButton backToMenuButton;
    private JButton searchButton;
    private JTextField textField1;

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



    viewallmembers2Window() {

        setContentPane(viewallmembers2Panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 420);
        setTitle("View A Member's info");
        setVisible(true);
        setLocationRelativeTo(null);

        redirectSystemStreams();
        if (!GymSystem.getMembers().isEmpty()) {


            for (Person member : GymSystem.getMembers()) {

            }

        }else {
            System.out.println("There are no members available !");
        }


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("\n---------------------------------------" + "Member info" +
                        "---------------------------------------\n");
                System.out.format("%16s\t%24s\t%6s\t%11s\n",
                        "Name",
                        "National ID",
                        "Gender" ,
                        "Phone Number"
                );

                boolean found = false;
                String national_id = textField1.getText();
                for (Member P : GymSystem.getMembers()) {
                    if (P.get_national_id().equals(national_id)){
//                        System.out.println(P);
                        System.out.format("%16s%24s\t%6s\t%11s\n",
                                P.get_name(),
                                P.get_national_id(),
                                P.get_gender(),
                                P.getPhone_number());
                        found=true;
                    }
                }
                System.out.println("\n-----------------------------------------------" +
                        "-----------------------------------------------\n");

                if(found==false)     System.out.println("Member Not Found");

            }
        });

        backToMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                employeemanagmentWindow employeemanagmentwindow = new employeemanagmentWindow();
            }
        });
    }
}

