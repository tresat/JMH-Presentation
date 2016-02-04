JMH EXAMPLES

Source

http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/

RUNNING

Run "gradlew jmh -PjmhClass=<CLASS_NAME>" to run a particular sample demos - this will output human readable results.csv files in the /build/reports/jmh/human.txt file.
Run "gradlew plot" to run all JMH demos and plot the results (this will require installing the matplotlib python library, see instructions in /chart/doc/SETUP.txt).