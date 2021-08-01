package systemFrames;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.Range;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import systemFiles.appNavigator;
import systemFiles.databaseConfiguration;
        
public class salaryRelatory extends JPanel{
    JLabel titleLabel, descriptionLabel;
    
    public salaryRelatory(){
        createSalaryRelatoryComponents();
        createSalaryRelatoryEvents();
    }
    
    private void createSalaryRelatoryComponents(){
        setLayout(null);
        
        titleLabel = new JLabel("Triple S - Salary relatories");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.PLAIN, 21));
        descriptionLabel = new JLabel("This graphic shows the functionaries quantity by salary indexes", JLabel.CENTER);
        CategoryDataset graphicalData = this.createGraphicalData();
        
        JFreeChart graphicalChart = ChartFactory.createBarChart3D("",null, "Professionals quantity",
                graphicalData, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot graphicalCategoryPlot = (CategoryPlot) graphicalChart.getCategoryPlot();
        
        graphicalCategoryPlot.setBackgroundPaint(null);
        graphicalCategoryPlot.setOutlinePaint(null);
        graphicalChart.setBackgroundPaint(null);
        
        graphicalCategoryPlot.getRangeAxis().setLowerBound(0);
        graphicalCategoryPlot.getRangeAxis().setRange(new Range(0,5));
        graphicalCategoryPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        graphicalCategoryPlot.getRangeAxis().setAutoRange(false);
        Font fontClass03 = new Font(titleLabel.getFont().getName(), Font.PLAIN, 11);
        graphicalCategoryPlot.getRangeAxis().setLabelFont(fontClass03);
        
        graphicalCategoryPlot.getDomainAxis().setVisible(false);
        
        BarRenderer graphicalBarRenderer = (BarRenderer) graphicalCategoryPlot.getRenderer();
        graphicalBarRenderer.setItemMargin(-3);
        
        ChartPanel graphicalChartPanel = new ChartPanel(graphicalChart){
            @Override
            public Dimension getPreferredSize(){
                return new Dimension(661,341);
            }
        };
        
        titleLabel.setBounds(21,21,661,41);
        descriptionLabel.setBounds(21,51,661,41);
        graphicalChartPanel.setBounds(21,101,661,341);
        
        add(titleLabel);
        add(descriptionLabel);
        add(graphicalChartPanel);
        
        setVisible(true);
    }
    
    private void createSalaryRelatoryEvents(){
        private CategoryDataset createGraphicalData(){
            DefaultCategoryDataset graphicalReceivedData = new DefaultCategoryDataset();
            
            Connection salaryRelatorySQLConnection;
            Statement salaryRelatorySQLInstruction;
            ResultSet salaryRelatorySQLOutput;
            
            try{
                salaryRelatorySQLConnection = DriverManager.getConnection(databaseConfiguration.connectionCoordinates, databaseConfiguration.databaseUser, databaseConfiguration.databasePassword);
                salaryRelatorySQLInstruction = salaryRelatorySQLConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String selectionQuery = "SELECT";
                selectionQuery += "COUNT(case when professionalSalary < 1000 then 1 end) AS salaryIndex01,";
                selectionQuery += "COUNT(case when professionalSalary >= 1000 AND professionalSalary < 2000 then 1 end) AS salaryIndex02,";
                selectionQuery += "COUNT(case when professionalSalary >= 2000 AND professionalSalary < 3000 then 1 end) AS salaryIndex03,";
                selectionQuery += "COUNT(case when professionalSalary >= 3000 AND professionalSalary < 4000 then 1 end) AS salaryIndex04,";
                selectionQuery += "COUNT(case when professionalSalary >= 4000 AND professionalSalary < 5000 then 1 end) AS salaryIndex05,";
                selectionQuery += "COUNT(case when professionalSalary >= 5000 then 1 end) AS salaryIndex06";
                
            }catch(){
                
            }
        }
    }
}
