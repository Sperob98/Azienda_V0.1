package GUI;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

public class EmployeeRegister extends JFrame {

    JPanel panelRegister, panelSesso, panelNascita, panelPaese, panelCf, panelAssunzione;

    JTextField nome, cognome, cf;

    JRadioButton femmina, maschio, italia, estero;

    ButtonGroup gruppoRadioSesso, gruppoRadioPaese;

    JSpinner dataNascitaSpinner, dataAssunzione;

    JComboBox comuniBox, esteriBox;

    JCheckBox dirigenteCheck;

    JButton calcolaCF, aggiungi;

    JFrame questo;

    ImageIcon icona;

    EmployeeRegister(JFrame home) {

        super("Registrazione impiegato");

        home.setEnabled(false);

        setSize(500, 400);

        setResizable(false);

        setLocationRelativeTo(null);

        icona = new ImageIcon(getClass().getResource("/write.png"));

        setIconImage(icona.getImage());

        questo = this;

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                home.setEnabled(true);

                dispose();
            }
        });

        panelRegister = new JPanel();

        panelRegister.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        //Riga 1 - colonna 1 (Label nome)

        gbc.gridx = 0;

        gbc.gridy = 0;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        panelRegister.add(new JLabel("Nome"), gbc);

        //Riga 1 colonna 2 (TextField nome)

        gbc.gridx = 1;

        gbc.gridy = 0;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        nome = new JTextField(20);

        panelRegister.add(nome, gbc);

        // riga 2 - colonna 1 (Label cognome)

        gbc.gridx = 0;

        gbc.gridy = 1;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        panelRegister.add(new JLabel("Cognome"), gbc);

        //Riga 2 - colonna 2 (TextField cognome)

        gbc.gridx = 1;

        gbc.gridy = 1;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        cognome = new JTextField(20);

        panelRegister.add(cognome, gbc);

        //riga 3 - colonna 1 (Label sesso)

        gruppoRadioSesso = new ButtonGroup();

        gbc.gridx = 0;

        gbc.gridy = 2;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        panelRegister.add(new JLabel("Sesso"), gbc);

        //riga3 - colonna 2 (panel Jradio-sesso)

        panelSesso = new JPanel();

        panelSesso.setLayout(new FlowLayout());

        femmina = new JRadioButton("femmina");

        maschio = new JRadioButton("maschio");

        gruppoRadioSesso.add(femmina);

        gruppoRadioSesso.add(maschio);

        panelSesso.add(femmina);

        panelSesso.add(maschio);

        gbc.gridx = 1;

        gbc.gridy = 2;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        panelRegister.add(panelSesso, gbc);

        //Riga 4 - colonna 1 (Label data di nascita)

        gbc.gridx = 0;

        gbc.gridy = 3;

        gbc.weightx = 0.5;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        panelRegister.add(new JLabel("Data di nascita "), gbc);

        //Riga4 colonna 2 (layout data di nascita)

        Date data = new Date();

        SpinnerDateModel modelloNascita = new SpinnerDateModel(data,null,null, Calendar.YEAR);

        dataNascitaSpinner = new JSpinner();

        dataNascitaSpinner.setModel(modelloNascita);

        JSpinner.DateEditor ded = new JSpinner.DateEditor(dataNascitaSpinner,"dd/MM/yyyy");

        dataNascitaSpinner.setEditor(ded);

        panelNascita = new JPanel();

        panelNascita.setLayout(new FlowLayout());

        panelNascita.add(new JLabel("(gg/mm/yyyy)"));

        panelNascita.add(dataNascitaSpinner);

        gbc.gridx = 1;

        gbc.gridy = 3;

        gbc.weightx = 0.1;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        panelRegister.add(panelNascita, gbc);

        // Riga 5 - colonna 1 (Paese di nascita label)

        gbc.gridx = 0;

        gbc.gridy = 4;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        panelRegister.add(new JLabel("Paese di nascita "), gbc);

        //Riga 5 -colonna 2(layout radio Paese)

        panelPaese = new JPanel();

        panelPaese.setLayout(new FlowLayout());

        italia = new JRadioButton("Italia");

        estero = new JRadioButton("Estero");

        gruppoRadioPaese = new ButtonGroup();

        gruppoRadioPaese.add(italia);

        gruppoRadioPaese.add(estero);

        panelPaese.add(italia);

        panelPaese.add(estero);

        italia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                esteriBox.setVisible(false);

                comuniBox.setVisible(true);
            }
        });

        estero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                comuniBox.setVisible(false);

                esteriBox.setVisible(true);
            }
        });

        gbc.gridx = 1;

        gbc.gridy = 4;

        gbc.weightx = 0.5;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        panelRegister.add(panelPaese, gbc);

        // Riga 6 - colonna 1 (Label luogo di nascita)

        gbc.gridx = 0;

        gbc.gridy = 5;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        panelRegister.add(new JLabel("Luogo di nascita "), gbc);

        // Riga 6 - colonna 2 (combobox comuni)

        String[] comuni = new String[8000];

        InputStream is = getClass().getResourceAsStream("/comuni.txt");

        InputStreamReader isr = new InputStreamReader(is);

        BufferedReader br = new BufferedReader(isr);

        int i = 0;

        String line;

        try {

            while((line = br.readLine()) != null)  {

                comuni[i++] = line;

            }

            br.close();
            isr.close();
            is.close();

        }

        catch(Exception e){

                //

        }


        comuniBox = new JComboBox<>(comuni);

        gbc.gridx = 1;

        gbc.gridy = 5;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        panelRegister.add(comuniBox, gbc);

        // Riga 6 - colonna 2 (combobox paesi Esteri)

        String[] esteri = new String[250];

        InputStream is2 = getClass().getResourceAsStream("/esteri.txt");

        InputStreamReader isr2 = new InputStreamReader(is2);

        BufferedReader br2 = new BufferedReader(isr2);

        int j = 0;

        String line2;

        try {

            while((line2 = br2.readLine()) != null)  {

                esteri[j++] = line2;

            }

            br2.close();
            isr2.close();
            is2.close();

        }

        catch(Exception e){

            //

        }


        esteriBox = new JComboBox<>(esteri);

        gbc.gridx = 1;

        gbc.gridy = 5;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        panelRegister.add(esteriBox, gbc);

        //Riga 7 - colonna 1 (Label codice fiscale)

        gbc.gridx = 0;

        gbc.gridy = 6;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        panelRegister.add(new JLabel("Codice fiscale "), gbc);

        //Riga 7 - colonna 2 (CF TextField)

        cf = new JTextField(20);

        panelCf = new JPanel();

        panelCf.setLayout(new FlowLayout());

        panelCf.add(cf);

        calcolaCF = new JButton("Calcola");

        panelCf.add(calcolaCF);

        gbc.gridx = 1;

        gbc.gridy = 6;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        panelRegister.add(panelCf, gbc);

        //Riga 8 - colonna 1 (Data di assunzione Label)

        gbc.gridx = 0;

        gbc.gridy = 7;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        panelRegister.add(new JLabel("Data assunzione "), gbc);

        //Riga 8 - colonna 2 (data di assunzione layout)

        panelAssunzione = new JPanel();

        panelAssunzione.setLayout(new FlowLayout());

        Date data2 = new Date();

        SpinnerDateModel modelloNascita2 = new SpinnerDateModel(data2,null,null, Calendar.YEAR);

        dataAssunzione = new JSpinner();

        dataAssunzione.setModel(modelloNascita2);

        JSpinner.DateEditor ded2 = new JSpinner.DateEditor(dataAssunzione,"dd/MM/yyyy");

        dataAssunzione.setEditor(ded2);

        panelAssunzione.add(new JLabel("(dd/mm/yyyy)"));

        panelAssunzione.add(dataAssunzione);

        gbc.gridx = 1;

        gbc.gridy = 7;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        panelRegister.add(panelAssunzione, gbc);

        //Riga 9 - colona 1 Label dirigente)

        gbc.gridx = 0;

        gbc.gridy = 8;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        panelRegister.add(new JLabel("Dirigente"), gbc);

        //Riga 9 - colonna 2 (checkBox dirigente)

        dirigenteCheck = new JCheckBox();

        gbc.gridx = 1;

        gbc.gridy = 8;

        gbc.weightx = 0.01;

        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        panelRegister.add(dirigenteCheck, gbc);

        //Riga 10 - colonna 1 (bottone finale)

        gbc.gridx = 0;

        gbc.gridy = 9;

        gbc.weightx = 0.01;

        gbc.weighty = 0.3;

        gbc.gridwidth = 3;

        gbc.anchor = GridBagConstraints.CENTER;

        gbc.insets = new Insets(0,0,0,0);

        aggiungi = new JButton("Aggiungi impiegato");

        panelRegister.add(aggiungi, gbc);

        //Costruisci Frame

        add(panelRegister);

        setVisible(true);



    }
}
