# Makefile: SCTMIC015

JAVAC = /usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin
DOCDIR=doc

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=LSItems.class AVLTree.class BST.class LSBSTApp.class LSAVLApp.class LSBSTAppTest.class LSAVLAppTest.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)
docs:
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java
clean:
	rm $(BINDIR)/*.class
run:
	java -cp bin LSItems
run2: 
	java -cp bin AVLTree
run3:
	java -cp bin BST
run4:
	java -cp bin LSBSTApp
run5:
	java -cp bin LSAVLApp
run6:
	java -cp bin LSBSTAppTest
run7:
	LSAVLAppTest.class	
