#include <stdio.h>

int main()   /*Designates the main section of the program */
{

    int myVariable; /* Declares and int variable */
    
    myVariable = 15; /* Set the variable's value to 15 (Magic Number) */
    
    printf("The value is %d \n", myVariable); /*Prints out "myVariable" */
    
    myVariable = 20; /*Reassigns "myVariable" another value*/
    
    printf("The value is %d \n", myVariable); /*Prints out the new value*/
    
    int booleanVal; /*Creates a boolean int*/
    
    booleanVal = 1;/*Sets the boolean int to true*/
    
    printf("This variable is true: %d \n", booleanVal); /*Prints whether the value is  true*/
    
    booleanVal = 0; /* Changes the value to false */
    
    printf("This variable is false: %d \n", booleanVal); /*Prints the false value*/
        
    return(0); /* Exits the program */
}