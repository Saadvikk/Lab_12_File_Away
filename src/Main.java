import javax.swing.filechooser.FileSystemView;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String FileName = "";

        int wordCount = 0;
        int characters = 0;
        int lineCount = 0;

        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = chooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = chooser.getSelectedFile();
            System.out.println(selectedFile.getAbsolutePath());
            FileName = selectedFile.getName();
            String s = selectedFile.getAbsolutePath();
            System.out.println(s);

            try
            {
                File file = new File(s);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;

                while ((line = br.readLine())!=null)
                {
                    lineCount += 1;
                    String[] arr=line.split(" ");
                    wordCount = wordCount + arr.length;
                    characters = characters + line.length();

                }
                fr.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("Name of file = " + FileName);
        System.out.println("Name of line = " + lineCount);
        System.out.println("Total word count = " + wordCount);
        System.out.println("Total number of characters = " + characters);
    }
}