package gui.formos.paneles;

import db.entities.Vartotojas;
import db.veiksmai.DuombazesVeiksmai;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class MenuPanele extends JPanel
{
    private JButton pridetiVartotojaButton;
    private JButton tempButton2;
    private JButton tempButton3;
    private JButton tempButton4;

    private JFrame mainFrame;
    private NaujasVartPanele naujasVartPanele;

    public MenuPanele()
    {
        pridetiVartotojaButton = new JButton();
        tempButton2 = new JButton();
        tempButton3 = new JButton();
        tempButton4 = new JButton();
    }

    public void nustatytiPanele()
    {
        pridetiVartotojaButton.setText("Prideti nauja vartotoja");
        pridetiVartotojaButton.addActionListener(new CreateButtonListener());

        tempButton2.setText("antras mygtukas");
        tempButton3.setText("trecias mygtukas");
        tempButton4.setText("ketvirtas mygtukas");

        this.setLayout(new GridLayout(4,1 ,10, 10));

        this.add(pridetiVartotojaButton);
        this.add(tempButton2);
        this.add(tempButton3);
        this.add(tempButton4);

    }

    class CreateButtonListener implements ActionListener
    {
        public CreateButtonListener() {}

        @Override
        public void actionPerformed(ActionEvent e)
        {
            mainFrame.getContentPane().removeAll();
            mainFrame.repaint();

            naujasVartPanele.nustatytiPanele();

            mainFrame.getContentPane().add(naujasVartPanele);
            mainFrame.repaint();
            mainFrame.printAll(mainFrame.getGraphics());
        }
    }

    public void setMainFrame(JFrame mainFrame)
    {
        this.mainFrame = mainFrame;
    }

    public void setNaujasVartPanele(NaujasVartPanele naujasVartPanele)
    {
        this.naujasVartPanele = naujasVartPanele;
    }
}
