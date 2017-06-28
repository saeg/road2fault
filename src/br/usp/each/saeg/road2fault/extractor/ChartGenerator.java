package br.usp.each.saeg.road2fault.extractor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.Paint;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jfree.util.SortOrder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LayeredBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;



public class ChartGenerator{ //extends ApplicationFrame{
	
	private final String FILE_PATH = "/home/higor/data/analysis-dci2013/files-xml/";
	private final String FILE_EXT = ".png";
	private final String FONT = "TimesRoman";
	public enum ChartType{
		BarChart,LayeredBarChart,LineChart
	}
	
	public ChartGenerator(){}
	
	/*public ChartGenerator(final String title){
		super(title);
		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500,270));
		setContentPane(chartPanel);
	}*/
	
	private List<Paint> createColorList(){
		List<Paint> colorList = new ArrayList<Paint>();
		Point2D startPoint = new Point2D.Float(0,0);
		Point2D streightPoint = new Point2D.Float(0,2);
		Point2D diagonalPoint = new Point2D.Float(2,2);
		float thickness[] = {0.2f, 0.8f};
		Color blackWhite[] = {Color.black,Color.white};
		Color grayWhite[] = {Color.gray,Color.white};
		LinearGradientPaint blackWhiteStraight = new LinearGradientPaint(startPoint, streightPoint, thickness, blackWhite,CycleMethod.REPEAT);
		LinearGradientPaint blackWhiteDiagonal = new LinearGradientPaint(startPoint, diagonalPoint, thickness, blackWhite,CycleMethod.REPEAT);
		LinearGradientPaint grayWhiteStraight = new LinearGradientPaint(startPoint, streightPoint, thickness, grayWhite,CycleMethod.REPEAT);
		LinearGradientPaint grayWhiteDiagonal = new LinearGradientPaint(startPoint, diagonalPoint, thickness, grayWhite,CycleMethod.REPEAT);
		
		colorList.add(Color.black); 
		colorList.add(new Color(160,160,160)); //light gray
		colorList.add(new Color(96,96,96)); //dark gray
		colorList.add(new Color(85,177,69)); //green
	    colorList.add(Color.red); 
		colorList.add(Color.blue); 
		colorList.add(blackWhiteStraight); 
		colorList.add(new Color(0,102,0)); //dark green
		colorList.add(grayWhiteStraight); 
		colorList.add(blackWhiteDiagonal); 
		colorList.add(grayWhiteDiagonal); 
		colorList.add(new Color(0,172,178)); //blue
        colorList.add(new Color(239,70,55)); //red                 		
        colorList.add(Color.orange); 
        colorList.add(Color.gray); 
        colorList.add(Color.cyan); 
        colorList.add(Color.magenta); 
        colorList.add(Color.pink); 
        
        return colorList;
	}
	
	
    public void loadBarChartDataset(List<List<String>> dataList, ChartType type, String title, String xAxisTitle, String yAxisTitle, String chartTitle, String fileName){
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	for(List<String> data : dataList){
    		dataset.addValue(Double.parseDouble(data.get(0)), data.get(1), data.get(2));
    	}
		if(type == ChartType.LayeredBarChart){
			createLayeredBarChart(dataset,chartTitle,xAxisTitle,yAxisTitle,fileName);
		}else{
			createBarChart(dataset,chartTitle,xAxisTitle,yAxisTitle,fileName);
		}
    }
    
