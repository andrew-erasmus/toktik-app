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

CLASSES= src/BTQueueNode.java src/BTQueue.java src/BinaryTreeNode.java src/BinaryTree.java \
         src/BinarySearchTree.java src/BinarySearchTreeTest.java \
		 src/Post.java src/PostList.java src/User.java src/Main.java  

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)
default: $(CLASS_FILES)
	
clean:
	rm $(BINDIR)/*.class

run: $(CLASS_FILES)
	java -cp bin Main
