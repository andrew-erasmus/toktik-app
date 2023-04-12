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

CLASSES= BTQueueNode.class BTQueue.class BinaryTreeNode.class BinaryTree.class \
         BinarySearchTree.class BinarySearchTreeTest.class \
		 Post.class PostList.class User.class Main.class  

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)
default: $(CLASS_FILES)
	
clean:
	rm $(BINDIR)/*.class

run: $(CLASS_FILES)
	java -cp bin Main

# JFLAGS = -g
# JC = javac
# SRC_DIR = src
# BIN_DIR = bin
# .SUFFIXES: .java .class
# .java.class:
# 	$(JC) $(JFLAGS) -cp $(BIN_DIR) -d $(BIN_DIR) $*.java

# CLASSES = \
# 	$(SRC_DIR)/BTQueueNode.java \
# 	$(SRC_DIR)/BTQueue.java \
# 	$(SRC_DIR)/BinaryTreeNode.java \
# 	$(SRC_DIR)/BinaryTree.java \
# 	$(SRC_DIR)/BinarySearchTree.java \
# 	$(SRC_DIR)/BinarySearchTreeTest.java \
# 	$(SRC_DIR)/Post.java \
# 	$(SRC_DIR)/PostList.java \
# 	$(SRC_DIR)/User.java \
# 	$(SRC_DIR)/Main.java

# default: classes

# classes: $(CLASSES:.java=.class)

# clean:
# 	$(RM) $(BIN_DIR)/*.class
