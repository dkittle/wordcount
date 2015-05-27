# Code Sample
Please provide us with a code sample meeting the following requirements in the language of your choice. Please do not use any external libraries to complete this test. Exceptions to this rule being tools used for building or testing your solution (e.g. sbt, RSpec, JUnit, NUnit, Rake, Ant, etc).

## Task

Create a console application that takes a UTF-8 plain-text file as input and outputs:

- Total number of words in text file
- Ten most common words and number of occurrences for each

You application should be run from the command line using a single command. For example:

    $ python ./word_counter.py input.txt
    $ sbt "run input.txt"

Please include a test suite demonstrating the correctness of your solution and a README file clearly explaining how to build, run and test your application.

# Submission

The preferred way to submit a response to this task is as a Github repository. Alternatively, you may submit a zip file containing the source code for your solution.  Update the My Submission section below with details for your application.

# My Submission
My solution is a case class that is constructed with a string to parse words.  Internally it creates a List of tuples that contain a word and the number of times is appears in the string.  The class exposes accessor methods for word stats.

The solution is an App that can be run from sbt using:

    $ sbt "run src/test/resources/writing.txt"
    
I've included the first 5 paragraphs of "Tarzan of the Apes" to test with.  Tests validate the proper responses for empty strings, strings with punctuation, strings with numbers and strings with words.

To run the tests use:

    $ sbt test

I've not provided any accessor to get the number of occurances for a specific word.  I'd likely want to transform the List to a Map of word -> count for this functionalty.  It's outside the scope of the intial requirements, though.

