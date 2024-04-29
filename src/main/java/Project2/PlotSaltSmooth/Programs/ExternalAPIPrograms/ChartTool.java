package Project2.PlotSaltSmooth.Programs.ExternalAPIPrograms;

import Project2.PlotSaltSmooth.Structures.Tuple;
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
public class ChartTool {

    /**
     * Creates the JFrame Window to display the chart.
     * @param windowTitle displayed title in the top bar of the JFrame
     * @param width the width of the JFrame window in pixels
     * @param height the height of the JFrame window in pixels
     * @return the JFrame object with labels, sections and title.
     */
    public JFrame makeWindow(String windowTitle, int width, int height) {
        //object representing display window
        JFrame window = new JFrame();
        //set the chart title
        if(windowTitle == null || windowTitle.isEmpty()) {
            window.setTitle("JFrame GUI");
        }else{
            window.setTitle(windowTitle);
        }
        //set size
        if(width <= 0 || height <= 0) {
            window.setSize(800, 600);
        }else{
            window.setSize(width, height);
        }
        //set the frame layout
        window.setLayout(new BorderLayout());
        //action to close the window when clicking x at top right
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return window;
    }

    /**
     * creates the series collection object to hold each point for plotting on the graph.
     * @param theData the data to plot
     * @param seriesName the name of the plotted data series
     * @return the instantiated XYSeriesCollection object.
     */
    public XYSeriesCollection plotData(ArrayList<Tuple<Double>> theData, String seriesName){
        //create series object to hold data
        XYSeries series = new XYSeries(seriesName);
        //add each tuple to the series
        for(Tuple<Double> t : theData){
            series.add(t.getInput(), t.getOutput());
        }
        //collection object holds series data for charting
        return new XYSeriesCollection(series);
    }

    /**
     * runs the chart tool, creating the window object, populating a series with the passed data,
     * and using JFreeChart to create a scatter plot displayed in a JFrame Window.
     * @param theData inputs and their associated outputs as tuples.
     * @param chartName the name of the chart
     * @param seriesLabels labels for the x and y axis.
     */
    public void runProgram(ArrayList<Tuple<Double>> theData, String chartName, String[] seriesLabels){
        //create the window
        JFrame theWindow = makeWindow(chartName, 0, 0);
        //create the chart using JFreeChart
        JFreeChart theChart = ChartFactory.createScatterPlot(chartName, seriesLabels[0],
                seriesLabels[1], plotData(theData, seriesLabels[1]));
        //add the chart to the middle of the window
        theWindow.add(new ChartPanel(theChart), BorderLayout.CENTER);
        //display the window
        theWindow.setVisible(true);
    }
}