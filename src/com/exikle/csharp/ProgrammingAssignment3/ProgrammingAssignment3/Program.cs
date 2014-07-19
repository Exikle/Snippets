using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using ConsoleCards;

namespace ProgrammingAssignment3 {
    class Program {
        static Deck deck = new Deck();
        static BlackjackHand playerHand = new BlackjackHand("Player");
        static BlackjackHand dealerHand = new BlackjackHand("Dealer");

        static void Main(string[] args) {

            //Welcome
            Console.WriteLine("Welcome to Blackjack!");
            Console.WriteLine("The program will only play one hand of blackjack.");

            Console.WriteLine();

            //Shuffle and deal cards
            deck.Shuffle();

            playerHand.AddCard(deck.TakeTopCard());
            playerHand.AddCard(deck.TakeTopCard());

            dealerHand.AddCard(deck.TakeTopCard());
            dealerHand.AddCard(deck.TakeTopCard());

            //Show player cards and first dealer card
            playerHand.ShowAllCards();
            dealerHand.ShowFirstCard();

            //print the cards
            playerHand.Print();
            dealerHand.Print();

            //check if player wants to hit
            playerHand.HitOrNot(deck);

            //show all cards
            dealerHand.ShowAllCards();

            //print the cards
            playerHand.Print();
            dealerHand.Print();

            //calculate scores
            Console.WriteLine("Player's Hand Value: " + playerHand.Score);
            Console.WriteLine("Dealers's Hand Value: " + dealerHand.Score);

            Console.WriteLine();

        }
    }
}
