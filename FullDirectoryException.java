/**
 *  @author joshua.s.george@stonybrook.edu
 *  ID: 112839378
 *  <p>
 *      This Exception is to be thrown if user attempts to add more than 3 child nodes to any given directory
 */
public class FullDirectoryException extends Exception {
    public FullDirectoryException(String message){
        super(message);
    }
}
