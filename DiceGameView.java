package kinel.emily.dicegame;
	
import java.awt.Component;

import javax.swing.JOptionPane;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 * DiceGameView takes the information from the class DiceGame and
 * creates the GUI application.
 * @author EmilyK
 *
 */
public class DiceGameView extends Application{
	
	/*Private instance variables*/
	private ImageView iv1 = new ImageView();
	private ImageView iv2 = new ImageView();
	private ImageView iv3 = new ImageView();
	private Button btnRoll;
	private DiceGame dGame;
	private Effect glow = new Glow(1.0);
	private Text rolling = new Text ("Rolling...");
	private FadeTransition ft = new FadeTransition(Duration.millis(700), rolling);
	private final VBox vboxbottom = new VBox(10);
	private int rollP1;
	private int rollP2;
	private static final Component frame = null;
	
	private StackPane stack = new StackPane();
	private StackPane stack00 = new StackPane();
	private StackPane stack10 = new StackPane();
	private StackPane stack01 = new StackPane();
	private StackPane stack11 = new StackPane();
	private StackPane stack20 = new StackPane();
	private StackPane stack02 = new StackPane();
	private StackPane stack21 = new StackPane();
	private StackPane stack12 = new StackPane();
	private StackPane stack22 = new StackPane();
	private StackPane stack30 = new StackPane();
	private StackPane stack03 = new StackPane();
	private StackPane stack31 = new StackPane();
	private StackPane stack13 = new StackPane();
	private StackPane stack32 = new StackPane();
	private StackPane stack23 = new StackPane();
	
