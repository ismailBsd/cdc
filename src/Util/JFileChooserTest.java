package Util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

public class JFileChooserTest 
{

   
	public class SimpleFileFilter extends FileFilter
	{
		private String desc;
		private List<String> extensions;
		private boolean showDirectories;

		/**
		 * @param name example: "Data files"
		 * @param glob example: "*.txt|*.csv"
		 */
		public SimpleFileFilter (String name, String globs) 
		{
			extensions = new ArrayList<String>();
			for (String glob : globs.split("\\|"))
			{
				if (!glob.startsWith("*.")) 
					throw new IllegalArgumentException("expected list of globs like \"*.txt|*.csv\"");
				// cut off "*"
				// store only lower case (make comparison case insensitive)
				extensions.add (glob.substring(1).toLowerCase());
			}
			desc = name + " (" + globs + ")";
		}

		public SimpleFileFilter(String name, String globs, boolean showDirectories) {
			this(name, globs);
			this.showDirectories = showDirectories;
		}

		@Override
		public boolean accept(File file) 
		{
			if(showDirectories && file.isDirectory()) {
				return true;
			}
			String fileName = file.toString().toLowerCase();

			for (String extension : extensions)
			{	
				if (fileName.endsWith (extension))
				{
					return true;
				}
			}
			return false;
		}

		@Override
		public String getDescription() 
		{
			return desc;
		}

		/**
		 * @return includes '.'
		 */
		public String getFirstExtension()
		{
			return extensions.get(0);
		}
	}

	public void save(String documentT) throws IOException
	{
		String documentTitle = documentT;

		final JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("save");
		jfc.setDialogType(JFileChooser.SAVE_DIALOG);
		jfc.setSelectedFile(new File (documentTitle));
		jfc.addChoosableFileFilter(new SimpleFileFilter("WORD", "*.docx"));
		jfc.addPropertyChangeListener(JFileChooser.FILE_FILTER_CHANGED_PROPERTY, new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent arg0) 
			{
				System.out.println ("Property changed");
				String extold = null;
				String extnew = null;
				if (arg0.getOldValue() == null || !(arg0.getOldValue() instanceof SimpleFileFilter)) return;
				if (arg0.getNewValue() == null || !(arg0.getNewValue() instanceof SimpleFileFilter)) return;
				SimpleFileFilter oldValue = ((SimpleFileFilter)arg0.getOldValue());
				SimpleFileFilter newValue = ((SimpleFileFilter)arg0.getNewValue());
				extold = oldValue.getFirstExtension();
				extnew = newValue.getFirstExtension();
				String filename = "" + jfc.getSelectedFile();
				System.out.println ("file: " + filename + " old: " + extold + ", new: " + extnew);
				if (filename.endsWith(extold))
				{
					filename.replace(extold, extnew);
				}
				else
				{
					filename += extnew;
				}
				jfc.setSelectedFile(new File (filename));
			}
		});
		jfc.showDialog(frame, "save");
                int retrival = jfc.showSaveDialog(null);
                
                if (retrival == JFileChooser.APPROVE_OPTION)
{String sb = "";
//  File file = jfc.getSelectedFile();
//  String path = file.getAbsolutePath();
    FileWriter fw = new FileWriter(jfc.getSelectedFile()+".docx");
            fw.write(sb.toString());
	}}

	JFrame frame;

	public void run(final String doc)
	{
		frame = new JFrame();
		JButton btn = new JButton ("save");
		frame.add (btn);
		btn.addActionListener (new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
                            try {
                                save(doc);
                            } catch (IOException ex) {
                                Logger.getLogger(JFileChooserTest.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		});
		frame.setSize (300, 300);
		frame.pack();
		frame.setVisible(true);
	}

	
}