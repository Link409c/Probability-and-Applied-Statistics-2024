package Project2.PlotSaltSmooth.Programs.ExternalAPIPrograms;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Implementation of the JFreeChart Library methods to display a plot of data.
 */
public class ChartTool<E> {

    public void createChart(ArrayList<E> inputPoints, ArrayList<E> outputPoints,
                            String chartName, String[] seriesLabels){

        //create the window

        //object representing display window
        JFrame window = new JFrame();
        //set the chart title
        window.setTitle("Chart GUI");
        //set size
        window.setSize(800, 600);
        //set the frame layout
        window.setLayout(new BorderLayout());
        //action to close the window when clicking x at top right
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create the data display section

        //labels for x and y value of points on mouseover
        JLabel inputLabel = new JLabel(String.valueOf(getCurrentInput()));
        JLabel outputLabel = new JLabel(String.valueOf(getCurrentOutput()));
        //separation of window for data display
        JPanel legend = new JPanel();
        //add data display to legend area
        legend.add(inputLabel);
        legend.add(outputLabel);
        //set legend position at bottom
        window.add(legend, BorderLayout.SOUTH);

        //create the series and data set objects

        //use passed data points to create series
        XYSeries y1 = new XYSeries(seriesLabels[1]);
        XYSeriesCollection data = new XYSeriesCollection(y1);

        //create the chart

        //create the chart using JFreeChart
        JFreeChart theChart = ChartFactory.createScatterPlot(chartName, seriesLabels[0],
                seriesLabels[1], data);
        //add the chart to the middle of the window
        window.add(new ChartPanel(theChart), BorderLayout.CENTER);

        //plot the data


    }

    public E getCurrentInput() {
        return currentInput;
    }

    public void setCurrentInput(E currentInput) {
        this.currentInput = currentInput;
    }

    public E getCurrentOutput() {
        return currentOutput;
    }

    public void setCurrentOutput(E currentOutput) {
        this.currentOutput = currentOutput;
    }

    /**
     * the x-axis value of a point on the plot.
     */
    private E currentInput;

    /**
     * the y-axis value of a point on the plot.
     */
    private E currentOutput;
}
