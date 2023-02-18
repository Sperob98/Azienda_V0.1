package GUI;

import Controller.Controller;
import Model.Impiegato;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Employee extends JFrame {

    ImageIcon icona, iconBack, iconRefresh;

    JPanel panelNord, panelOvest, panelEst, panelSud;

    JScrollPane panelCenter;

    JTable table;

    JLabel cercaLabel, infoCarriraLabel, toBack, reflash;
    JComboBox ricercaPer, ricercaSpecifica;

    DefaultComboBoxModel modelRicerca;

    DefaultTableModel modelTable;

    String inputDialog;

    JTable tableMain;

    ArrayList<Impiegato> impiegati;

    public  Employee(JFrame home, Controller controller) {

        //Impostazioni finestra

        super("Area impiegati");

        setSize(800, 600);

        setLocationRelativeTo(null);

        setResizable(true);

        icona = new ImageIcon(getClass().getResource("/employee2.png"));

        setIconImage(icona.getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());


        //Area PAGE_START (Filtro di ricerca)

        String[] filtroRicerca = {"Tutti gli impiegati", "Categoria", "Codice fiscale", "Sesso", "Nome", "Cognome", "Età", "Data assunzione"};

        ricercaPer = new JComboBox<>(filtroRicerca);

        ricercaSpecifica = new JComboBox<>();

        ricercaSpecifica.setEnabled(false);

        modelRicerca = new DefaultComboBoxModel();

        impiegati = new ArrayList<>();

        ricercaPer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int indexRicerca = ricercaPer.getSelectedIndex();

                switch (indexRicerca) {

                    case 0:

                        String genere;

                        controller.readAllEmployee(impiegati);

                        for(Impiegato impiegato : impiegati) {

                            if (impiegato.getSesso() == 'm') {genere = "maschio";}

                                else {genere = "femmina";}

                            String[] dati = {impiegato.getNome(), impiegato.getCognome(),genere,
                                    impiegato.getDataDiNascita().toString(), impiegato.getCF(),
                                        impiegato.getDataAssunzione().toString()};

                            modelTable.addRow(dati);
                        }

                        break;

                    case 1:

                        modelRicerca.removeAllElements();

                        modelRicerca.addElement("Junior");

                        modelRicerca.addElement("Middle");

                        modelRicerca.addElement("Senior");

                        modelRicerca.addElement("Dirigente");

                        ricercaSpecifica.setModel(modelRicerca);

                        ricercaSpecifica.setEnabled(true);

                        break;

                    case 2:

                        modelRicerca.removeAllElements();

                        ricercaSpecifica.setEnabled(false);

                        inputDialog = JOptionPane.showInputDialog("Inserisci il codice fiscale");

                        break;

                    case 3:

                        modelRicerca.removeAllElements();

                        modelRicerca.addElement("Femmina");

                        modelRicerca.addElement("Mschio");

                        ricercaSpecifica.setEnabled(true);

                        break;

                    case 4:

                        modelRicerca.removeAllElements();

                        ricercaSpecifica.setEnabled(false);

                        inputDialog = JOptionPane.showInputDialog("Inserisci il nome");

                        break;

                    case 5:

                        modelRicerca.removeAllElements();

                        ricercaSpecifica.setEnabled(false);

                        inputDialog = JOptionPane.showInputDialog("Inserisci il cognome");

                        break;

                    case 6:

                        modelRicerca.removeAllElements();

                        ricercaSpecifica.setEnabled(false);

                        inputDialog = JOptionPane.showInputDialog("Inserisci l'età");

                        break;

                    case 7:

                        modelRicerca.removeAllElements();

                        ricercaSpecifica.setEnabled(false);

                        inputDialog = JOptionPane.showInputDialog("Inserisci la data assunzione");

                        break;

                    default:

                        modelRicerca.removeAllElements();

                        ricercaSpecifica.setEnabled(false);

                        break;

                }
            }
        });

        panelNord = new JPanel();

        panelNord.setLayout(new BoxLayout(panelNord, BoxLayout.PAGE_AXIS));

        JPanel rigaLabel = new JPanel();

        rigaLabel.setLayout(new BoxLayout(rigaLabel, BoxLayout.X_AXIS));

        cercaLabel = new JLabel("Cerca per:");

        rigaLabel.add(cercaLabel);

        rigaLabel.add(Box.createHorizontalGlue());

        panelNord.add(rigaLabel);

        panelNord.add(ricercaPer);

        panelNord.add(ricercaSpecifica);


        //Area ovest (dati carriera)

        panelOvest = new JPanel();

        panelOvest.setLayout(new BoxLayout(panelOvest, BoxLayout.PAGE_AXIS));

        Border bordoInterno = BorderFactory.createTitledBorder("Info carriera");

        Border bordoEsterno = BorderFactory.createEmptyBorder(0,5,5,5);

        Border bordoFinale = BorderFactory.createCompoundBorder(bordoEsterno, bordoInterno);

        panelOvest.setBorder(bordoFinale);

        JPanel primaRigaOvest = new JPanel();

        primaRigaOvest.setLayout(new BoxLayout(primaRigaOvest, BoxLayout.X_AXIS));

        infoCarriraLabel = new JLabel("Carriera");

        primaRigaOvest.add(Box.createHorizontalGlue());

        primaRigaOvest.add(infoCarriraLabel);

        primaRigaOvest.add(Box.createHorizontalGlue());

        panelOvest.add(primaRigaOvest);




        //Area Center (tabella dati)

        table = new JTable();

        table.setEnabled(false);

        String[] colonne = {"Nome", "Cognome", "Sesso", "Data di nascita", "Codice Fiscale", "Data assunzione", "Nome laboratorio afferente", "Topic"};

        modelTable = new DefaultTableModel(colonne, 0);

        table.setModel(modelTable);

        panelCenter = new JScrollPane(table);




        //Area Sud

        panelSud = new JPanel();

        panelSud.setLayout(new FlowLayout());

        iconBack = new ImageIcon(getClass().getResource("/toback.png"));

        iconRefresh = new ImageIcon(getClass().getResource("/refresh.png"));

        toBack = new JLabel(iconBack);

        reflash = new JLabel(iconRefresh);

        toBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                dispose();

                home.setVisible(true);
            }
        });

        panelSud.add(toBack);

        panelSud.add(reflash);


        //Finalizzazione frame

        add(panelOvest, BorderLayout.WEST);

        add(panelNord, BorderLayout.PAGE_START);

        add(panelCenter, BorderLayout.CENTER);

        add(panelSud, BorderLayout.PAGE_END);

        setVisible(true);



    }

}
