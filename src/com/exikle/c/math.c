#include <stdio.h>

int main()
{
	int x, y;
	x = 2;
	y = 3;

	if ((x > 1)&&(y < 6))
	{
		printf("true");
	}

	if ((x == 2) || (y == 2))
	{
		printf("true");
	}
	return 0;
}