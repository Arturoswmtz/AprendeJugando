 
package paintdrawtools;

import Formulario.SelecionMateria;
import painttools.StrokeStyle;
import paintapplication.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class EraserElement extends BrushElement
{
    public EraserElement(Point pt, Color clr, int dim, StrokeStyle style)
    {
        super(pt, clr, dim, style);
    }

    @Override
    public void update(Graphics g)
    {
        if (strokeStyle == StrokeStyle.DOT_CIRC)
        {
            g.setColor(SelecionMateria.paint.drawPanel.getBackground());
            g.fillOval(coors.x, coors.y, strokeWidth, strokeWidth);
        }
        if (strokeStyle != StrokeStyle.DOT_CIRC)
        {
            g.setColor(SelecionMateria.paint.drawPanel.getBackground());
            g.fillRect(coors.x, coors.y, strokeWidth, strokeWidth);
        }
    }
}
