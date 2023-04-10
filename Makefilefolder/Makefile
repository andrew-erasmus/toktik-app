# binary search program makefile
# Hussein Suleman
# 27 March 2017

JAVAC=./bin/javac

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $<

classes: BinaryTreeNode.class BinaryTree.class \
         BTQueueNode.class BTQueue.class \
         BinarySearchTree.class BinarySearchTreeTest.class \
		 User.class Post.class PostList.class Main.class

default: $(CLASSES)

clean:
	rm *.class
