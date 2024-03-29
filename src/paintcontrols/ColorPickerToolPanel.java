package paintcontrols;

import myutilities.*;
import painttools.*;

import java.awt.*;
import javax.swing.*;

public class ColorPickerToolPanel extends ToolOptionPanel
{
    protected Color color;
    protected JPanel showColor;

    public ColorPickerToolPanel(Tool tool, Color clr)
    {
        super(tool);

        showColor = new ColorPanel(color);
        showColor.setPreferredSize(new Dimension(150, 120));

        add(showColor, BorderLayout.NORTH);
    }

    @Override
    public void setColor(Color clr)
    {
        showColor.setBackground(clr);
        color = clr;
    }
    public Color getColor()
    {
        return color; 
    }
}