    public void loadLineChartDataset(Map<String,List<String>> dataList, String title, String xAxisTitle, String yAxisTitle, String chartTitle, String fileName){
    	XYSeriesCollection dataset = new XYSeriesCollection();
    	Set<String> seriesDataList = dataList.keySet();
    	for(String seriesName: seriesDataList){
    		List<String> seriesList = dataList.get(seriesName);
    		XYSeries series = new XYSeries(seriesName);
    		for(int index = 0; index < seriesList.size(); index+=2){
    			double x = Double.parseDouble(seriesList.get(index));
    			double y = Double.parseDouble(seriesList.get(index+1));
    			series.add(x,y);
    		}
    		dataset.addSeries(series);
    	}
    	createLineChart(dataset,chartTitle,xAxisTitle,yAxisTitle,fileName);
    }
    
    
    private void createBarChart(final CategoryDataset dataset,String title, String xAxisTitle, String yAxisTitle, String fileName){//String heuristic, String programName, String range, String details, String description){
		List<Paint> colorList = createColorList();
		Font titleFont = new Font(FONT, Font.BOLD, 20);
		Font labelAxisFont = new Font(FONT, Font.BOLD, 16);
		Font budgetSeriesFont = new Font(FONT, Font.PLAIN, 14);
		Font effortRangeFont = new Font(FONT, Font.PLAIN, 14);
		Font legendFont = new Font(FONT, Font.PLAIN, 10);
		Font barFont = setBarLabelFontSize(FONT,dataset.getRowCount());
		        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            title,      // chart title
            xAxisTitle,                      // x axis label
            yAxisTitle,                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );
        
        chart.setBackgroundPaint(Color.white);
        
