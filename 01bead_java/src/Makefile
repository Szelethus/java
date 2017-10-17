Make: ./*/*.java
	@find . -type f -path "./*/*" -name "*.class" -delete
	@javac main/Main.java
	@java main.Main BB ../test/input.txt output.txt

