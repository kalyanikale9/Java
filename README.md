**Ch1. An Introduction  to Java **
Java Operators Reference Note
1.	Arithmetic Operators
Arithmetic operators perform basic mathematical calculations. Java uses Integer Division (truncates decimals) when both operands are integers, and Floating-point Division if at least one operand is a decimal type.
 Syntax & Behaviour
•	+ (Addition): Sums numbers or concatenates strings.
•	- (Subtraction): Subtracts right operand from left.
•	* (Multiplication): Multiplies values.
•	/ (Division): Divides left operand by right.
•	% (Modulus): Returns the division remainder. [1, 2, 3]
 Example
java
int a = 15;
int b = 4;

System.out.println(a + b); // Outputs: 19
System.out.println(a - b); // Outputs: 11
System.out.println(a * b); // Outputs: 60
System.out.println(a / b); // Outputs: 3 (Integer division drops .75)
System.out.println(a % b); // Outputs: 3 (15 divided by 4 leaves a remainder of 3)

double division = (double) a / b; 
System.out.println(division); // Outputs: 3.75 (Floating-point division)
Use code with caution.
2.	Increment and Decrement Operators
These unary operators alter an integer variable value by exactly 1. [1]
 Syntax & Behaviour
•	++ (Increment): Increases value by 1.
•	-- (Decrement): Decreases value by 1.
•	Prefix (++x / --x): Updates the variable value before the expression evaluates.
•	Postfix (x++ / x--): Evaluates the expression with the old value, then updates the variable after. [1]
 Example
int x = 10;
int y = 10;

// Prefix evaluation
int prefixResult = ++x; 
System.out.println("x: " + x + ", Result: " + prefixResult); // Outputs: x: 11, Result: 11

// Postfix evaluation
int postfixResult = y++; 
System.out.println("y: " + y + ", Result: " + postfixResult); // Outputs: y: 11, Result: 10
Use code with caution.
3. Relational Operators
Relational operators compare primitive operands and always return a boolean state (true or false).
 Syntax & Behaviour
•	== (Equal to) | != (Not equal to)
•	> (Greater than) | < (Less than)
•	>= (Greater than or equal to) | <= (Less than or equal to) [1, 2, 3]
 Example
java
int p = 20;
int q = 25;

System.out.println(p == q); // Outputs: false
System.out.println(p != q); // Outputs: true
System.out.println(p < q);  // Outputs: true
System.out.println(p >= q); // Outputs: false
Use code with caution.
4. Logical Operators
Logical operators combine multiple Boolean expressions. Java implements short-circuit evaluation, skipping execution of the second expression if the final output can be determined by the first.
 Syntax & Behaviour
•	&& (Conditional-AND): Returns true if both states are true. (Short-circuits to false if the first expression is false).
•	|| (Conditional-OR): Returns true if at least one state is true. (Short-circuits to true if the first expression is true).
•	! (Logical NOT): Reverses a boolean value.
 Example
java
int age = 20;
boolean hasLicense = true;

// Both must be true
boolean canDrive = (age >= 18) && hasLicense; 
System.out.println(canDrive); // Outputs: true

// Short-circuit example
boolean rule = (age < 10) && (10 / 0 == 0); 
System.out.println(rule); // Outputs: false (Does not crash because age < 10 is false)

System.out.println(!hasLicense); // Outputs: false
Use code with caution.
5. Bitwise Shift Operators
Shift operators manipulate individual bits of binary numbers. Java uses two's complement form for signed negative integer numbers.
 Syntax & Behaviour
•	<< (Left Shift): Shifts bits left; fills empty right spots with 0. (Equivalent to \(x \times 2^n\)).
•	>> (Signed Right Shift): Shifts bits right; preserves the sign bit (0 for positive, 1 for negative).
•	>>> (Unsigned Right Shift): Shifts bits right; fills empty left spots with 0 regardless of the original sign.
 Example
java
int val = 12; // Binary: 0000 1100

// Left Shift
int leftResult = val << 2;  
System.out.println(leftResult); // Outputs: 48 (Binary: 0011 0000)

// Signed Right Shift
int rightResult = val >> 2; 
System.out.println(rightResult); // Outputs: 3 (Binary: 0000 0011)

// Unsigned Right Shift effect on a negative integer
int negVal = -8;
System.out.println(negVal >> 1);  // Outputs: -4 (Preserves the sign bit)
System.out.println(negVal >>> 1); // Outputs: 2147483644 (Fills left bit with 0)
Use code with caution.
Summary
Java utilizes structured arithmetic operations, pre/post evaluation adjustments, boolean comparisons, conditional short-circuit evaluations, and bit manipulation configurations to execute logic.
More Information 
https://www.youtube.com/watch?v=nJbXWIDt2u4


