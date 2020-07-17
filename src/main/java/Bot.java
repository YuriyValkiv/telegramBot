import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

  public void onUpdateReceived(Update update) {

    String message = update.getMessage().getText();
    long chatId = update.getMessage().getChatId();
    if (message.equalsIgnoreCase("Привіт")) {
      sendMsg(chatId, "Привіт, " + update.getMessage().getContact().getFirstName());
    } else {
      sendMsg(chatId, "Що це таке?");
    }

  }

  private synchronized void sendMsg(long chatId, String s) {
    SendMessage sendMessage = new SendMessage();
    sendMessage.enableMarkdown(true);
    sendMessage.setChatId(chatId);
    sendMessage.setText(s);
    try {
      execute(sendMessage);
    } catch (TelegramApiException e) {
      e.printStackTrace();
    }
  }

  public String getBotUsername() {
    return "yura_speak_bot";
  }

  @Override
  public String getBotToken() {
    return "1315655773:AAEybENErU8KUDz5-ssbtgJ0XNoiWGgIAos";
  }
}
