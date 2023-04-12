# Andrew Erasmus
# Makefile for the tok tik application
# 12/04/2023

JAVAC=bin/javac
JAVA=bin/java

.SUFFIXES: .java .class
SRCDIR=src 
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=BinaryTreeNode.class \
		BinaryTree.class \
		BTQueueNode.class \
		BTQueue.class \
        BinarySearchTree.class \
		Post.class \
		PostList.class \
		User.class \
		Main.class
		 

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)
default: $(CLASS_FILES)
		
clean:
	rm $(BINDIR)/*.class

run: $(CLASS_FILES)
	java -cp bin Main