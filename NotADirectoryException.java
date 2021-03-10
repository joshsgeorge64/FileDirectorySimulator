/**
 *   @author joshua.s.george@stonybrook.edu
 *   ID: 112839378
 *   <p>
 *       Exception class to be thrown if the user is attempting to change the current directory to a file, or its name doesn't exist
 */
public class NotADirectoryException extends Exception {
    public NotADirectoryException(String message) {
        super(message);
    }
}
