import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {

    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();                  //We moved this line out of the register method, to access it later
        botsApi.registerBot(bot);


        // /*
        //ID Patrick
        bot.sendText(6341326992L, "RPG-Bot is running... \n" +
                "Type \" start \" to start the game.");  //The L just turns the Integer into a Long
        // */

        // /*
        //ID Sezgin
        bot.sendText(5934581428L, "RPG-Bot is running. \n" +
                "Type \" start \" to start the game.");  //The L just turns the Integer into a Long
        // */
    }
}
