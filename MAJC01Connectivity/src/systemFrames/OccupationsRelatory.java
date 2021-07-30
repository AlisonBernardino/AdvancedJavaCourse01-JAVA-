package systemFrames;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import systemFiles.databaseConfiguration;
import systemFiles.appNavigator;

public class OccupationsRelatory extends JPanel{
    JLabel titleLabel, descriptionLabel;
    
    public OccupationsRelatory(){
        createRelatoryComponents();
        createRelatoryEvents();
        appNavigator.enableMenu();
    }
    
    private void createRelatoryComponents(){
        setLayout(null);
        
        titleLabel = new JLabel("Triple S - Occupations relatories", JLabel.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 21));
        descriptionLabel = new JLabel("This graphic shows the operators quantity per occupation", JLabel.CENTER);
        DefaultPieDataset graphicData = this.createGraphicData();
        
        JFreeChart graphicsChart = ChartFactory.createPieChart3D("", graphicsChart, false, true, false);
        PiePlot graphicsPlot = (PiePlot) graphicsChart.getPlot();
        graphicsPlot.setLabelBackgroundPaint(Color.WHITE);
        graphicsPlot.setBackgroundPaint(null);
        graphicsPlot.setOutlinePaint(null);
        graphicsChart.setBackgroundPaint(null);
        
        PieSectionLabelGenerator pieSectionGenerator = new StandardPieSectionLabelGenerator("{0}: {1} {2}",
        new DecimalFormat("0"), new DecimalFormat("0"));
        graphicsPlot.setLabelGenerator(pieSectionGenerator);
        
        ChartPanel graphicsChartPanel = new ChartPanel(graphicsChart){
            @Override
            public 
        };
    }
}
