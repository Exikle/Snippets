using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

/*
 * Student: Dixon D'Cunha
 * Date: Sept 14, 2013
 * Coursera: Beginning Game Programming with C# 
 * Teacher: Dr. Tim "Dr. T" Chamillard
 * Assignment: Programming Assignment 1
 */
namespace PlayerStatistics {
    class Program {

        //The amount of minutes in an hour
        static readonly int MIN_PER_HOUR = 60;

        static void Main(string[] args) {

            //Welcome
            Console.WriteLine("Welcome!");
            Console.WriteLine("This application will calculate your average gold-collecting performance!");

            //Input
            Console.Write("How much gold have you collected in the game? ");
            int goldCollected = int.Parse(Console.ReadLine());
            Console.Write("How much hours have you played the game? ");
            float hoursPlayed = float.Parse(Console.ReadLine());

            Console.WriteLine("");

            //Calculations
            //1 hour = 60 min therfore hours * 60 =  amount of minutes
            float minutesPlayed = hoursPlayed * MIN_PER_HOUR;
            float goldPerMin = goldCollected / minutesPlayed;

            //Output
            Console.WriteLine("The amount of gold you have collected: " + goldCollected);
            Console.WriteLine("The amount of time in hours that you have played: " + hoursPlayed);
            Console.WriteLine("The gold per minute you make is: " + goldPerMin);
        }
    }
}