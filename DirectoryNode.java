/**
 * @author joshua.s.george@stonybrook.edu
 *  ID: 112839378
 *  <p>
 *      This class represents the nodes of the directory tree
 */
public class DirectoryNode {
    private String name;
    private DirectoryNode left, middle, right;
    private boolean isFile;

    public DirectoryNode(String name, boolean isFile) {
        this.name = name;
        this.isFile = isFile;
    }

    /**
     *
     * @return name of node
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFile() {
        return isFile;
    }

    /**
     *
     * @return left child node
     */
    public DirectoryNode getLeft() {
        return left;
    }

    /**
     *
     * @return middle child node
     */
    public DirectoryNode getMiddle() {
        return middle;
    }

    /**
     *
     * @return right child node
     */
    public DirectoryNode getRight() {
        return right;
    }

    /**
     * Adds newChild to any of the open child positions of this node
     *
     * @param node node to be added to directory
     * @throws FullDirectoryException Thrown if directory is full
     * @throws NotADirectoryException Thrown if cursor is a file
     */
    public void addChild(DirectoryNode node) throws FullDirectoryException, NotADirectoryException {
        if(isFile)
            throw new NotADirectoryException("Error: This node is a file");
        if(left != null && middle != null && right != null)
            throw new FullDirectoryException("This directory is full");
        if(left == null)
            left = node;
        else if(middle == null)
            middle = node;
        else if(right == null)
            right = node;
    }
}
