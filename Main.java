import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //DO TO
        // Add an override to the Binary Tree so that can find a user based on their name
        //Add logic for error handling
        //// write logic so that the account does not exist already -- Possibly an exists class in the tree (recursive one)
        //add logic to delete based on the account name
        //Understand the 7th option
        //Do a makefile
        //Make a simple GUI
        //Watch out if inputs have an extra "\n"

        BinarySearchTree<User> bst = new BinarySearchTree<User>();
        Scanner input = new Scanner(System.in);
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
                    System.out.println("Enter the account name: ");
                    String targetName = input.next();
                    // add logic to find a User object in the tree based off the name
                    // create a target object with the same name and have it return a node with the correct user object
                    User temp = new User(targetName, "");
                    BinaryTreeNode<User> found = bst.find(temp);
                    System.out.println("Profile Desription: "+found.data.getDesc()+"\n");
                    break;

                case 2:
                    System.out.println("\n-- Accounts --");
                    bst.inOrder();
                    break;

                case 3:
                    System.out.println("\n-- Create New Account --");
                    System.out.print("Enter an account name: ");
                    String accName = input.next();
                    System.out.print("Enter an account description: ");
                    String desc= input.next();

                    User inAcc = new User(accName, desc);
                    // write logic so that the account does not exist already

                    bst.insert(inAcc);
                    System.out.println("-- New Account Created --");
                    break;

                case 4:
                
                    System.out.println("\n-- Delete Account --");
                    System.out.println("Enter account name to delete: ");
                    String deleteName= input.nextLine();
                    // add logic to delete based on the account name
                    break;

                case 5:
                    System.out.println("\n-- Posts --");


                    break;
                    // add logic to find a User object in the tree based off the name
                case 6:
                    System.out.println("\n-- New Post --");
                    System.out.println("Enter the account to add a post to: ");
                    String postAcc = input.nextLine();
                    // find the post account and then add to it
                    System.out.println("Title: ");
                    String postTitle = input.nextLine();
                    System.out.println("File name: ");
                    String fileName = input.nextLine();
                    System.out.println("Number of likes: ");
                    int numLikes = input.nextInt();
                    Post inPost = new Post(postTitle,fileName,numLikes); 

                    //postAcc.addPost(inPost);
                    break;
                    // add logic to find a User object in the tree based off the name
                case 7:
                    System.out.println("Enter disk action");
                    //create logic to add accounts from file for add and remove
                    break;
                case 8:
                    System.out.println("-- Goodbye! --");
                    input.close();
                    break;
                default:
                    System.out.println("Please select a valid option (1-8)");
                    break;

            }
        }

    }
}
