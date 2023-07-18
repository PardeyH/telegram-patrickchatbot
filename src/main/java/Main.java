import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {

    public static void main(String[] args) throws TelegramApiException {

        // TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        // botsApi.registerBot(new Bot());

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        Bot bot = new Bot();                  //We moved this line out of the register method, to access it later
        botsApi.registerBot(bot);
        bot.sendText(6341326992L, "Bot is running :)");  //The L just turns the Integer into a Long

    }
}
