# BookStore TDD Excercise

What is TDD: Writing the test before the code. It makes you think up front of how you will invoke your code and get the result back. This means you design the API first based on how you will use it. This frequently results in a better API.
Your coding style will change because you will NEED to think more modular, to be able to test parts of the code instead of just the whole thing.
You will also get to a point where you will be able to confidently pull out a major chunk and insert a new chunk instead behaving the same, because your test pass. I did that recently with a date parsing library, as the original was too lenient.

This Excercise is to develop a simple BookStore management software that would have 100% code coverage in form of tests.
