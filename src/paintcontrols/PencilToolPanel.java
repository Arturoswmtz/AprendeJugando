
package paintcontrols;

import Formulario.SelecionMateria;
import painttools.Tool;
import painttools.StrokeStyle;
import paintdrawtools.*;
import paintapplication.*;
import myutilities.*;
import painttools.*;

import paintvisuals.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class PencilToolPanel extends ToolOptionPanel
{

    public StrokeStyle[] strokeStyleList ={StrokeStyle.DOT_CIRC, StrokeStyle.DOT_RECT,
                                           StrokeStyle.LINE,     StrokeStyle.TRIANGLE,
                                           StrokeStyle.RIBBON };
    protected JSlider strokeSlider;

    protected JPanel showStrokePanel;

    protected StrokePanel showStroke;

    public PencilToolPanel(Tool tool, int stroke)
    {
        super(tool);

        setLayout(new FlowLayout());

        strokeSlider = new JSlider(SwingConstants.HORIZONTAL, 0, 16, 1);
        strokeSlider.setPaintTicks(false);
        strokeSlider.setMaximum(16);
        strokeSlider.setMinimum(1);
        strokeSlider.setMajorTickSpacing(1);

        strokeSlider.setValue(stroke);
        strokeSlider.revalidate();

        SlideChangeListener listener = new SlideChangeListener();
        strokeSlider.addChangeListener(listener);

        for(int i=0; i<3; i++)
        {
       //     styleIcons[i] = new ImageIcon(getClass().getResource("style"+(i+1)+".png"));
        }

        showStroke = new StrokePanel();
        showStrokePanel = new JPanel();
        showStrokePanel.setPreferredSize(new Dimension(92, 92));
        showStrokePanel.setLayout(new FlowLayout());
        showStrokePanel.add(showStroke, BorderLayout.CENTER);

        add(showStrokePanel);
        add(strokeSlider);
    }

    private class SlideChangeListener implements ChangeListener
    {
        @Override
        public void stateChanged(ChangeEvent event)
        {
            SelecionMateria.paint.drawPanel.tool.setStrokeWidth(strokeSlider.getValue());
            repaint();
            System.out.println("Tool: "+SelecionMateria.paint.drawPanel.tool+"  - - Stroke: "+ SelecionMateria.paint.drawPanel.tool.getStroke());
        }
    }
}

