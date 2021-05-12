package paintapplication;

import Formulario.SelecionMateria;
import painttools.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

public class PaintMenuBar extends JMenuBar {

    JMenu file;
    JMenuItem quit;
    JMenuItem saveSketch;

    PaintMenuBar() {
        PaintMenuBar.ItemHandler itemHandler = new PaintMenuBar.ItemHandler();

        file = new JMenu("Archivo");

        saveSketch = new JMenuItem("Guardar");
        quit = new JMenuItem("Salir");

        saveSketch.addActionListener(itemHandler);
        quit.addActionListener(itemHandler);

        file.add(saveSketch);
        file.addSeparator();
        file.add(quit);

        add(file);
    }

    private class ItemHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == quit) {
                SelecionMateria.paint.dispose();
            }

            if (event.getSource() == saveSketch) {
                SelecionMateria.paint.saveFile();
            }

            SelecionMateria.paint.repaint();
            setFocusable(false);
        }
    }
}
