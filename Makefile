Make: ./*/*.java
	@find . -type f -path "./*/*" -name "*.class" -delete
	@javac main/Main.java
	@java main.Main BB ../test/input.txt output.txt
format-stdout: .clang-format
	clang-format -style=file ./*/*.java ./*/*/*.java
format: .clang-format
	clang-format -i -style=file ./*/*.java ./*/*/*.java ./*/*/*/*.java
