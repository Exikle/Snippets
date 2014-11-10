/*************************a2.c****************************
Student Name: Dickson D'Cunha                Student Number:  0904177
Date: 09/29/14                               Course Name: CIS*1500_F14
I have exclusive control over this submission via my password.
By including this statement in this header comment, I certify that:
     1) I have read and understood the University policy on academic integrity;
     2) I have completed the Computing with Integrity Tutorial on Moodle; and
     3) I have achieved at least 80% in the Computing with Integrity Self Test.
I assert that this work is my own. I have appropriately acknowledged any and all material
(data, images, ideas or words) that I have used, whether directly quoted or paraphrased.
Furthermore, I certify that this assignment was prepared by me specifically for this course.
****************************************************************************/

/*******************

Game must be able too play with these combinations.

Scissors cuts paper.
Paper covers rock.
Rock crushes lizard.
Lizard poisons Spock.
Spock smashes scissors.
Scissors decapitates lizard.
Lizard eats paper.
Paper disproves Spock. 
Spock vaporizes rock. 
Rock crushes scissors.

Needs to ask which game mode they want to play
1.  rock-paper-scissors
2.  rock-paper-scissors-lizard-Spock

Check how many times player wants to play(loop, duh)

For each loop (req decision statements )
..............
	prompt the player for a numerical equivalent to rock-1, paper-2, sissors-3, (lizard-4, Spock-5)

	int x;
	srand(time(NULL));
	x = (rand() % 3) + 1; OR x = (rand() % 5) + 1; (for lizard and spock)
	
	Check who wins, count/ record the number
	
	If loop finished, display statistics (wins ofr player, wins for computer, ties)
	else LOOOOOP again
	
	Sample Output ------------------------------------>
	This program allows you to play Rock, Paper, Scissors
	How many games do you want? 2
	
	Game number 1
	3=Rock, 2=Scissors, 1=Paper
	What's your choice? 1
	My choice is paper
	Tie game - no winner
	
	Game number 2
	3=Rock, 2=Scissors, 1=Paper
	What's your choice? 3
	My choice is scissors
	You win!!
	
	Here is the final score
	I have won 0 game(s), 
	you have won 1 game(s)
	and 1 games ended in a tie
	Thanks for playing!
	
	
*************************/

#include <stdlib.h>
#include <time.h>

