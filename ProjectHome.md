# eSuite #

Program that solves numerically algebraic systems of non-linear, and linear, equations where one only has to write down the equations to obtain the results.
It also includes a database of thermodynamical properties for many substances and a  symbolic mathematical program to perform mathematical operations.
Basically the program is an open source clone of the EES but written in Java.

**100% FREE award granted by Softpedia**
http://www.softpedia.com/progClean/Engineering-Suite-Clean-187045.html

## Open source and multiplatform equation solver ##

The purpose of this project is to create a fully functional program that allows the user to solve systems of non-linear equations, more concretely engineering type equations. Also, it includes a data base of thermodynamical properties of several substances: steam, air, nitrogen, argon, butane, propane,...

## Features ##

Solves systems of non-linear algebraic equation in an easy way. For example:
> For solving the second newton law you only have to introduce the following code:
```
F = M * A
/*It includes trigonometric, hiperbolic, logarithms and exponential functions*/
M = 2 * 2 + 1 - 1 + sin(Pi) + sinh(2.7)
A = 2^2*(exp(2/3)+log(1))
```

> Calling a thermodynamic property in the program, it includes validity range and reliable information:
```
/**Temperature: Kelvin.
Cp: Kj/(Kg*Kelvin)
Average error: 0.24
Validity: 273 to 1500*/
Butane.Cp(Cp, Temperature)
/*You can change the name of the variables Cp and temperature, but the order must be the same*/
Temperature = 700
```
## Pictures ##
**Equations window**

![http://engineeringsuite.googlecode.com/svn/trunk/Imagenes/Main.png](http://engineeringsuite.googlecode.com/svn/trunk/Imagenes/Main.png)

**Symbolic program**

![http://engineeringsuite.googlecode.com/svn/trunk/Imagenes/Mathematics.png](http://engineeringsuite.googlecode.com/svn/trunk/Imagenes/Mathematics.png)

**Rendered equations**

![http://engineeringsuite.googlecode.com/svn/trunk/Imagenes/Equations.png](http://engineeringsuite.googlecode.com/svn/trunk/Imagenes/Equations.png)

### Other features ###

**GUI features:**

  1. Undo/Redo.
  1. Save/Load.
  1. Export to pdf and Print.
  1. Add/Remove your own thermodynamical properties for a substance or include new substances.
  1. Complete help, explains not only how to use the program but also the algorithms.
  1. Syntax and parenthesis highlight.
  1. Two kind of comments, to emphasize the information.
  1. The program is in english and in spanish.

**Mathematical features**

  1. Four algorithms to carry out the resolution of the equations. The algorithms are globally convergent methods. The included ones are the following: Levenberg-Marquard, Double-Dogleg, Hebden-Moré and Dumped Newton -Newton with backtracking-
  1. Initial value of the variables can be changed.
  1. Tarjan algorithm is used to reduce split the equations in smaller systems of equations. For example to solve two equation system of 2 x 2 instead one of 4 x 4.
  1. The only limit for the number of equations depends on the complexity of them.
  1. It also includes a mathematical symbolic program, based on Matheclipse.

---
