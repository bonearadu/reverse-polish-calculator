# Reverse Polish Calculator

Using the Java Swing library of GUI components, built an application that implements a Reverse Polish Calculator, where the user can click on the buttons and see the results of calculations.

## Rules

1. It can parse variable-sized reverse polish notation inputs
2. It can perform the 4 basic operators (addition, subtraction, multiplication, division)
3. It will return back the result of the input

### Example

(2 3 + 5 + 10 -) = 0 \
(2 2 2 * * 3 +) = 11


## Assumptions
1. We deal only with binary operators (=, -, *, /)
2. The result fits into a java Double
3. The evaluator throws custom exceptions when it finds a problem with the expression

## Improvements
1. We can enhance the calculator to accept unary operators.
2. We can enhance the calculator handle malformed RPN strings