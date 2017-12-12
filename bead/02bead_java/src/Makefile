Make: ./*/*.java ./*/*/*.java
	@find . -type f -path "./*/*" -name "*.class" -delete
	@javac main/Main.java
	@java main.Main  apples1.txt moves1.txt output.txt
tests: snake/tests/ToApplesTest.java
	javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar snake/tests/ToApplesTest.java
run-tests:
	java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar	org.junit.runner.JUnitCore snake/tests.ToApplesTest
format-stdout: ../../../.clang-format
	find . -iname *.java | xargs clang-format
format: ../../../.clang-format
	find . -iname *.java | xargs clang-format -i
clean: 	
	find . -type f -path "./*/*" -name "*.class" -delete
	rm -rf output.txt

