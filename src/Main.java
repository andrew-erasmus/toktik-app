
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

    /**
     * Main method for the application, will allow user to run all processes
     * @param args The user input to the terminal
     */
    public static void main(String[] args) {

    

        String choice = "";
        // actions for the user to select from
        String menu = "--------- Welcome to TokTik ---------\n";
        menu += "Menu:\nChoose an action from the menu: (Choose 1-10)";
        menu += "\n1. Find the profile description for a given account";
        menu += "\n2. List all accounts";
        menu += "\n3. Create an account";
        menu += "\n4. Delete an account";
        menu += "\n5. Display all posts for a single account";
        menu += "\n6. Add a new post for an account";
        menu += "\n7. Update title for a post";
        menu += "\n8. Find a post";
        menu += "\n9. Load a file of actions from disk and process this";
        menu += "\n10. Help";
        menu += "\n11. Quit\nEnter your choice: ";
        // help menu to give users extra information
        String help = "Help Menu:";
        help += "\n1. Displays the description of any you account you enter if exists in the system";
        help += "\n2. Lists all the accounts in the current system in alphabetical order";
        help += "\n3. Creates an account and add it to the system. Provide a unique username and profile description";
        help += "\n4. Deletes an account you enter from the syste, provided that the account exists";
        help += "\n5. Displays all the posts for an account you enter in the order of most recent first, provided the account exists";
        help += "\n6. Adds a new post to any account in the system, provided that the account exists";
        help += "\n7. Updates the title of any post for a user's account, given that the account and post exist";
        help+="\n8. Finds and outputs a post of any user based on the post's filename, given that the account and post both exist";
        help += "\n9. Loads actions from a disk to generate exisiting accounts and posts in the system. This file is named dataset.txt";
        help += "\n10. Opens this help menu";
        help += "\n11. Exits TokTik";
        help += "\nPress \"X\" to return to menu: ";

        while (choice != "11") {
            System.out.print(menu);
            choice = input.nextLine();

            switch (choice) {
                case "1":
                    findDesc();
                    break;

                case "2":
                    System.out.println("\n-- Accounts --\n");
                    bst.inOrder();
                    break;

                case "3":
                    System.out.println("\n-- Create New Account --\n");
                    createAccount();
                    break;

                case "4":
                    System.out.println("\n-- Delete Account --\n");
                    deleteAccount();
                    break;

                case "5":
                    System.out.println("\n-- Posts --\n");
                    displayPosts();
                    break;

                case "6":
                    System.out.println("\n-- New Post --\n");
                    addPosts();
                    break;

                case "7":
                    System.out.println("\n -- Update a Post Title --\n");
                    changeTitle();
                    break;

                case "8":
                    findPost();
                    break;
                case "9":
                    // runs processes to do the actions in a file such as adding and deleting files
                    loadFileActions();
                    break;
                case "10":
                    System.out.println("\n" + help);
                    String decision = input.next();
                    input.nextLine();
                    if (decision.equalsIgnoreCase("X"))
                        continue;
                case "11":
                    System.out.println("\n-- Goodbye! --\n");
                    input.close();
                    System.exit(0);
                    break;
                default:
                    // if the user does not enter a number from 1-8
                    System.out.println("\n-- Please select a valid option (1-11) --\n");
                    break;

            }
        }

    }

    /**
     * Finds the description of a given account by passing in username to search in
     * the
     * tree and by outputting the description of it.
     * If the username is not found in the binary tree then it will output that it
     * does not exist.
     * 
     * @param targetName The name of the user to search in the binary tree
     */
    public static void findDesc() {
        System.out.print("Enter the account name (or \"back\" to return to menu): ");
        String targetName = input.next();
        input.nextLine();
        if (!targetName.equalsIgnoreCase("back")) {
            User temp = new User(targetName, "");
            BinaryTreeNode<User> found = bst.find(temp);
            if (found == null) {
                System.out.println("\n-- Account entered does not exist --\n");
            } else {
                System.out.println("\nProfile Desription: " + found.getData().getDesc() + "\n");
            }
        }
    }

    /**
     * Method to create an account and add it to the binary tree based on user
     * input.
     */
    public static void createAccount() {
        BinaryTreeNode<User> exists;
        do {
            System.out.print("Enter an account name (or \"back\" to return to menu): ");
            String accName = input.next();
            input.nextLine();
            System.out.print("Enter an account description (or \"back\" to return to menu): ");
            String desc = input.nextLine();

            if (accName.equalsIgnoreCase("back") || desc.equalsIgnoreCase("back")) {
                break;
            }
            User inAcc = new User(accName, desc);
            exists = bst.find(inAcc);

            if (exists != null) {
                System.out.println("Account name already exists, please try again");
                System.out.println("Do you want to continue? Y/N"); // Allows them to quit if they don't want to
                                                                    // continue
                String cont = input.nextLine();

                if (cont.equals("Y") || cont.equals("y")) {
                    continue;
                } else {
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
     * @param desc    The description of the respective account entered
     */
    public static void createAccount(String accName, String desc) {
        // BinaryTreeNode<User> exists;
        User inAcc = new User(accName, desc);
        // exists = bst.find(inAcc);
        bst.insert(inAcc);

    }

    /**
     * Deletes an account based on the username that the user enters.
     * If it is not found, the user can try again if they wish
     */
    public static void deleteAccount() {
        BinaryTreeNode<User> foundToDelete;
        do {
            System.out.print("Enter account to delete (or \"back\" to return to menu): ");
            String deleteName = input.next();
            input.nextLine();

            if (deleteName.equalsIgnoreCase("back")) {
                break;
            }
            // Create a new user with the name to search for
            User deleteUser = new User(deleteName, "");
            // See if an object with the same name can be found
            foundToDelete = bst.find(deleteUser);

            if (foundToDelete == null) {
                System.out.println("\n-- Account name does not exist, please try again --\n");
                System.out.println("Do you want to continue? Y/N");
                String cont = input.nextLine();

                if (cont.equals("Y") || cont.equals("y")) {
                    continue;
                } else {
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
        System.out.print("Enter the account name (or \"back\" to return to menu): ");
        String postsName = input.next();
        input.nextLine();
        // create a target object with the same name and have it return a node with the
        // correct user object
        if (!postsName.equalsIgnoreCase("back")) {
            User target = new User(postsName, "");
            BinaryTreeNode<User> foundForPosts = bst.find(target);
            if (foundForPosts == null) {
                System.out.println("\n-- Account cannot be found --\n");
            } else {
                foundForPosts.getData().getPosts();
            }
        }

    }

    /**
     * Asks the user to enter a title, filename and number of likes.
     * It then creates a post object and adds it to the linked list belonging to a
     * user
     */
    public static void addPosts() {
        System.out.print("Enter the account to add a post to (or \"back\" to return to menu): ");
        String postAcc = input.next();
        input.nextLine();

        if (!postAcc.equalsIgnoreCase("back")) {
            User poster = new User(postAcc, "");
            BinaryTreeNode<User> toPost = bst.find(poster);

            if (toPost != null) {
                System.out.print("Title: ");
                String postTitle = input.nextLine();
                System.out.print("File name: ");
                String fileName = input.next();
                input.nextLine();
                System.out.print("Number of likes: ");
                String inLikes = input.next();
                input.nextLine();
                //checks if the number entered is an integer or not
                if(!inLikes.matches("\\d+")){
                    System.out.println("\n--Please enter a number for the number of likes--\n");
                    
                }else{
                    int numLikes = Integer.parseInt(inLikes);

                    
                    Post inPost = new Post(postTitle, fileName, numLikes);

                    toPost.getData().addPost(inPost);
                    System.out.println("\n-- Post Added --\n");
                }   
            } else {
                System.out.println("\n-- Account cannot be found, cannot make a post --\n");
            }
        }

    }

    /**
     * Adds posts to the account of a user based off the actions from a file
     * 
     * @param postAcc   The account to add the post to
     * @param postTitle The title of the post to be added
     * @param numLikes  The number of likes for the post
     * @param fileName  The fileName of the post
     */
    public static void addPosts(String postAcc, String postTitle, int numLikes, String fileName) {
        User poster = new User(postAcc, "");
        BinaryTreeNode<User> toPost = bst.find(poster);

        // find the post account and then add to it
        Post inPost = new Post(postTitle, fileName, numLikes);
        toPost.getData().addPost(inPost);
    }

    /**
     * Loads actions from an external file to create and add a file
     * 
     * @throws e If the file cannot be found it throws this exception
     */
    public static void loadFileActions() {
        // create logic to add accounts from file for add and remove
        Scanner fileIn = null;
        try {
            System.out.print("Please enter a filename to load (or \"back\" to return to menu): ");
            String fileName = input.next();
            input.nextLine();

            if (!fileName.equalsIgnoreCase("back")) {

                fileIn = new Scanner(new FileInputStream(fileName));

                while (fileIn.hasNext()) {
                    String line = fileIn.nextLine();
                    String[] splitLine = line.split(" ");

                    if (splitLine[0].equalsIgnoreCase("Create")) {
                        int createLength = splitLine[0].length(); // length of the word "create"
                        int nameLength = splitLine[1].length(); // length of the username
                        int spaces = 2;
                        // substring for the description from after the word to the end of the line
                        createAccount(splitLine[1], line.substring(nameLength + createLength + spaces, line.length()));

                    } else {
                        int addLength = splitLine[0].length(); // length of the word "add"
                        int nameLength = splitLine[1].length(); // length of the username
                        int fileNameLength = splitLine[2].length(); // length of the filename
                        int numLikesLength = splitLine[3].length(); // length of the number of likes as a string
                        int spaces = 4;
                        addPosts(splitLine[1],
                                line.substring(addLength + nameLength + fileNameLength + numLikesLength + spaces,
                                        line.length()),
                                Integer.parseInt(splitLine[3]), splitLine[2]); // adds the post with the respective
                                                                               // files
                                                                               // and uses substring to account for
                                                                               // spaces
                    }

                }
                System.out.println("\n --Actions loaded from disk-- \n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("\n--System could not find the file--\n");
        }
    }

    /**
     * Method to change the title of a post for a certain account.
     * This is if the user's account exists and if the post entered also exists
     */
    public static void changeTitle() {
        System.out.print("Enter the account to edit a post for (or \"back\" to return to menu): ");
        String accName = input.next();
        input.nextLine();

        System.out.print("Enter the filename of the post to edit (or \"back\" to return to menu): ");
        String file = input.next();
        input.nextLine();

        System.out.print("Enter the new post title (or \"back\" to return to menu): ");
        String postTitle = input.nextLine();
        
        if (!accName.equalsIgnoreCase("back") || !file.equalsIgnoreCase("back")
                || !postTitle.equalsIgnoreCase("back")) {
            User poster = new User(accName, "");
            BinaryTreeNode<User> toUpdate = bst.find(poster);

            if (toUpdate != null) {
                Post update = toUpdate.getData().getListOfPosts().findPost(file);
                if (update != null) {
                    update.updateTitle(postTitle);
                    System.out.println("\n--Post Updated--\n");
                } else {
                    System.out.println("\n-- Post could not be found, cannot update -- \n");
                }
            } else {
                System.out.println("\n -- Account not found, cannot update post --\n");
            }
        }
    }

    /**
     * Method that finds a post based off the filename.
     * If the post does not exist, gives the user an appropriate error message
     */
    public static void findPost() {
        System.out.print("\n-- Find a post--\n");
        System.out.print("Enter the account to find a post for (or \"back\" to return to menu): ");
        String accName = input.next();
        input.nextLine();

        System.out.print("Enter the filename of the post to find (or \"back\" to return to menu): ");
        String file = input.next();
        input.nextLine();

        if (!accName.equalsIgnoreCase("back") || !!file.equalsIgnoreCase("back")) {
            User poster = new User(accName, "");
            BinaryTreeNode<User> toUpdate = bst.find(poster);

            if (toUpdate != null) {
                Post found = toUpdate.getData().getListOfPosts().findPost(file);
                if (found != null) {
                    System.out.println("\n-- Results --\n");
                    System.out.println(found.toString());
                } else {
                    System.out.println("\n-- Post could not be found -- \n");
                }
            }
        }

    }

}
