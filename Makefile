JAVAC = javac
JAVA = java
JFLAGS = -g

MAIN = Bank

SOURCES = $(wildcard *.java)

CLASSES = $(SOURCES:.java=.class)

default: classes

classes: $(CLASSES)

%.class: %.java
	$(JAVAC) $(JFLAGS) $<

run: classes
	$(JAVA) $(MAIN)

clean:
	rm -f *.class

.PHONY: default classes run clean
