import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import textrpg.GameLogic;
import textrpg.GameMain;

import java.util.List;
import java.util.Scanner;

import static textrpg.GameLogic.choseName;

public class Bot extends TelegramLongPollingBot {

    GameLogic rpg;

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    @Override
    public void onUpdateReceived(Update update) {

        long chatId = update.getMessage().getChatId();
        String msgReceived = update.getMessage().getText();
        System.out.println(msgReceived);

        if (msgReceived.toLowerCase().startsWith("start")) {
            sendResponse(chatId, GameLogic.startGame());
            sendResponse(chatId, "Please enter a name: ");
        }
    }

    @Override
    public String getBotUsername() {
        return "patrickchatbot";
    }

    @Override
    public String getBotToken() {
        return "6048269057:AAFTlZasLKrp1HaTUGHT3QPH10LI-Ji_PNw";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    private void sendResponse(long chatId, String s) {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText(s);

        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
