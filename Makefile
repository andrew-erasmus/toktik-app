# TokTik program makefile
# Andrew Erasmus
# 11/04/2023

JAVAC=./bin/javac
JAVA=./bin/java

.SUFFIXES: .java .class
SRCDIR=src 
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES: BTQueueNode.class BTQueue.class BinaryTreeNode.class BinaryTree.class \
         BinarySearchTree.class BinarySearchTreeTest.class \
		 Post.class PostList.class User.class Main.class  

CLASS_FILES=$(classes:%.class=$(BINDIR)/%.class)
default: $(CLASS_FILES)
	
clean:
	rm $(BINDIR)/*.class

run: $(CLASS_FILES)
	java -cp bin Main
