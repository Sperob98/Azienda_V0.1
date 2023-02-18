package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarHome {

    JMenuBar barra;

    JMenu menu, edit;

    JMenuItem addEmp, addLab, addProj;


    public MenuBarHome(JFrame home) {

        barra = new JMenuBar();

        menu = new JMenu("Menu");

        edit = new JMenu("Edit");

        addEmp = new JMenuItem("Aggiungi Impiegato");

        addLab = new JMenuItem("Aggiungi Laboratorio");

        addProj = new JMenuItem("Aggiungi progetto");

        addEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmployeeRegister(home);
            }
        });

        menu.add(addEmp);

        menu.add(addLab);

        menu.add(addProj);

        barra.add(menu);

        barra.add(edit);

        home.setJMenuBar(barra);

    }

}
