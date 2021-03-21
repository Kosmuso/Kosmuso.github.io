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


        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //login label layout param.
        c.gridx = 1; // stulpelis
        c.gridy = 1; // eilute
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0,0,20,0);
        newLoginLabel.setPreferredSize(new Dimension(200, 30));
        this.add(newLoginLabel, c);

        //login text layout param.
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        newLoginText.setPreferredSize(new Dimension(250, 30));
        this.add(newLoginText, c);

        //psw label layout param.
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        newPswLabel.setPreferredSize(new Dimension(250, 30));
        this.add(newPswLabel, c);

        //psw text layout param.
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        newPswText.setPreferredSize(new Dimension(250, 30));
        this.add(newPswText, c);

        //login Button layout param.
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        createButton2.setPreferredSize(new Dimension(150, 25));
        this.add(createButton2, c);

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

                System.out.println("Naujas vartotojas \"" + login +  "\"  pridetas sekmyngai");

            }
            catch (SQLException exc)
            {
                exc.printStackTrace();
                System.out.println("Nepavyko prisijungti i DB ir prideti naujo vartotojo");
            }
        }
    }
}
