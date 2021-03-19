package gui.formos.paneles;

import db.entities.Vartotojas;
import db.veiksmai.DuombazesVeiksmai;
import gui.formos.frame.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginPanele extends JPanel
{
    private JButton loginButton;
    private JTextField loginText;
    private JLabel loginLabel;
    private JPasswordField pswText;
    private JLabel pswLabel;

    private JFrame mainFrame;
    private MenuPanele menuPanele;

    public LoginPanele()
    {
        loginButton = new JButton();
        loginText = new JTextField();
        loginLabel = new JLabel();
        pswText = new JPasswordField();
        pswLabel = new JLabel();
    }

    public void nustatytiPanele()
    {
        loginButton.setText("Prisijungti");
        loginButton.setFont(new Font("monospace", Font.BOLD, 15));
        loginButton.addActionListener(new LoginButtonListener());

        loginLabel.setText("Iveskite prisijungimo varda: ");
        pswLabel.setText("Iveskite slaptazodi: ");

        //--------------LAYOUT----------
        //this.setLayout(new GridLayout(5, 1, 10, 10));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //login label layout param.
        c.gridx = 1; // stulpelis
        c.gridy = 1; // eilute
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(0,0,20,0);
        loginLabel.setPreferredSize(new Dimension(200, 30));
        this.add(loginLabel, c);

        //login text layout param.
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        loginText.setPreferredSize(new Dimension(250, 30));
        this.add(loginText, c);

        //psw label layout param.
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        pswLabel.setPreferredSize(new Dimension(250, 30));
        this.add(pswLabel, c);

        //psw text layout param.
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        pswText.setPreferredSize(new Dimension(250, 30));
        this.add(pswText, c);

        //login Button layout param.
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.BOTH;
        loginButton.setPreferredSize(new Dimension(150, 25));
        this.add(loginButton, c);

        //this.add(loginLabel);
        //this.add(loginText);
        //this.add(pswLabel);
        //this.add(pswText);
        //this.add(loginButton);
    }

    class LoginButtonListener implements ActionListener
    {
        private int arTinkaVart = 0;
        public LoginButtonListener() {}

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String login = loginText.getText();
            char[] pswChar = pswText.getPassword();
            String psw = String.valueOf(pswChar);;

            Vartotojas ivestasVart = new Vartotojas(login, psw);

            try
            {
                Connection jungtis = DuombazesVeiksmai.sukurtiDuombaze();
                arTinkaVart = DuombazesVeiksmai.palygintiVartDuomenis(jungtis, ivestasVart);

                if (arTinkaVart == 1)
                {
                    mainFrame.getContentPane().removeAll();
                    mainFrame.repaint();

                    menuPanele.nustatytiPanele();

                    mainFrame.getContentPane().add(menuPanele);
                    mainFrame.repaint();
                    mainFrame.printAll(mainFrame.getGraphics());
                }
            }
            catch (SQLException exc)
            {
                exc.printStackTrace();
                System.out.println("Nepavyko prisijungti i DB");
            }
        }
    }


    public void setMainFrame(JFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }

    public void setMenuPanele(MenuPanele menuPanele)
    {
        this.menuPanele = menuPanele;
    }
}
