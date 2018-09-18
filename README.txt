
Welcome to Beer-less Pong!

Please read ALL instructions below carefully! They are crucial in making
sure that this game runs correctly!

CREATORS: Viktor Kelemen & Henry Rose
VERSION: 4/26/2018

INSTRUCTIONS TO RUN THE GAME:

*************************CRUCIAL INFO BELOW*******************************
If you will be running this program on a Mac, please copy and enter this
in your command prompt before doing anything else:

defaults write -g ApplePressAndHoldEnabled -bool false

We discovered a last minute bug that only occurs on Mac computers. The bug
occurs as a result of the interaction between the newest Mac OS and Java's
KeyListener. When a key is held on this newest OS, a list of accents is
brought up for the user to choose from. This functionality doesn't agree
with Java's KeyListener, and the command we provided above disables it.
The functionality can be re-enabled by writing the same line in the
command prompt, but changing "false" to "true".
**************************************************************************
To run the game, simply double click the "Pong.jar" file.

In order to run this game from the command prompt / terminal, first make
sure your command line has accessed the PongGame directory.

Then, compile the code using this command:

javac -d . *.java

You will now be able to run the program! Do so with this command:

java -cp . pongpackage.PongDriver

**************************************************************************
INSTRUCTIONS TO PLAY THE GAME:

Upon running the game, a small window will appear giving you options
regarding the game mode you would like to play. Pick either option -
instructions and explanations of each mode are provided below.

**************************************************************************
BALL GETS FASTER MODE:

In this mode, the ball increases in speed over time. While it may not seem
obvious at first, 30 second of play will reveal a large difference in ball
speed from when the game was started.

The ball bounces off of the sliders based on where it hits the sliders. The
closer it hits to the middle, the flatter the angle will be. The closer to
the top or bottom edge, the sharper the angle will be.

The ball bounces off of the walls at an angle equal to that of which it hit
the wall at.

Sliders are controlled using the 'W' and 'S' keys for player one and the
UP arrow and DOWN arrow keys for player 2.

Any time the ball gets past a player's slider, the other player gets a point.
The first player to obtain 5 points wins! To exit the game, close out the
game window. The mode selection window remains open so that you can play
again or choose a new game mode. If you would like to exit the application
entirely, close out the mode selection window.
***************************************************************************

***************************************************************************
MULTIPLE BALLS MODE:

In this mode, two additional balls (of different colors!) can be added to the
field of play.

To add an additional ball, press 'B' on your keyboard.

The balls will NOT speed up in this mode.

All other controls are the same in this mode.
***************************************************************************

In both modes, a rally counter exists at the bottom of the screen that counts
the number of times the ball has hit a slider in any given rally. Additionally,
a longest rally counter keeps track of the longest rally played over the course
of the game.
