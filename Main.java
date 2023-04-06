import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // User andrew = new User("andrewOnTok", "I make fun videos");
        // User bella = new User("bellasTok", "I make art videos");
        // User hayden = new User("haydennn", "I make car videos");

        //

        // bst.insert(bella);
        // bst.insert(andrew);
        // bst.insert(hayden);

        // bst.preOrder();

        //Add logic for error handling
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
            System.out.println(menu);
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the account name: ");
                    // add logic to find a User object in the tree based off the name
                    break;

                case 2:
                    System.out.println("\n-- Accounts --");
                    break;

                case 3:
                    System.out.println("\n-- Create New Account --");
                    System.out.println("Enter an account name: ");
                    String accName = input.nextLine();
                    System.out.println("Enter an account description: ");
                    String desc= input.nextLine();

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
                    break;
                default:
                    System.out.println("Please select a valid option (1-8)");
                    break;

            }
        }

    }
}
