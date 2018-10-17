
public class GameStarter {

	public static void main(String[] args) {
		Game game = Game.getGame();
		//GameLogic.startGame(game);
		game.getGameLogic().startGame(game);

	}

}
