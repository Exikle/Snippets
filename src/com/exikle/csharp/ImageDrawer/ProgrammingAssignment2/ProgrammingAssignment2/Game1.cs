using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Audio;
using Microsoft.Xna.Framework.Content;
using Microsoft.Xna.Framework.GamerServices;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;
using Microsoft.Xna.Framework.Media;

/*
 * Student: Dixon D'Cunha
 * Date: Sept 28, 2013
 * Coursera: Beginning Game Programming with C# 
 * Teacher: Dr. Tim "Dr. T" Chamillard
 * Assignment: Programming Assignment 2
 */
namespace ProgrammingAssignment2 {
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game {
        const int WINDOW_WIDTH = 800;
        const int WINDOW_HEIGHT = 600;

        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;

        // Sprite variables
        Texture2D sprite0;
        Texture2D sprite1;
        Texture2D sprite2;
        Texture2D sprite3;
        Texture2D sprite4;

        // used to handle generating random values
        Random rand = new Random();
        const int CHANGE_DELAY_TIME = 1000;
        const int AMOUNT_OF_SPRITES = 5;
        int elapsedTime = 0;

        // used to keep track of current sprite and location
        Texture2D currentSprite;
        Rectangle drawRectangle = new Rectangle();

        public Game1() {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";

            graphics.PreferredBackBufferWidth = WINDOW_WIDTH;
            graphics.PreferredBackBufferHeight = WINDOW_HEIGHT;
        }

        /// <summary>
        /// Allows the game to perform any initialization it needs to before starting to run.
        /// This is where it can query for any required services and load any non-graphic
        /// related content.  Calling base.Initialize will enumerate through any components
        /// and initialize them as well.
        /// </summary>
        protected override void Initialize() {
            // TODO: Add your initialization logic here

            base.Initialize();
        }

        /// <summary>
        /// LoadContent will be called once per game and is the place to load
        /// all of your content.
        /// </summary>
        protected override void LoadContent() {
            // Create a new SpriteBatch, which can be used to draw textures.
            spriteBatch = new SpriteBatch(GraphicsDevice);

            //load the images here
            sprite0 = Content.Load<Texture2D>("Pic1");
            sprite1 = Content.Load<Texture2D>("Pic2");
            sprite2 = Content.Load<Texture2D>("Pic3");
            sprite3 = Content.Load<Texture2D>("Pic4");
            sprite4 = Content.Load<Texture2D>("Pic5");

            // Set the currentSprite variable to one of the sprite variables
            currentSprite = sprite0;
        }

        /// <summary>
        /// UnloadContent will be called once per game and is the place to unload
        /// all content.
        /// </summary>
        protected override void UnloadContent() {
            // TODO: Unload any non ContentManager content here
        }

        /// <summary>
        /// Allows the game to run logic such as updating the world,
        /// checking for collisions, gathering input, and playing audio.
        /// </summary>
        /// <param name="gameTime">Provides a snapshot of timing values.</param>
        protected override void Update(GameTime gameTime) {
            // Allows the game to exit
            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed)
                this.Exit();

            elapsedTime += gameTime.ElapsedGameTime.Milliseconds;
            if (elapsedTime > CHANGE_DELAY_TIME) {
                elapsedTime = 0;

                // Generates a random number between 0 and 4
                int spriteNumber = rand.Next(0, AMOUNT_OF_SPRITES);

                // sets current sprite depending on the random number
                if (spriteNumber == 0) {
                    currentSprite = sprite0;
                } else if (spriteNumber == 1) {
                    currentSprite = sprite1;
                } else if (spriteNumber == 2) {
                    currentSprite = sprite2;
                } else if (spriteNumber == 3) {
                    currentSprite = sprite3;
                } else if (spriteNumber == 4) {
                    currentSprite = sprite4;
                }

                // Sets drawRectangle.X to a random number between 0 and the preferred backbuffer width - the width of the current sprite 
                // using the rand field I provided
                drawRectangle.X = rand.Next(0, WINDOW_WIDTH - currentSprite.Width);

                // Sets drawRectangle.Y to a random number between 0 and the preferred backbuffer height - the height of the current sprite
                // using the rand field I provided
                drawRectangle.Y = rand.Next(0, WINDOW_HEIGHT - currentSprite.Height);

                // Sets the drawRectangle.Width and drawRectangle.Height to match the width and height of currentSprite
                drawRectangle.Width = currentSprite.Width;
                drawRectangle.Height = currentSprite.Height;
            }

            base.Update(gameTime);
        }

        /// <summary>
        /// This is called when the game should draw itself.
        /// </summary>
        /// <param name="gameTime">Provides a snapshot of timing values.</param>
        protected override void Draw(GameTime gameTime) {
            GraphicsDevice.Clear(Color.AliceBlue);

            // Draws current sprite here
            spriteBatch.Begin();

            spriteBatch.Draw(currentSprite, drawRectangle, Color.AliceBlue);

            spriteBatch.End();

            base.Draw(gameTime);
        }
    }
}
