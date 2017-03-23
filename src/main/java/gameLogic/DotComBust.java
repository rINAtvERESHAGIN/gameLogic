package gameLogic;

/**
 * Created by Max on 23.03.2017.
 */
public class DotComBust {
    private GameHelper helper = new GameHelper();
    private List<DotCom> dotList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName( "yandex.ru" );
        DotCom two = new DotCom();
        one.setName( "google.com" );
        DotCom three = new DotCom();
        one.setName( "vk.com" );

        dotList.add(one);
        dotList.add(two);
        dotList.add(three);

        for (DotCom dot : dotList) {
            List<String> newLocation = helper.placeDotCom( 3 );
            dot.setLocationCells( newLocation );

        }
    }
    private void startPlaying() {
        while ( !dotList.isEmpty() ) {
            String userGuess = helper.getUserInput( "Сделайте ход" );
            checkUserGuess( userGuess );
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Мимо";

        for (DotCom dot : dotList) {
            result = dot.checkYourself(userGuess);

            if ( "Попал".equals(result) ) {
                break;
            }

            if ( "Потопил".equals(result) ) {
                dotList.remove(dot);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("Все сайты ушли ко дну");
    }
}
