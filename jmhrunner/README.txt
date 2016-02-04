PROJECT SETUP

See the instructions in /doc/SETUP.txt

RUNNING

Run "gradlew tasks" from the jmhrunner directory to see a list of tasks
Run "gradlew jmh" to run your JMH benchmarks - this will output human readable results.csv files in each sub-projects' /build/reports/jmh/human.txt file.
Run "gradlew plot" to run all JMH demos and plot the results (this will require installing the matplotlib python library, see instructions in ../chart/doc/SETUP.txt).

VSCODE

This directory is setup to run as a Visual Studio Code project, so you can edit and run from a nice IDE for text editing.  

VS Code Shortcuts
Ctrl+Shift+B - build
Ctrl+Shift+R - run tasks

The /.vscode directory contains files which define the VSCode bindings for the project:
- tasks.json
-- Defines tasks which can be run with the run tasks command
-- Define a gradle task runner
-- Defines a default build command for this project = gradle
