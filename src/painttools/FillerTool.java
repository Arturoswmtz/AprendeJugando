
package painttools;

import Formulario.SelecionMateria;
import paintapplication.*;
import paintdrawtools.*;

import java.awt.*;

public class FillerTool extends AbstractTool
{
    public FillerTool(Color clr, int stroke)
    {
        super(clr, stroke);
    }

    public void fillAllSides(Point point, Color color)
    {
        Robot robot;
        try
        {
            System.out.println(point);

            robot = new Robot();
            Color[] neswClrs = new Color[4];

            neswClrs[0] = robot.getPixelColor(point.x-1, point.y);
            neswClrs[1] = robot.getPixelColor(point.x+1, point.y);
            neswClrs[2] = robot.getPixelColor(point.x, point.y+1);
            neswClrs[3] = robot.getPixelColor(point.x, point.y-1);

            robot = null;

            if (neswClrs[0] != SelecionMateria.paint.drawPanel.getBackground())
            {
                robot.mouseMove(point.x-1, point.y);
                SelecionMateria.paint.drawPanel.elements.add(new BrushElement(SelecionMateria.paint.drawPanel.getMousePosition(), color, 1, StrokeStyle.DOT_RECT));
                System.out.println(SelecionMateria.paint.drawPanel.getMousePosition());
                SelecionMateria.paint.drawPanel.repaint();
                fillAllSides(new Point(point.x-1, point.y), color);
            }
            if (neswClrs[1] == SelecionMateria.paint.drawPanel.getBackground())
            {
                robot.mouseMove(point.x-1, point.y);
                SelecionMateria.paint.drawPanel.elements.add(new BrushElement(SelecionMateria.paint.drawPanel.getMousePosition(), color, 1, StrokeStyle.DOT_RECT));
                SelecionMateria.paint.drawPanel.repaint();
                fillAllSides(new Point(point.x+1, point.y), color);
            }
            if (neswClrs[2] == SelecionMateria.paint.drawPanel.getBackground())
            {
                robot.mouseMove(point.x-1, point.y);
                SelecionMateria.paint.drawPanel.elements.add(new BrushElement(SelecionMateria.paint.drawPanel.getMousePosition(), color, 1, StrokeStyle.DOT_RECT));
                SelecionMateria.paint.drawPanel.repaint();
                fillAllSides(new Point(point.x, point.y+1), color);
            }
            if (neswClrs[3] == SelecionMateria.paint.drawPanel.getBackground())
            {
                robot.mouseMove(point.x-1, point.y);
                SelecionMateria.paint.drawPanel.elements.add(new BrushElement(SelecionMateria.paint.drawPanel.getMousePosition(), color, 1, StrokeStyle.DOT_RECT));
                SelecionMateria.paint.drawPanel.repaint();
                fillAllSides(new Point(point.x, point.y-1), color);
            }
        }
        catch (AWTException exception)
        {
            exception.printStackTrace();
        }
    }
}
