/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package htmltree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author MARTJA1
 */
public class HtmlTree extends JFrame{
    
    private	JPanel		topPanel;
    private	JTree		tree;
    private	JScrollPane     scrollPane;
    
    public HtmlTree()
    {       
            // Set the frame characteristics
            setTitle( "Simple Tree Application" );
            setSize( 300, 100 );
            setBackground( Color.gray );

            // Create a panel to hold all other components
            topPanel = new JPanel();
            topPanel.setLayout( new BorderLayout() );
            getContentPane().add( topPanel );

            // Create a new tree control
            tree = new JTree();

            // Add the listbox to a scrolling pane
            scrollPane = new JScrollPane();
            scrollPane.getViewport().add( tree );
            topPanel.add( scrollPane, BorderLayout.CENTER );
            
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
    }

    public static void main(String[] args) {
        HtmlTree root	= new HtmlTree();
        
        try{
            Connect("http://nothing.com");
        } catch (Exception e) {
            System.out.println("That website doesn't work!");
        }
        
        root.setVisible( true );
        
    }
    
    public static void Connect(String link) throws Exception {
        URL url = new URL(link);
        URLConnection c = url.openConnection();
        
        c.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)");
        BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
        String strLine = "";
        
        while ((strLine = in.readLine()) != null) {
            if (!strLine.equals("")) System.out.println(strLine);
        }
    }

    

    
}