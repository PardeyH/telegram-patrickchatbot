import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import textrpg.*;

import java.util.HashMap;
import java.util.Map;

public class Bot extends TelegramLongPollingBot {

    private final Map<Long, UserState> userStates = new HashMap<>();
    UserState userState = userStates.getOrDefault(null, new UserState());
    long chatId;

    public Bot() {
        this.chatId = 0L;
    }

    public void sendText(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())         //Who are we sending a message to
                .text(what).build();            //Message content
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

        //Status = userState.Start
        //the game starts of by showing the title screen and lets the user choose a name
        while (userState.getState() == State.START) {

            if (userState.getProgress() == 0) {
                System.out.println(msgReceived);
                //Start of the game
                if (msgReceived.toLowerCase().startsWith("start")) {
                    sendResponse(chatId, GameLogic.titleScreen());
                    userState.setProgress(1);
                    sendResponse(chatId, "\nPlease enter a name for your character:");
                    break;
                }
            }

            //User enters his/her/their name
            if (userState.getProgress() == 1) {
                System.out.println(msgReceived);
                sendResponse(chatId, GameLogic.chooseName(msgReceived));
                userState.setProgress(2);
                break;
            }

            if (userState.getProgress() == 2) {

                //Check whether the entered name is correct
                if (msgReceived.equalsIgnoreCase("yes")) {
                    sendResponse(chatId, "Created player with name " + GameLogic.playerName);
                    GameLogic.createPlayer();
                    userState.setState(State.PLAYING);
                    userState.setProgress(0);
                } else {
                    sendResponse(chatId, "Please enter another name:");
                    userState.setProgress(1);
                    break;
                }
            }
        }

        //Status = userState.PLAYING
        //The actual game loop begins
        while (userState.getState() == State.PLAYING) {

            if (userState.getProgress() == 0) {
                sendResponse(chatId, GameLogic.printMenu());
                userState.setProgress(1);
                break;
            }

            if (userState.getProgress() == 1) {
                if (msgReceived.equalsIgnoreCase("1")) {
                    sendResponse(chatId, Story.printIntro());
                    userState.setState(State.ACT1);
                    userState.setProgress(0);
                    break;
                } else if (msgReceived.equalsIgnoreCase("2")) {
                    sendResponse(chatId, GameLogic.characterInfo());
                    sendResponse(chatId, GameLogic.printMenu());
                    break;
                } else {
                    userState.setProgress(0);
                    userState.setState(State.END);
                }
            }
        }

        while (userState.getState() == State.ACT1) {
            if (userState.getProgress() == 0) {
                if (msgReceived.equalsIgnoreCase("Menu")) {
                    userState.setProgress(0);
                    userState.setState(State.PLAYING);
                    break;
                } else if (msgReceived.equalsIgnoreCase("Wisdom")) {
                    sendResponse(chatId, Story.printAct1Wisdom());
                    userState.setProgress(1);
                    break;
                } else if (msgReceived.equalsIgnoreCase("Strength")) {
                    sendResponse(chatId, Story.printAct1Strength());
                    userState.setProgress(1);
                    break;
                } else if (msgReceived.equalsIgnoreCase("Stealth")) {
                    sendResponse(chatId, Story.printAct1Stealth());
                    userState.setProgress(1);
                    break;
                } else if (msgReceived.equalsIgnoreCase("Compassion")) {
                    sendResponse(chatId, Story.printAct1Compassion());
                    userState.setProgress(1);
                    break;
                } else {
                    userState.setProgress(0);
                    userState.setState(State.PLAYING);
                }
            }

            if (userState.getProgress() == 1) {
                userState.setProgress(0);
                userState.setState(State.END);
                break;
            }
        }


        //Status = userState.END
        //End of the game!! Thank you for playing! :)
        while (userState.getState() == State.END) {

            if (userState.getProgress() == 0) {
                userState.setProgress(1);
                //sendResponse(chatId, "Type something to end the game.");
                sendResponse(chatId, "This is the end for now. Thank you for playing");
                System.exit(0); //ends the game loop for now
            }
        }
    }

    @Override
    public String getBotUsername () {
        return "patrickchatbot";
    }

    @Override
    public String getBotToken () {
        return "6048269057:AAFTlZasLKrp1HaTUGHT3QPH10LI-Ji_PNw";
    }

    @Override
    public void onRegister () {
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