int main()
{
	int timesToLoop=0; //Amount of games to play
	int playerScore=0; //Amount of times player won
	int compScore=0; //Amount of times comp won
	int tieCount=0; //Amount of times won
	
	int playerChoice=0; //Which choice the player chose
	int compChoice=0; //Which choice did the comp get
	
	int gameType=0; // 1 - Regular, 2 - Big Bang Version
	
	do
	{
	printf("What type of game would you like to play?\nRegular rock-paper-scissors = 1 OR rock-paper-scissors-lizard-Spock = 2\n");
	scanf("%d", &gameType); //Gets players choice for game type
	}while(gameType==0 || gameType>=3);
	
	printf("How many times would you like to play? ");
	scanf("%d", &timesToLoop); //Gets players choice for game type

	
	for (int i=0;i<timesToLoop;i++)//Number of rounds - loop
    {	
		//reset variables
		playerChoice=0;
		compChoice=0;
		
		printf("\n");
		printf("Game %d\n",i+1);
		
		
			switch(gameType)
			{
				case 1:
					do //repeats till player chooses the right number in range
					{ 
					printf("3=Rock, 2=Scissors, 1=Paper\n");
					printf("Whats your choice? ");
					scanf("%d", &playerChoice); //Gets players choice for game type
					} while(playerChoice==0 || playerChoice>=4);
					break;
				case 2: 
					do //repeats till player chooses the right number in range
					{ 
					printf("5=Spock, 4=Lizard, 3=Rock, 2=Scissors, 1=Paper\n");
					printf("Whats your choice? ");
					scanf("%d", &playerChoice); //Gets players choice for game type
					} while(playerChoice==0 || playerChoice>=6);
					break;
			}
		
		printf("What I chose was ");
		
		switch(gameType)
		{
			case 1: 
				srand(time(NULL));
				compChoice = (rand() % 3) + 1;
				break;
			case 2:
				srand(time(NULL));
				compChoice = (rand() % 5) + 1;
				break;
		}
		
		switch(compChoice)
		{
			case 1: printf("Paper.\n");
				break;
			case 2: printf("Scissors.\n");
				break;
			case 3: printf("Rock.\n");
				break;
			case 4: printf("Lizard.\n");
				break;
			case 5: printf("Spock.\n");
				break;
		}
		
		printf("CALCULATING WINNER.\n"); //check who wins
		
		
		if(playerChoice == 1) //Paper
		{	
			switch(compChoice)
			{
				case 1: //Paper
					printf("Tie game - no winner\n");
					tieCount+=1;
					break;
				case 2: //Scissors
					printf("Scissors cuts paper\nYou Lose...\n");
					compScore+=1;
					break;
				case 3: //Rock
					printf("Paper covers rock\nYou Win!!!!\n");
					playerScore+=1;
					break;
				case 4:	//Lizard
					printf("Lizard eats Paper\nYou Lose...\n");
					compScore+=1;
					break;
				case 5: //Spock
					printf("Paper disproves Spock\nYou Win!!!!\n");
					playerScore+=1;
					break;
			}
		}
		else if(playerChoice == 2) //Scissors
		{	
			switch(compChoice)
			{
				case 1: //Paper
					printf("Scissors cuts paper\nYou win!!!\n");
					playerScore+=1;
					break;
				case 2: //Scissors
					printf("Tie game - no winner\n");
					tieCount+=1;
					break;
				case 3: //Rock
					printf("Rock crushes scissors\nYou Lose...\n");
					compScore+=1;
					break;
				case 4:	//Lizard
					printf("Scissors decapitates lizard\nYou Win!!!\n");
					playerScore+=1;
					break;
				case 5: //Spock
					printf("Spock smashes scissors\nYou lose...\n");
					compScore+=1;
					break;
			}
		}
		else if(playerChoice == 3) //Rock
		{	
			switch(compChoice)
			{
				case 1: //Paper
					printf("Paper covers rock\nYou lose...\n");
					compScore+=1;
					break;
				case 2: //Scissors
					printf("Rock crushes scissors\nYou Win!!\n");
					playerScore+=1;
					break;
				case 3: //Rock
					printf("Tie game - no winner\n");
					tieCount+=1;
					break;
				case 4:	//Lizard
					printf("Rock crushes lizard\nYou Lose...\n");
					compScore+=1;
					break;
				case 5: //Spock
					printf("Spock vaporizes rock\nYou lose...\n");
					compScore+=1;
					break;
			}
		}
		else if(playerChoice == 4) //Lizard
		{	
			switch(compChoice)
			{
				case 1: //Paper
					printf("Lizard eats paper\nYou Win!!!!\n");
					playerScore+=1;
					break;
				case 2: //Scissors
					printf("Scissors decapitates Lizard\nYou lose...\n");
					compScore+=1;
					break;
				case 3: //Rock
					printf("Rock crushes lizard\nYou lose...\n");
					compScore+=1;
					break;
				case 4:	//Lizard
					printf("Tie game - no winner\n");
					tieCount+=1;
					break;
				case 5: //Spock
					printf("Lizard poisons Spock\nYou win!!!\n");
					playerScore+=1;
					break;
			}
		}
		else if(playerChoice == 5) //Spock
		{	
			switch(compChoice)
			{
				case 1: //Paper
					printf("Paper disproves Spock\nYou lose...\n");
					compScore+=1;
					break;
				case 2: //Scissors
					printf("Spock crushes scissors\nYou win!!!\n");
					playerScore+=1;
					break;
				case 3: //Rock
					printf("Spock vaporizes rock\nYou win!!!\n");
					playerScore+=1;
					break;
				case 4:	//Lizard
					printf("Lizard poisons Spock\nYou lose!!!\n");
					compScore+=1;
					break;
				case 5: //Spock
					printf("Tie game - no winner\n");
					tieCount+=1;
					break;
			}
		}
	}//Loops ends here	
	
	printf("\nHere is the final score\n");
	printf("I have won %d game(s).\n", compScore);
	printf("You have won %d game(s).\n", playerScore);
	printf("We have tied %d game(s)\n", tieCount);
	printf("Thanks for playing!\n");
	return 0;
}
<<<<<<< HEAD
	//possibly create a method to calculate the winner, probably will remove lots of code redundancy
=======

//possibly create a method to calculate the winner, probably will remove lots of code redundancy

>>>>>>> origin/master
