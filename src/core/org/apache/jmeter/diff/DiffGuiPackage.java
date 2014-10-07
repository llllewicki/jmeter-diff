package org.apache.jmeter.diff;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JToolBar;

import org.apache.jmeter.exceptions.IllegalUserActionException;
import org.apache.jmeter.gui.GuiPackage;
import org.apache.jmeter.gui.JMeterGUIComponent;
import org.apache.jmeter.gui.LoggerPanel;
import org.apache.jmeter.gui.MainFrame;
import org.apache.jmeter.gui.tree.JMeterTreeListener;
import org.apache.jmeter.gui.tree.JMeterTreeModel;
import org.apache.jmeter.gui.tree.JMeterTreeNode;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jorphan.collections.HashTree;

public final class DiffGuiPackage {
  private static DiffGuiPackage guiPack;

  /**
   * Map from TestElement to JMeterGUIComponent, mapping the nodes in the tree
   * to their corresponding GUI components.
   */
  private Map<TestElement, JMeterGUIComponent> nodesToGui = new HashMap<TestElement, JMeterGUIComponent>();

  /**
   * Map from Class to JMeterGUIComponent, mapping the Class of a GUI
   * component to an instance of that component.
   */
  private Map<Class<?>, JMeterGUIComponent> guis = new HashMap<Class<?>, JMeterGUIComponent>();

  /**
   * Map from Class to TestBeanGUI, mapping the Class of a TestBean to an
   * instance of TestBeanGUI to be used to edit such components.
   */
  private Map<Class<?>, JMeterGUIComponent> testBeanGUIs = new HashMap<Class<?>, JMeterGUIComponent>();

  /** The currently selected node in the tree. */
  private JMeterTreeNode currentNode = null;

  private boolean currentNodeUpdated = false;

  /** The model for JMeter's test tree. */
  private final JMeterTreeModel treeModel1;
  private final JMeterTreeModel treeModel2;

  /** The listener for JMeter's test tree. */
  private final JMeterTreeListener treeListener1;
  private final JMeterTreeListener treeListener2;

  /** The main JMeter frame. */
  private MainFrame mainFrame;

  /** The main JMeter toolbar. */
  private JToolBar toolbar;

  /** The menu item toolbar. */
  private JCheckBoxMenuItem menuToolBar;

  /**
   * The LoggerPanel menu item
   */
  private JCheckBoxMenuItem menuItemLoggerPanel;

  /**
   * Logger Panel reference
   */
  private LoggerPanel loggerPanel;

  /**
   * History for tree states
   */

  private DiffGuiPackage() {
    this.treeModel1 = new JMeterTreeModel();
    this.treeListener1 = new JMeterTreeListener(treeModel1);
    this.treeModel2 = new JMeterTreeModel();
    this.treeListener2 = new JMeterTreeListener(treeModel1);
}
  
  public static DiffGuiPackage getInstance(){
    if(guiPack==null){
      guiPack = new DiffGuiPackage();
    }
    return guiPack;
  }
  
  public HashTree addSubTree1(HashTree subTree) throws IllegalUserActionException {
    HashTree hashTree = treeModel1.addSubTree(subTree, treeListener1.getCurrentNode());
    return hashTree;
}
  
  public HashTree addSubTree2(HashTree subTree) throws IllegalUserActionException {
    HashTree hashTree = treeModel1.addSubTree(subTree, treeListener1.getCurrentNode());
    return hashTree;
}  
  
  public void clearTestPlan() {
    treeModel1.clearTestPlan();
    nodesToGui.clear();
//    setTestPlanFile(null);
}
}
