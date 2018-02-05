user:011131029(Li,Everette)
---------------------------
Calculator:
Operation and numbers must be typed in three separate command lines
Example:
add
2.56
2.18
---------------------------
RandomStringGenerator:
When adding the range, the "from" and "to" characters must follow the alphabetical order. Otherwise, IllegalArgumentException would be triggered.
Example:
RSG.addRange('d','Z');	//is valid
RSG.addRange('z','a');	//is not
Additional function reset() has been added to empty the current range.
---------------------------
DataAnalyzerTester:
A .txt file called dataFile will be generated. Please use that to test the DataAnalyzer class.