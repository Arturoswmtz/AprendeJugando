package paintapplication;

import Formulario.SelecionMateria;
import painttools.Tool;
import myutilities.*;
import paintdrawtools.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList; 

public class ColorPicker extends JPanel
{
    protected ColorOptionBox[] colorOptions; 
    protected ArrayList points;

    protected JPanel currentClrPanel;

    protected Color[] colors;

    protected Color color;
    
    public ColorPicker()
    {
        setBackground(Color.darkGray);
        setPreferredSize(new Dimension(92, 92));
        setLayout(new BorderLayout());
        colors = new Color[32];
        int count=0;
        for(int i=1; i<5; i++){
            for(int j=1; j<5; j++){
                for(int k=1; k<3; k++){
                    colors[count] = new Color(i*51, j*51, k*127);
                    count++;
                }
            }
        }
        
        color  = Color.black;
        
        currentClrPanel = new JPanel();
        currentClrPanel.setBackground(Color.white);
        currentClrPanel.setPreferredSize(new Dimension(92,92));
        
        currentClrPanel.addMouseListener(
            new MouseAdapter()
            {
                @Override
                public void mousePressed(MouseEvent event)
                {
                    if (SelecionMateria.paint.drawPanel.getTool() != Tool.ERASER)
                    {
                        currentClrPanel.setBackground(
                                    JColorChooser.showDialog( SelecionMateria.paint, "Change Color",
                                                         SelecionMateria.paint.drawPanel.brushColor));
                        color = currentClrPanel.getBackground();
                        SelecionMateria.paint.drawPanel.tool.setColor(currentClrPanel.getBackground());
                        SelecionMateria.paint.drawPanel.setBrushColor(color);
                        
                    }
                }
            }
        );

        JPanel colorGrid = new JPanel();
        colorGrid.setBackground(Color.darkGray);
        colorGrid.setLayout(new GridLayout(2, 16, 6, 6));

        colorOptions = new ColorOptionBox[colors.length];

        for(int i=0; i<colorOptions.length; i++)
        {
            colorOptions[i] = new ColorOptionBox(colors[i]);
            colorGrid.add(colorOptions[i]);
        }

        ColorPanel holder = new ColorPanel(Color.darkGray);
        holder.setLayout(new BorderLayout(6, 6));

        holder.add(currentClrPanel, BorderLayout.WEST);
        holder.add(colorGrid, BorderLayout.CENTER);

        JPanel holder2 = new JPanel();
        holder2.setLayout(new BorderLayout());
        holder2.add(new ColorPanel(Color.darkGray), BorderLayout.WEST);
        holder2.add(new ColorPanel(Color.darkGray), BorderLayout.EAST);
        holder2.add(new ColorPanel(Color.darkGray), BorderLayout.SOUTH);
        holder2.add(new ColorPanel(Color.darkGray), BorderLayout.NORTH);

        holder2.add(holder, BorderLayout.CENTER);
        add(holder2, BorderLayout.CENTER);
    }

    public void deselectAll()
    {
        for(int i=0; i<colorOptions.length; i++)
        {
            colorOptions[i].selected = false;
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }
}
