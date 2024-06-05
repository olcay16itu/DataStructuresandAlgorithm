JC = javac
JFLAGS = -g
TARGET = Main
SOURCES = main.java StockDataManager.java Stock.java RandomInputFileGenerator.java PerformanceAnalysis.java AVLTree.java GUIVisualization.java 


default: $(TARGET)

$(TARGET): $(SOURCES)
	$(JC) $(JFLAGS) $^
	java $(TARGET)


clean:
	rm -f *.class

.PHONY: clean default