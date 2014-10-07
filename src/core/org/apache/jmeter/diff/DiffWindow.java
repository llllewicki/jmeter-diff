package org.apache.jmeter.diff;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;

import org.apache.jmeter.gui.GuiPackage;
import org.apache.jmeter.gui.util.FileDialoger;
import org.apache.jmeter.save.SaveService;
import org.apache.jorphan.collections.HashTree;

public class DiffWindow extends JFrame{

  
  private JTree tree1, tree2;
  JScrollPane treePanel1;
  JScrollPane treePanel2;
  
  private static final long serialVersionUID = 1L;

  public DiffWindow() {
  
  setTitle("Diff Window");
  tree1 = GuiPackage.getInstance().getMainFrame().getTree();
  tree2 = new JTree();

  
  JPanel all = new JPanel();
  JButton button1 = new JButton("AAA");
//  button1.setActionCommand("Load1");
  button1.addActionListener(new Load1ActionListener());
  JButton button2 = new JButton("BBB");
  button1.setActionCommand("Load2");
all.add(button1);
all.add(button2);


  JSplitPane treePanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
  JScrollPane treePanel1 = new JScrollPane(tree1);
  treePanel1.setMinimumSize(new Dimension(100, 100));

  treePanel2 = new JScrollPane(tree2);
  treePanel2.setMinimumSize(new Dimension(100, 100));


//  treePanel = createTreePanel();
  treePanel.setLeftComponent(treePanel1);
  treePanel.setRightComponent(treePanel2);
  all.add(treePanel);

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  getContentPane().add(all);
  
  pack();
  setVisible(true);

  }
  
//method based on Load.java loadProjectFile method
  
  class Load1ActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
      JFileChooser chooser = FileDialoger.promptToOpenFile(new String[] { ".jmx" }); //$NON-NLS-1$
      final File selectedFile = chooser.getSelectedFile();
      if (selectedFile != null) {
        InputStream reader = null;
        try {
        reader = new FileInputStream(selectedFile);
        System.out.println("1111");
         final HashTree tree = SaveService.loadTree(reader);
         final DiffGuiPackage gui = DiffGuiPackage.getInstance();
         gui.clearTestPlan();
         gui.addSubTree1(tree);
         
         // catch try from Load.loadProjectFile()
       } catch (Exception e1) {
         // TODO Auto-generated catch block
         
         
         e1.printStackTrace();
       }
     //treePanel1.add
        System.out.println(selectedFile.getName());
//        treePanel1.setViewportView(tree);
//        treePanel1.revalidate();
    }
  }
  }
  
  public static void main(String[] args) {
    
  }
}
