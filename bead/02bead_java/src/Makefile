Make: ./*/*.java ./*/*/*.java
	@find . -type f -path "./*/*" -name "*.class" -delete
	@javac main/Main.java
	@java main.Main BB input.txt output.txt
format-stdout: ../../.clang-format
	find . -iname *.java | xargs clang-format
format: ../../.clang-format
	find . -iname *.java | xargs clang-format -i
clean: 	
	find . -type f -path "./*/*" -name "*.class" -delete
	rm -rf output.txt

