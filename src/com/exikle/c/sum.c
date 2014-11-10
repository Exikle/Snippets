#include <stdio.h>

int main()
{
    int sum;
    int sub;
    int multi;
    int div;
    int mod;
    

    int valOne;
    int valTwo; 

    valOne = 5;
    valTwo = 4;

    sum = valOne + valTwo;
    sub = valOne - valTwo;
    multi =  valOne * valTwo;
    div = valOne / valTwo;
    mod = valOne % valTwo;

    printf("The sum is: %d \n", sum);
    printf("The subtracted value is: %d \n", sub);
    printf("The multiplied value is: %d \n", multi);
    printf("The divided value is: %d \n", div);
    printf("The modulo value is: %d \n", mod);
    
    return(0);
}  