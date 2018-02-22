package sample;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
class DisplayGraph{
	JFreeChart displayGraph;
	
	   public DisplayGraph() {
			 this.displayGraph= ChartFactory.createLineChart(
			         "Display",
			         "Number","Value",
			         createDataset(),
			         PlotOrientation.VERTICAL,
			         true,true,false);
	}

	private DefaultCategoryDataset createDataset( ) {
		      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
		      dataset.addValue( 15 , "values" , "1" );
		      dataset.addValue( 30 , "values" , "2" );
		      dataset.addValue( 60 , "values" ,  "3" );
		      dataset.addValue( 120 , "values" , "4" );
		      dataset.addValue( 240 , "values" , "5" );
		      dataset.addValue( 300 , "values" , "6" );
		      return dataset;
		   }
}

public class ClientWindow {

	private JFrame frmClient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientWindow window = new ClientWindow();
					window.frmClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClientWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClient = new JFrame();
		frmClient.setTitle("Client");
		frmClient.setBounds(100, 100, 1000, 1000);
		frmClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClient.setLocationRelativeTo(null);
		SpringLayout springLayout = new SpringLayout();
		frmClient.getContentPane().setLayout(springLayout);
		
		addComponentsToFrame(springLayout);
	}
	
	/**
	 * Adds start/stop button and two panels to form a layout.
	 * @param springLayout
	 */
	private void addComponentsToFrame(SpringLayout springLayout)
	{
		JToggleButton btnNewButton = new JToggleButton("Start/Stop");
		frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
		JLabel lblToggle = new JLabel("Start");
                lblToggle.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	if (e.getButton() == 1 && lblToggle.getText() == "Stop") {
	        		btnNewButton.setBackground(RED);
	            		lblToggle.setText("Start");
	            		//closeConnection(); 
	        	} 
			else if (e.getButton() == 1 && lblToggle.getText() == "Start") {
	        		btnNewButton.setBackground(GREEN);
	            		lblToggle.setText("Stop");
	            		//createSocket();
	        	}
	      	}
	        });	    
		
	        btnNewButton.addActionListener(new ActionListener() {
	        @Override
	        	public void actionPerformed(ActionEvent e) {
	        		if (e.getID() == 1001 && lblToggle.getText() == "Stop") {
	        			btnNewButton.setBackground(RED);
	            			lblToggle.setText("Start");
	            			//closeConnection();    
	        		} 
				else if (e.getID() == 1001 && lblToggle.getText() == "Start") {
	        			btnNewButton.setBackground(GREEN);
	            			lblToggle.setText("Stop");
	            			//createSocket();
	        		}
	      		}
	    	});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 10, SpringLayout.NORTH, frmClient.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, -231, SpringLayout.EAST, frmClient.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 56, SpringLayout.NORTH, frmClient.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, frmClient.getContentPane());
		frmClient.getContentPane().add(btnNewButton);
		
		DisplayGraph DG= new DisplayGraph();
		ChartPanel chartPanel= new ChartPanel(DG.displayGraph);
		chartPanel.setLocation(12, 26);
		chartPanel.setSize(new Dimension(478, 567));
		JPanel graphPanel = new JPanel();
		graphPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		springLayout.putConstraint(SpringLayout.NORTH, graphPanel, 17, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, graphPanel, 623, SpringLayout.SOUTH, btnNewButton);
		frmClient.getContentPane().add(graphPanel);
		graphPanel.setLayout(null);
		
		graphPanel.add(chartPanel);
		
		JPanel centerPanel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, graphPanel, -26, SpringLayout.WEST, centerPanel);
		springLayout.putConstraint(SpringLayout.WEST, centerPanel, 538, SpringLayout.WEST, frmClient.getContentPane());
		centerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		springLayout.putConstraint(SpringLayout.NORTH, centerPanel, 17, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, centerPanel, 623, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, centerPanel, 0, SpringLayout.EAST, btnNewButton);
		frmClient.getContentPane().add(centerPanel);
		centerPanel.setLayout(new GridLayout(5, 2, 0, 0));
		addComponentsToCenterPanel(centerPanel);
		
		
		
		JPanel consolePanel = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, graphPanel, 0, SpringLayout.WEST, consolePanel);
		consolePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		springLayout.putConstraint(SpringLayout.NORTH, consolePanel, -257, SpringLayout.SOUTH, frmClient.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, consolePanel, 10, SpringLayout.WEST, frmClient.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, consolePanel, -10, SpringLayout.SOUTH, frmClient.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, consolePanel, 0, SpringLayout.EAST, btnNewButton);
		frmClient.getContentPane().add(consolePanel);
		

	}
	
	/**
	 * adds labels to show highest,lowest and average values
	 * to center panel
	 */
	private void addComponentsToCenterPanel(JPanel centerPanel) {
		JLabel highestValueLabel = new JLabel("<html>Highest<br>Value</html>");
		highestValueLabel.setBackground(SystemColor.activeCaption);
		highestValueLabel.setOpaque(true);
		centerPanel.add(highestValueLabel);
		
		JLabel actualHighValueLabel = new JLabel("");
		actualHighValueLabel.setBackground(Color.PINK);
		centerPanel.add(actualHighValueLabel);
		actualHighValueLabel.setOpaque(true);
		
		JLabel lowestValueLabel = new JLabel("<html>Lowest<br>Value</html>");
		lowestValueLabel.setBackground(Color.PINK);
		centerPanel.add(lowestValueLabel);
		lowestValueLabel.setOpaque(true);
		
		JLabel actualLowestValueLabel = new JLabel("");
		actualLowestValueLabel.setBackground(SystemColor.activeCaption);
		centerPanel.add(actualLowestValueLabel);
		actualLowestValueLabel.setOpaque(true);
		
		JLabel averageLabel= new JLabel("Average");
		averageLabel.setBackground(SystemColor.activeCaption);
		centerPanel.add(averageLabel);
		averageLabel.setOpaque(true);
		
		JLabel actualAverageLabel = new JLabel("");
		actualAverageLabel.setBackground(Color.PINK);
		centerPanel.add(actualAverageLabel);
		actualAverageLabel.setOpaque(true);
		
	}
	}


