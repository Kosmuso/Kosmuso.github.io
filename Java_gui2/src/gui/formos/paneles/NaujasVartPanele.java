package gui.formos.paneles;

import db.entities.Vartotojas;
import db.veiksmai.DuombazesVeiksmai;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class NaujasVartPanele extends JPanel
{
    private JLabel newLoginLabel;
    private JTextField newLoginText;
    private JLabel newPswLabel;
    private JPasswordField newPswText;
    private JButton createButton2;

    private JFrame mainFrame;

    public NaujasVartPanele()
    {
        newLoginLabel = new JLabel();
        newLoginText = new JTextField();
        newPswLabel = new JLabel();
        newPswText = new JPasswordField();
        createButton2 = new JButton();
    }

    public void nustatytiPanele()
    {
        newLoginLabel.setText("Naujo vartotojo vardas: ");
        newPswLabel.setText("Naujo vartotojo password: ");
        createButton2.setText("Sukurti");
        createButton2.setFont(new Font("monospace", Font.BOLD, 15));
        createButton2.addActionListener(new CreateButtonListener2());

        this.setLayout(new GridLayout(3, 2, 10, 10));
        this.add(newLoginLabel);
        this.add(newLoginText);
        this.add(newPswLabel);
        this.add(newPswText);
        this.add(createButton2);

    }

    class CreateButtonListener2 implements ActionListener
    {
        public CreateButtonListener2() {}

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String login = newLoginText.getText();
            char[] pswChar = newPswText.getPassword();
            String psw = String.valueOf(pswChar);

            Vartotojas ivestasVart = new Vartotojas(login, psw);

            try
            {
                Connection jungtis = DuombazesVeiksmai.sukurtiDuombaze();
                DuombazesVeiksmai.sukurtiNaujaVart(jungtis, ivestasVart);
            }
            catch (SQLException exc)
            {
                exc.printStackTrace();
                System.out.println("Nepavyko prisijungti i DB ir prideti naujo vartotojo");
            }
        }
    }


}
