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
 * Coursera: Beginning Game Programming with C# 
 * Teacher: Dr. Tim "Dr. T" Chamillard
 * Assignment: Project Increment 1 - Oct 6th, 2013
 * Assignment: Project Increment 2 - Oct 13th, 2013
 */
namespace GameProject {
    /// <summary>
    /// This is the main type for your game
    /// </summary>
    public class Game1 : Microsoft.Xna.Framework.Game {

        // The window dimensions
        const int WINDOW_WIDTH = 800;
        const int WINDOW_HEIGHT = 600;

        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;

        // game state
        GameState gameState = GameState.Menu;

        // Increment 1: opening screen fields
        Texture2D texOpenScreen;
        Rectangle openRect;


        // Increment 2: the board
        NumberBoard nBoard;

        public Game1() {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";

            // Increment 1: set window resolution
            graphics.PreferredBackBufferWidth = WINDOW_WIDTH;
            graphics.PreferredBackBufferHeight = WINDOW_HEIGHT;

            // Increment 1: make the mouse visible
            IsMouseVisible = true;

        }

        /// <summary>
        /// Allows the game to perform any initialization it needs to before starting to run.
        /// This is where it can query for any required services and load any non-graphic
        /// related content.  Calling base.Initialize will enumerate through any components
        /// and initialize them as well.
        /// </summary>
        protected override void Initialize() {
            base.Initialize();
        }

        /// <summary>
        /// LoadContent will be called once per game and is the place to load
        /// all of your content.
        /// </summary>
        protected override void LoadContent() {
            // Create a new SpriteBatch, which can be used to draw textures.
            spriteBatch = new SpriteBatch(GraphicsDevice);

            // load audio content

            // Increment 1: load opening screen and set opening screen draw rectangle
            texOpenScreen = Content.Load<Texture2D>("openingscreen");

            openRect = new Rectangle();
            openRect.Width = WINDOW_WIDTH;
            openRect.Height = WINDOW_HEIGHT;

            // Increment 2: create the board object (this will be moved before you're done with the project)
            Vector2 center = new Vector2(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);
            int sideLength = WINDOW_WIDTH - 50;
            int correctNum = 8;
            SoundBank soundBank = null;
            nBoard = new NumberBoard(Content, center, sideLength, correctNum, soundBank);
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

            // Increment 2: change game state if game state is GameState.Menu and user presses Enter
            if (Keyboard.GetState().IsKeyDown(Keys.Enter)) {
                gameState = GameState.Play;
            }
            // if we're actually playing, update mouse state and update board
            base.Update(gameTime);
        }

        /// <summary>
        /// This is called when the game should draw itself.
        /// </summary>
        /// <param name="gameTime">Provides a snapshot of timing values.</param>
        protected override void Draw(GameTime gameTime) {
            GraphicsDevice.Clear(Color.CornflowerBlue);

            // Increments 1 and 2: draw appropriate items here
            spriteBatch.Begin();
            if (gameState == GameState.Menu) {
                spriteBatch.Draw(texOpenScreen, openRect, Color.White);
            } else if (gameState == GameState.Play) {
                nBoard.Draw(spriteBatch);
            }
            spriteBatch.End();

            base.Draw(gameTime);
        }

        /// <summary>
        /// Starts a game
        /// </summary>
        void StartGame() {
            // randomly generate new number for game

            // create the board object (this will be moved before you're done)

        }
    }
}
