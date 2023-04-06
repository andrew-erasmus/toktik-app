import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //DO TO
        //Add logic for error handling
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
                    System.out.print("Enter the account name: ");
                    String targetName = input.next();
                    input.nextLine();
                    // create a target object with the same name and have it return a node with the correct user object
                    User temp = new User(targetName, "");
                    BinaryTreeNode<User> found = bst.find(temp);
                    System.out.println("\nProfile Desription: "+found.data.getDesc()+"\n");
                    break;

                case 2:
                    System.out.println("\n-- Accounts --\n");
                    bst.inOrder();
                    break;

                case 3:
                    System.out.println("\n-- Create New Account --\n");
                    BinaryTreeNode<User> exists;
                    do{
                        System.out.print("Enter an account name: ");
                        String accName = input.next();
                        input.nextLine();
                        System.out.print("Enter an account description: ");
                        String desc= input.nextLine();

                        User inAcc = new User(accName, desc);
                        exists=bst.find(inAcc);
                        
                        if(exists!=null){
                            System.out.println("Account name already exists, please try again");
                        }else{
                            bst.insert(inAcc);
                            System.out.println("\n-- New Account Created --\n");
                        }
                    }while(exists!=null);           
                    break;

                case 4:
                
                    System.out.println("\n-- Delete Account --\n");
                    System.out.print("Enter account to delete: ");
                    String deleteName= input.next();
                    input.nextLine();
                    User deleteUser = new User(deleteName, "");
                    bst.delete(deleteUser);
                    System.out.println("\n-- Account Deleted --\n");
                    break;

                case 5:
                    System.out.println("\n-- Posts --\n");
                    System.out.print("Enter the account name: ");
                    String postsName = input.next();
                    input.nextLine();
                    // create a target object with the same name and have it return a node with the correct user object
                    User target = new User(postsName, "");
                    BinaryTreeNode<User> foundForPosts = bst.find(target);
                    foundForPosts.data.getPosts();

                    break;
                    
                case 6:
                    System.out.println("\n-- New Post --\n");
                    System.out.print("Enter the account to add a post to: ");
                    String postAcc = input.next();
                    input.nextLine();

                    User poster = new User(postAcc, "");
                    BinaryTreeNode<User> toPost = bst.find(poster);

                    // find the post account and then add to it
                    System.out.print("Title: ");
                    String postTitle = input.nextLine();
                    System.out.print("File name: ");
                    String fileName = input.nextLine();
                    System.out.println("Number of likes: ");
                    int numLikes = input.nextInt();
                    Post inPost = new Post(postTitle,fileName,numLikes); 

                    toPost.data.addPost(inPost);
                    break;
                    
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
