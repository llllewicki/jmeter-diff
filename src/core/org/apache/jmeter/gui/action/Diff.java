package org.apache.jmeter.gui.action;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;

import org.apache.jmeter.diff.DiffWindow;
import org.apache.jmeter.exceptions.IllegalUserActionException;
import org.apache.jmeter.gui.GuiPackage;
import org.apache.jmeter.gui.util.FileDialoger;

public class Diff implements Command {

  private static final Set<String> commands = new HashSet<String>();


  
  static {
    commands.add(ActionNames.DIFF);
}
  
  @Override
  public void doAction(ActionEvent e) throws IllegalUserActionException {
    // TODO Auto-generated method stub
    new DiffWindow();
//    final JFileChooser chooser = FileDialoger.promptToOpenFile(new String[] { ".jmx" }); //$NON-NLS-1$
//    if (chooser == null) {
//        return;
//    }
//    final File selectedFile = chooser.getSelectedFile();
//    if(selectedFile != null) {
//        final boolean merging = e.getActionCommand().equals(ActionNames.MERGE);
//        // We must ask the user if it is ok to close current project
//        if(!merging) { // i.e. it is OPEN
//            if (!Close.performAction(e)) {
//                return;
//            }
//        }
////        loadProjectFile(e, selectedFile, merging);
//    }
//    

//    final JFileChooser chooser = FileDialoger.promptToOpenFile(new String[] { ".jmx" }); //$NON-NLS-1$

  }

  @Override
  public Set<String> getActionNames() {
    // TODO Auto-generated method stub
    return commands;
  }

}
