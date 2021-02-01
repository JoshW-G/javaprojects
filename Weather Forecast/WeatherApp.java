package eeub10.project2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.xml.sax.SAXException;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

/**
 * 
 * @author Josh Gardner eeub10
 * WeatherApp gets & displays weather of locations through the use of xml parsers 
 *
 */
public class WeatherApp extends JFrame {

	private JPanel contentPane;
	private JTextField urlText;
	private final Pattern r;
	private final String brokerUrl, geoLoc, geoUsnm;
	protected double rot;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeatherApp frame = new WeatherApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WeatherApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel URLpanel = new JPanel();
		panel_1.add(URLpanel);
		URLpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
		
		JLabel urlLabel = new JLabel("Enter City:");
		URLpanel.add(urlLabel);
		
		urlText = new JTextField();
		URLpanel.add(urlText);
		urlText.setColumns(10);
		
		final JButton submitBtn = new JButton("Forecast");
		URLpanel.add(submitBtn);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,7,0,0));
		panel_1.add(panel);
		
		final JLabel tempLabel = new JLabel();
		panel.add(tempLabel); 
		final JLabel iconLabel = new JLabel();
		panel.add(iconLabel);
		final ImageIcon arrow = new ImageIcon(WeatherApp.class.getResource("/arrow.png"));
		
		final JLabel windDirLabel = new JLabel(null, arrow, JLabel.CENTER){
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                Graphics2D g2 = (Graphics2D) g;
	                g2.rotate(rot, arrow.getIconWidth() / 2, arrow.getIconHeight() / 2);
	                g2.drawImage(arrow.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH), 0, 0, null);
	            }
	        };
	     windDirLabel.setVisible(false);
	        
	     panel.add(windDirLabel);
	     final JLabel windSpeedLabel = new JLabel();
	     panel.add(windSpeedLabel);
	     final JLabel humLabel = new JLabel();
	     panel.add(humLabel);
	     final JLabel pressLabel = new JLabel();
	     panel.add(pressLabel);
	     final JLabel visibLabel = new JLabel();
	     panel.add(visibLabel);
		//iconLabel.setBounds(50, 50, 40, 40);
		
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		final JTextArea weatherText = new JTextArea();
		panel_2.add(weatherText);

		String pattern = ": (.+?),"; //regex gets Weather type inbetween : , 
	    r = Pattern.compile(pattern);
	    brokerUrl = "https://weather-broker-cdn.api.bbci.co.uk/en/observation/rss/";
	    geoLoc = "http://api.geonames.org/search?q=";
	    geoUsnm = "&maxRows=1&lang=en&username=eeub10";
	    
	    
		class btnListener implements ActionListener{

			private String geoID,geoUrl,url;

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==submitBtn) {
					if(urlText.getText().equals("")) {
						weatherText.setText(weatherText.getText() + "Please enter a location!\n");
					}
					else {
						geoUrl = geoLoc + urlText.getText() + geoUsnm;
						try {
							XMLParser geoParse = new XMLParser(geoUrl, "geoname", "geonameId");
							geoParse.parse();
							geoID = geoParse.getContents();
							//System.out.println(geoID);
						} catch (MalformedURLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (SAXException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						url = brokerUrl + geoID;
					
						try {
							XMLParser weatherParse = new XMLParser(url,"item","title");
							weatherParse.parse();
							String forecast = weatherParse.getContents();
							weatherText.setText(weatherText.getText()  + forecast + "\n");
							Matcher m = r.matcher(forecast);
							if(m.find()) {
								
								String weather = m.group(1);
								//String weather = "Sunny"; //testing
								ImageIcon image;
								//System.out.print(weather);//test
								switch(weather) {
									case "Sunny":
										image = new ImageIcon(WeatherApp.class.getResource("/sunny.png"));
										break;
								
									case "Cloudy":
										image = new ImageIcon(WeatherApp.class.getResource("/cloudy.png"));
										break;
									case "Light Clouds":
										image = new ImageIcon(WeatherApp.class.getResource("/lightcloud.png"));
										break;
									case "Windy":
										image = new ImageIcon(WeatherApp.class.getResource("/windy.png"));
										break;
									case "Heavy Rain":
										image = new ImageIcon(WeatherApp.class.getResource("/heavyrain.png"));
										break;
									case "RainShowers/Light Rain":
										image = new ImageIcon(WeatherApp.class.getResource("/lightrain.png"));
										break;
									case "Snow":
										image = new ImageIcon(WeatherApp.class.getResource("/snow.png"));
										break;
									case "Lightning":
										image = new ImageIcon(WeatherApp.class.getResource("/lighnting.png"));
										break;
									case "Not available":
										image = new ImageIcon(WeatherApp.class.getResource("/unavailable.png"));
										break;
									default:
										image = null;
										break;
								
								}
								if (image != null) {
									Image i = image.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
									image.setImage(i);
									iconLabel.setIcon(image);
									iconLabel.repaint();
								}
									
							}
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();  
						} catch (SAXException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try {
							XMLParser descParse = new XMLParser(url,"item","description");
							descParse.parse();
							String desc = descParse.getContents();
							Pattern pat = Pattern.compile("(.+?[^,]): ([^,].+?), ");//regex: gets descriptor and info
							Matcher m = pat.matcher(desc);
							//System.out.println(desc);
							while(m.find()) {
								System.out.println(m.group(1));
								System.out.println(m.group(2));
								String tag = m.group(1);
								String data = m.group(2);;
								switch(tag) {
									case "Temperature":
										
										tempLabel.setText(data);
										tempLabel.repaint();
										break;
									case "Wind Direction":
										//to do
										//nne,ene,ese,sse,ssw,wsw,wnw,nww 
										switch(data) {
										case "North":
											rot = 0.0;
											break;
										case "South":
											rot = 180;
											break;
										case "East":
											rot = 90;
											break;	
										case "West":
											rot = 270;
											break;
										case "North East":
											rot = 45;
											break;
										case "North West":
											rot = 315;
											break;
										case "South East":
											rot = 135;
										break;
										case "South West":
											rot = 225;
										break;


										case "North North East":
											rot = 22;
											break;
										case "East North East":
											rot = 68;
											break;
	
										case "East South East":
											rot = 112;
											break;
										case "South South East":
											rot = 158;
											break;
										case "South South West":
											rot = 202;
											break;
										case "West South West":
											rot = 248;
											break;
										case "West North West":
											rot = 292;
											break;
										case "North West West":
											rot = 338;
											break;
										case "Direction not available":
											rot = 0;
										}
										
										windDirLabel.setVisible(true);
										windDirLabel.repaint();
										break;
									case "Wind Speed":
									
										windSpeedLabel.setText(data);
										windSpeedLabel.repaint();
										break;
									case "Humidity":
									
										humLabel.setText(data);
										humLabel.repaint();
										break;
									case "Pressure":
										
										pressLabel.setText(data);
										pressLabel.repaint();
										break;
									case "Visibility":
										//, (.+?[^,]): ([^,].+?) 
										//not found in current regex
										
										break;
										
								
								}
									
								
							}
						} catch (MalformedURLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SAXException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						
						
						
					}
					
					
						
					}
				}
				
			}
			
		
		
		btnListener list = new btnListener();
		submitBtn.addActionListener(list);
	}

}
