

package paintvisuals;

import Formulario.SelecionMateria;
import painttools.StrokeStyle;


import java.awt.*;
import javax.swing.*;

public class StrokePanel extends JPanel
{
    public StrokeStyle style;

    public StrokePanel()
    {
        setPreferredSize(new Dimension(84, 84));
        style = StrokeStyle.DOT_RECT;
    }

    public void setStyle(StrokeStyle style)
    {
        this.style = style; 
    }

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(SelecionMateria.paint.drawPanel.tool.getColor());

        if ( ( style == StrokeStyle.DOT_RECT) || (style == StrokeStyle.SQUARE) ||
             ( style == StrokeStyle.LINE)     || (style == StrokeStyle.FILL_RECT ))
        {
            g.fillRect(getWidth ()/2-SelecionMateria.paint.drawPanel.tool.getStroke()/2,
                   getHeight()/2-SelecionMateria.paint.drawPanel.tool.getStroke()/2,
                                 SelecionMateria.paint.drawPanel.tool.getStroke(),
                                 SelecionMateria.paint.drawPanel.tool.getStroke());

            g.setColor(Color.black);
            g.drawRect(getWidth ()/2-SelecionMateria.paint.drawPanel.tool.getStroke()/2,
                   getHeight()/2-SelecionMateria.paint.drawPanel.tool.getStroke()/2,
                                 SelecionMateria.paint.drawPanel.tool.getStroke(),
                                 SelecionMateria.paint.drawPanel.tool.getStroke());
        }
        if ( (style == StrokeStyle.DOT_CIRC) || (style == StrokeStyle.CIRCLE) ||
             (style == StrokeStyle.FILL_OVAL) )
        {
            g.fillOval(getWidth ()/2-SelecionMateria.paint.drawPanel.tool.getStroke()/2,
                   getHeight()/2-SelecionMateria.paint.drawPanel.tool.getStroke()/2,
                                 SelecionMateria.paint.drawPanel.tool.getStroke(),
                                 SelecionMateria.paint.drawPanel.tool.getStroke());

            g.setColor(Color.black);
            g.drawOval(getWidth ()/2-SelecionMateria.paint.drawPanel.tool.getStroke()/2,
                   getHeight()/2-SelecionMateria.paint.drawPanel.tool.getStroke()/2,
                                 SelecionMateria.paint.drawPanel.tool.getStroke(),
                                 SelecionMateria.paint.drawPanel.tool.getStroke());
        }
        if ( (style == StrokeStyle.OPEN_OVAL) )
        {
            g.drawOval(getWidth ()/2-SelecionMateria.paint.drawPanel.tool.getStroke()/2,
                   getHeight()/2-SelecionMateria.paint.drawPanel.tool.getStroke()/2,
                                 SelecionMateria.paint.drawPanel.tool.getStroke(),
                                 SelecionMateria.paint.drawPanel.tool.getStroke());
        }
        if ( (style == StrokeStyle.OPEN_RECT) )
        {
            g.drawRect(getWidth ()/2-SelecionMateria.paint.drawPanel.tool.getStroke()/2,
                   getHeight()/2-SelecionMateria.paint.drawPanel.tool.getStroke()/2,
                                 SelecionMateria.paint.drawPanel.tool.getStroke(),
                                 SelecionMateria.paint.drawPanel.tool.getStroke());
        }
    }
}