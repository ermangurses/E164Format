JFLAGS = -g
JC = javac -sourcepath . -classpath lib/*.jar 

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	E164Format.java \
	E164FormatTest.java 

default: classes

classes: $(CLASSES:.java=.class)

run:
	java -cp .:lib/libphonenumber-8.9.9.jar E164FormatTest

clean:
	$(RM) *.class
