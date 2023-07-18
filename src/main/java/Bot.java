import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import textrpg.GameLogic;
import textrpg.State;
import textrpg.UserState;

import java.util.HashMap;
import java.util.Map;

public class Bot extends TelegramLongPollingBot {

    private Map<Long, UserState> userStates = new HashMap<>();
    UserState userState = userStates.getOrDefault(null, new UserState());
    long chatId;

    public Bot() {
        this.chatId = 0L;
    }

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

        chatId = update.getMessage().getChatId();
        String msgReceived = update.getMessage().getText();

        while (true) {

            //

            if (userState.getProgress() == 0 && userState.getState() == State.START) {

                System.out.println(msgReceived);

                if (msgReceived.toLowerCase().startsWith("start")) {
                    sendResponse(chatId, GameLogic.titleScreen());
                    userState.setProgress(1);
                    sendResponse(chatId,"\nPlease enter a name for your character: ");
                    break;
                }
            }

            if (userState.getProgress() == 1 && userState.getState() == State.START) {
                System.out.println(msgReceived);
                sendResponse(chatId, GameLogic.choseName(msgReceived));
                userState.setProgress(2);
                break;
            }

            if (userState.getProgress() == 2 && userState.getState() == State.START) {

                if (msgReceived.equalsIgnoreCase("no")) {
                    sendResponse(chatId, "Please enter another name:");
                    userState.setProgress(1);
                    break;

                } else {
                    userState.setState(State.PLAYING);
                    userState.setProgress(0);
                    break;
                }

            }
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
