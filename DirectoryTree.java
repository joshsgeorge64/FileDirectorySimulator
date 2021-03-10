/**
 * @author joshua.s.george@stonybrook.edu
 * ID: 112839378
 * <p>
 * This class acts the tree for managing the files and directories in the system
 */
public class DirectoryTree {
    private DirectoryNode root, cursor;

    public DirectoryTree() {
        root = new DirectoryNode("root", false);
        cursor = root;
    }

    public DirectoryNode getCursor() {
        return cursor;
    }

    /**
     * Resets cursor node to the root of the tree
     */
    public void resetCursor() {
        cursor = root;
    }

    /**
     * Moves the cursor to the directory with the name indicated by name
     * <dl>
     * <dt><b>Preconditions:</b></dt>
     * <dd>
     *     'name' references a valid directory
     * </dd>
     *
     * </dl>
     *
     * @param name Name of directory to change to
     * @throws NotADirectoryException Thrown if name is file or doesn't exist
     */
    public void changeDirectory(String name) throws NotADirectoryException {
        if (cursor.getLeft() != null) {
            if (cursor.getLeft().getName().equalsIgnoreCase(name)) {
                if (cursor.getLeft().isFile())
                    throw new NotADirectoryException("Cannot change directory to a file");
                cursor = cursor.getLeft();
                return;
            }
        }
        if (cursor.getMiddle() != null) {
            if (cursor.getMiddle().getName().equalsIgnoreCase(name)) {
                if (cursor.getMiddle().isFile())
                    throw new NotADirectoryException("Cannot change directory to a file");
                cursor = cursor.getMiddle();
                return;
            }
        }
        if (cursor.getRight() != null) {
            if (cursor.getRight().getName().equalsIgnoreCase(name)) {
                if (cursor.getRight().isFile())
                    throw new NotADirectoryException("Cannot change directory to a file");
                cursor = cursor.getRight();
                return;
            }
        }
        throw new NotADirectoryException("Directory not found");

    }

    /**
     * Returns a String containing a space-separated list of names of all the child directories or files of the cursor
     * <dl>
     * <dt><b>Postconditions:</b></dt>
     * <dd>
     *     The cursor remains at the same directory node
     * </dd>
     * </dl>
     *
     * @return A formatted string of DirectoryNode names
     */
    public String listDirectory() {
        String result = "";
        if (cursor.getLeft() != null)
            result += cursor.getLeft().getName() + " ";
        if (cursor.getMiddle() != null)
            result += cursor.getMiddle().getName() + " ";
        if (cursor.getRight() != null)
            result += cursor.getRight().getName();
        return result;
    }

    /**
     * Prints formatted list of files and directories in the system
     *
     * @param node    Starting node
     * @param indents Number of indents for that line
     */
    public void printDirectoryTree(DirectoryNode node, int indents) {
        String start = "";
        for (int i = 0; i < indents; i++) {
            start += "   ";
        }

        if (node == null)
            return;
        if (node.isFile())
            System.out.println(start + " - " + node.getName());
        else
            System.out.println(start + "|- " + node.getName());
        printDirectoryTree(node.getLeft(), indents + 1);
        printDirectoryTree(node.getMiddle(), indents + 1);
        printDirectoryTree(node.getRight(), indents + 1);
    }

    /**
     * Creates a directory with indicated name
     *
     * @param name Name of directory
     * @throws IllegalArgumentException Thrown if name is invalid
     * @throws FullDirectoryException   Thrown if all child references are occupied
     * @throws NotADirectoryException Thrown if 'name' is not a valid directory
     */
    public void makeDirectory(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException {
        if (name.contains(" ") || name.contains("/"))
            throw new IllegalArgumentException();
        if (cursor.getLeft() != null && cursor.getMiddle() != null && cursor.getRight() != null)
            throw new FullDirectoryException("This directory is full");
        DirectoryNode node = new DirectoryNode(name, false);
        cursor.addChild(node);
    }

    /**
     * Creates a file with indicated name
     *
     * @param name Name of file
     * @throws IllegalArgumentException Thrown if name is invalid
     * @throws FullDirectoryException   Thrown if all child references are occupied
     * @throws NotADirectoryException Thrown if 'name' is not a valid directory
     */
    public void makeFile(String name) throws IllegalArgumentException, FullDirectoryException, NotADirectoryException {
        if (name.contains(" ") || name.contains("/"))
            throw new IllegalArgumentException();
        if (cursor.getLeft() != null && cursor.getMiddle() != null && cursor.getRight() != null)
            throw new FullDirectoryException("This directory is full");
        DirectoryNode node = new DirectoryNode(name, true);
        cursor.addChild(node);
    }

}
