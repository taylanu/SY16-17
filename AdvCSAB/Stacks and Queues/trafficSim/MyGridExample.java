package trafficSim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MyGridExample extends JPanel {

    private static final int SIZE = 40;    //size of cell being drawn

    private static final int DELAY = 500;    //#miliseconds delay between each time the enemy moves and screen refreshes for the timer

    private Timer t;                            //used to set the speed of the enemy that moves around the screen

    //define 2 queues for lanes of traffic (main & maple)
    //define values for delay and prob for each lane (mainDelay, mainProb, mapleDelay, mapleProb)
    //define number of cycles
    //define counter for number of cycles completed (numCycles)
    private static boolean mainGreen = true; //(true: green on main & red on maple, false: red on main & green on maple)
    private static int frameNum;    //count of frames to keep track of time
    private static int numCycles = 0;
    private static int mainDelay, mainProb, mapleDelay, mapleProb;
    int lightcycles;

    private static MyQueue main;// = new MyQueue();
    private static MyQueue maple; // = new MyQueue();
    private static int cars; //all cars through intersection
    private String asciicar;

    public MyGridExample(int mainD, int mainP, int mapleD, int mapleP) // int mainDelay, int mainProb, int mapleDelay, int mapleProb
    {
        main = new MyQueue();
        maple = new MyQueue();
        mainDelay = mainD;
        mainProb = mainP;
        mapleDelay = mapleD;
        mapleProb = mapleD;
        lightcycles = 4;
        cars = 0;
        asciicar = "*"; //potentially can be modified.
        t = new Timer(DELAY, new Listener());                //the higher the value of the first argument, the slower the enemy will move
        t.start();

    }

    private void display() {
        System.out.println("Main Queue(" + (main.size()) + ") " + main.toString());
        System.out.println("Maple Queue(" + (maple.size()) + "): " + maple.toString());
        System.out.println();
    }


    //post:  shows different pictures on the screen in grid format depending on the values stored in the array board
    //			0-blank, 1-white, 2-black and gives priority to drawing the player
    public void showBoard(Graphics g) {
        int x = SIZE, y = SIZE;        //upper left corner location of where image will be drawn. Dimensions of Board.
        //for(Iterator i=main.iterator(); i.hasNext())

        //GFX MODE ONLY
        //draw maple from origin to the right x+=SIZE;
        //draw main from origin down y+=SIZE;
    }

    private void randgen(int prob, MyQueue q) {
        int gen = (int) (Math.random() * 100) + 1;
        if (prob > gen) {
            q.add(asciicar);
        }
    }

    private void stats() {
        System.out.println("Queue on Main " + main.size());
        System.out.println("Queue on Maple " + maple.size());
        System.out.println("Number of cycles run " + numCycles);
        System.out.println("Number of cars " + cars);
        //System.out.println()
    }

    //THIS METHOD IS ONLY CALLED THE MOMENT A KEY IS HIT - NOT AT ANY OTHER TIME
    //pre:   k is a valid keyCode
    //post:  changes the players position depending on the key that was pressed (sent from the driver)
    //			keeps the player in the bounds of the size of the array board, then the enemy moves
    public void processUserInput(int k) {
        if (k == KeyEvent.VK_Q || k == KeyEvent.VK_ESCAPE)                    //End the program
            System.exit(1);
        repaint();            //refresh the screen
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);        //draw a blue boarder around the board
        g.fillRect(0, 0, 800, 800);
        showBoard(g);                    //draw the contents of the array board on the screen
    }

    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e)    //this is called for each timer iteration - traffic mechanics
        {
            //convert english to code
            //stats();
            if(numCycles >= lightcycles) { //show stats each cycle
                stats();
                System.exit(1); //ending
            }
            if (mainGreen)//checks boolean condition
            {
                if (frameNum >= mainDelay) {
                    frameNum = 0;
                    mainGreen = false;
                } else {
                    randgen(mainProb,main);
                    randgen(mapleProb,maple);
                    display();
                    if(!main.isEmpty()){
                        main.remove();
                        cars++;
                    }
                    frameNum++;
                }
            }
            else    //main is red and maple is green //right now not running.
            {
                if (frameNum >= mapleDelay) {
                    frameNum = 0;
                    mainGreen = true;
                    numCycles++;
                } else {
                    //maybe add a car to main and/or maple
                    randgen(mainProb,main);
                    randgen(mapleProb,maple);
                    display();
                    if (!maple.isEmpty()) {
                        maple.remove(); //remove a car from maple
                        cars++;
                    }
                    frameNum++;
                }
            }

            repaint();
        }

    }

}
