#include <stdio.h>

int main()
{
	int myInt; /* Creates a variable */
	
	myInt = 9; /* Sets the value of the variable */
	
	printf("%d",myInt); /* Prints out the variable */
	
	if (myInt == 5) /* Checks if the variable is equal to 5 */
	{
		printf("true");
	}
	else if(myInt == 7) /* Checks if the value is equal to 7 */
	{
		print("second condition is true!\n")
	}
	else /* All else fails, say "false" */
	{
		printf("false");
	}
    return 0;
}