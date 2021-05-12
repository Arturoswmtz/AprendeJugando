
package painttools;

import painttools.StrokeStyle;
import painttools.AbstractTool;
import java.awt.*;
import paintdrawtools.PaintElement;


public abstract class PaintTool extends AbstractTool
{   
    protected PaintElement element; 

    public PaintTool(Color clr, int dim)
    {
        super(clr, dim);
        
        isDrawing = false;
    }
    
    public PaintElement getElement()
    {
        return element; 
    }

    public abstract void drawElement(Graphics g);
}
