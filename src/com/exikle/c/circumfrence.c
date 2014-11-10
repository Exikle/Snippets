#include <stdio.h>

int main()
{
    int sum;
    int sub;
    int multi;
    int div;
    int mod;
    float cirCumfOne;
    float cirCumfTwo;
    float cirAreaOne;
    float cirAreaTwo;
    float pi;
    int valOne;
    int valTwo; 

    valOne = 5;
    valTwo = 4;
    pi = 3.14;

    sum = valOne + valTwo;
    sub = valOne - valTwo;
    multi =  valOne * valTwo;
    div = valOne / valTwo;
    mod = valOne % valTwo;
    cirCumfOne = 2 * pi * valOne;
    cirAreaOne = pi * valOne * valOne;
    cirCumfTwo = 2 * pi * valTwo;
    cirAreaTwo = pi * valTwo * valTwo;

    printf("The sum is: %d \n", sum);
    printf("The subtracted value is: %d \n", sub);
    printf("The multiplied value is: %d \n", multi);
    printf("The divided value is: %d \n", div);
    printf("The modulo value is: %d \n", mod);
    printf("The first circle circumfrence value is: %f \n", cirCumfOne);
    printf("The first circle area value is: %f \n", cirAreaOne);
    printf("The second circle circumfrence value is: %f \n", cirCumfTwo);
    printf("The second circle area value is: %f \n", cirAreaTwo);
    
    return(0);
}  