	/**
	 * Creates the layout of the game using a BorderPane
	 * with the top, left, right and bottom of the BorderPane being VBoxs
	 * and the center being an HBox.
	 * The left pane displays the information of the die for player1 after each roll.
	 * The right pane displays the information of the die for player2 after each roll.
	 * The bottom pane displays the score of the game after each round.
	 * The center pane displays the images of the three die, changing them after each roll.
	 * The top pane displays the title of the game as well as the roll button.
	 * When the roll button is pressed, an animation in the top left corner is displayed,
	 * the die are rolled, the images of the die are updated, and the information of the roll
	 * is displayed in the right or left pane, depending on whose turn it is.
	 * If the game is over, text is added to the bottom pane saying which player won.
	 */
	 @Override
	    public void start(Stage primaryStage) {
		 	dGame = new DiceGame();
	    	final BorderPane root = new BorderPane();

	        final HBox hboxcenter = new HBox(10);
	        hboxcenter.setAlignment(Pos.CENTER);
	        hboxcenter.setId("vbox-center");
	        
	        final VBox vboxtop = new VBox(10);
	        vboxtop.setAlignment(Pos.TOP_CENTER);
	        vboxtop.setId("vbox-top");
	        
	        final VBox vboxleft = new VBox(10);
	        vboxleft.setAlignment(Pos.TOP_CENTER);
	        
	        final VBox vboxright = new VBox(10);
	        vboxright.setAlignment(Pos.TOP_CENTER);
	        
	        vboxbottom.setAlignment(Pos.TOP_CENTER);
	        
	        root.setTop(vboxtop);
	        root.setCenter(hboxcenter);
	        root.setLeft(vboxleft);
	        root.setRight(vboxright);
	        root.setBottom(vboxbottom);
	        
	        /*Rolling animation defaults*/
	        rolling.setId("rolling-text");
	        rolling.setOpacity(0.0);
	        stack.setAlignment(Pos.TOP_LEFT);
	        stack.getChildren().addAll(rolling);
	        root.getChildren().add(stack);
	        
	        /*Center Pane*/
	        iv1.setImage(d1Images());
	        iv2.setImage(d2Images());
	        iv3.setImage(d3Images());
	        hboxcenter.getChildren().addAll(iv1, iv2, iv3);
	        HBox.setMargin(iv1, new Insets(-25, 0, 0, 0));
	        HBox.setMargin(iv2, new Insets(-25, 0, 0, 0));
	        HBox.setMargin(iv3, new Insets(-25, 0, 0, 0));
	        
	        
	        /*Left Pane*/
	        final Text p1 = new Text("Player one:");
	        p1.setId("player-text");
	        vboxleft.getChildren().addAll(p1);
	        VBox.setMargin(p1, new Insets(-100, 0, 0, 10));
	        
	        /*Right Pane*/
	        final Text p2 = new Text("Player two:");
	        p2.setId("player-text");
	        vboxright.getChildren().addAll(p2);
	        VBox.setMargin(p2, new Insets(-100, 10, 0, 0));
	        
	        
	        /*Top Pane*/
	        Text welcome = new Text("Cee-Lo");
	        welcome.setId("welcome-text");
	        VBox.setMargin(welcome, new Insets(-55, 0, 0, 0));
	        btnRoll = new Button("Roll");
	        VBox.setMargin(btnRoll, new Insets(0, 0, 0, 0));
	        Button instructions = new Button("How to Play");
	        VBox.setMargin(instructions, new Insets(-15, 0, 0, 0));
	        /*Action Event if button is pushed*/
	        instructions.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
					JOptionPane.showMessageDialog(frame, "How to Play:\n\nEach player takes turns rolling all three dice at once\n"
							+ "and must continue until a recognized combination is rolled.\n"
							+ "Whichever player rolls the best combination wins the round\n"
							+ "and a new one begins. In cases where the players tie for the\n"
							+ "best combination, there is no winner for that round.\n\n"
							+ "The combinations are ranked from best to worst as:"
							+ "\n\n4-5-6:\nThe highest possible roll.\n"
							+ "If you roll 4-5-6, you automatically win the round.\n\n"
							+ "“Trips”:\nRolling three of the same number is known as rolling “trips”\n"
							+ "Higher trips beat lower trips, so 4-4-4 is better than 3-3-3.\n\n"
							+ "“Point”:\nRolling a pair, and another number, establishes the singleton as a “point”.\n"
							+ "A higher point beats a lower point, so 1-1-3 is better than 6-6-2.\n\n"
							+ "1-2-3:\nThe lowest possible roll.\n"
							+ "If you roll 1-2-3, you automatically lose the round."
							+ "\n\nThe first player to win 3 rounds wins the game!");
					}
	        });
	        
	        
	        p1.setEffect(glow);
	        p2.setEffect(null);
	        /*Events on button push*/
	        btnRoll.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	rollingFadeIn();
	            	dGame.rollDice();
	            	iv1.setImage(d1Images());
	    	        iv2.setImage(d2Images());
	    	        iv3.setImage(d3Images());
	    	        /*Adds roll info to left pane*/
	    	        if(dGame.player1Turn() == true){
	    	        	rollP1++;
	    	        	if(rollP1 == 1)
	    	        		addRound(vboxleft);
	    	        	addRollP1(vboxleft);
	    	        	if(dGame.autoWin() == true){
	    	        		addAutoWin(vboxleft);
	    	        		p2.setEffect(glow);
		    	        	p1.setEffect(null);
	    	        	}
	    	        	if(dGame.autoLose() == true){
	    	        		addAutoLose(vboxleft);
	    	        		p2.setEffect(glow);
		    	        	p1.setEffect(null);
	    	        	}
	    	        	if(dGame.trips() == true){
	    	        		addTriples(vboxleft);
	    	        		p2.setEffect(glow);
		    	        	p1.setEffect(null);
	    	        	}
	    	        	if(dGame.point() == true){
	    	        		addDoubles(vboxleft);
	    	        		p2.setEffect(glow);
		    	        	p1.setEffect(null);
	    	        	}
	    	        	if(dGame.isReroll() == true)
	    	        		addReroll(vboxleft);
	    	        }
	    	        /*Adds roll info to right pane*/
	    	        else{
	    	        	rollP2++;
	    	        	if(rollP2 == 1)
	    	        		addRound(vboxright);
	    	        	addRollP2(vboxright);
	    	        	if(dGame.autoWin() == true){
	    	        		addAutoWin(vboxright);
	    	        		p1.setEffect(glow);
		    	        	p2.setEffect(null);
	    	        	}
	    	        	if(dGame.autoLose() == true){
	    	        		addAutoLose(vboxright);
	    	        		p1.setEffect(glow);
		    	        	p2.setEffect(null);
	    	        	}
	    	        	if(dGame.trips() == true){
	    	        		addTriples(vboxright);
	    	        		p1.setEffect(glow);
		    	        	p2.setEffect(null);
	    	        	}
	    	        	if(dGame.point() == true){
	    	        		addDoubles(vboxright);
	    	        		p1.setEffect(glow);
		    	        	p2.setEffect(null);
	    	        	}
	    	        	if(dGame.isReroll() == true)
	    	        		addReroll(vboxright);
	    	        }
	    	        dGame.tripsPointLogic();
	    			dGame.setLastRoll();
	    	        if(dGame.isEndRound() == true){
	    	        	rollP1 = 0;
	    	        	rollP2 = 0;
	    	        	if(dGame.isTie() == true)
		    				JOptionPane.showMessageDialog(frame, "Oh no! It's a tie.\nNo one wins the round.");
		    			else{
		    				dGame.score();
		    				updateScore();
		    				if(dGame.gameOver() == true){
		    					addWin(vboxbottom);
		    				}
								
	 	    	        }
	    	
	    	        }
	    	        dGame.getResults();
	            }

	        });
	        vboxtop.getChildren().addAll(welcome, instructions, btnRoll);
	        
	        /*Bottom Pane*/
	        Text score = new Text("Score:");
	        score.setId("score-text");
	        vboxbottom.getChildren().addAll(score);
	        addStackPaneScore00(vboxbottom);
	     
	        
	        Scene scene = new Scene(root, 890, 700);
	        
	        
	        primaryStage.setTitle("Cee-Lo");
	        primaryStage.setScene(scene);
	        scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
	        primaryStage.show();     
	    }

	 
	 
	/**
	 * Creates the dice images for die1 and returns them if 
	 * the top of the die is set to their corresponding number.
	 * @return image of the die for die1
	 */
	public Image d1Images(){
	    Image d1 = new Image("http://i41.tinypic.com/15cogf9.jpg");
	    Image d2 = new Image("http://i43.tinypic.com/29vxag6.jpg");
	    Image d3 = new Image("http://i43.tinypic.com/2dhcsk7.jpg");
	    Image d4 = new Image("http://i44.tinypic.com/8z4ew9.jpg");
	    Image d5 = new Image("http://i43.tinypic.com/256w5yt.jpg");
	    Image d6 = new Image("http://i39.tinypic.com/f8136.jpg");
	   
	    if(dGame.getTopD1() == 1)
	    	return d1;
	    if(dGame.getTopD1() == 2)
	    	return d2;
	    if(dGame.getTopD1() == 3)
	    	return d3;
	    if(dGame.getTopD1() == 4)
	    	return d4;
	    if(dGame.getTopD1() == 5)
	    	return d5;
	    return d6;
	    
	}
	
	/**
	 * Creates the dice images for die2 and returns them if 
	 * the top of the die is set to their corresponding number.
	 * @return image of the die for die2
	 */
	public Image d2Images(){
		Image d1 = new Image("http://i41.tinypic.com/15cogf9.jpg");
	    Image d2 = new Image("http://i43.tinypic.com/29vxag6.jpg");
	    Image d3 = new Image("http://i43.tinypic.com/2dhcsk7.jpg");
	    Image d4 = new Image("http://i44.tinypic.com/8z4ew9.jpg");
	    Image d5 = new Image("http://i43.tinypic.com/256w5yt.jpg");
	    Image d6 = new Image("http://i39.tinypic.com/f8136.jpg");
	   
	    if(dGame.getTopD2() == 1)
	    	return d1;
	    if(dGame.getTopD2() == 2)
	    	return d2;
	    if(dGame.getTopD2() == 3)
	    	return d3;
	    if(dGame.getTopD2() == 4)
	    	return d4;
	    if(dGame.getTopD2() == 5)
	    	return d5;
	    return d6;
	    
	}
	
	/**
	 * Creates the dice images for die3 and returns them if 
	 * the top of the die is set to their corresponding number.
	 * @return image of the die for die3
	 */
	public Image d3Images(){
		Image d1 = new Image("http://i41.tinypic.com/15cogf9.jpg");
	    Image d2 = new Image("http://i43.tinypic.com/29vxag6.jpg");
	    Image d3 = new Image("http://i43.tinypic.com/2dhcsk7.jpg");
	    Image d4 = new Image("http://i44.tinypic.com/8z4ew9.jpg");
	    Image d5 = new Image("http://i43.tinypic.com/256w5yt.jpg");
	    Image d6 = new Image("http://i39.tinypic.com/f8136.jpg");
	   
	    if(dGame.getTopD3() == 1)
	    	return d1;
	    if(dGame.getTopD3() == 2)
	    	return d2;
	    if(dGame.getTopD3() == 3)
	    	return d3;
	    if(dGame.getTopD3() == 4)
	    	return d4;
	    if(dGame.getTopD3() == 5)
	    	return d5;
	    return d6;
	    
	}
	
	/**
	 * Creates the Texts when the game is over. 
	 * If player1 wins it displays "Player one wins! Game Over"
	 * If player2 wins it displays "Player two wins! Game Over"
	 * @param vb
	 */
	public void addWin(VBox vb){
    	Text gameOver = new Text("GAME OVER");
    	gameOver.setId("over-text");
    	VBox.setMargin(gameOver, new Insets(-200, 0, 0, 0));
    	if(dGame.player1Win() == true){
    		Text winp1 = new Text("PLAYER ONE WINS!");
    		winp1.setId("win-text");
    		VBox.setMargin(winp1, new Insets(-600, 0, 300, 0));
            vb.getChildren().addAll(winp1, gameOver);
    	}
    	else{
    		Text winp2 = new Text("PLAYER TWO WINS!");
    		winp2.setId("win-text");
    		VBox.setMargin(winp2, new Insets(-600, 0, 300, 0));
            vb.getChildren().addAll(winp2, gameOver);
    	}
        
    }
	
	/**
	 * The animation for the "Rolling..." text when it fades in
	 * after the Roll button has been pushed
	 */
	public void rollingFadeIn(){
		ft.setFromValue(0.0);
		ft.setToValue(1.0);
		ft.setAutoReverse(true);
		ft.setCycleCount(4);
		ft.play();
	}
	
	
	/**
	 * Creates the text that displays the number of each round.
	 * @param vb
	 */
	public void addRound(VBox vb) {
        Text roll = new Text("Round " + dGame.getRounds() + ":");
        roll.setId("round-text");    
        VBox.setMargin(roll, new Insets(-13, 0, 0, 0));

        vb.getChildren().add(roll);            
    }
	
	/**
	 * Creates the text that displays the number of rolls per round
	 * that player1 is on and the values of the die after each roll.
	 * @param vb
	 */
	public void addRollP1(VBox vb) {
        Text roll = new Text("Roll " + rollP1 + ": " + dGame.getTopD1() + "," + dGame.getTopD2() + "," + dGame.getTopD3());
        roll.setId("roll-text");     
        VBox.setMargin(roll, new Insets(-15, 0, 0, 0));

        vb.getChildren().add(roll);            
    }
	
	/**
	 * Creates the text that displays the number of rolls per round
	 * that player1 is on and the values of the die after each roll.
	 * @param vb
	 */
	public void addRollP2(VBox vb) {
        Text roll = new Text("Roll " + rollP2 + ": " + dGame.getTopD1() + "," + dGame.getTopD2() + "," + dGame.getTopD3());
        roll.setId("roll-text");
        VBox.setMargin(roll, new Insets(-15, 0, 0, 0));

        vb.getChildren().add(roll);            
    }
	
	/**
	 * Creates the text that is displayed if a player
	 * rolls a 4-5-6 and thus automatically wins the round.
	 * @param vb
	 */
	public void addAutoWin(VBox vb) {
        Text info = new Text("Auto win.");
        info.setId("info-text");     
        VBox.setMargin(info, new Insets(-15, 0, 0, 0));

        vb.getChildren().add(info);            
    }
	
	/**
	 * Creates the text that is displayed if a player
	 * rolls a 1-2-3 and thus automatically loses the round.
	 * @param vb
	 */
	public void addAutoLose(VBox vb) {
       
        Text info = new Text("Auto lose.");
        info.setId("info-text");
             
        VBox.setMargin(info, new Insets(-15, 0, 0, 0));
        vb.getChildren().add(info);            
    }
	
	/**
	 * Creates the text that is displayed if a player rolls triples.
	 * @param vb
	 */
	public void addTriples(VBox vb) {
       
        Text info = new Text("Triple " + dGame.getThisRoll() + "'s rolled.");
        info.setId("info-text");
        VBox.setMargin(info, new Insets(-15, 0, 0, 0));
        vb.getChildren().add(info);
    }
	
	/**
	 * Creates the text that is displayed if a player rolls doubles.
	 * And tells the players the point value.
	 * @param vb
	 */
	public void addDoubles(VBox vb) {
     
        Text info = new Text("Doubles rolled. Point: " + dGame.getThisRoll());
        info.setId("info-text");
        VBox.setMargin(info, new Insets(-15, 0, 0, 0));
        vb.getChildren().add(info);         
    }
	
	/**
	 * Creates the text that is displayed if a player doesn't roll
	 * a 4-5-6, 1-2-3, triples or doubles, and tells the player to reroll.
	 * @param vb
	 */
	public void addReroll(VBox vb) {
        
        Text info = new Text("Please reroll.");
        info.setId("info-text");
        VBox.setMargin(info, new Insets(-15, 0, 0, 0));
        vb.getChildren().add(info);
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 0 and player2 has a score of 0
	 * @param vb
	 */
	public void addStackPaneScore00(VBox vb) {
        Text info = new Text("0-0");
        info.setId("playerscore-text");
        stack00.getChildren().add(info);
        stack00.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack00);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 1 and player2 has a score of 0
	 * @param vb
	 */
	public void addStackPaneScore10(VBox vb) {
        Text info = new Text("1-0");
        info.setId("playerscore-text");
        stack10.getChildren().add(info);
        stack10.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack10);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 0 and player2 has a score of 1
	 * @param vb
	 */
	public void addStackPaneScore01(VBox vb) {
        Text info = new Text("0-1");
        info.setId("playerscore-text");
        stack01.getChildren().add(info);
        stack01.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack01);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 and player2 are tied, both having a score of 1
	 * @param vb
	 */
	public void addStackPaneScore11(VBox vb) {
        Text info = new Text("1-1");
        info.setId("playerscore-text");
        stack11.getChildren().add(info);
        stack11.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack11);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 2 and player2 has a score of 0
	 * @param vb
	 */
	public void addStackPaneScore20(VBox vb) {
        Text info = new Text("2-0");
        info.setId("playerscore-text");
        stack20.getChildren().add(info);
        stack20.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack20);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 0 and player2 has a score of 2
	 * @param vb
	 */
	public void addStackPaneScore02(VBox vb) {
        Text info = new Text("0-2");
        info.setId("playerscore-text");
        stack02.getChildren().add(info);
        stack02.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack02);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 2 and player2 has a score of 1
	 * @param vb
	 */
	public void addStackPaneScore21(VBox vb) {
        Text info = new Text("2-1");
        info.setId("playerscore-text");
        stack21.getChildren().add(info);
        stack21.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack21);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 1 and player2 has a score of 2
	 * @param vb
	 */
	public void addStackPaneScore12(VBox vb) {
        Text info = new Text("1-2");
        info.setId("playerscore-text");
        stack12.getChildren().add(info);
        stack12.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack12);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 and player2 are tied, both having a score of 2
	 * @param vb
	 */
	public void addStackPaneScore22(VBox vb) {
        Text info = new Text("2-2");
        info.setId("playerscore-text");
        stack22.getChildren().add(info);
        stack22.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack22);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 3 and player2 has a score of 0
	 * @param vb
	 */
	public void addStackPaneScore30(VBox vb) {
        Text info = new Text("3-0");
        info.setId("playerscore-text");
        stack30.getChildren().add(info);
        stack30.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack30);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 0 and player2 has a score of 3
	 * @param vb
	 */
	public void addStackPaneScore03(VBox vb) {
        Text info = new Text("0-3");
        info.setId("playerscore-text");
        stack03.getChildren().add(info);
        stack03.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack03);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 1 and player2 has a score of 3
	 * @param vb
	 */
	public void addStackPaneScore13(VBox vb) {
        Text info = new Text("1-3");
        info.setId("playerscore-text");
        stack13.getChildren().add(info);
        stack13.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack13);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 3 and player2 has a score of 1
	 * @param vb
	 */
	public void addStackPaneScore31(VBox vb) {
        Text info = new Text("3-1");
        info.setId("playerscore-text");
        stack31.getChildren().add(info);
        stack31.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack31);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 2 and player2 has a score of 3
	 * @param vb
	 */
	public void addStackPaneScore23(VBox vb) {
        Text info = new Text("2-3");
        info.setId("playerscore-text");
        stack23.getChildren().add(info);
        stack23.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack23);            
    }
	
	/**
	 * Creates a stack pane that is added to the bottom pane
	 * when player1 has a score of 3 and player2 has a score of 2
	 * @param vb
	 */
	public void addStackPaneScore32(VBox vb) {
        Text info = new Text("3-2");
        info.setId("playerscore-text");
        stack32.getChildren().add(info);
        stack32.setAlignment(Pos.TOP_CENTER);     
        StackPane.setMargin(info, new Insets(-40, 0, 0, 0));

        vb.getChildren().add(stack32);            
    }
	
	
	
	/**
	 * Updates the score of the game, removing the previous score from the bottom pane 
	 * and adding the new one.
	 */
	public void updateScore(){
		if(dGame.getPlayer1Score() == 1 && dGame.getPlayer2Score() == 0){
    		vboxbottom.getChildren().remove(stack00);
    		addStackPaneScore10(vboxbottom);
    	}
		if(dGame.getPlayer2Score() == 1 && dGame.getPlayer1Score() == 0){
    		vboxbottom.getChildren().remove(stack00);
    		addStackPaneScore01(vboxbottom);
    	}
		if(dGame.getPlayer1Score() == 2 && dGame.getPlayer2Score() == 0){
    		vboxbottom.getChildren().remove(stack10);
    		addStackPaneScore20(vboxbottom);
    	}
		if(dGame.getPlayer2Score() == 2 && dGame.getPlayer1Score() == 0){
    		vboxbottom.getChildren().remove(stack01);
    		addStackPaneScore02(vboxbottom);
    	}
		if(dGame.getPlayer1Score() == 3 && dGame.getPlayer2Score() == 0){
    		vboxbottom.getChildren().remove(stack20);
    		addStackPaneScore30(vboxbottom);
    	}
		if(dGame.getPlayer2Score() == 3 && dGame.getPlayer1Score() == 0){
    		vboxbottom.getChildren().remove(stack02);
    		addStackPaneScore03(vboxbottom);
    	}
		if(dGame.getPlayer1Score() == 1 && dGame.getPlayer2Score() == 1){
    		if(vboxbottom.getChildren().contains(stack10))
    			vboxbottom.getChildren().remove(stack10);
    		if(vboxbottom.getChildren().contains(stack01))
    			vboxbottom.getChildren().remove(stack01);
    		addStackPaneScore11(vboxbottom);
    	}
		if(dGame.getPlayer1Score() == 2 && dGame.getPlayer2Score() == 1){
			if(vboxbottom.getChildren().contains(stack11))
    			vboxbottom.getChildren().remove(stack11);
    		if(vboxbottom.getChildren().contains(stack20))
    			vboxbottom.getChildren().remove(stack20);
    		addStackPaneScore21(vboxbottom);
    	}
		if(dGame.getPlayer2Score() == 2 && dGame.getPlayer1Score() == 1){
			if(vboxbottom.getChildren().contains(stack11))
    			vboxbottom.getChildren().remove(stack11);
    		if(vboxbottom.getChildren().contains(stack02))
    			vboxbottom.getChildren().remove(stack02);
    		addStackPaneScore12(vboxbottom);
    	}
		if(dGame.getPlayer1Score() == 3 && dGame.getPlayer2Score() == 1){
			if(vboxbottom.getChildren().contains(stack21))
    			vboxbottom.getChildren().remove(stack21);
    		if(vboxbottom.getChildren().contains(stack30))
    			vboxbottom.getChildren().remove(stack30);
    		addStackPaneScore31(vboxbottom);
    	}
		if(dGame.getPlayer2Score() == 3 && dGame.getPlayer1Score() == 1){
			if(vboxbottom.getChildren().contains(stack12))
    			vboxbottom.getChildren().remove(stack12);
    		if(vboxbottom.getChildren().contains(stack03))
    			vboxbottom.getChildren().remove(stack03);
    		addStackPaneScore13(vboxbottom);
    	}
		if(dGame.getPlayer1Score() == 2 && dGame.getPlayer2Score() == 2){
			if(vboxbottom.getChildren().contains(stack12))
    			vboxbottom.getChildren().remove(stack12);
    		if(vboxbottom.getChildren().contains(stack21))
    			vboxbottom.getChildren().remove(stack21);
    		addStackPaneScore22(vboxbottom);
    	}
		if(dGame.getPlayer1Score() == 3 && dGame.getPlayer2Score() == 2){
			if(vboxbottom.getChildren().contains(stack22))
    			vboxbottom.getChildren().remove(stack22);
    		if(vboxbottom.getChildren().contains(stack31))
    			vboxbottom.getChildren().remove(stack31);
    		addStackPaneScore32(vboxbottom);
    	}
		if(dGame.getPlayer2Score() == 3 && dGame.getPlayer1Score() == 2){
			if(vboxbottom.getChildren().contains(stack22))
    			vboxbottom.getChildren().remove(stack22);
    		if(vboxbottom.getChildren().contains(stack13))
    			vboxbottom.getChildren().remove(stack13);
    		addStackPaneScore23(vboxbottom);
    	}
	}
	
	
	
	
	/**
	*The main() method is ignored.
	* @param args the command line arguments
	*/
	public static void main(String[] args) {
		 launch(DiceGameView.class, args);  
	 }
	}