import java.util.Scanner;

/**
 *  @author joshua.s.george@stonybrook.edu
 *  ID: 112839378
 *  <p>
 *      This class acts as main method for executing the terminal
 */
public class BashTerminal {

    /**
     * This is the main method of the class. Runs the Bash Terminal
     * @param args Command line args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DirectoryTree tree = new DirectoryTree();
        System.out.println("Starting bash terminal.");
        String selection = "";
        while (!selection.equalsIgnoreCase("exit")) {
            try {
                System.out.print("[jsgeorge@cortana] : $ ");
                selection = scan.nextLine();

                if (selection.equalsIgnoreCase("pwd")) {
                    System.out.println("root/");

                } else if (selection.contains("ls")) {
                    if (selection.contains("-R") || selection.contains("-r")) {
                        tree.printDirectoryTree(tree.getCursor(), 0);
                    } else
                        System.out.println(tree.listDirectory());

                } else if (selection.contains("cd ")) {
                    String[] values = selection.split(" ");
                    if (values[1].equalsIgnoreCase("/"))
                        tree.resetCursor();
                    else {
                        tree.changeDirectory(values[1]);
                    }

                } else if (selection.contains("mkdir")) {
                    String[] values = selection.split(" ");
                    tree.makeDirectory(values[1]);
                } else if (selection.contains("touch ")) {
                    String[] values = selection.split(" ");
                    tree.makeFile(values[1]);
                } else if (selection.equalsIgnoreCase("exit")) {
                    System.out.println("Closing bash terminal...");
                } else {
                    System.out.println("Error: Command not found");
                }
            } catch (NotADirectoryException e) {
                System.out.println(e);
            } catch (FullDirectoryException e) {
                System.out.println(e);
            } catch (Exception e) {
                System.out.println("Error: Please enter a valid input");
            }

        }

    }
}
