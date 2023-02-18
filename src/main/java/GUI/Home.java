package GUI;

import Controller.Controller;
import Database.ConnessioneDatabase;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Home extends JFrame {

    private Controller controller;

    MenuBarHome menuBarra;

    JLabel empLabel, labLabel, projLabel;

    ImageIcon icona, emp, lab, proj, pc, roberto, chiara;

    JPanel panelMain, endPanel;

    JFrame questo;

    private Connection connection;

    public Home()  {

        super("Home");

        controller = new Controller();

        setSize(1100, 650);

        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        icona = new ImageIcon(getClass().getResource("/pc.png"));

        setIconImage(icona.getImage());

        getContentPane().setBackground(Color.gray);

        menuBarra = new MenuBarHome(this);

        questo = this;

        emp = new ImageIcon(getClass().getResource("/employee.png"));

        empLabel = new JLabel( emp);

        empLabel.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e)
            {

                setVisible(false);

                new Employee(questo, controller);

            }
        });

        lab = new ImageIcon(getClass().getResource("/laboratory.png"));

        labLabel = new JLabel(lab);

        proj = new ImageIcon(getClass().getResource("/project.png"));

        projLabel = new JLabel(proj);

        panelMain = new JPanel();

        panelMain.setBackground(Color.gray);

        panelMain.setLayout(new FlowLayout(0, 0, 0));

        panelMain.add(empLabel);

        panelMain.add(labLabel);

        panelMain.add(projLabel);

        add(panelMain, BorderLayout.WEST);

        endPanel = new JPanel();

        endPanel.setLayout(new FlowLayout(0, 0, 0));

        endPanel.setBackground(Color.gray);

        pc = new ImageIcon(getClass().getResource("/pc.png"));

        roberto = new ImageIcon(getClass().getResource("/roberto.png"));

        chiara = new ImageIcon(getClass().getResource("/chiara.png"));

        endPanel.add(new JLabel(roberto));

        endPanel.add(new JLabel(pc));

        endPanel.add(new JLabel(chiara));

        add(endPanel, BorderLayout.PAGE_END);

        setVisible(true);


    }
}
