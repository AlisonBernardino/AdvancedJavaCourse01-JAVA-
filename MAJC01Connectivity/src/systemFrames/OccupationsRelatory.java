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
            public Dimension getPreferredSize(){
                return new Dimension(661,341);
            }
        };
        
        titleLabel.setBounds(21,21,661,41);
        descriptionLabel.setBounds(21,51,661,41);
        graphicsChartPanel.setBounds(21,101,661,341);
        
        add(titleLabel);
        add(descriptionLabel);
        add(graphicsChartPanel);
        setVisible(true);
    }
    
    private void createRelatoryEvents(){
        
    }
    
    private DefaultPieDataset createGraphicsData(){
        DefaultPieDataset graphicInfo = new DefaultPieDataset();
        
        Connection graphicsInfoSQLConnection;
        Statement graphicsInfoSQLInstruction;
        ResultSet graphicsInfoSQLOutput;
        
        try{
            graphicsInfoSQLConnection = DriverManager.getConnection(databaseConfiguration.connectionCoordinates, databaseConfiguration.databaseUser, databaseConfiguration.databasePassword);
            graphicsInfoSQLInstruction = graphicsInfoSQLConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String graphicsInfoQuery = "SELECT availableOccupations.occupationName, count(*) as occupationQuantity FROM avalabelOccupations, availableManagers";
            graphicsInfoQuery += "WHERE avaiableOccupations.occupationID = availableManagers.managerOccupation group by availableOccupations.occupationName order by occupationName asc";
            graphicsInfoSQLOutput = graphicsInfoSQLInstruction.executeQuery(graphicsInfoQuery);
            
            while(graphicsInfoSQLOutput.next()){
                graphicInfo.setValue(graphicsInfoSQLOutput.getString("Specific name: "), graphicsInfoSQLOutput.getInt("Specific quantity:"));
            }
            
            return graphicInfo;
        }catch(SQLException graphicInfoException){
            JOptionPane.showMessageDialog(null, "Error F-01! We found an unstable situation during the relatory creation. Please, re-insert the information and try again (GraphicsInfoException)" + graphicInfoException.getMessage());
            appNavigator.homeFrame();
        }
        
        return null;
    }
}
