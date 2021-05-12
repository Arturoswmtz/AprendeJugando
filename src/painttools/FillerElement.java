package painttools;

import Formulario.SelecionMateria;
import paintdrawtools.PaintElement;

import java.awt.Graphics;
import java.awt.Color;

public class FillerElement extends PaintElement
{
    public FillerElement(Color clr)
    {
        super(clr);
    }

    @Override
    public void update(Graphics g)
    {
        SelecionMateria.paint.drawPanel.setBackground(color);
        SelecionMateria.paint.drawPanel.backgroundColor = color;
        SelecionMateria.paint.drawPanel.repaint();
    }
}
