 

package paintshapetools;

import painttools.*;

import paintdrawtools.*;

import java.awt.*;

public abstract class DragElement extends PaintElement
{
    protected Point sPoint;
    protected Point fPoint;

    public DragElement(Color clr, Point pt1, Point pt2, int dim, StrokeStyle style)
    {
        super(clr, dim, style);
        
        sPoint = pt1;
        fPoint = pt2;
    }

    public Point getSPoint()
    {
        return sPoint;
    }

    public Point getFPoint()
    {
        return fPoint; 
    }

    public abstract void update(Graphics g);
}