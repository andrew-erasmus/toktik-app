
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
        // Add logic for error handling
        // Do a makefile
        // Make a simple GUI, or a follow and follow back feature, delete posts, search
        // for posts

        int choice = 0;
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
                    System.out.println("\n --Actions loaded from disk-- \n");
                    loadFileActions();
                    break;
                case 8:
                    System.out.println("-- Goodbye! --");
                    input.close();
                    break;
                default:
                    System.out.println("\n-- Please select a valid option (1-8) --\n");
                    break;

            }
        }

    }

    /**
     * 
     * @param targetName
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
            } else {
                bst.insert(inAcc);
                System.out.println("\n-- New Account Created --\n");
            }
        } while (exists != null);
    }

    /**
     * 
     * @param accName
     * @param desc
     */
    public static void createAccount(String accName, String desc) {
        BinaryTreeNode<User> exists;
        User inAcc = new User(accName, desc);
        exists = bst.find(inAcc);
        bst.insert(inAcc);

    }

    /**
     * 
     */
    public static void deleteAccount() {
        BinaryTreeNode<User> foundToDelete;
        do {
            System.out.print("Enter account to delete: ");
            String deleteName = input.next();
            input.nextLine();

            User deleteUser = new User(deleteName, "");
            foundToDelete = bst.find(deleteUser);

            if (foundToDelete == null) {
                System.out.println("\n-- Account name does not exist, please try again --\n");
            } else {
                bst.delete(deleteUser);
                System.out.println("\n-- Account Deleted --\n");
            }
        } while (foundToDelete == null);
    }

    /**
     * 
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
     * 
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
     * 
     * @param postAcc
     * @param postTitle
     * @param numLikes
     * @param fileName
     */
    public static void addPosts(String postAcc, String postTitle, int numLikes, String fileName) {
        User poster = new User(postAcc, "");
        BinaryTreeNode<User> toPost = bst.find(poster);

        // find the post account and then add to it
        Post inPost = new Post(postTitle, fileName, numLikes);
        toPost.data.addPost(inPost);
    }

    /**
     * 
     * @throws e
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
                    int createLength = splitLine[0].length();
                    int nameLength = splitLine[1].length();
                    int spaces = 2;
                    createAccount(splitLine[1], line.substring(nameLength + createLength + spaces, line.length()));
                } else {
                    int addLength = splitLine[0].length();
                    int nameLength = splitLine[1].length();
                    int fileNameLength = splitLine[2].length();
                    int numLikesLength = splitLine[3].length();
                    int spaces = 4;
                    addPosts(splitLine[1],
                            line.substring(addLength + nameLength + fileNameLength + numLikesLength + spaces,
                                    line.length()),
                            Integer.parseInt(splitLine[3]), splitLine[2]);
                }

            }
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("System could not find the file");
            System.exit(0);
        }
    }

}