        //set the chart's font
        TextTitle chartTitle = chart.getTitle();
        chartTitle.setFont(titleFont);
                       
        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.black);
        plot.setOutlineVisible(true);
        
        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        renderer.setGradientPaintTransformer(null);
        //renderer.setMinimumBarLength(.1);
        renderer.setItemMargin(0.05);
        renderer.setBarPainter(new StandardBarPainter());
        for(Paint paint : colorList){
        	renderer.setSeriesPaint(colorList.indexOf(paint), paint);
        }
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelFont(barFont);
                        
        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);//.createUpRotationLabelPositions(Math.PI / 6.0)
        domainAxis.setCategoryMargin(0.2);
        domainAxis.setTickLabelFont(budgetSeriesFont);
        domainAxis.setLabelFont(labelAxisFont);
        //domainAxis.setCategoryLabelPositionOffset(4);
        domainAxis.setLowerMargin(0.01);//set margin
        domainAxis.setUpperMargin(0.01);
        
        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setTickLabelFont(effortRangeFont);
        rangeAxis.setLabelFont(labelAxisFont);
        
        final LegendTitle legend = chart.getLegend();
        legend.setPosition(RectangleEdge.TOP);
        legend.setItemFont(legendFont);
                 
        createImageFile(chart,fileName);
        
    }
    
    private void createLayeredBarChart(final CategoryDataset dataset,String title, String xAxisTitle, String yAxisTitle, String fileName){//String heuristic, String programName, String range, String details, String requirement){
    	List<Paint> colorList = createColorList();
		Font titleFont = new Font(FONT, Font.BOLD, 20);
		Font labelAxisFont = new Font(FONT, Font.BOLD, 16);
		Font budgetSeriesFont = new Font(FONT, Font.PLAIN, 14);
		Font effortRangeFont = new Font(FONT, Font.PLAIN, 14);
		Font legendFont = new Font(FONT, Font.PLAIN, 10);
		Font barFont = new Font(FONT, Font.PLAIN, 5);
    	
		CategoryAxis categoryAxis = new CategoryAxis(xAxisTitle);
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);//.createUpRotationLabelPositions(Math.PI / 6.0)
        categoryAxis.setCategoryMargin(0.2);
        categoryAxis.setTickLabelFont(budgetSeriesFont);
        categoryAxis.setLabelFont(labelAxisFont);
        //categoryAxis.setCategoryLabelPositionOffset(4);
        categoryAxis.setLowerMargin(0.01);
        categoryAxis.setUpperMargin(0.01);
         
     	NumberAxis rangeAxis = new NumberAxis(yAxisTitle);
     	rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());//shows only integer numbers
        rangeAxis.setTickLabelFont(effortRangeFont);
        rangeAxis.setLabelFont(labelAxisFont);
		
    	CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, rangeAxis, new LayeredBarRenderer());
    	plot.setOrientation(PlotOrientation.VERTICAL);
    	plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.black);
        plot.setOutlineVisible(true);
    	
    	JFreeChart chart = new JFreeChart(title, titleFont, plot, true);
    	chart.setBackgroundPaint(Color.white);
    	
    	LayeredBarRenderer renderer = (LayeredBarRenderer) plot.getRenderer();
    	renderer.setDrawBarOutline(false);
        renderer.setGradientPaintTransformer(null);
        //renderer.setMinimumBarLength(.1);
        renderer.setItemMargin(0.05);
        renderer.setBarPainter(new StandardBarPainter());
        for(Paint paint : colorList){
        	renderer.setSeriesPaint(colorList.indexOf(paint), paint);
        }
        //renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        //renderer.setBaseItemLabelsVisible(true);
        //renderer.setBaseItemLabelFont(barFont);
        for(int i = 0; i < dataset.getRowCount();i++){//good proportion to deal with the bar's widths
        	renderer.setSeriesBarWidth(i, (double)(dataset.getRowCount()-i)/(dataset.getRowCount()+i));
        }
        
        LegendTitle legend = chart.getLegend();
        legend.setPosition(RectangleEdge.TOP);
        legend.setItemFont(legendFont);
                  
        createImageFile(chart,fileName);
     	
    }
    
    private void createLineChart(XYDataset dataset,String title, String xAxisTitle, String yAxisTitle, String fileName){//String heuristic, String programName, String range, String details, String requirement){
    	List<Paint> colorList = createColorList();
		Font titleFont = new Font(FONT, Font.BOLD, 20);
		Font labelAxisFont = new Font(FONT, Font.BOLD, 16);
		Font seriesFont = new Font(FONT, Font.PLAIN, 10);
		Font effortRangeFont = new Font(FONT, Font.PLAIN, 12);
		Font legendFont = new Font(FONT, Font.PLAIN, 10);
		        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            title,     							 	// chart title
            xAxisTitle,                      	// x axis label
            yAxisTitle,                      	// y axis label
            dataset,                  			// data
            PlotOrientation.VERTICAL,
            true,                     			// include legend
            false,                     			// tooltips
            false                     			// urls
        );
        
        chart.setBackgroundPaint(Color.white);
        
        //set the chart's font
        TextTitle chartTitle = chart.getTitle();
        chartTitle.setFont(titleFont);
        
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainCrosshairVisible(true);
         
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        //renderer.setSeriesLinesVisible(0, false);
       /* for(int i = 0; i < dataset.getSeriesCount(); i++){//remove line points
        	renderer.setSeriesShapesVisible(i,false);
        }*/
        for(int i = 0; i < dataset.getSeriesCount(); i++){//thickness and style
        	if(i%2==0){
        		renderer.setSeriesStroke(i, new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f, new float[]{10.0f,6.0f}, 0.0f));
        	}else if(i%3==0){
        		renderer.setSeriesStroke(i, new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER, 1.0f, new float[]{6.0f,6.0f}, 0.0f));
        	}else{
        		renderer.setSeriesStroke(i, new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 1.0f, new float[]{2.0f,6.0f}, 0.0f));
        	}
        }
        for(Paint paint : colorList){
        	renderer.setSeriesPaint(colorList.indexOf(paint), paint);
        }
        //renderer.setSeriesShape(0, getShapes()[0]);
        plot.setRenderer(renderer);
        
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        domainAxis.setTickLabelFont(seriesFont);
        domainAxis.setLabelFont(labelAxisFont);
        domainAxis.setRange(0, 100);
        domainAxis.setTickUnit(new NumberTickUnit(5));
        
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setTickLabelFont(effortRangeFont);
        rangeAxis.setLabelFont(labelAxisFont);
        rangeAxis.setRange(0,102);
        rangeAxis.setTickUnit(new NumberTickUnit(10));
        
        LegendTitle legend = chart.getLegend();
        legend.setPosition(RectangleEdge.TOP);
        legend.setItemFont(legendFont);
        legend.setSortOrder(SortOrder.DESCENDING);
        
                 
        createImageFile(chart,fileName);
        
    }
        
    private Shape[] getShapes(){
    	final Shape[] shapes = new Shape[3];
        int[] xpoints;
        int[] ypoints;

        // right-pointing triangle
        xpoints = new int[] {-3, 3, -3};
        ypoints = new int[] {-3, 0, 3};
        shapes[0] = new Polygon(xpoints, ypoints, 3);

        // vertical rectangle
        shapes[1] = new Rectangle2D.Double(-2, -3, 3, 6);

        // left-pointing triangle
        xpoints = new int[] {-3, 3, 3};
        ypoints = new int[] {0, -3, 3};
        shapes[2] = new Polygon(xpoints, ypoints, 3);
        
        return shapes;
    }
    
    
    private void createImageFile(JFreeChart chart,String fileName){
    	
    	File imageChart = new File(FILE_PATH+fileName+FILE_EXT);
        try {
			ChartUtilities.saveChartAsPNG(imageChart, chart, 1680, 1050);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private Font setBarLabelFontSize(String fontName, int barsPerCategory){
    	Font barFont; 
    	int size = 0;
    	if(barsPerCategory <= 4){
    		size = 14;
    	}else if(barsPerCategory > 4 && barsPerCategory <= 8){
    		size = 10;
    	}else if(barsPerCategory > 8 && barsPerCategory <= 12){
    		size = 7;
    	}else{
    		size = 5;
    	}
    		
    	barFont= new Font(fontName, Font.PLAIN, size);
    	return barFont;
    }
    
    
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the data for the chart.
     * 
     * @return a chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "Chart Demo",      // chart title
            "Category",                      // x axis label
            "Value",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);
        
        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.black);
        plot.setOutlineVisible(true);
        
       
     // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        List<Paint> colorList = new ArrayList<Paint>();
        colorList.add(new Color(0,172,178)); //blue
        colorList.add(new Color(239,70,55)); //red                 		
        colorList.add(new Color(85,177,69)); //green
        
        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        renderer.setGradientPaintTransformer(null);
        renderer.setBarPainter(new StandardBarPainter());
        for(Paint paint : colorList){
        	renderer.setSeriesPaint(colorList.indexOf(paint), paint);
        }
        
        Font seriesFont = new Font("TimesRoman", Font.PLAIN, 10);
                
        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);//.createUpRotationLabelPositions(Math.PI / 6.0)
        domainAxis.setCategoryMargin(0.2);
        domainAxis.setTickLabelFont(seriesFont);
        //domainAxis.setCategoryLabelPositionOffset(4);
        
        final LegendTitle legend = chart.getLegend();
        legend.setPosition(RectangleEdge.TOP);
        legend.setItemFont(seriesFont);
        
         
        File barChart = new File("/home/higor/workspace/chart.png");
        try {
			ChartUtilities.saveChartAsPNG(barChart, chart, 800, 600);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return chart;
    }
	
    /**
     * Creates a sample dataset.
     * 
     * @return a sample dataset.
     */
    private CategoryDataset createDataset() {
        
    	// row keys...
        final String series1 = "First";
        final String series2 = "Second";
        final String series3 = "Third";

        // column keys...
        final String category1 = "Category 1";
        final String category2 = "Category 2";
        final String category3 = "Category 3";
        final String category4 = "Category 4";
        final String category5 = "Category 5";
    	
     // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, series1, category1);
        dataset.addValue(4.0, series1, category2);
        dataset.addValue(3.0, series1, category3);
        dataset.addValue(5.0, series1, category4);
        dataset.addValue(5.0, series1, category5);

        dataset.addValue(5.0, series2, category1);
        dataset.addValue(7.0, series2, category2);
        dataset.addValue(6.0, series2, category3);
        dataset.addValue(8.0, series2, category4);
        dataset.addValue(4.0, series2, category5);

        dataset.addValue(4.0, series3, category1);
        dataset.addValue(3.0, series3, category2);
        dataset.addValue(2.0, series3, category3);
        dataset.addValue(3.0, series3, category4);
        dataset.addValue(6.0, series3, category5);
                
        return dataset;
        
    }
    
}
