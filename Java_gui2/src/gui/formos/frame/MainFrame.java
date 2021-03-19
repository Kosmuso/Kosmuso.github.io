package gui.formos.frame;

import gui.formos.paneles.LoginPanele;
import gui.formos.paneles.MenuPanele;
import gui.formos.paneles.NaujasVartPanele;

import javax.swing.*;
import java.awt.*;

public class MainFrame
{
    private JFrame mainFrame;
    private LoginPanele loginPanele;
    private MenuPanele menuPanele;
    private NaujasVartPanele naujasVartPanele;

    public MainFrame()
    {
        mainFrame = new JFrame();

        loginPanele = new LoginPanele();
        loginPanele.setMainFrame(mainFrame);
        loginPanele.nustatytiPanele();

        mainFrame.add(loginPanele);

        menuPanele = new MenuPanele();
        menuPanele.nustatytiPanele();

        loginPanele.setMenuPanele(menuPanele);

        naujasVartPanele = new NaujasVartPanele();

        menuPanele.setMainFrame(mainFrame);
        menuPanele.setNaujasVartPanele(naujasVartPanele);

        mainFrame.setSize(new Dimension(700, 500));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setTitle("Logistikos imones programa");
        mainFrame.setVisible(true);
    }

    public static void main(String[] args)
    {
        new MainFrame();
    }
}
