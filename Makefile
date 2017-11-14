Make: ./*/*.java
	@find . -type f -path "./*/*" -name "*.class" -delete
	@javac main/Main.java
	@java main.Main BB ../test/input.txt output.txt
format-stdout: .clang-format
	find -name "*.java" | xargs clang-format -style=file
format: .clang-format
	find -name "*.java" | xargs clang-format -i -style=file
