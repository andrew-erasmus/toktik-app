// Andrew Erasmus
// 11/04/2023
// Main page for the backend of a simple tik tok clone
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This method runs the main operations of the application where the user can
 * select options to manipulate data in a certain way
 */
public class Main {

    static BinarySearchTree<User> bst = new BinarySearchTree<User>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // DO TO
        // Do a makefile
        // Make a simple GUI, or a follow and follow back feature, delete posts, search
        // Error handling to go back
        // Error handling if enter a string for the choice

        int choice = 0;
        // actions for the user to select from
        String menu = "Choose an action from the menu: (Choose 1-8)";
        menu += "\n1. Find the profile description for a given account";
        menu += "\n2. List all accounts";
        menu += "\n3. Create an account";
        menu += "\n4. Delete an account";
        menu += "\n5. Display all posts for a single account";
        menu += "\n6. Add a new post for an account";
        menu += "\n7. Load a file of actions from disk and process this";
        menu += "\n8. Quit\nEnter your choice: ";

        while (choice != 8) {
            System.out.print(menu);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the account name: ");
                    String targetName = input.next();
                    input.nextLine();
                    findDesc(targetName);
                    break;

                case 2:
                    System.out.println("\n-- Accounts --\n");
                    bst.inOrder();
                    break;

                case 3:
                    System.out.println("\n-- Create New Account --\n");
                    createAccount();
                    break;

                case 4:
                    System.out.println("\n-- Delete Account --\n");
                    deleteAccount();
                    break;

                case 5:
                    System.out.println("\n-- Posts --\n");
                    displayPosts();
                    break;

                case 6:
                    System.out.println("\n-- New Post --\n");
                    addPosts();
                    break;

                case 7:
                    // runs processes to do the actions in a file such as adding and deleting files
                    System.out.println("\n --Actions loaded from disk-- \n");
                    loadFileActions();
                    break;
                case 8:
                    System.out.println("-- Goodbye! --");
                    input.close();
                    break;
                default:
                    // if the user does not enter a number from 1-8
                    System.out.println("\n-- Please select a valid option (1-8) --\n");
                    break;

            }
        }

    }

    /**
     * Finds the description of a given account by passing in username to search in the
     * tree and by outputting the description of it.
     * If the username is not found in the binary tree then it will output that it 
     * does not exist.
     * 
     * @param targetName The name of the user to search in the binary tree
     */
    public static void findDesc(String targetName) {
        User temp = new User(targetName, "");
        BinaryTreeNode<User> found = bst.find(temp);
        if (found == null) {
            System.out.println("\n-- Account entered does not exist --\n");
        }else{
            System.out.println("\nProfile Desription: " + found.data.getDesc() + "\n");
        }
       
    }

    /**
     * Method to create an account with an inputted name and description
     * If the name of the user already exists, it will make the user try again until they 
     * choose a unique name if they so choose. 
     * 
     */
    public static void createAccount() {
        BinaryTreeNode<User> exists;
        do {
            System.out.print("Enter an account name: ");
            String accName = input.next();
            input.nextLine();
            System.out.print("Enter an account description: ");
            String desc = input.nextLine();

            User inAcc = new User(accName, desc);
            exists = bst.find(inAcc);

            if (exists != null) {
                System.out.println("Account name already exists, please try again");
                System.out.println("Do you want to continue? Y/N"); // Allows them to quit if they don't want to continue
                String cont = input.nextLine();
                
                if(cont.equals("Y") || cont.equals("y")){
                    continue;
                }else{
                    break;
                }
            } else {
                bst.insert(inAcc);
                System.out.println("\n-- New Account Created --\n");
            }
        } while (exists != null);
    }

    /**
     * Method to create an account based on the actions loaded from a file.
     * 
     * @param accName The name of the user to be added to the tree
     * @param desc The description of the respective account entered
     */
    public static void createAccount(String accName, String desc) {
        //BinaryTreeNode<User> exists;
        User inAcc = new User(accName, desc);
        //exists = bst.find(inAcc);
        bst.insert(inAcc);

    }

    /**
     * Deletes an account based on the username that the user enters.
     * If it is not found, the user can try again if they wish
     * 
     */
    public static void deleteAccount() {
        BinaryTreeNode<User> foundToDelete;
        do {
            System.out.print("Enter account to delete: ");
            String deleteName = input.next();
            input.nextLine();

            // Create a new user with the name to search for
            User deleteUser = new User(deleteName, "");
            // See if an object with the same name can be found
            foundToDelete = bst.find(deleteUser);

            if (foundToDelete == null) {
                System.out.println("\n-- Account name does not exist, please try again --\n");
                System.out.println("Do you want to continue? Y/N");
                String cont = input.nextLine();
                
                if(cont.equals("Y") || cont.equals("y")){
                    continue;
                }else{
                    break;
                }
            } else {
                bst.delete(deleteUser);
                System.out.println("\n-- Account Deleted --\n");
            }
        } while (foundToDelete == null);
    }

    /**
     * Displays all the posts for a single user if the account exists
     */
    public static void displayPosts() {
        System.out.print("Enter the account name: ");
        String postsName = input.next();
        input.nextLine();
        // create a target object with the same name and have it return a node with the
        // correct user object
        User target = new User(postsName, "");
        BinaryTreeNode<User> foundForPosts = bst.find(target);
        if (foundForPosts == null) {
            System.out.println("\n-- Account cannot be found --\n");
        } else {
            foundForPosts.data.getPosts();
        }

    }

    /**
     * Asks the user to enter a title, filename and number of likes. 
     * It then creates a post object and adds it to the linked list belonging to a user
     */
    public static void addPosts() {
        System.out.print("Enter the account to add a post to: ");
        String postAcc = input.next();
        input.nextLine();

        User poster = new User(postAcc, "");
        BinaryTreeNode<User> toPost = bst.find(poster);

        if (toPost != null) {
            System.out.print("Title: ");
            String postTitle = input.nextLine();
            System.out.print("File name: ");
            String fileName = input.nextLine();
            System.out.println("Number of likes: ");
            int numLikes = input.nextInt();
            Post inPost = new Post(postTitle, fileName, numLikes);

            toPost.data.addPost(inPost);
        } else {
            System.out.println("\n-- Account cannot be found, cannot make a post --\n");
        }
        

    }

    /**
     * Adds posts to the account of a user based off the actions from a file
     * @param postAcc The account to add the post to
     * @param postTitle The title of the post to be added
     * @param numLikes The number of likes for the post
     * @param fileName The fileName of the post
     */
    public static void addPosts(String postAcc, String postTitle, int numLikes, String fileName) {
        User poster = new User(postAcc, "");
        BinaryTreeNode<User> toPost = bst.find(poster);

        // find the post account and then add to it
        Post inPost = new Post(postTitle, fileName, numLikes);
        toPost.data.addPost(inPost);
    }

    /**
     * Loads actions from an external file to create and add a file
     * @throws e If the file cannot be found it throws this exception
     */
    public static void loadFileActions() {
        // create logic to add accounts from file for add and remove
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new FileInputStream("dataset.txt"));

            while (fileIn.hasNext()) {
                String line = fileIn.nextLine();
                String[] splitLine = line.split(" ");

                if (splitLine[0].equalsIgnoreCase("Create")) {
                    int createLength = splitLine[0].length(); // length of the word "create"
                    int nameLength = splitLine[1].length(); // length of the username
                    int spaces = 2;
                    createAccount(splitLine[1], line.substring(nameLength + createLength + spaces, line.length())); //substring for the description from after the word to the end of the line
                } else {
                    int addLength = splitLine[0].length(); // length of the word "add"
                    int nameLength = splitLine[1].length(); // length of the username
                    int fileNameLength = splitLine[2].length(); // length of the filename
                    int numLikesLength = splitLine[3].length(); // length of the number of likes as a string
                    int spaces = 4;
                    addPosts(splitLine[1],
                            line.substring(addLength + nameLength + fileNameLength + numLikesLength + spaces,
                                    line.length()), 
                            Integer.parseInt(splitLine[3]), splitLine[2]); // adds the post with the respective files and uses substring to account for spaces
                }

            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("System could not find the file");
            System.exit(0);
        }
    }


    public static void findPost(){
        
    }

}
